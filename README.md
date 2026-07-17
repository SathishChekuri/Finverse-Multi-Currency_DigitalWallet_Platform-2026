# 💳 FinVerse - Multi-Currency Digital Wallet Platform

A full-stack multi-currency digital wallet platform built using **Spring Boot**, **React** and **MySQL**.

The application enables users to securely manage digital wallets, maintain balances in multiple currencies, transfer funds between FinVerse users, add money from linked bank accounts and withdraw money back to their banks through simulated financial transactions while following industry-standard backend architecture and REST API development practices.

## 🎯 Project Goal

Build **FinVerse** in **30 days** by implementing one module at a time while learning backend development, system design, Spring Boot and full-stack application development.
# 🚀 Development Roadmap

- [x] Day 1 - Project Setup
- [x] Day 2 - Database Design & User Entity
- [ ] Day 3 - Wallet Module
- [ ] Day 4 - Currency Management
- [ ] Day 5 - Bank Account Module
- [ ] Day 6 - Authentication (JWT)
- [ ] Day 7 - User APIs
- [ ] Day 8 - Wallet APIs
- [ ] Day 9 - Money Transfer
- [ ] Day 10 - Transaction History
- [ ] Day 11 - Add Money
- [ ] Day 12 - Withdraw Money
- [ ] Day 13 - Notifications
- [ ] Day 14 - Currency Conversion
- [ ] Day 15 - KYC Module
- [ ] Day 16 - Admin Dashboard
- [ ] Day 17 - Fraud Detection
- [ ] Day 18 - Analytics
- [ ] Day 19 - QR Payments
- [ ] Day 20 - Bill Payments
- [ ] Day 21 - Rewards
- [ ] Day 22 - Exception Handling
- [ ] Day 23 - Global Validation
- [ ] Day 24 - Testing
- [ ] Day 25 - React Integration
- [ ] Day 26 - Docker
- [ ] Day 27 - Swagger Documentation
- [ ] Day 28 - Deployment
- [ ] Day 29 - Performance Optimization
- [ ] Day 30 - Final Documentation
---
# 🚀 Technology Stack

## Backend

* Java 21
* Spring Boot
* Spring Security
* Spring Data JPA
* Hibernate
* JWT *(Planned)*

## Frontend

* React
* Tailwind CSS *(Planned)*

## Database

* MySQL

## Tools

* Maven
* Git & GitHub
* Postman
* Docker *(Planned)*
* Swagger *(Planned)*

---

# 📂 Project Modules

* User Management
* Authentication & Authorization
* Multi-Currency Wallet Management
* Currency Management
* Currency Conversion
* Bank Account Management
* Money Transfer
* Transaction History
* QR Payment Simulation
* Bill Payments
* Notifications
* Rewards & Cashback
* Expense Analytics
* Admin Dashboard
* KYC Verification
* Fraud Detection
* Docker Deployment
---

# 📅 Development Progress

## ✅ Day 1 - Project Setup

### Completed Tasks

* Created the Spring Boot project using Spring Initializr.
* Configured Java 21 development environment.
* Connected Spring Boot with MySQL.
* Configured Spring Data JPA and Hibernate.
* Added Spring Security dependency.
* Successfully started the Spring Boot application.
* Initialized the Git repository.
* Created the GitHub repository.
* Pushed the initial project setup to GitHub.

### Concepts Learned

* Spring Boot Project Structure
* Maven Dependency Management
* Spring Data JPA
* Hibernate ORM
* MySQL Configuration
* Embedded Tomcat
* Spring Security (Default Configuration)
* Git & GitHub Workflow

### Challenges Faced

* Resolved Java 17 vs Java 21 configuration issues.
* Fixed Maven JDK compatibility issues.
* Configured MySQL datasource correctly.
* Successfully connected Spring Boot with MySQL.

### Project Status

* ✅ Spring Boot application is running successfully.
* ✅ MySQL database connected.
* ✅ Development environment is ready for feature implementation.

---
## ✅ Day 2 - Database Design & User Entity

### Completed Tasks

* Designed the overall system architecture.
* Planned the database schema for the application.
* Identified core entities required for the project.
* Designed relationships between User, Wallet, BankAccount, WalletBalance, Currency, Transaction, Notification, OTP, KYC and Admin.
* Created the package structure following layered architecture.
* Implemented the `User` entity.
* Implemented `Role` and `AccountStatus` enums.
* Configured Lombok to reduce boilerplate code.

### Concepts Learned

* Layered Architecture
* Database Design
* Entity Relationship Design
* Primary Key
* Auto Increment Strategy
* JPA Entity Mapping
* `@Entity`
* `@Table`
* `@Id`
* `@GeneratedValue`
* `@Column`
* `@Enumerated`
* Enum Design
* Lombok
* Builder Pattern
* `@CreationTimestamp`
* `@UpdateTimestamp`

### Challenges Faced

* Designed a scalable multi-currency wallet architecture.
* Decided to separate User and Wallet responsibilities.
* Designed the database to support multiple currencies without changing the schema.
* Fixed enum configuration issues during development.

### Project Status

* ✅ User entity completed.
* ✅ Database design finalized.
* ✅ Project architecture established.
* ✅ Ready to implement the Wallet module.

  ## Day 3 - Wallet & Currency Module

### Completed Tasks

- Designed Wallet entity
- Designed Currency entity
- Designed WalletBalance entity
- Implemented One-to-One relationship between User and Wallet
- Implemented One-to-Many relationship between Wallet and WalletBalance
- Implemented Many-to-One relationship between WalletBalance and Currency
- Used BigDecimal for financial values
- Added composite unique constraint on Wallet and Currency
- Implemented wallet lifecycle using WalletStatus enum

### Concepts Learned

- One-to-One Relationship
- One-to-Many Relationship
- Many-to-One Relationship
- @JoinColumn
- mappedBy
- Cascade
- orphanRemoval
- BigDecimal
- Composite Unique Constraints
- Database Normalization

### Project Status

- ✅ User Module Completed
- ✅ Wallet Module Completed
- ✅ Multi-Currency Design Completed
- ✅ Ready to implement Bank Account Module

# 📊 Current Status

**Current Phase:** Database Design & User Module

**Progress:** **2 / 30 Days Completed (7%)**

**Next:** Wallet Module & Entity Relationships
---

## 👨‍💻 Developer

**Sathish Chekuri**

B.Tech Computer Science & Engineering

Java | Spring Boot | Full Stack Development
