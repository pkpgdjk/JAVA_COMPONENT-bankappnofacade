/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankfacade;

import bankcustomers.BankAccount;
import bankcustomers.BankCustomer;
import gencustaccount.AccountIf;
import gencustaccount.CustomerIf;
import java.util.ArrayList;
import bankcustomerfacade.BankCustomerFacade;

/**
 *
 * @author sarun
 */
public class BankFacade {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BankCustomerFacade bankCustomerFacade = new BankCustomerFacade();
        AccountIf acc;

        CustomerIf cust1 = bankCustomerFacade.getBankCustomer("John");
        System.out.println("Customer and account information");
        System.out.println("Name = " + cust1.getCustomerName());
        System.out.println("Has " + cust1.getNumAccounts() + " accounts");

        acc = bankCustomerFacade.getBankAccount(cust1, 111111);
        System.out.println("Account Number: " + acc.getAccountNumber() + " has " + acc.getBalance());

        acc = bankCustomerFacade.getBankAccount(cust1, 222222);
        System.out.println("Account Number: " + acc.getAccountNumber() + " has " + acc.getBalance());

        bankCustomerFacade.doDeposit(1000,cust1,222222);
        System.out.println("Account Number: " + acc.getAccountNumber() + " has " + acc.getBalance());

        ArrayList<AccountIf> accounts = bankCustomerFacade.getBankCustomer("John").getllAccounts();
        for(AccountIf account : accounts) {
            System.out.println("Account number " + account.getAccountNumber() + " has " + account.getBalance());
        }
    }
    
}
