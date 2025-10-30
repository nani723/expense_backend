# Fix Compilation Errors in IDE

## ✅ Problem Identified

You're getting this error:
```
The method getTitle() is undefined for the type ExpenseRequest
```

This means **Lombok isn't generating getters/setters** in your IDE.

---

## 🎯 Solution for IntelliJ IDEA

### Step 1: Enable Annotation Processing

1. **File** → **Settings** (Ctrl+Alt+S)
2. Navigate to: **Build, Execution, Deployment** → **Compiler** → **Annotation Processors**
3. ✅ **Check** "Enable annotation processing"
4. Click **Apply** → **OK**

### Step 2: Install Lombok Plugin

1. **File** → **Settings** → **Plugins**
2. Search for **"Lombok"**
3. Click **Install**
4. Click **Restart IDE** when prompted

### Step 3: Clean and Rebuild

1. **Build** → **Rebuild Project** (or press `Ctrl+Shift+F9`)
2. Wait for compilation to complete

### Step 4: Run Application

1. Open `ExpenseTrackerApplication.java`
2. Right-click → **Run 'ExpenseTrackerApplication'**

---

## 🎯 Solution for Eclipse

### Step 1: Enable Annotation Processing

1. Right-click on **backend** project
2. **Properties**
3. **Java Compiler** → **Annotation Processing**
4. Check ✅ **"Enable annotation processing"**
5. Click **Apply and Close**

### Step 2: Install Lombok

Download from: https://projectlombok.org/download

1. Double-click `lombok.jar`
2. Click **Specify location** → **Select** your Eclipse installation
3. Click **Install/Update**
4. Restart Eclipse

### Step 3: Clean and Build

1. **Project** → **Clean**
2. Select **backend** project
3. Click **Clean**

### Step 4: Run Application

Right-click on `ExpenseTrackerApplication.java` → **Run As** → **Java Application**

---

## 🎯 Solution for VS Code

### Step 1: Install Extensions

1. Press **Ctrl+Shift+X** (Extensions)
2. Install these extensions:
   - **Language Support for Java** (by Microsoft)
   - **Lombok Support** (by GabrielBB)
3. Reload VS Code

### Step 2: Enable Annotation Processing

1. Open settings: **Ctrl+,**
2. Search: "java.compile.nullAnalysis"
3. Enable annotation processing

### Step 3: Run Application

Press **F5** to run

---

## 🔧 Manual Fix (If All Else Fails)

If Lombok still doesn't work, I can regenerate the files without Lombok (using manual getters/setters). Let me know if you need this.

---

## ✅ Verify It's Working

After fixing, you should see:
```
Started ExpenseTrackerApplication in X.XXX seconds
Tomcat started on port 8080
```

Your application is now running on: **http://localhost:8080**

---

## 📞 Quick Checklist

- [ ] Annotation processing enabled
- [ ] Lombok plugin installed
- [ ] Project cleaned/rebuilt
- [ ] No compilation errors
- [ ] Application starts successfully

---

## 🚀 Next Steps

Once the backend is running:
1. Start the frontend (see main README)
2. Test the API endpoints
3. Use the application!



