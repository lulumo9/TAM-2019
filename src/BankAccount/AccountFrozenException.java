package BankAccount;
    /**
     * This exception will throw if the account status is frozen, and debit is still calling.
     */
    public class AccountFrozenException extends Exception
    {
        public AccountFrozenException(String message) {
            super(message);
        }
    }


