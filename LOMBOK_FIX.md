# Fix Lombok Compilation Issues

## Problem
Lombok annotations (@Data, @Getter, @Setter) are not generating getter/setter methods during compilation.

## Solution

### Option 1: Clean and Rebuild in IDE

**IntelliJ IDEA:**
1. File → Invalidate Caches / Restart
2. Check File → Settings → Build → Compiler → Annotation Processors
3. Enable: "Enable annotation processing"
4. Rebuild Project: Build → Rebuild Project

**Eclipse:**
1. Right-click project → Properties
2. Java Compiler → Annotation Processing
3. Check "Enable annotation processing"
4. Project → Clean → Build

**VS Code:**
1. Install "Language Support for Java" extension
2. Install "Lombok Support" extension
3. Reload window

### Option 2: Manually Clean and Build

```bash
cd backend
mvn clean compile
```

Or if you have Maven Wrapper:
```bash
cd backend
./mvnw clean compile
```

### Option 3: Add Lombok Plugin to IDE

**IntelliJ:**
1. File → Settings → Plugins
2. Search for "Lombok"
3. Install and restart IDE

**Eclipse:**
1. Help → Eclipse Marketplace
2. Search "Lombok"
3. Install "Lombok for Eclipse"

### Option 4: Disable DevTools (Temporary Fix)

The error might be caused by Spring DevTools. Let's rebuild without it:

In `pom.xml`, temporarily comment out:
```xml
<!--
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
    <optional>true</optional>
</dependency>
-->
```

Then rebuild:
```bash
mvn clean compile
```

### Option 5: Delete Target and Rebuild

```bash
cd backend
rmdir /s target
mvn clean install
```

On Windows:
```cmd
cd backend
rd /s /q target
mvn clean compile
```

---

## Quick Fix Commands

**If using IntelliJ IDEA:**
```
1. File → Invalidate Caches / Restart
2. Build → Rebuild Project
```

**If using Maven from command line:**
```bash
cd backend
mvn clean install -U
```

---

## Verify Lombok is Working

After applying the fix, the following should work:
- ExpenseRequest.getTitle()
- ExpenseRequest.getAmount()
- Expense.getDate()
- User.getName()
- etc.

---

## If Still Not Working

Contact me for an alternative approach without Lombok annotations.



