<div align="center">

# 💰 Expense Tracker API
### *Secure • Simple • JWT Powered*

<p align="center">
  <img src="https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk">
  <img src="https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=springboot">
  <img src="https://img.shields.io/badge/Spring_Security-6.x-6DB33F?style=for-the-badge&logo=springsecurity">
  <img src="https://img.shields.io/badge/JWT-Authentication-blue?style=for-the-badge">
  <img src="https://img.shields.io/badge/H2-Database-0078D4?style=for-the-badge">
  <img src="https://img.shields.io/badge/Postman-Tested-orange?style=for-the-badge&logo=postman">
</p>

*A secure REST API that enables users to manage their personal expenses with JWT-based authentication and Spring Security.*

</div>

---

# 📖 About the Project

The **Expense Tracker API** is a RESTful backend application built using **Spring Boot** that allows users to securely manage their personal expenses.

Each user has their own account and can perform CRUD operations only on their own expenses. Authentication is implemented using **JSON Web Tokens (JWT)**, making the application completely stateless and secure.

This project was built to gain a deeper understanding of **Spring Security**, **JWT Authentication**, **Spring Data JPA**, and how authentication and authorization work internally in modern backend applications.

---

# ✨ Features

### 👤 User Authentication

- Register as a new user
- Login with email and password
- Password encryption using BCrypt
- Generate JWT after successful login
- Stateless authentication using JWT
- Protected REST endpoints

---

### 💸 Expense Management

- Create a new expense
- View all personal expenses
- Update existing expenses
- Delete expenses
- Every expense is associated with its authenticated user

---

### 🔍 Expense Filtering

Users can filter their expenses based on:

- 📅 Past Week
- 📆 Past Month
- 🗓️ Last 3 Months
- 📌 Custom Date Range

---

# 🛠️ Tech Stack

| Technology | Purpose |
|------------|----------|
| Java | Programming Language |
| Spring Boot | Backend Framework |
| Spring Security | Authentication & Authorization |
| Spring Data JPA | Database Operations |
| Hibernate | ORM Framework |
| JWT (JJWT 0.12.7) | Authentication |
| BCrypt | Password Encryption |
| H2 Database | In-Memory Database |
| Maven | Dependency Management |
| Postman | API Development & API Testing |

---

# 🔐 Authentication Flow

```text
          Register
              │
              ▼
   Password encrypted using BCrypt
              │
              ▼
        Stored in H2 Database
              │
              ▼
            Login
              │
              ▼
   Credentials validated
              │
              ▼
      Generate JWT Token
              │
              ▼
Client sends JWT in Authorization Header
              │
              ▼
  JwtAuthenticationFilter intercepts request
              │
              ▼
       JWT Token Validation
              │
              ▼
Authentication stored in Security Context
              │
              ▼
     Access Protected Endpoints
```

---

# 🔒 Security

This project uses **Spring Security** along with a custom JWT implementation to secure every protected endpoint.

### Authentication includes:

- BCrypt password hashing before storing credentials
- JWT generation during login
- JWT validation for every incoming request
- Custom `JwtAuthenticationFilter`
- Stateless authentication
- User-specific authorization for expense operations

---

# 📌 REST API Endpoints

## Authentication

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/signup` | Register a new user |
| POST | `/login` | Authenticate user and generate JWT |

---

## Expenses

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | `/expenses` | Retrieve all expenses |
| POST | `/expenses` | Create a new expense |
| PUT | `/expenses/{id}` | Update an existing expense |
| DELETE | `/expenses/{id}` | Delete an expense |

---

## Expense Filters

| Endpoint | Description |
|----------|-------------|
| `/expenses?filter=week` | Expenses from the past week |
| `/expenses?filter=month` | Expenses from the past month |
| `/expenses?filter=3months` | Expenses from the last 3 months |
| `/expenses?startDate=yyyy-MM-dd&endDate=yyyy-MM-dd` | Expenses within a custom date range |

---

# 📚 What I Learned

Developing this project helped me strengthen my understanding of:

- Spring Security
- JWT Authentication
- Custom Authentication Filters
- Stateless Authentication
- Password Encryption using BCrypt
- Spring Data JPA
- Hibernate Entity Relationships
- DTO Mapping
- REST API Design
- Repository Pattern
- User Authentication & Authorization
- Exception Handling
- Building Secure Backend Applications

---

<div align="center">

### ⭐ If you found this project interesting, consider giving it a Star!

**"Secure your expenses. Simplify your spending."** 💰

</div>
