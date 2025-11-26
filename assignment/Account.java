package assignment;

public class Account {
    private String accountNumber;
    private String ownerName;
    private double balance;

    public String getAccountNumber(){
        return accountNumber;
    }

    public String getOwnerName(){
        return ownerName;
    }

    public double getBalance(){
        return balance;
    }

    public void setAccountNumber(String accountNumber){
        if (accountNumber == null || accountNumber.length() < 4){
            throw new RuntimeException("INVALID INPUT");
        }

        this.accountNumber = accountNumber;
    }

    public void setOwnerName(String ownerName){
        if (ownerName == null || ownerName.length() < 3){
            throw new RuntimeException("INVALID INPUT");
        }

        this.ownerName = ownerName;
    }

    public void setBalance(double balance){
        if (balance < 0){
            throw new RuntimeException("INVALID INPUT");
        }

        this.balance = balance;
    }

    public Account(String accountNumber, String ownerName, double balance) {
        setAccountNumber(accountNumber);
        setOwnerName(ownerName);
        setBalance(balance);
    }

    public void deposit(double amount){
        if (amount > 0){
            this.balance += amount;
        }

        else {
            System.out.println("Invalid Amount");
        }
    }

    public void withdraw(double amount){
        if (this.balance > amount){
            this.balance -= amount;
        }

        else {
            System.out.println("Not Enough Balance");
        }
    }
}