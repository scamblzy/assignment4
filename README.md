# Endterm Project — Tournament Management System

## Project Overview
This project is a Spring Boot REST API designed to manage players and tournaments.  
It follows a layered architecture and demonstrates the use of JDBC with a relational database, REST principles, and several design patterns.

The application allows creating, retrieving, updating, and deleting players, with data persisted in a real SQLite database.

---

## Technologies Used
- Java 17+
- Spring Boot
- Spring JDBC (`JdbcTemplate`)
- SQLite
- Maven
- Postman (for API testing)

---

## Architecture
The project follows a classic layered architecture:
Controller → Service → Repository → Database

### Layers description:
- **Controller** — handles HTTP requests and responses (REST API)
- **Service** — contains business logic and validation
- **Repository** — works with the database using JDBC
- **Database** — SQLite relational database

This separation improves maintainability, testability, and scalability.

---

##  Database
- Database type: **SQLite**
- Access method: **JDBC (JdbcTemplate)**
- Schema is initialized automatically using `schema.sql`
- Data persists between application restarts, proving real database usage

---

##  API Endpoints

### Player endpoints:
- **GET** `/api/players` — get all players (sorted by age)
- **POST** `/api/players` — create a new player
- **PUT** `/api/players/{id}` — update existing player
- **DELETE** `/api/players/{id}` — delete player by id

All endpoints were tested using Postman.

---

##  Design Patterns Used

### Singleton
**AppLogger**
- Ensures a single logging instance across the application
- Used in the service layer for logging important operations

### Factory
**TournamentFactory**
- Creates different tournament types (e.g. LAN, Online)
- Hides object creation logic from client code
- Returns abstract `Tournament` type instead of concrete implementations

### Builder
**PlayerBuilder**
- Simplifies creation of `Player` objects with multiple parameters
- Improves readability and flexibility
- Demonstrates fluent API usage

---

## Global Exception Handling
- Implemented using `@RestControllerAdvice`
- Custom exceptions (e.g. `InvalidInputException`) are handled centrally
- Ensures consistent and clean error responses
- Prevents controllers from being cluttered with try-catch blocks

---

## Validation
- Input validation is handled in the domain model
- Invalid data results in custom exceptions
- Exceptions are translated into proper HTTP responses (e.g. 400 Bad Request)

---

## How JDBC Usage Is Verified
- The application uses `JdbcTemplate`
- Data is stored in a physical SQLite database file
- Data persists after application restart
- Disabling JDBC repository breaks persistence, proving it is actually used

---

## Testing
- All CRUD operations were tested using Postman
- Validation and error handling were tested with invalid inputs
- Database persistence was verified across restarts

---

## Reflection

During this project, I learned how a real backend application is structured and how different layers interact with each other.  
The most challenging part was configuring JDBC and understanding the difference between in-memory storage and a real relational database.

Working with JDBC helped me understand SQL constraints, primary keys, and real database errors, which are often hidden when using simpler abstractions.  
Implementing global exception handling and validation improved the robustness and clarity of the API.

This project helped me gain practical experience with Spring Boot, REST architecture, and design patterns, and showed how theoretical concepts are applied in real-world applications.

---

## Conclusion
This project demonstrates a complete Spring Boot REST application with:
- Clean layered architecture
- Real database integration using JDBC
- Proper exception handling and validation
- Usage of multiple design patterns

It meets all the endterm project requirements and reflects real backend development practices.

