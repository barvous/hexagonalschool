# HexagonalSchool

### This is a project to document my knowledge about APIs and hexagonal architecture projects.

I'm using [Spring Framework](https://spring.io/projects/spring-framework) to manage the endpoints in the "application" package, [Lombok](https://projectlombok.org/features/) to reduce boiler plate code, [Spring Data JPA](https://spring.io/projects/spring-data-jpa) 
in the "infra" package to make interactions with the Database, by the way I choose [H2 database](https://www.h2database.com/html/main.html) to create a in-memory database.

I could do some things different or better, like make a "PersonEntity" abstract class so i don't have to repeat the same columns to "TeacherEntity" and "StudentEntity" classes in the code. But, if I do that I would have to increase the code complexity and i don't want to
make this project much complex, so i decide to make the things more simple to show the core of the project, that is document the Hexagonal Arquitecture.
