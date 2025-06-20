# 🎓 Alumni Connect Platform

A full-featured Alumni Connection web application built using Spring Boot, Thymeleaf, 
and MySQL to help alumni and current students connect, communicate, and collaborate.

## 🚀 Features

- 🔐 User Authentication (Login/Signup with role-based access)
- 🧑‍🎓 Profile Management for alumni and students
- 💬 Real-time Chat functionality
- 📢 Event & Job Posting
- 🛠️ Admin Panel for managing users, events, and content
- 📄 Fully integrated with MySQL for data persistence
- 🎨 Clean and responsive UI with Bootstrap

## 🏗️ Technologies Used

| Backend     | Frontend       | Database | Others                |
|-------------|----------------|----------|------------------------|
| Spring Boot | Thymeleaf      | MySQL    | JPA, Hibernate, WebSocket |
| Java        | HTML/CSS/JS    |          | Maven, REST API       |

## 📁 Project Structure

alumni-connect/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/alumniconnect/
│   │   │       ├── controller/
│   │   │       ├── entity/
│   │   │       ├── service/
│   │   │       └── AlumniConnectApplication.java
│   │   └── resources/
│   │       ├── templates/
│   │       ├── static/
│   │       └── application.properties
└── pom.xml

## Configure your MySQL Database
- Update your credentials in src/main/resources/application.properties.

## Access the app
Web: http://localhost:8080

🛠️ Future Improvements
- Mobile responsive optimization
- Video conferencing integration
- Advanced search and filtering for alumni
- Notification system
- AI Intregration 