package BankAccount.Tests;

import BankAccount.Pages.AccountFrozenException;
import BankAccount.Pages.BankAccount;
import org.junit.Test;

public class AccountFrozenExceptionTest {

    public static final double ACCOUNT_INITIAL_BALANCE = 100;
    public static final double INITIAL_LIMIT = -50;

    @Test(expected = AccountFrozenException.class)
    public void ExceptionHandling() {
        //Given
        BankAccount accountThree = new BankAccount("Mr. Diana Ocampo", ACCOUNT_INITIAL_BALANCE, -INITIAL_LIMIT);
        //When
        try {
            accountThree.debit(100);
            accountThree.debit(50);
        } catch (AccountFrozenException e) {
            e.printStackTrace();
//            Assert.assertThat(e.getMessage());
        }
        //Then

    }

    @Test(expected = AccountFrozenException.class)
    public void ExceptionHandling2() throws AccountFrozenException {
        //Given
        BankAccount accountThree = new BankAccount("Mr. Diana Ocampo", ACCOUNT_INITIAL_BALANCE, -INITIAL_LIMIT);
        accountThree.debit(100);
        accountThree.debit(50);


    }
}

    // >> How I am supposed to test this exception

