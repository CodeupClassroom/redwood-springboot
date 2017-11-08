package com.codeup.blog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringbootBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBlogApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(Cohorts cohorts, Quizzes quizzes) {
        return args -> {
            // what models can I identify?
            // * Quiz -> Question -> Options
            // * Cohort -> Student
            // * Student Grade

            // Create a cohort with 2 students
            Cohort redwood = new Cohort("Redwood");
            redwood.enroll(new Student("Jordan", "jordan"));
            redwood.enroll(new Student("Terrel", "terrel"));

            cohorts.save(redwood);

            // Create a new quiz for redwood
            Quiz javaQuiz = new Quiz(redwood);
            Question newQuestion = new Question("Is Java a compiled language");
            newQuestion.addOption(new QuestionOption("Yes", true));
            newQuestion.addOption(new QuestionOption("No", false));
            newQuestion.addOption(new QuestionOption("Not always", false));
            javaQuiz.addQuestion(newQuestion);
            Question secondQuestion = new Question("Is String a primitive type");
            secondQuestion.addOption(new QuestionOption("Yes", false));
            secondQuestion.addOption(new QuestionOption("No", true));
            javaQuiz.addQuestion(secondQuestion);

            quizzes.save(javaQuiz);

            Quiz java2Quiz = new Quiz(redwood);
            java2Quiz.addQuestion(newQuestion);

            quizzes.save(java2Quiz);
        };
    }
}

// Saving on a database
// What kind of statement you use?
// INSERT INTO <table_name> (<column_1, column_2, ... column_n>)
// VALUES (<value_1, value2, ..., value_n>)

@Entity
@Table(name = "students")
class Student {
    @Id @GeneratedValue Long id;
    private String name;
    @Column(nullable = false)
    private String githubUsername;

    @ManyToOne
    // The name of the foreign key column is determined by the name of this property
    private Cohort cohort;

    public Student(String name, String githubUsername) {
        this.name = name;
        this.githubUsername = githubUsername;
    }

    public void enrollTo(Cohort cohort) {
        this.cohort = cohort;
    }
}

/*
 create table student (
    id bigint not null primary key auto_increment,
    name varchar(255),
    github_username varchar(255)
 );
 */
@Entity
@Table(name = "cohorts")
class Cohort {
    @Id @GeneratedValue Long id;
    @Column(nullable = false)
    private String name;
    private Date startDate;
    private Date endDate;

    @OneToMany(mappedBy = "cohort", cascade = CascadeType.ALL) // Student.cohort is an attribute in Student
    private List<Student> students;

    public Cohort(String name) {
        this.name = name;
        students = new ArrayList<>();
    }

    public void enroll(Student newStudent) {
        newStudent.enrollTo(this);
        students.add(newStudent);
    }
}

interface Cohorts extends CrudRepository<Cohort, Long> {}

@Entity
@Table(name = "question_options")
class QuestionOption {
    @Id @GeneratedValue Long id;
    @Column(nullable = false)
    private String text;
    @Column(nullable = false)
    private boolean isCorrect;
    @ManyToOne
    private Question question;

    public QuestionOption(String text, boolean isCorrect) {
        this.text = text;
        this.isCorrect = isCorrect;
    }

    public void addTo(Question question) {
        this.question = question;
    }
}

@Entity
@Table(name = "questions")
class Question {
    @Id @GeneratedValue Long id;
    @Column(nullable = false)
    private String text;
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<QuestionOption> options;

    //@ManyToOne
    //private Quiz quiz;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        joinColumns = {@JoinColumn(name = "question_id")},
        inverseJoinColumns = {@JoinColumn(name = "quiz_id")}
    )
    private List<Quiz> quizzes;

    public Question(String text) {
        this.text = text;
        options = new ArrayList<>();
        quizzes = new ArrayList<>();
    }

    public void addOption(QuestionOption newOption) {
        newOption.addTo(this);
        options.add(newOption);
    }

    public void addTo(Quiz quiz) {
        quizzes.add(quiz);
    }
}

@Entity
@Table(name = "quizzes")
class Quiz {
    @Id @GeneratedValue Long id;
    @ManyToOne
    private Cohort assignedCohort;
    //@OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    @ManyToMany(mappedBy = "quizzes", cascade = CascadeType.ALL)
    private List<Question> questions;

    public Quiz(Cohort cohort) {
        assignedCohort = cohort;
        questions = new ArrayList<>();
    }

    public void addQuestion(Question newQuestion) {
        newQuestion.addTo(this);
        questions.add(newQuestion);
    }

    public boolean isOpenFor(Student student) {
        return true;
    }
}

interface Quizzes extends CrudRepository<Quiz, Long> {}
