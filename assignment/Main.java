package assignment;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        Account accountArr[] = new Account[10];
        boolean running = true;
        while (running) {
            System.out.println("Select action: \n");
            System.out.println("1:Create Account \n");
            System.out.println("2:Select Account\n");
            System.out.println("3:Exit App\n");
            String userInput = myObj.nextLine();
            switch (userInput){
                case "1":
                    System.out.println("Select Account Type:\n");
                    System.out.println("1: Regular Account");
                    System.out.println("2: Loan Account");
                    System.out.println("3: Deposit Account");
                    System.out.println("4: Mortgage Account");
                    String typeChoice = myObj.nextLine();
                    System.out.println("Enter Account Number: ");
                    String accountNumber = myObj.nextLine();
                    System.out.println("Enter Account Name: ");
                    String accountName = myObj.nextLine();
                    System.out.println("Enter Amount: ");
                    double initialBalance = Double.parseDouble(myObj.nextLine());
                    Account newAccount = null;
                    switch (typeChoice) {
                        case "1":
                            newAccount = new Account(accountNumber, accountName, initialBalance);
                            break;
                        case "2":
                            newAccount = new LoanAccount(accountNumber, accountName, initialBalance);
                            break;
                        case "3":
                            newAccount = new DepositAccount(accountNumber, accountName, initialBalance);
                            break;
                        case "4":
                            newAccount = new MortgageAccount(accountNumber, accountName, initialBalance);
                            break;
                        default:
                            System.out.println("Invalid account type selected!\n");
                            break;
                    }
                    if (newAccount == null) {
                        break;
                    }
                    for (int i = 0; i < accountArr.length; i++) {
                        if (accountArr[i] == null) {
                            accountArr[i] = newAccount;
                            System.out.println("Account Created Successfully!\n");
                            break;
                        }
                    }
                    break;
                case "2":
                    System.out.println("Enter Account Number: ");
                    String selectAccountNumber = myObj.nextLine();
                    Account selectedAccount = null;
                    for (Account acc : accountArr) {
                        if (acc != null && acc.getAccountNumber().equals(selectAccountNumber)) {
                            selectedAccount = acc;
                            break;
                        }
                    }
                    if (selectedAccount == null) {
                        System.out.println("Account not found\n");
                        break;
                    }
                    while (true) {
                        int optionNumber = 1;
                        int specialActionNumber = -1;
                        int exitOption;
                        System.out.println("Select action for Account " + selectedAccount.getAccountNumber() + ":\n");
                        System.out.println(optionNumber + ": Deposit");
                        String depositOption = String.valueOf(optionNumber++);
                        System.out.println(optionNumber + ": Withdraw");
                        String withdrawOption = String.valueOf(optionNumber++);
                        System.out.println(optionNumber + ": Check Balance");
                        String checkOption = String.valueOf(optionNumber++);
                        String specialOption = null;
                        if (selectedAccount instanceof LoanAccount) {
                            System.out.println(optionNumber + ": Charge Interest");
                            specialActionNumber = optionNumber++;
                            specialOption = String.valueOf(specialActionNumber);
                        } else if (selectedAccount instanceof DepositAccount) {
                            System.out.println(optionNumber + ": Apply Bonus");
                            specialActionNumber = optionNumber++;
                            specialOption = String.valueOf(specialActionNumber);
                        } else if (selectedAccount instanceof MortgageAccount) {
                            System.out.println(optionNumber + ": Pay Monthly Installment");
                            specialActionNumber = optionNumber++;
                            specialOption = String.valueOf(specialActionNumber);
                        }
                        System.out.println(optionNumber + ": Exit to Main Menu");
                        exitOption = optionNumber;
                        String exitOptionStr = String.valueOf(exitOption);
                        String choice = myObj.nextLine();
                        if (choice.equals(depositOption)) {
                            System.out.println("Enter amount to deposit: ");
                            double depositAmount = Double.parseDouble(myObj.nextLine());
                            selectedAccount.deposit(depositAmount);
                        } else if (choice.equals(withdrawOption)) {
                            System.out.println("Enter amount to withdraw: ");
                            double withdrawAmount = Double.parseDouble(myObj.nextLine());
                            selectedAccount.withdraw(withdrawAmount);
                        } else if (choice.equals(checkOption)) {
                            System.out.println("Current Balance: " + selectedAccount.getBalance() + "\n");
                        } else if (choice.equals(specialOption)) {
                            if (selectedAccount instanceof LoanAccount) {
                                ((LoanAccount) selectedAccount).chargeInterest();
                                System.out.println("Interest charged!\n");
                            } else if (selectedAccount instanceof DepositAccount) {
                                ((DepositAccount) selectedAccount).addMonthlyBonus();
                                System.out.println("Bonus applied!\n");
                            } else {
                                ((MortgageAccount) selectedAccount).addMonthlyFee();
                                System.out.println("Installment paid!\n");
                            }
                        } else if (choice.equals(exitOptionStr)) {
                            System.out.println("Exiting to Main Menu...\n");
                            break;
                        } else {
                            System.out.println("Invalid action. Please try again.\n");
                        }
                    }
                    break;
                case "3":
                    System.out.println("Exiting program.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid action. Please try again.\n");
            }
        }
    }
}
