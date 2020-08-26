package bankcustomerfacade;

import bankcustomers.BankAccount;
import bankcustomers.BankCustomer;
import gencustaccount.AccountIf;
import gencustaccount.CustomerIf;
import java.util.ArrayList;


public class BankCustomerFacade {
    private ArrayList<CustomerIf> customers = new ArrayList();
    
    public BankCustomerFacade() {
        ArrayList<AccountIf> cust1Accounts = new ArrayList();
        AccountIf acc = new BankAccount(111111);
        acc.deposit(500);
        cust1Accounts.add(acc);
        acc = new BankAccount(222222);
        acc.deposit(1000);
        cust1Accounts.add(acc);
        CustomerIf cust1 = new BankCustomer("John", cust1Accounts);
        customers.add(cust1);

        ArrayList<AccountIf> cust2Accounts = new ArrayList();
        acc = new BankAccount(333333);
        acc.deposit(2000);
        cust2Accounts.add(acc);
        acc = new BankAccount(444444);
        acc.deposit(3000);
        cust2Accounts.add(acc);
        CustomerIf cust2 = new BankCustomer("Wick", cust2Accounts);
        customers.add(cust2);
    }


    public void doDeposit(double amt, CustomerIf cust, int accNo){
        cust.getAccount(accNo).deposit(amt);
    }

    public AccountIf getBankAccount(CustomerIf cust, int accNo){
        return cust.getAccount(accNo);
    }

    public CustomerIf getBankCustomer(String custName){
        for(CustomerIf cus : customers){
            if(cus.getCustomerName().equals(custName)){
               return cus;
            }
        }

        return null;
    }
}