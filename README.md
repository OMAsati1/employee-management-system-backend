# Employee Management System - Backend

A RESTful Employee Management System backend built using **Spring Boot**. It provides CRUD APIs for managing employee records and integrates with a MySQL database.

## 🚀 Features

- Create Employee
- Get Employee by ID
- Get All Employees
- Update Employee
- Delete Employee
- Duplicate Email Validation
- Global Exception Handling
- RESTful API Design
- MySQL Database Integration

## 🛠️ Tech Stack

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Lombok

## 📂 Project Structure

```
src
├── controller
├── dto
├── entity
├── exception
├── mapper
├── repository
├── service
└── resources
```

## ⚙️ Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/OMAsati1/employee-management-system-backend.git
```

### 2. Navigate to the project

```bash
cd employee-management-system-backend
```

### 3. Configure Database

Create an `application.properties` file inside:

```
src/main/resources/
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Or copy the provided:

```
application.properties.example
```

and rename it to

```
application.properties
```

### 4. Run the application

```bash
./mvnw spring-boot:run
```

or

```bash
mvn spring-boot:run
```

The backend will start at:

```
http://localhost:8080
```

## 📌 REST API Endpoints

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | `/api/employees` | Get all employees |
| GET | `/api/employees/{id}` | Get employee by ID |
| POST | `/api/employees` | Create employee |
| PUT | `/api/employees/{id}` | Update employee |
| DELETE | `/api/employees/{id}` | Delete employee |

## ⚠️ Exception Handling

The project includes centralized exception handling using `@RestControllerAdvice`.

Handled exceptions include:

- Employee Not Found (404)
- Duplicate Email (409)
- Internal Server Error (500)

## 📁 Environment Variables

Sensitive database credentials are **not committed** to GitHub.

Use:

```
application.properties.example
```

to configure your local database.

## 🤝 Frontend Repository

https://github.com/OMAsati1/employee-management-system-frontend

## 👨‍💻 Author

**Om Asati**

GitHub: https://github.com/OMAsati1
