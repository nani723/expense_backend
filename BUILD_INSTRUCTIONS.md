# Build Instructions - Expense Tracker Backend

## Current Issue: Lombok Not Generating Methods

The application shows compilation errors because Lombok annotations aren't being processed.

## How to Fix

### Step 1: Open Project in IntelliJ IDEA

1. File → Open
2. Select the `backend` folder
3. Click OK

### Step 2: Enable Annotation Processing

1. File → Settings (or Ctrl+Alt+S)
2. Go to: Build, Execution, Deployment → Compiler → Annotation Processors
3. Check ✅ "Enable annotation processing"
4. Click Apply and OK

### Step 3: Install Lombok Plugin

1. File → Settings → Plugins
2. Search for "Lombok"
3. Click Install
4. Restart IDE when prompted

### Step 4: Clean and Rebuild

1. Build → Rebuild Project (or Ctrl+Shift+F9)
2. Wait for compilation to finish

### Step 5: Run Application

1. Find `ExpenseTrackerApplication.java`
2. Right-click → Run 'ExpenseTrackerApplication'
3. Wait for: "Started ExpenseTrackerApplication"

---

## Alternative: Use Maven from Command Line

If you have Maven installed:

```bash
cd backend
mvn clean install
mvn spring-boot:run
```

---

## Still Having Issues?

### Delete Target Folder and Rebuild

**Windows:**
```cmd
cd backend
rd /s /q target
mvn clean install
```

**Mac/Linux:**
```bash
cd backend
rm -rf target
mvn clean install
```

---

## Verify It's Working

After running, you should see:
```
Started ExpenseTrackerApplication in X.XXX seconds
Tomcat started on port 8080
```

Visit: http://localhost:8080

---

## Need More Help?

Check these files:
- LOMBOK_FIX.md - More detailed Lombok fixes
- QUICK_START.md - Quick troubleshooting
- BUILD_AND_RUN.md - Full build instructions



