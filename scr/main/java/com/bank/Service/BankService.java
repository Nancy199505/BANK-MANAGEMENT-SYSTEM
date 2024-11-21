package com.bank.Service;

import com.bank.DAO.AccountDAO;
import com.bank.DAO.TransactionDAO;
import com.bank.Model.Account;
import java.sql.SQLException;

public class BankService {
    private AccountDAO accountDAO = new AccountDAO();
    private TransactionDAO transactionDAO = new TransactionDAO();

    public boolean deposit(int accountId, double amount) throws SQLException {
        return transactionDAO.deposit(accountId, amount, null);
    }

    public boolean withdraw(int accountId, double amount) throws SQLException {
        return transactionDAO.withdraw(accountId, amount, null);
    }

    public boolean transfer(int fromAccountId, int toAccountId, double amount) throws SQLException {
        return transactionDAO.transfer(fromAccountId, toAccountId, amount);
    }

    public Account getAccountDetails(int accountId) throws SQLException {
        return accountDAO.getAccountById(accountId);
    }
}
