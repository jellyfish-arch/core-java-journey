package atm_system;

import java.util.*;

public class ATM {

    private List<Account> accounts = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    // Constructor: Add dummy accounts
    public ATM() {
        accounts.add(new Account("154G87JTD890", "Nmuis", 1234, 5000));
        accounts.add(new Account("746Y30UGT712", "Iuhra", 4321, 8000));
    }

    // LOGIN SYSTEM
    public Account login() {

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter Account Number: ");
            String accNum = sc.nextLine();

            System.out.print("Enter PIN: ");
            int pin = sc.nextInt();
            sc.nextLine(); // clear buffer

            for (Account acc : accounts) {
                if (acc.getAccountNumber().equals(accNum)
                        && acc.getPin() == pin
                        && acc.isActiveStatus()) {

                    System.out.println("Login Successful");
                    return acc;
                }
            }

            System.out.println("Invalid credentials. Attempts left: " + (2 - i));
        }

        System.out.println("Too many failed attempts.");
        return null;
    }

    // MENU SYSTEM
    public void showMenu(Account acc) {

        while (true) {
            System.out.println("\n--- ATM MENU ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.println("5. Transaction Count");
            System.out.println("6. Change PIN");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double dep = sc.nextDouble();
                    acc.deposit(dep);
                    System.out.println("Updated Balance: " + acc.getBalance());
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double wd = sc.nextDouble();
                    if (acc.withdraw(wd)) {
                        System.out.println("Withdraw Successful");
                    }
                    System.out.println("Current Balance: " + acc.getBalance());
                    break;

                case 3:
                    System.out.println("Current Balance: " + acc.getBalance());
                    break;

                case 4:
                    System.out.println("Thank you for using ATM");
                    return;
                
                case 5:
                    System.out.println("Transactions: " + acc.getTransactionCount());
                    break;
                case 6:
                    System.out.print("Enter old PIN: ");
                    int oldPin = sc.nextInt();

                    System.out.print("Enter new PIN: ");
                    int newPin = sc.nextInt();

                    acc.changePin(oldPin, newPin);
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}