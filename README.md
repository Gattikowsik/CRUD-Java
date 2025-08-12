# 🛒 ECOM_1 - Spring Boot E-commerce User Management API

## 📌 Overview
`ECOM_1` is a **Spring Boot REST API** designed for managing users in an e-commerce platform.  
It supports full **CRUD operations** for users, including their associated **address details**.

This is a backend service built with **Java, Spring Boot, and JPA/Hibernate**.

---

## 📂 Project Structure
E1-master/
│
├── ECOM_1/
│ ├── src/main/java/com/uttamatul/ECOM_1/
│ │ ├── controller/ # REST controllers
│ │ │ └── UserController.java
│ │ ├── entity/ # Entities (User, Address, UserRole)
│ │ ├── repository/ # Spring Data JPA Repositories
│ │ ├── service/ # Business Logic Layer
│ │ └── Ecom1Application.java
│ ├── resources/
│ │ └── application.properties
│ └── test/ # Unit tests
└── pom.xml

yaml
Copy
Edit

---

## ⚙️ Technologies Used
- **Java 17+**
- **Spring Boot 3+**
- **Spring Web**
- **Spring Data JPA**
- **Hibernate**
- **Lombok**
- **H2 / MySQL Database** (configurable)
- **Maven**

---

## 🚀 Getting Started

### 1️⃣ Clone the Repository
git clone https://github.com/Gattikowsik/E1-master.git
cd E1-master/ECOM_1
2️⃣ Configure Database
Edit src/main/resources/application.properties:

properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecom_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
For H2 in-memory database:

properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true

3️⃣ Build & Run the Application
mvn spring-boot:run
The app will start at:

http://localhost:8080
📍 API Endpoints
Method	Endpoint	Description
GET	/api/users	Get all users
GET	/api/users/{id}	Get user by ID
POST	/api/users	Create a new user
PUT	/api/users/{id}	Update an existing user
DELETE	/api/users/{id}	Delete a user

📄 Example JSON Requests
Create a User
json
{
  "fname": "John",
  "lname": "Doe",
  "email": "john.doe@example.com",
  "password": "password123",
  "phone": "9876543210",
  "userRole": "CUSTOMER",
  "address": {
    "street": "123 Main St",
    "city": "Bangalore",
    "state": "Karnataka",
    "country": "India",
    "zipCode": "560001"
  }
}
Update a User
json
{
  "fname": "Jane",
  "lname": "Smith",
  "email": "jane.smith@example.com",
  "password": "newpassword",
  "phone": "9876543210",
  "userRole": "ADMIN",
  "address": {
    "street": "456 Park Ave",
    "city": "Delhi",
    "state": "Delhi",
    "country": "India",
    "zipCode": "110001"
  }
}
📦 Build JAR
mvn clean package
java -jar target/ecom1-0.0.1-SNAPSHOT.jar
🔮 Future Enhancements
Product management APIs

JWT authentication & authorization

Role-based access control (Admin, Customer)

Swagger/OpenAPI documentation

🧑‍💻 Author
Uttamatul
📧 Email: kowsikgatti11@gmail.com
🔗 GitHub: Gattikowsik
