# Spring & Spring Boot Learning Journey

A hands-on learning journey covering the fundamentals of the Spring Framework and Spring Boot, progressing towards building database-driven applications with Spring MVC, REST APIs, JPA, Spring Security, and Spring AOP.

## Topics Covered

### 1. Spring Boot & Maven Fundamentals
- Maven project structure, dependencies, `pom.xml`, and build lifecycle.
- Spring Boot auto-configuration and application startup.
- `@SpringBootApplication`, `@EnableAutoConfiguration`, `@ComponentScan`, and `@Configuration`.
- Application properties, logging, DevTools, and `CommandLineRunner`.

### 2. Spring Core – IoC, DI & Beans
- Inversion of Control (IoC) and Dependency Injection (DI).
- Spring Container and ApplicationContext.
- Component scanning and stereotype annotations.
- Constructor, setter, and field injection.
- `@Autowired`, `@Qualifier`, and `@Primary`.
- Bean scopes, lifecycle, lazy initialization, and Java-based configuration using `@Bean`.

### 3. Spring MVC & Thymeleaf
- MVC architecture and DispatcherServlet request lifecycle.
- `@Controller` vs. `@RestController`.
- Request mappings, `@RequestParam`, `@PathVariable`, and `@ModelAttribute`.
- Form handling and data binding with Thymeleaf.
- `@InitBinder`, `WebDataBinder`, and custom property editors.
- Server-side validation using `@Valid`, `BindingResult`, and custom validation annotations.
- CRUD operations: Create, Read, Update, and Delete.
- Form reuse, redirects, and Post/Redirect/Get pattern.

### 4. REST APIs & Exception Handling
- Building REST endpoints and handling HTTP requests.
- JSON serialization and deserialization using Jackson.
- Custom exceptions and structured error responses.
- `@ExceptionHandler`, `@ControllerAdvice`, and `@RestControllerAdvice`.
- `ResponseEntity` and HTTP status codes.
- Spring Data REST, HATEOAS, and HAL.
- OpenAPI and Swagger documentation.

### 5. JDBC, JPA & Hibernate
- JDBC, ORM, JPA, and Hibernate fundamentals.
- DataSource configuration and DAO/Repository patterns.
- Transaction management using `@Transactional`.
- Entity mapping and annotations.
- EntityManager and JpaRepository.
- JPQL and derived query methods.
- Persistence context and entity lifecycle states.
- `persist()`, `find()`, `merge()`, and `remove()`.
- Dirty checking, flushing, and transaction commits.
- Lazy vs. eager fetching and `JOIN FETCH`.

#### Entity Relationships
- One-to-One: Instructor and InstructorDetail.
- One-to-Many / Many-to-One: Instructor and Course.
- Unidirectional One-to-Many: Course and Review.
- Many-to-Many: Student and Course.
- Owning and inverse sides, `mappedBy`, `@JoinColumn`, and `@JoinTable`.
- Cascade operations and bidirectional relationship management.

### 6. Spring Security
- Authentication vs. Authorization.
- Spring Security filter chain.
- `SecurityFilterChain` and HTTP authorization rules.
- In-memory and database-backed authentication.
- Roles and authorities.
- Custom login and logout functionality.
- Role-based UI rendering with Thymeleaf `sec:authorize`.
- JDBC authentication using `JdbcUserDetailsManager`.
- Custom user and authority queries.
- Password hashing using BCrypt and `PasswordEncoder`.
- Securing application endpoints and resources.

### 7. Spring AOP – Aspect-Oriented Programming
- Understanding cross-cutting concerns.
- Aspect, Advice, Join Point, and Pointcut.
- `@Aspect`, `@Component`, and `@Before`.
- Pointcut expressions using `execution()`.
- Reusable pointcuts using `@Pointcut`.
- Pointcut composition using `&&`, `||`, and `!`.
- Aspect ordering using `@Order`.
- `JoinPoint` and `MethodSignature`.
- Accessing method signatures, arguments, target objects, and proxies.
- `@AfterReturning`, `@AfterThrowing`, and `@After`.
- `@Around` advice and `ProceedingJoinPoint`.
- `proceed()` and `proceed(Object[] args)`.
- Method execution-time monitoring.
- Exception handling and fallback responses.
- Integrating Spring AOP into a Spring MVC CRUD application.

## Application Architecture

```text
Client (Browser / API)
        |
        v
Spring Security Filter Chain
        |
        v
DispatcherServlet
        |
        v
Controller Layer
        |
        v
Service Layer
        |
        |---- Spring AOP
        |
        v
DAO / Repository Layer
        |
        v
JPA / Hibernate
        |
        v
Relational Database
```

## Key Learning Outcomes

- Understand Spring's IoC container and dependency injection.
- Build applications using layered architecture.
- Develop MVC applications with Thymeleaf and implement complete CRUD workflows.
- Create REST APIs and handle exceptions effectively.
- Work with relational databases using JPA and Hibernate.
- Model and manage entity relationships.
- Understand transactions and persistence-context behavior.
- Implement authentication and role-based authorization.
- Apply AOP to separate cross-cutting concerns from business logic.
- Understand how Spring components work together in a complete application.

## Technologies & Frameworks

- Java
- Spring Framework
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate
- Spring Security
- Spring AOP
- Maven
- Thymeleaf
- REST APIs
- SQL / Relational Databases
