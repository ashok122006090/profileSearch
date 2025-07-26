# User Profile Search – Spring Boot + Angular Application

## Project Overview

This is a full-stack application that enables free-text search over user profiles based on attributes like First Name, Last Name, Email, SSN, and more. Data is fetched from https://dummyjson.com/users and stored locally using SQLite (with optional H2 support for quick testing). The UI is built with Angular and supports sorting, filtering, and global search entirely on the client side.

---

## Tech Stack

**Backend:** Spring Boot 3, Spring Data JPA, SQLite, Hibernate  
**Frontend:** Angular 15+, TypeScript, Bootstrap  
**Documentation:** Springdoc OpenAPI (Swagger UI)  
**Testing:** JUnit, Mockito  
**Build Tool:** Maven  

---

## Features

### Backend (Spring Boot)
- Full-text search on multiple fields (firstName, lastName, email, username, ssn)
- SQLite as the default offline datastore (H2 also included)
- RESTful API with clean architecture
- Exception handling and input validations
- Swagger API documentation
- Unit test cases with code coverage

### Frontend (Angular)
- Global search bar with live filtering
- Client-side sorting and filtering
- Responsive and modular grid view
- Angular services consuming REST endpoints
- Lazy loading and component-based design

---

## API Endpoints

| Method | Endpoint                  | Description                   |
|--------|---------------------------|-------------------------------|
| GET    | `/api/users`              | Get all users                 |
| GET    | `/api/users/search?q=`    | Search users by free-text     |
| POST   | `/api/users`              | Add a new user                |

Swagger UI is available at:  
`http://localhost:8080/swagger-ui/index.html`

---

## Getting Started

### Prerequisites
- Java 17
- NodeJS + Angular CLI
- Maven

### Running the Backend
```bash
git clone https://github.com/ashok122006090/profileSearch.git
cd profileSearch
./mvnw clean install
./mvnw spring-boot:run
