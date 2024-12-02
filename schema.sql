CREATE DATABASE bank_management;
USE bank_management;

CREATE TABLE Users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE accounts (
    account_id INT AUTO_INCREMENT PRIMARY KEY,
    account_holder_name VARCHAR(255) NOT NULL,
    balance DOUBLE NOT NULL
);

CREATE TABLE transactions (
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    account_id INT NOT NULL,
    transaction_type VARCHAR(50) NOT NULL,
    amount DOUBLE NOT NULL,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_id) REFERENCES accounts(account_id)
);

INSERT INTO accounts (account_holder_name, balance)
VALUES 
('John Doe', 1500.00),
('Jane Smith', 3200.75),
('Alice Wonder', 450.50),
('Bob Marley', 8900.00);

INSERT INTO transactions (account_id, transaction_type, amount)
VALUES 
(1, 'Deposit', 500.00),
(1, 'Withdrawal', 200.00),
(2, 'Deposit', 1500.00),
(3, 'Withdrawal', 50.00),
(4, 'Deposit', 3000.00),
(4, 'Withdrawal', 1000.00);


select * from accounts;
select * from transactions;

