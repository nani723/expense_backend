# Quick Start Guide - Run the Complete Project

## 🎯 Running the Expense Tracker Application

### Step 1: Start Backend (Terminal 1)

```bash
cd backend
mvn spring-boot:run
```

**Wait for this message:**
```
Started ExpenseTrackerApplication in X.XXX seconds
```

Backend is now running on **http://localhost:8080**

---

### Step 2: Start Frontend (Terminal 2)

Open a **NEW terminal window**:

```bash
cd frontend
npm install
npm run dev
```

Frontend is now running on **http://localhost:5173**

---

### Step 3: Use the Application

1. Open browser: http://localhost:5173
2. Click "Sign up"
3. Create an account:
   - Name: Your Name
   - Email: your@email.com
   - Password: password123
4. Click "Sign Up"
5. You'll be redirected to the dashboard
6. Click "Add Expense" to start tracking!

---

## 🔧 Troubleshooting

### Backend won't start?

**Check:**
- Java 17+ installed? `java -version`
- Maven installed? `mvn -version`
- Port 8080 available?
- Dependencies downloaded?

**Solution:**
```bash
cd backend
mvn clean install
mvn spring-boot:run
```

### Frontend won't start?

**Check:**
- Node.js installed? `node -version`
- In the correct directory? `cd frontend`
- Dependencies installed? `npm install`

**Solution:**
```bash
cd frontend
rm -rf node_modules package-lock.json
npm install
npm run dev
```

### Can't connect Frontend to Backend?

**Check:**
1. Both are running?
2. Backend on port 8080?
3. Frontend on port 5173?
4. CORS configured?

**Solution:**
- Check browser console for errors
- Verify backend is running: http://localhost:8080
- Check `frontend/src/services/api.js` - API URL should be `http://localhost:8080/api`

---

## 📋 Quick Commands Reference

### Backend:
```bash
cd backend
mvn clean compile          # Compile
mvn spring-boot:run        # Run
mvn clean package          # Build JAR
```

### Frontend:
```bash
cd frontend
npm install                # Install dependencies
npm run dev                # Start dev server
npm run build              # Build for production
```

---

## 🎉 You're All Set!

The complete application is now running:
- ✅ Backend API (Spring Boot)
- ✅ Frontend (React)
- ✅ Database (H2)
- ✅ Authentication (JWT)
- ✅ All features working

**Enjoy tracking your expenses!** 💰📊



