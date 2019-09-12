package BankAccount.Tests;

import BankAccount.Pages.AccountFrozenException;
import BankAccount.Pages.BankAccount;
import org.junit.Assert;
import org.junit.Test;

public class DebitTest {

    public static final double ACCOUNT_INITIAL_BALANCE = 100;
    public static final double DEBIT_AMOUNT = 50;

    @Test
    public void isBalanceBeingUpdatedAfterDebit() throws AccountFrozenException
    {
        //Given
        BankAccount accountOne = new BankAccount("Ms. Luisa Munoz", ACCOUNT_INITIAL_BALANCE,30);
        //When
        accountOne.debit(DEBIT_AMOUNT);
        //Then
        Assert.assertTrue("The balance has not being updated", accountOne.getAccountDetails().contains("Your current balance is: 50"));
        //Assert.assertEquals("The balance has not being updated", 50, accountOne.getActualBalance(), 0);
        System.out.println("Yes, balance is being updated after a debit");
    }
}
