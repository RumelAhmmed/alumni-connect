
# Alumni Connect Demo

This is a full-stack Java Spring Boot project with:

- MySQL Database
- CRUD operations for Jobs and Events
- Authentication and Authorization (ROLE_USER, ROLE_ADMIN)
- Real-time Chat via WebSocket
- Thymeleaf for UI

## 🚀 How to Run

### Prerequisites

- Java 17+
- Maven
- MySQL

### Setup Instructions

1. **Clone the repository or unzip the source.**

2. **MySQL Setup:**

Create a database named `alumni_connect_db`.

```
CREATE DATABASE alumni_connect_db;
```

(Optional) Load sample data:

```
SOURCE path/to/sample.sql;
```

3. **Update MySQL credentials in `src/main/resources/application.properties`:**

```
spring.datasource.url=jdbc:mysql://localhost:3306/alumni_connect_db
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.thymeleaf.cache=false
```

4. **Run the application:**

```
mvn spring-boot:run
```

Access the app at `http://localhost:8080`

---

## 🧪 Default Roles

- ROLE_USER
- ROLE_ADMIN

## 📁 Project Structure

See full details in `src/main/...`.

## 🧰 Technologies

- Spring Boot
- Spring Security
- Spring Data JPA
- WebSocket (STOMP)
- Thymeleaf
- MySQL

Enjoy! 🎓
