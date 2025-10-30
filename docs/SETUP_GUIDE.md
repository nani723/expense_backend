# Expense Tracker - Complete Setup Guide

This guide will help you set up and run the Expense Tracker application with both frontend and backend.

## 📋 Prerequisites

- **Node.js** (v16 or higher) and **npm**
- **Java 17** or higher
- **Maven 3.6+**
- An IDE (VS Code, IntelliJ IDEA, etc.)

## 🚀 Quick Start

### 1. Backend Setup

```bash
# Navigate to backend directory
cd backend

# Build the project
mvn clean install

# Run the Spring Boot application
mvn spring-boot:run
```

The backend will start on **http://localhost:8080**

You can verify it's running by visiting:
- API: http://localhost:8080/api/auth
- H2 Console: http://localhost:8080/h2-console

**H2 Console Credentials:**
- JDBC URL: `jdbc:h2:mem:expensedb`
- Username: `sa`
- Password: (leave empty)

### 2. Frontend Setup

```bash
# Navigate to frontend directory (in a new terminal)
cd frontend

# Install dependencies
npm install

# Start the development server
npm run dev
```

The frontend will start on **http://localhost:5173**

## 📁 Project Structure

```
Expense_Project/
├── backend/                 # Spring Boot Backend
│   ├── src/
│   │   ├── main/java/com/expensetracker/
│   │   │   ├── config/         # Security & CORS config
│   │   │   ├── controller/     # REST Controllers
│   │   │   ├── dto/            # Data Transfer Objects
│   │   │   ├── model/          # Entity Models (User, Expense)
│   │   │   ├── repository/     # JPA Repositories
│   │   │   ├── service/        # Business Logic
│   │   │   └── ExpenseTrackerApplication.java
│   │   └── resources/
│   │       └── application.properties
│   ├── pom.xml               # Maven dependencies
│   └── README.md
├── frontend/                # React + Vite Frontend
│   ├── src/
│   │   ├── contexts/         # Auth Context
│   │   ├── pages/            # Login, Signup, Dashboard
│   │   ├── services/         # API service
│   │   └── App.jsx           # Main app with routing
│   ├── package.json
│   └── README.md
└── README.md               # Main project README
```

## 🔧 Configuration

### Backend Configuration

Edit `backend/src/main/resources/application.properties`:

```properties
# Change port (default: 8080)
server.port=8080

# JWT Secret (change for production)
jwt.secret=mySecretKey123456789012345678901234567890
jwt.expiration=86400000

# CORS (Frontend URL)
spring.web.cors.allowed-origins=http://localhost:5173
```

### Frontend Configuration

Edit `frontend/src/services/api.js` to change the backend URL:

```javascript
const API_BASE_URL = 'http://localhost:8080/api'
```

## 🎯 Features

### Authentication
- ✅ User Signup
- ✅ User Login
- ✅ JWT Token-based Authentication
- ✅ Protected Routes

### Expense Management
- ✅ Add Expenses
- ✅ View All Expenses
- ✅ Edit Expenses
- ✅ Delete Expenses
- ✅ Filter by Month, Year, Category
- ✅ Real-time Statistics

### Statistics
- Total Expenses
- This Month's Total
- Average Expense
- Total Transactions

## 🔑 Default Test User

After running the application, you can:

1. **Sign up** at http://localhost:5173/signup
2. Create your account with:
   - Name: Your Name
   - Email: your@email.com
   - Password: yourpassword

3. Or **login** if you already have an account

## 📡 API Endpoints

### Authentication
- `POST /api/auth/signup` - Create account
- `POST /api/auth/login` - Login

### Expenses
- `GET /api/expenses` - Get all expenses (requires token)
- `GET /api/expenses/{id}` - Get expense by ID
- `POST /api/expenses` - Create expense
- `PUT /api/expenses/{id}` - Update expense
- `DELETE /api/expenses/{id}` - Delete expense
- `GET /api/expenses/stats` - Get statistics

## 🛠️ Development

### Running Backend in IDE

1. Open the `backend` folder in your IDE
2. Right-click on `ExpenseTrackerApplication.java`
3. Select "Run" or "Debug"

### Running Frontend

```bash
cd frontend
npm run dev
```

### Building for Production

**Backend:**
```bash
cd backend
mvn clean package
java -jar target/expense-tracker-1.0.0.jar
```

**Frontend:**
```bash
cd frontend
npm run build
```

The production build will be in `frontend/dist/`

## 🐛 Troubleshooting

### Backend won't start
- Make sure Java 17+ is installed: `java -version`
- Make sure Maven is installed: `mvn -version`
- Check if port 8080 is already in use
- Check logs in console for errors

### Frontend won't connect to backend
- Make sure backend is running on port 8080
- Check CORS configuration in `application.properties`
- Verify API URL in `frontend/src/services/api.js`
- Check browser console for errors

### Authentication issues
- Check JWT secret in `application.properties`
- Verify token is being sent in request headers
- Check backend logs for authentication errors

## 📊 Database

### Development (H2 - In-memory)
- Data is stored in memory
- Access via H2 Console at http://localhost:8080/h2-console
- Data is lost when server stops

### Production (MySQL)
To switch to MySQL, update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/expense_tracker
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

## 🚢 Deployment

### Backend
Deploy the JAR file to any cloud service (AWS, Azure, Heroku, etc.)

```bash
mvn clean package
# Upload target/expense-tracker-1.0.0.jar
```

### Frontend
Deploy the build folder to:
- Netlify
- Vercel
- AWS S3
- GitHub Pages

Update API URL in `services/api.js` before building.

## 📝 Notes

- Passwords are encrypted using BCrypt
- JWT tokens expire after 24 hours
- All expenses are user-specific (isolated data)
- H2 console is enabled for development
- CORS is configured for localhost:5173

## 🤝 Support

For issues or questions:
1. Check the README files in each directory
2. Review the code comments
3. Check the application logs

## 🎉 You're All Set!

Now you can:
1. Create an account
2. Login
3. Add, edit, and delete expenses
4. View statistics
5. Filter your expenses

Happy tracking! 💰



