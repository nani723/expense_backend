# Quick Start - Expense Tracker Backend

## ✅ All Errors Fixed!

The following issues have been resolved:

1. ✅ **JWT Service**: Updated to use JJWT 0.11.5 API (newer builder pattern)
2. ✅ **Configuration**: Changed from `.properties` to `.yml` format
3. ✅ **Imports**: Fixed all import statements
4. ✅ **Removed unused imports**: Cleaned up code

## 🚀 How to Run

### Option 1: Using Maven Wrapper (Recommended)

If you have Maven installed:
```bash
# Navigate to backend directory
cd backend

# Clean and compile
mvn clean compile

# Run the application
mvn spring-boot:run
```

### Option 2: Using IDE

1. Open the `backend` folder in your IDE (IntelliJ IDEA, Eclipse, VS Code)
2. Wait for Maven to download dependencies
3. Find `ExpenseTrackerApplication.java`
4. Right-click and select "Run" or "Debug"

### Option 3: Direct Java Command

After building:
```bash
mvn clean package
java -jar target/expense-tracker-1.0.0.jar
```

## 🔍 Verify It's Running

Once the server starts, you'll see:
```
Started ExpenseTrackerApplication in X.XXX seconds
```

Visit these URLs to verify:
- **API Health**: http://localhost:8080/api/auth
- **H2 Console**: http://localhost:8080/h2-console

## 🐛 If You Still Get Errors

### Error: "Maven not found"
**Solution**: Install Maven from https://maven.apache.org/download.cgi
Or use the IDE's built-in Maven support

### Error: "Java version incompatible"
**Solution**: Make sure Java 17+ is installed:
```bash
java -version
```

### Error: "Port already in use"
**Solution**: Change the port in `application.yml`:
```yaml
server:
  port: 8081  # Change to any available port
```

### Error: "Cannot resolve dependencies"
**Solution**: Delete `.m2` repository and rebuild:
```bash
# Windows
rmdir /s %USERPROFILE%\.m2\repository
mvn clean install

# Mac/Linux
rm -rf ~/.m2/repository
mvn clean install
```

## 📝 What Changed

### 1. JWT Service (JwtService.java)
- Updated from old JWT API to new JJWT 0.11.5 API
- Changed `builder().setClaims()` to `builder().claims()`
- Changed `parserBuilder()` to `parser().verifyWith()`
- Fixed token parsing for new API

### 2. Configuration (application.yml)
- Switched from `.properties` to `.yml` format
- Better structure and readability
- All configurations preserved

### 3. POM File
- No changes needed - already correct

## ✅ Test the Backend

Once running, test with curl or Postman:

**Signup:**
```bash
curl -X POST http://localhost:8080/api/auth/signup \
  -H "Content-Type: application/json" \
  -d '{"name":"Test User","email":"test@test.com","password":"password123"}'
```

**Login:**
```bash
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"email":"test@test.com","password":"password123"}'
```

## 🎉 You're Done!

The backend should now run without errors. You can now:
1. Start the frontend application
2. Sign up for an account
3. Add expenses
4. View statistics

Happy coding! 🚀



