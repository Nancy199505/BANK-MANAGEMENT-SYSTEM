# Bank Management System:

A comprehensive Bank Management System built using Java, MySQL, HTML, CSS, JavaScript, and Bootstrap.
This system provides functionality for user management, account transactions, and profile management with interactive web pages and form validations.

# Features:

* User Management: 

User Registration
Login and Logout
Profile Management

* Account Operations:

Deposit
Withdrawal
Fund Transfer
View Account Balance

* Transaction Management:

View Transaction History
Track Account Activities

* Responsive Design:
  
Fully responsive web design using Bootstrap.

* Form Validations:
  
JavaScript-based real-time form validation and interactivity.

* Technologies Used: 

Frontend: HTML, CSS, JavaScript, Bootstrap
Backend: Java (Servlets, JDBC)
Database: MySQL
Build Tool: Maven
Server: Apache Tomcat 9
IDE: Eclipse IDE

* Project Structure:

BankManagementSystem/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── bank/
│   │   │           ├── dao/          # Database operations
│   │   │           ├── model/        # POJOs for User, Account, Transaction
│   │   │           ├── service/      # Business logic
│   │   │           ├── util/         # Utility classes (e.g., DatabaseConnection)
│   │   │           └── controller/   # Servlets for handling HTTP requests
│   │   └── webapp/
│   │       ├── WEB-INF/              # Contains web.xml
│   │       ├── index.html            # Welcome page
│   │       ├── login.html            # User login page
│   │       ├── register.html         # User registration page
│   │       ├── profile.html          # Profile management page
│   │       ├── styles.css            # Custom styles
│   │       └── js/                   # JavaScript files for validation
├── pom.xml                           # Maven dependencies


# Database Schema: 

* Users Table:

CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

* Accounts Table:

CREATE TABLE Accounts (
    account_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    account_type VARCHAR(20) NOT NULL,
    balance DOUBLE DEFAULT 0.0,
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

* Transactions Table:

CREATE TABLE Transactions (
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    account_id INT NOT NULL,
    transaction_type VARCHAR(20) NOT NULL,
    amount DOUBLE NOT NULL,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_id) REFERENCES Accounts(account_id)
);

# Setup and Installation: 

* Prerequisites:
  
1.Java Development Kit (JDK) 11+
2.Apache Tomcat 9+
3.MySQL 8.0+
4.Maven
5. Eclipse IDE

# Steps to Run the Project: 

* Clone the repository:

git clone https://github.com/Nancy199505/bank-management-system.git
cd bank-management-system

* Set up the Database:

Open MySQL Workbench or command line.

* Create a database:

CREATE DATABASE bank_management;

Import the tables using the SQL scripts provided in the resources/sql folder.

* Configure Database Credentials:

Update the DatabaseConnection class in com.bank.util with MySQL username and password.

* Build the Project:

Open the project in Eclipse.
Run the following Maven command in the terminal:

mvn clean install

* Deploy on Tomcat:

Right-click on the project in Eclipse → Run on Server → Select Apache Tomcat.

* Access the Application:

Open your browser and go to http://localhost:8080/bank-management-system.

# License:

This project is licensed under the MIT License. See the LICENSE file for details.







