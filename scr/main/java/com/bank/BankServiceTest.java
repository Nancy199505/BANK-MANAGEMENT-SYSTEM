package com.bank;

import com.bank.Model.Account;
import com.bank.Service.BankService;

public class BankServiceTest {
    public static void main(String[] args) {
        BankService bankService = new BankService();

        try {

            boolean depositSuccess = bankService.deposit(1, 500);
            System.out.println("Deposit successful: " + depositSuccess);


            boolean withdrawalSuccess = bankService.withdraw(1, 200);
            System.out.println("Withdrawal successful: " + withdrawalSuccess);


            boolean transferSuccess = bankService.transfer(1, 2, 100);
            System.out.println("Transfer successful: " + transferSuccess);


            Account account = bankService.getAccountDetails(1);
            System.out.println("Account Balance: " + account.getBalance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}