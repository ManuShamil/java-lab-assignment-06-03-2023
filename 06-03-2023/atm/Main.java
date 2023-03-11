package atm;

// 3. Develop an interface with two methods namely, withdraw money and deposit money. Develop a class
// Account that implements the interface with necessary private data members such as current account
// balance and account number. Develop another class CreditCardAccount that implements the interface
// with necessary data members such as current credit limit and the credit card number. When money is
// withdrawn from a credit card account; the credit limit is diminished by the amount of money withdrawn
// and by an additional 0.5% of the amount of money withdrawn and when the money is deposited; the
// credit limit is increased by the amount of money deposited. Develop a class containing the main method
// and create an account object and a credit card account object and demonstrate the withdrawal and
// deposit method on the objects.

interface IAccount {
    void withdrawMoney();
    void depositMoney();
}

class Account implements IAccount {
    private int accountNumber;
    private double accountBalance;
    Account( int accountNumber, double accountBalance ) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }
    public int getAccountNumber() {
        return this.accountNumber;
    }
    public double getAccountBalance() {
        return this.accountBalance;
    }
    public void setAccountNumber( int accountNumber ) {
        this.accountNumber = accountNumber;
    }
    public void setAccountBalance( double accountBalance ) {
        this.accountBalance = accountBalance;
    }
    public void withdrawMoney() {
        System.out.println("Withdraw money from account");
    }
    public void depositMoney() {
        System.out.println("Deposit money to account");
    }
}

class CreditCardAccount {
    
}

public class Main {
    public static void main(String[] args) {
        
    }

}
