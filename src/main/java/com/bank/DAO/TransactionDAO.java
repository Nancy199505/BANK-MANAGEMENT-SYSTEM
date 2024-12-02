package com.bank.DAO;

import com.bank.Model.Transaction;
import com.bank.Util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionDAO {

    public boolean addTransaction(Transaction transaction, Connection conn) throws SQLException {
        String sql = "INSERT INTO Transactions (account_id, transaction_type, amount) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, transaction.getAccountId());
            stmt.setString(2, transaction.getTransactionType());
            stmt.setDouble(3, transaction.getAmount());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deposit(int accountId, double amount, Connection conn) throws SQLException {
        String sql = "UPDATE Accounts SET balance = balance + ? WHERE account_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, amount);
            stmt.setInt(2, accountId);
            boolean success = stmt.executeUpdate() > 0;
            if (success) {
                Transaction transaction = new Transaction();
                transaction.setAccountId(accountId);
                transaction.setTransactionType("DEPOSIT");
                transaction.setAmount(amount);
                addTransaction(transaction, conn);
            }
            return success;
        }
    }

    public boolean withdraw(int accountId, double amount, Connection conn) throws SQLException {
        String sql = "UPDATE Accounts SET balance = balance - ? WHERE account_id = ? AND balance >= ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, amount);
            stmt.setInt(2, accountId);
            stmt.setDouble(3, amount);
            boolean success = stmt.executeUpdate() > 0;
            if (success) {
                Transaction transaction = new Transaction();
                transaction.setAccountId(accountId);
                transaction.setTransactionType("WITHDRAWAL");
                transaction.setAmount(amount);
                addTransaction(transaction, conn);
            }
            return success;
        }
    }

    public boolean transfer(int fromAccountId, int toAccountId, double amount) throws SQLException {
        Connection conn = null;
        try {
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false);

            // Withdraw from the sender's account
            if (!withdraw(fromAccountId, amount, conn)) {
                conn.rollback();
                return false;
            }

            // Deposit to the receiver's account
            if (!deposit(toAccountId, amount, conn)) {
                conn.rollback();
                return false;
            }

            // Record transactions for both accounts
            Transaction fromTransaction = new Transaction();
            fromTransaction.setAccountId(fromAccountId);
            fromTransaction.setTransactionType("TRANSFER_OUT");
            fromTransaction.setAmount(amount);
            addTransaction(fromTransaction, conn);

            Transaction toTransaction = new Transaction();
            toTransaction.setAccountId(toAccountId);
            toTransaction.setTransactionType("TRANSFER_IN");
            toTransaction.setAmount(amount);
            addTransaction(toTransaction, conn);

            conn.commit();
            return true;
        } catch (SQLException ex) {
            if (conn != null) conn.rollback();
            throw ex;
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}