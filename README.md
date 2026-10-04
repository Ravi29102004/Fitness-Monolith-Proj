# 🏋️ Fitness Monolith

<p align="center">

**A production-oriented Fitness Management REST API built with Java & Spring Boot**

</p>

<p align="center">

Java • Spring Boot • Spring Security • JWT • JPA • Hibernate • PostgreSQL • Docker • Neon • Render

</p>

---

## 🚀 About The Project

**Fitness Monolith** is a backend-focused fitness management application built to understand how a real-world Spring Boot application is designed, secured, persisted, containerized, and deployed.

The project started as a traditional layered Spring Boot application and is intentionally designed as a foundation for a future **Microservices Architecture**.

The primary goal is not just to build CRUD APIs, but to understand the complete backend development lifecycle:

```text
Java
  ↓
Spring Boot
  ↓
REST APIs
  ↓
JPA / Hibernate
  ↓
PostgreSQL
  ↓
Spring Security
  ↓
JWT Authentication
  ↓
Docker
  ↓
Cloud Database
  ↓
Cloud Deployment
  ↓
Microservices Ready
```

---

# ✨ Key Features

* 🔐 JWT-based authentication and authorization
* 👤 User management
* 🏃 Fitness activity management
* 🗄️ PostgreSQL database integration
* 🔄 JPA / Hibernate ORM
* 🌐 RESTful APIs
* 🛡️ Spring Security
* ✅ Request validation
* ⚠️ Global exception handling
* 📦 DTO-based API design
* 🐳 Docker containerization
* ☁️ Cloud PostgreSQL using Neon
* 🚀 Cloud deployment using Render
* 🔧 Environment-based configuration
* 📊 Production-oriented application structure
* 🔮 Designed for future Microservices migration

---

# 🧰 Tech Stack

| Technology         | Purpose                        |
| ------------------ | ------------------------------ |
| ☕ Java             | Core programming language      |
| 🌱 Spring Boot     | Backend framework              |
| 🔐 Spring Security | Authentication & authorization |
| 🎫 JWT             | Stateless authentication       |
| 🗃️ JPA            | Persistence API                |
| 💤 Hibernate       | ORM implementation             |
| 🐘 PostgreSQL      | Relational database            |
| 📦 Maven           | Dependency & build management  |
| 🐳 Docker          | Containerization               |
| ☁️ Neon            | Cloud PostgreSQL               |
| 🚀 Render          | Cloud deployment               |
| 🧪 Postman         | API testing                    |
| 🔀 Git & GitHub    | Version control                |

---

# 🏗️ Architecture

The current application follows a layered monolithic architecture:

```text
                    CLIENT
                      │
                      ▼
                ┌─────────────┐
                │ Controller  │
                └──────┬──────┘
                       │
                       ▼
                ┌─────────────┐
                │   Service   │
                └──────┬──────┘
                       │
                       ▼
                ┌─────────────┐
                │ Repository  │
                └──────┬──────┘
                       │
                       ▼
                ┌─────────────┐
                │ JPA/Hibernate│
                └──────┬──────┘
                       │
                       ▼
                 PostgreSQL
```

Security is integrated into the request flow:

```text
Client
  ↓
Spring Security
  ↓
JWT Validation
  ↓
Controller
  ↓
Service
  ↓
Repository
  ↓
PostgreSQL
```

---

# 🔐 Authentication Flow

The application uses token-based authentication.

```text
User
 │
 │ Login
 ▼
Authentication API
 │
 ▼
Credentials Validation
 │
 ▼
JWT Generated
 │
 ▼
Client
 │
 │ Authorization: Bearer <token>
 ▼
Spring Security Filter
 │
 ▼
JWT Validation
 │
 ▼
Protected API
```

This provides a stateless authentication model suitable for REST APIs.

---

# 🗄️ Database Layer

The application uses:

**PostgreSQL + JPA + Hibernate**

Basic persistence flow:

```text
REST Request
     ↓
DTO
     ↓
Service
     ↓
Entity
     ↓
JPA Repository
     ↓
Hibernate
     ↓
PostgreSQL
```

The application is configured using environment variables rather than hardcoding production database credentials.

Example:

```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PWD}
```

---

# 🐳 Docker

The application can be packaged as a Docker image and executed as a container.

```text
Spring Boot Application
        ↓
     Dockerfile
        ↓
    Docker Image
        ↓
     Container
```

Typical workflow:

```bash
mvn clean package

docker build -t fitness-monolith .

docker run -p 8080:8080 fitness-monolith
```

For Apple Silicon environments, production images can be built for AMD64:

```bash
docker buildx build \
  --platform linux/amd64 \
  -t ravi29102004/fitness-monolith:latest \
  --push .
```

---

# ☁️ Cloud Deployment

The project has been designed for cloud deployment using:

```text
Docker Image
     ↓
Docker Hub
     ↓
Render
     ↓
Spring Boot Application
     ↓
Neon PostgreSQL
```

Production configuration is provided through environment variables.

### Environment Variables

```text
DB_URL
DB_USER
DB_PWD
PORT
```

Sensitive credentials should never be committed to Git.

---

# 🧪 API Testing

The APIs can be tested using **Postman**.

Typical flow:

```text
Register
   ↓
Login
   ↓
Receive JWT
   ↓
Attach Bearer Token
   ↓
Access Protected APIs
```

Example:

```http
Authorization: Bearer <JWT_TOKEN>
```

---

# 📚 Concepts Studied Through This Project

