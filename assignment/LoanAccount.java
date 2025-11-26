package assignment;

public class LoanAccount extends Account{

    public LoanAccount(String accountNumber, String ownerName, double balance) {
        super(accountNumber, ownerName, balance);
    }

    public void chargeInterest(){
        double newBalance = this.getBalance() * 1.05;
        this.setBalance(newBalance);
    }
}
