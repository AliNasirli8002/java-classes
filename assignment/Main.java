package assignment;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        Account accountArr[] = new Account[10];
        while (true) {
            System.out.println("Select action: \n");
            System.out.println("1:Create Account \n");
            System.out.println("2:Select Account\n");
            String userInput = myObj.nextLine();
            switch (userInput){
                case "1":
                    System.out.println("Enter Account Number: ");
                    String accNum = myObj.nextLine();
                    System.out.println("Enter Account Name: ");
                    String accName = myObj.nextLine();
                    System.out.println("Enter Initial Deposit Amount: ");
                    double initDeposit = Double.parseDouble(myObj.nextLine());
                    Account newAcc = new Account(accNum, accName, initDeposit);
                    for (int i = 0; i < accountArr.length; i++) {
                        if (accountArr[i] == null) {
                            accountArr[i] = newAcc;
                            System.out.println("Account Created Successfully!\n");
                            break;
                        }
                    }
                    break;
                case "2":
                    System.out.println("Enter Account Number: ");
                    String selectAccNum = myObj.nextLine();
                    Account selectedAcc = null;
                    for (Account acc : accountArr) {
                        if (acc != null && acc.getAccountNumber().equals(selectAccNum)) {
                            selectedAcc = acc;
                            break;
                        }
                    }
                    if (selectedAcc == null) {
                        System.out.println("Account not found!\n");
                        break;
                    }
                    while (true) {
                        System.out.println("Select action for Account " + selectedAcc.getAccountNumber() + ":\n");
                        System.out.println("1:Deposit\n");
                        System.out.println("2:Withdraw\n");
                        System.out.println("3:Check Balance\n");
                        System.out.println("4:Exit to Main Menu\n");
                        String accAction = myObj.nextLine();
                        switch (accAction) {
                            case "1":
                                System.out.println("Enter amount to deposit: ");
                                double depositAmount = Double.parseDouble(myObj.nextLine());
                                selectedAcc.deposit(depositAmount);
                                break;
                            case "2":
                                System.out.println("Enter amount to withdraw: ");
                                double withdrawAmount = Double.parseDouble(myObj.nextLine());
                                selectedAcc.withdraw(withdrawAmount);
                                break;
                            case "3":
                                System.out.println("Current Balance: " + selectedAcc.getBalance() + "\n");
                                break;
                            case "4":
                                System.out.println("Exiting to Main Menu...\n");
                                break;
                            default:
                                System.out.println("Invalid action. Please try again.\n");
                        }
                        if (accAction.equals("4")) {
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid action. Please try again.\n");
            }
        }
    }
}
