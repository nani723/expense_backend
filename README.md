# Expense Tracker Backend

Spring Boot REST API backend for the Expense Tracker application.

## 🚀 Features

- **User Authentication**: JWT-based authentication system
- **User Management**: Signup and login endpoints
- **Expense CRUD**: Create, Read, Update, Delete expenses
- **Statistics**: Get expense statistics with filtering
- **Security**: Spring Security with JWT tokens
- **Database**: H2 in-memory database (easy to switch to MySQL)

## 📋 Prerequisites

- Java 17 or higher
- Maven 3.6+

## 🛠️ Tech Stack

- **Spring Boot 3.1.5**
- **Spring Security** - Authentication & Authorization
- **Spring Data JPA** - Database operations
- **H2 Database** - In-memory database
- **MySQL** - Production database (optional)
- **JWT** - JSON Web Tokens
- **Lombok** - Reduce boilerplate code

## 📦 Installation & Running

### 1. Build the project
```bash
cd backend
mvn clean install
```

### 2. Run the application
```bash
mvn spring-boot:run
```

Or use the IDE to run `ExpenseTrackerApplication.java`

The server will start on **http://localhost:8080**

### 3. Access H2 Console (for development)
Visit: http://localhost:8080/h2-console
- JDBC URL: `jdbc:h2:mem:expensedb`
- Username: `sa`
- Password: (leave empty)

## 🔗 API Endpoints

### Authentication

#### Signup
```
POST /api/auth/signup
Content-Type: application/json

{
  "name": "John Doe",
  "email": "john@example.com",
  "password": "password123"
}
```

#### Login
```
POST /api/auth/login
Content-Type: application/json

{
  "email": "john@example.com",
  "password": "password123"
}
```

### Expenses (Requires Authorization Header)

#### Get All Expenses
```
GET /api/expenses
Authorization: Bearer <token>
```

#### Get Expense by ID
```
GET /api/expenses/{id}
Authorization: Bearer <token>
```

#### Create Expense
```
POST /api/expenses
Authorization: Bearer <token>
Content-Type: application/json

{
  "title": "Grocery Shopping",
  "amount": 250.00,
  "category": "Food",
  "date": "2024-01-15"
}
```

#### Update Expense
```
PUT /api/expenses/{id}
Authorization: Bearer <token>
Content-Type: application/json

{
  "title": "Updated Title",
  "amount": 300.00,
  "category": "Shopping",
  "date": "2024-01-20"
}
```

#### Delete Expense
```
DELETE /api/expenses/{id}
Authorization: Bearer <token>
```

#### Get Statistics
```
GET /api/expenses/stats?month=1&year=2024&category=Food
Authorization: Bearer <token>
```

## 🔒 Security

- JWT-based authentication
- Password encryption using BCrypt
- Protected API endpoints
- CORS configured for frontend

## 📊 Database

### Development (H2)
- In-memory database
- Auto-creates tables on startup
- Data persists during application runtime

### Production (MySQL)
Update `application.properties` to use MySQL:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/expense_tracker
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

## 🧪 Testing

Run tests:
```bash
mvn test
```

## 📁 Project Structure

```
backend/
├── src/
│   ├── main/
│   │   ├── java/com/expensetracker/
│   │   │   ├── config/         # Configuration classes
│   │   │   ├── controller/     # REST controllers
│   │   │   ├── dto/            # Data Transfer Objects
│   │   │   ├── model/          # Entity models
│   │   │   ├── repository/     # JPA repositories
│   │   │   ├── service/        # Business logic
│   │   │   └── ExpenseTrackerApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
└── pom.xml
```

## 🔧 Configuration

All configuration is in `src/main/resources/application.properties`:

### Port
Default port is **8080**. Change:
```properties
server.port=8080
```

### JWT Secret
Change JWT secret:
```properties
jwt.secret=your-secret-key-here
jwt.expiration=86400000
```

### Database
Switch to MySQL (production):
```properties
# Comment out H2 and add MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/expense_tracker
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

## 🚀 Building for Production

```bash
mvn clean package
java -jar target/expense-tracker-1.0.0.jar
```

## 📝 Notes

- Passwords are encrypted using BCrypt
- JWT tokens expire after 24 hours
- All expenses are user-specific (isolated data)
- H2 console is enabled for development

## 🤝 Contributing

Feel free to contribute by submitting pull requests or opening issues!