This project represents the backend concepts studied and practiced during development.

### Java

* Object-Oriented Programming
* Classes & Objects
* Interfaces
* Exception Handling
* Collections
* Generics
* Streams
* Lambda Expressions
* Maven-based project structure

### Spring Boot

* Dependency Injection
* IoC
* Controllers
* Services
* Repositories
* REST APIs
* DTOs
* Validation
* Exception Handling
* Configuration
* Profiles

### Persistence

* JPA
* Hibernate
* Entity Mapping
* Repositories
* Transactions
* PostgreSQL
* ORM concepts

### Security

* Spring Security
* Authentication
* Authorization
* JWT
* Password handling
* Protected endpoints
* Stateless authentication

### DevOps / Deployment

* Git
* GitHub
* Docker
* Dockerfile
* Docker images
* Containers
* Docker Hub
* Environment variables
* Cloud deployment
* Neon PostgreSQL
* Render

---

# 🧠 Microservices Roadmap

This monolith is intentionally treated as the starting point for a future distributed architecture.

Current:

```text
                 FITNESS MONOLITH
                       │
          ┌────────────┼────────────┐
          │            │            │
        Auth         User       Activity
          │            │            │
          └────────────┼────────────┘
                       │
                    Database
```

Future architecture:

```text
                         Client
                           │
                           ▼
                     API Gateway
                           │
                     Service Discovery
                           │
          ┌────────────────┼────────────────┐
          ▼                ▼                ▼
     Auth Service     User Service    Activity Service
          │                │                │
       Auth DB           User DB        Activity DB
                                           │
                                           ▼
                                         Kafka
                                           │
                              ┌────────────┼────────────┐
                              ▼            ▼            ▼
                         Analytics   Notification    Recommendation
```

Planned technologies:

* Spring Cloud
* Eureka
* API Gateway
* OpenFeign
* Resilience4j
* Kafka
* Redis
* Docker Compose
* Kubernetes
* Prometheus
* Grafana
* AWS

---

# 🎯 Learning Objectives

This project was built to understand more than just CRUD.

The major learning objectives are:

```text
Build
 ↓
Secure
 ↓
Persist
 ↓
Test
 ↓
Containerize
 ↓
Deploy
 ↓
Monitor
 ↓
Scale
 ↓
Decompose into Microservices
```

---

# 🔮 Future Improvements

* [ ] Add comprehensive unit tests
* [ ] Add integration tests
* [ ] Add Testcontainers
* [ ] Add Redis caching
* [ ] Introduce Kafka event-driven communication
* [ ] Add API Gateway
* [ ] Introduce Eureka Service Discovery
* [ ] Split monolith into microservices
* [ ] Add Resilience4j
* [ ] Add centralized configuration
* [ ] Add Prometheus metrics
* [ ] Add Grafana dashboards
* [ ] Containerize complete microservices architecture
* [ ] Deploy microservices to Kubernetes
* [ ] Add AWS infrastructure

---

# 📈 Project Evolution

```text
Phase 1
Java + Spring Boot
        ↓
Phase 2
REST API + JPA/Hibernate
        ↓
Phase 3
PostgreSQL + Security
        ↓
Phase 4
JWT Authentication
        ↓
Phase 5
Docker
        ↓
Phase 6
Neon + Render
        ↓
Phase 7
Microservices
        ↓
Phase 8
Kafka + Redis
        ↓
Phase 9
Kubernetes
        ↓
Phase 10
Cloud + Observability
```

---

# 👨‍💻 Author

**Ravi Ranjan**

Java Backend Developer in progress, focused on:

```text
Java
Spring Boot
Backend Engineering
Microservices
Distributed Systems
Cloud & DevOps
Data Structures & Algorithms
```

---

## ⭐ Why This Project?

This repository is not just a demonstration of a completed application.

It represents a learning journey from a **Spring Boot Monolith toward a production-oriented Microservices architecture**.

> **Build the monolith. Understand the boundaries. Then break it into services.**

---

⭐ If you find this project useful, consider giving the repository a star.












==============Images===========================







<img width="1437" height="875" alt="Screenshot 2026-10-04 at 1 57 31 PM" src="https://github.com/user-attachments/assets/bc98a58c-f20a-4502-9f4a-287f8b025ec6" />














<img width="1437" height="875" alt="Screenshot 2026-10-04 at 1 58 25 PM" src="https://github.com/user-attachments/assets/deb5757e-aad8-4738-8a52-fdb6c8d4f47b" />














<img width="1437" height="875" alt="Screenshot 2026-10-04 at 1 58 33 PM" src="https://github.com/user-attachments/assets/2513ffe6-9761-4d8c-beb3-9d1c72a8c298" />










<img width="1437" height="875" alt="Screenshot 2026-10-04 at 1 59 27 PM" src="https://github.com/user-attachments/assets/f904b210-7494-4439-8cdc-6ff2c8b62be0" />










<img width="1437" height="875" alt="Screenshot 2026-10-04 at 1 59 36 PM" src="https://github.com/user-attachments/assets/d8320444-1d63-4693-bb5c-e763e80c6c6c" />









<img width="1437" height="676" alt="Screenshot 2026-10-04 at 2 00 00 PM" src="https://github.com/user-attachments/assets/6d741b78-45fd-460f-8f86-ad63a48bb7c4" />









<img width="1437" height="676" alt="Screenshot 2026-10-04 at 2 00 10 PM" src="https://github.com/user-attachments/assets/7532ef13-089a-47ae-b669-0a2cfad00166" />









