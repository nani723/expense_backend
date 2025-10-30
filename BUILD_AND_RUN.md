# Build and Run Instructions

## ✅ Prerequisites

Before building, ensure you have:
- **Java 17** or higher installed
- **Maven** installed (or use your IDE's built-in Maven)

Check versions:
```bash
java -version  # Should show Java 17 or higher
mvn -version   # Should show Maven version
```

## 🚀 Building the Project

### Step 1: Navigate to Backend Directory
```bash
cd backend
```

### Step 2: Clean and Compile
```bash
mvn clean compile
```

This will:
- Download all dependencies
- Compile the Java source files
- Check for any compilation errors

**Expected Output:**
```
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
```

### Step 3: Run the Application

**Option A: Using Maven**
```bash
mvn spring-boot:run
```

**Option B: Build JAR and Run**
```bash
mvn clean package
java -jar target/expense-tracker-1.0.0.jar
```

## ✨ Success Indicators

When the application starts successfully, you'll see:

```
Started ExpenseTrackerApplication in X.XXX seconds
Tomcat started on port 8080
```

### Access Points:

1. **Backend API**: http://localhost:8080
2. **H2 Database Console**: http://localhost:8080/h2-console
   - JDBC URL: `jdbc:h2:mem:expensedb`
   - Username: `sa`
   - Password: (leave empty)

## 🔍 Troubleshooting

### Issue 1: "mvn is not recognized"
**Solution**: Install Maven from https://maven.apache.org/download.cgi
Or use your IDE (IntelliJ/Eclipse) - it has built-in Maven support

### Issue 2: Java version error
**Error**: "Unsupported class file major version..."
**Solution**: Install Java 17+
```bash
# Check current version
java -version

# Download Java 17 from: https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
```

### Issue 3: Port 8080 already in use
**Error**: "Web server failed to start. Port 8080 was already in use."

**Solution A**: Stop the other application using port 8080
**Solution B**: Change port in `application.properties`:
```properties
server.port=8081  # Use a different port
```

### Issue 4: Dependencies not downloading
**Error**: "Could not resolve dependencies"

**Solution**:
```bash
# Delete Maven cache
# Windows:
rmdir /s %USERPROFILE%\.m2\repository

# Mac/Linux:
rm -rf ~/.m2/repository

# Rebuild
mvn clean install
```

### Issue 5: Compilation Errors
If you see Java compilation errors:

1. Check that all files exist in the correct directories
2. Verify package names match directory structure
3. Ensure Lombok is installed (if using IDE annotations)

### Issue 6: application.properties not loading
**Solution**: Check that `application.properties` is in:
```
backend/src/main/resources/application.properties
```

The file should contain all configuration including:
- Server port
- Database settings
- JWT secret
- CORS configuration

## 📝 Running in IDE

### IntelliJ IDEA:
1. Open `backend` folder
2. Wait for Maven to import dependencies
3. Open `src/main/java/com/expensetracker/ExpenseTrackerApplication.java`
4. Right-click → Run 'ExpenseTrackerApplication'

### Eclipse:
1. Import as Maven Project
2. Right-click on `ExpenseTrackerApplication.java`
3. Run As → Java Application

### VS Code:
1. Install "Spring Boot Extension Pack"
2. Open `backend` folder
3. Press F5 to run

## 🧪 Test the API

Once running, test with these commands:

**1. Create User (Signup):**
```bash
curl -X POST http://localhost:8080/api/auth/signup ^
  -H "Content-Type: application/json" ^
  -d "{\"name\":\"John Doe\",\"email\":\"john@example.com\",\"password\":\"password123\"}"
```

**2. Login:**
```bash
curl -X POST http://localhost:8080/api/auth/login ^
  -H "Content-Type: application/json" ^
  -d "{\"email\":\"john@example.com\",\"password\":\"password123\"}"
```

You should receive a token in the response!

## 🎯 Next Steps

After the backend is running:

1. **Start Frontend** (in another terminal):
   ```bash
   cd frontend
   npm install
   npm run dev
   ```

2. **Open Browser**: http://localhost:5173

3. **Sign up** for an account

4. **Start tracking expenses!** 💰

## 📊 Project Structure

```
backend/
├── pom.xml                          # Maven dependencies
├── src/main/
│   ├── java/com/expensetracker/
│   │   ├── ExpenseTrackerApplication.java  # Main class
│   │   ├── config/                  # Security config
│   │   ├── controller/             # REST endpoints
│   │   ├── dto/                    # Data Transfer Objects
│   │   ├── model/                  # Entities
│   │   ├── repository/             # JPA repositories
│   │   └── service/                # Business logic
│   └── resources/
│       └── application.properties  # Configuration
└── target/                         # Compiled files (auto-generated)
```

## ✅ Verification Checklist

- [ ] Java 17+ installed
- [ ] Maven installed (or IDE with Maven)
- [ ] Backend compiles without errors
- [ ] Backend starts on port 8080
- [ ] H2 console accessible
- [ ] API endpoints respond
- [ ] Frontend can connect to backend

## 🎉 Success!

If everything works:
- Backend is running on port 8080
- Frontend can connect and authenticate
- You can add/edit/delete expenses
- Statistics are calculated correctly

Happy coding! 🚀

