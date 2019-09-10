package BankAccount;

public class Main {

    public static void main(String[] args)
    {
        BankAccount ba = new BankAccount("Mr. Larry Ellison", 11.99);
        BankAccount ba2 = new BankAccount("Mr. Bryan Walton", 100.00, -50.00);

        try {
            ba.credit(5.77);
            ba.debit(11.22);
            ba2.debit(100);
            ba2.debit(50);
        } catch (AccountFrozenException e) {
            System.out.println("An exception has occurred. Details: " + e.getMessage());
        }

        System.out.println(ba.getAccountDetails());
        System.out.println(ba2.getAccountDetails());
    }
}


