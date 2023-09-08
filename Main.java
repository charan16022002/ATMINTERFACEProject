import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount account) {
        userAccount = account;
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        double amount;

        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Balance: $" + userAccount.getBalance());
                    break;

                case 2:
                    System.out.print("Enter deposit amount: $");
                    amount = scanner.nextDouble();
                    if (amount > 0) {
                        userAccount.deposit(amount);
                        System.out.println("Deposited $" + amount);
                    } else {
                        System.out.println("Invalid deposit amount.");
                    }
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: $");
                    amount = scanner.nextDouble();
                    if (amount > 0) {
                        if (userAccount.withdraw(amount)) {
                            System.out.println("Withdrawn $" + amount);
                        } else {
                            System.out.println("Insufficient balance.");
                        }
                    } else {
                        System.out.println("Invalid withdrawal amount.");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0); // Initial balance of $1000
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}
