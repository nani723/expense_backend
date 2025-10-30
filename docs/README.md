# Expense Tracker Project

A full-stack expense tracking application with a modern React frontend and Spring Boot backend API.

## 🚀 Project Structure

```
Expense_Project/
├── backend/           # Spring Boot REST API
├── frontend/          # React + Vite frontend
├── docs/              # Project documentation
└── README.md          # This file
```

## ✨ Features

The frontend application includes:

- **🔐 User Authentication**: Secure login and signup pages
- **👤 User Management**: Personalized experience with user profiles
- **💰 Add/Edit/Delete Expenses**: Full CRUD operations
- **📊 Real-time Statistics**: Total expenses, monthly breakdowns, and averages
- **🎨 Category-based Organization**: Multiple pre-defined categories
- **📅 Date Filtering**: Filter by month and year
- **🔍 Advanced Filters**: Multiple filter combinations
- **💾 Local Storage**: Automatic data persistence
- **🔒 Protected Routes**: Route protection for authenticated users
- **📱 Responsive Design**: Works on all devices
- **🎯 Modern UI/UX**: Beautiful dark theme with gradients and animations

## 🛠️ Tech Stack

**Backend:**
- Spring Boot 3.1.5
- Spring Security (JWT Authentication)
- Spring Data JPA
- H2 Database (Development)
- MySQL Support (Production)
- REST API

**Frontend:**
- React 18
- Vite 4
- React Router DOM 6
- Lucide React (Icons)
- Context API (Authentication)
- Vanilla CSS with modern features
- REST API Integration

## 📦 Getting Started

### Prerequisites

- **Java 17** or higher
- **Maven 3.6+**
- **Node.js** (v16 or higher)
- **npm** or yarn

### Quick Start

#### 1. Start Backend
```bash
cd backend
mvn spring-boot:run
```
Backend runs on **http://localhost:8080**

#### 2. Start Frontend (in new terminal)
```bash
cd frontend
npm install
npm run dev
```
Frontend runs on **http://localhost:5173**

### Complete Setup

For detailed setup instructions, see **[SETUP_GUIDE.md](./docs/SETUP_GUIDE.md)**

### Documentation

- [Start Here](./docs/START_HERE.md)
- [Setup Guide](./docs/SETUP_GUIDE.md)
- [Run Project](./docs/RUN_PROJECT.md)
- [Project Summary](./docs/PROJECT_SUMMARY.md)

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

## 🐳 Docker

### Prerequisites

- Docker Desktop

### Build and Run (compose)

```bash
docker compose -f fullstack-deployment.yaml up -d --build
```

- Frontend: http://localhost
- Backend: http://localhost:8080

To stop and remove containers:

```bash
docker compose -f fullstack-deployment.yaml down
```

### Notes

- If your frontend calls the backend via `http://localhost:8080`, no extra config is needed.
- If your frontend uses a relative path like `/api`, you can enable the proxy in `frontend/nginx.conf` by uncommenting the `/api` block and rebuilding.

## 📱 Usage

1. **Sign Up**: Create a new account with email and password
2. **Sign In**: Login with your credentials
3. **Add Expense**: Click "Add Expense" button to create a new expense entry
4. **Edit Expense**: Click the edit icon on any expense card
5. **Delete Expense**: Click the delete icon and confirm
6. **Filter**: Use the filter button to filter by month, year, or category
7. **Statistics**: View your spending patterns in the dashboard cards
8. **Logout**: Click the logout button in the header

## 🎨 Design Features

- Dark theme with gradient backgrounds
- Smooth animations and transitions
- Color-coded categories
- Responsive card layout
- Modal dialogs for forms
- Icon-based navigation
- Clean and minimalist design

## 📂 File Structure

```
Expense_Project/
├── backend/
│   ├── src/main/java/com/expensetracker/
│   │   ├── config/         # Security configuration
│   │   ├── controller/     # REST controllers
│   │   ├── dto/            # Data Transfer Objects
│   │   ├── model/          # Entity models
│   │   ├── repository/     # JPA repositories
│   │   ├── service/        # Business logic
│   │   └── ExpenseTrackerApplication.java
│   ├── src/main/resources/
│   │   └── application.properties
│   ├── pom.xml
│   └── README.md
├── frontend/
│   ├── src/
│   │   ├── App.jsx         # Main app with routing
│   │   ├── contexts/       # Auth context
│   │   ├── pages/          # Login, Signup, Dashboard
│   │   └── services/       # API service
│   ├── package.json
│   └── README.md
├── docs/
│   ├── START_HERE.md
│   ├── SETUP_GUIDE.md
│   ├── RUN_PROJECT.md
│   └── PROJECT_SUMMARY.md
└── README.md               # This file
```

## 🚀 Available Scripts

- `npm run dev` - Start development server
- `npm run build` - Build for production
- `npm run preview` - Preview production build

## 🌟 Categories

- Food
- Transport
- Shopping
- Bills
- Health
- Entertainment
- Education
- Other

## 📄 License

MIT License

## 🤝 Contributing

Feel free to contribute to this project by adding features, fixing bugs, or improving the UI/UX!

