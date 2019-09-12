package BankAccount.Pages;

import java.text.MessageFormat;

public class BankAccount {

    private String customerName;
    private double balance;
    private final double limit;
    private boolean frozen = false;

    /**
     * Create a bank account with Customer Name and Balance, Limit will be 0.0 as default in this case.
     * @param customerName the name of the account owner
     * @param balance the starting balance of the account
     */
    //Constructor
    public BankAccount(String customerName, double balance)
    {
        this(customerName, balance, 0.0);
    }

    /**
     * Create bank account with Customer Name, Balance and Limitation
     * @param customerName the name of the account owner
     * @param balance the starting balance of the account
     * @param limit the minimum value of the balance, usually nonpositive value
     */
    //Constructor
    public BankAccount(String customerName, double balance, double limit)
    {
        this.customerName = customerName;
        this.balance = balance;
        this.limit = limit;
    }

    /**
     * Decrease method of the account. It will subtraction the amount from the balance till the limit allows.
     * @param amount of money what will decrease the balance.
     * @throws AccountFrozenException will throw if the balance have already reached the limit.
     */
    public void debit(double amount) throws AccountFrozenException
    {
        if (frozen) {
            throw new AccountFrozenException("Account frozen");
        }

        balance -= amount;

        updateAccountStatus();
    }

    /**
     * Increase method of the account. It will add the amount to the balance.
     * @param amount of the money what will increase the balance.
     */
    public void credit(double amount)
    {
        balance += amount;

        updateAccountStatus();
    }

    /**
     * Print method, which will give information about the account.
     * @return With formatted String which contains customer name, actual status, actual balance, and the limit of the account
     */
    public String getAccountDetails()
    {
        String because = "";
        if(frozen){
            because = "Because you are over your credit limit. ";
        }

        return MessageFormat.format("Dear {0}, your account is {1}. {2}Your current balance is: {3} and your limit is: {4}",
                getCustomerName(), getStatus(), because, getActualBalance(), getLimit());
    }

    private String getCustomerName()
    {
        return customerName;
    }

    public double getActualBalance()
    {
        return balance;
    }

    private double getLimit()
    {
        return limit;
    }

    private String getStatus()
    {
        String status = "Active";
        if(frozen){
            status = "Frozen";
        }
        return status;
    }

    private void updateAccountStatus()
    {
        frozen = (balance <= limit);
    }
}

