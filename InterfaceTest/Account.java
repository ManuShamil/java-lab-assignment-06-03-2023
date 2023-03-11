package InterfaceTest;

interface IAccount
{
    String accountNumber = "756898965663";
}

public class Account {
    private String accountNumber;
    
    Account( String accountNumber )
    {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber()
    {
        return this.accountNumber;
    }

    @Override
    public String toString()
    {
        return String.format(
            "AccountNumber: %s", this.accountNumber
        );
    }
}
