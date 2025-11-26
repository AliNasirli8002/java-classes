package assignment;

public class DepositAccount extends Account{

    public DepositAccount(String accountNumber, String ownerName, double balance) {
        super(accountNumber, ownerName, balance);
    }

    public void addMonthlyBonus(){
        double newBalance = this.getBalance() * 1.01;
        this.setBalance(newBalance);
    }
    
}
