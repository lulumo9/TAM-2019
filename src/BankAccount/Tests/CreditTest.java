package BankAccount.Tests;

import BankAccount.Pages.BankAccount;
import org.junit.Assert;
import org.junit.Test;

public class CreditTest {

    public static final double ACCOUNT_INITIAL_BALANCE = 100.00;
    public static final double CREDIT_AMOUNT = 60;

    @Test
    public void isBalanceBeingUpdatedAfterACredit()
    {
        //Given
        BankAccount accountOne = new BankAccount("Ms. Tomas Munoz", ACCOUNT_INITIAL_BALANCE, 40);
        //When
        accountOne.credit(CREDIT_AMOUNT);
        //Then
        Assert.assertTrue("The balance has not being updated", accountOne.getAccountDetails().contains("Your current balance is: 160"));
        //Assert.assertEquals("The balance has not being updated", 160, accountOne.getActualBalance(), 0);
        System.out.println("Yes, balance is being after a credit");
    }
}
