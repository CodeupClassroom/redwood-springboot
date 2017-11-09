/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.blog;

import com.codeup.blog.services.UserDetailsLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsLoader userDetails;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(userDetails) // How to find users by their username
            .passwordEncoder(passwordEncoder()) // how to encode/verify passwords
        ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/ads") // user's home page, it can be any URL
                .permitAll() // Anyone can go to the login page
            .and()
                .authorizeRequests()
                .antMatchers("/", "/logout", "/posts", "/register") // anyone can see the home and logout page
                .permitAll()
            .and()
                .logout()
                .logoutSuccessUrl("/login?logout") // append a query string value
            .and()
                .authorizeRequests()
                .antMatchers(
                    "/ads/create",
                    "/posts/create",
                    //"/ads/{id}/edit",
                    "/ads/?/edit"
                ) // only authenticated users can create ads
                .authenticated()
        ;
    }
}
