package assignment;

public class MortgageAccount extends Account{

    public MortgageAccount(String accountNumber, String ownerName, double balance) {
        super(accountNumber, ownerName, balance);
    }
    
    public void addMonthlyFee(){
        double newBalance = this.getBalance() - 10;

        if (newBalance < 0){ 
            System.out.println("WARNING: FUNDS NEGATIVE");
        }

        this.setBalance(newBalance);
    }
}
