# Console-application-in-Spring-core
Console application using Spring core framework with hibernate


The project is a simple Java application using the Spring Framework and Hibernate for data persistence. It focuses on basic CRUD (Create, Read, Update, Delete) operations on a Student entity. The application uses MySQL as the database.

Steps to Create the Project:
1. Project Setup:
Create a Maven Project:
Use Maven to manage dependencies and build the project.

Add Dependencies:
Add dependencies for Spring, Hibernate, and MySQL Connector in your pom.xml file.

2. Database Setup:
Create MySQL Database:
Create a MySQL database named springorm (or a name of your choice).

Define Student Entity:
Create the Student entity class with fields such as id, name, and city. Annotate the class with Hibernate annotations.

Hibernate Configuration:
Set up Hibernate configuration (XML or JavaConfig) with database connection details.

Spring Configuration:
Create a Spring configuration file (config.xml) to define beans, including DataSource, SessionFactory, and TransactionManager.

3. DAO Layer:
StudentDao:
Create a StudentDao class with methods for CRUD operations. Inject the SessionFactory and use Hibernate's Session for database operations.
4. Service Layer:
StudentService:
Create a StudentService class to interact with the DAO layer. Implement business logic if needed.
5. Main Application:
App Class:
Create a main class (App) to test the application. Use the Spring context to get beans and perform CRUD operations.
6. Testing:
Run the Application:
Run the application to ensure that it connects to the database and performs CRUD operations on the Student entity.
