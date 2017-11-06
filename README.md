# Notes

## Similarities/Differences between Servlets/Spring Boot

* Controllers. Coordinate model an view
    * With Servlets, the Servlet is the controller
        * The input came from the HttpRequest
        * One servlet per path
        * How do we pass information to the view -> request.setAttribute
    * With Spring Boot, any class with the annotation @Controller
        * We user path variables @PathVariable -> a parameter in your controller method
        * One method per path
        * How do we pass information to the view -> model.addAttribute
* View
    * With Servlets, jsp are the views -> EL, JSTL
        * JSTL worked with custom tags (c:tag)
    * With Spring Boot, thymeleaf are the views -> EL
        * Thymeleaf works with custom attributes (th:attribue)
