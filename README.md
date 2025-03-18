# DeliciousFood Backend

This is the backend for **DeliciousFood**, an online food ordering and delivery platform. The application allows users to place orders, restaurants to manage them, and delivery personnel to fulfill deliveries.

## 🛠️ Technologies Used

- **Java 17**
- **Spring Boot** (Backend framework)
- **PostgreSQL** (Database)


## 📂 Architecture

The backend follows a **layered architecture** and the **C4 model**, with the following modules:

- **Presentation Layer**
  - Web App: **Angular**
  - Mobile App: **React Native** or **Flutter**

- **Business Layer** (Backend - Spring Boot)
  - Order processing logic
  - Validations and user management
  - Real-time notifications using **Kafka & WebSockets**

- **Persistence Layer**
  - Repositories and DAO to handle database access

- **Data Layer**
  - Relational database **PostgreSQL**

## 🚀 How to Run the Project

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/deliciousfood-backend.git
   cd deliciousfood-backend
