import java.util.Scanner;

class BankAccount{
    private double balance;

    public BankAccount(double initialBalance){
        balance = initialBalance;
    }

    public double getBalance(){
        return balance;
    }
    public void deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amount){
        if(amount <= balance){
            balance -= amount;
        }
        else{
            System.out.println("Withdrawal Failure due to Insufficient balance");
        }
    }
}

class ATM{
    private final BankAccount bankAccount;

    public ATM(BankAccount account){
        bankAccount = account;
    }

    public void displayOptions(){
        System.out.println("     Welcome to ATM interface     ");
        System.out.println("**********************************");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void performOption(int option){
        switch (option) {
            case 1 -> withdraw();
            case 2 -> deposit();
            case 3 -> checkBalance();
            case 4 -> {
                System.out.println("Thank you for using the ATM.");
                System.exit(0);
            }
            default -> System.out.println("Invalid option");
        }
    }

    public void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            if (amount <= bankAccount.getBalance()) {
                bankAccount.withdraw(amount);
                System.out.println("Withdrawal successfull");
            } else {
                System.out.println("Withdrawal Failed Due To Insufficient Balance");
            }
        } else {
            System.out.println("Invalid amount");
        }
    }

    public void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to be deposit: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            bankAccount.deposit(amount);
            System.out.println("Amount Deposited successfully");
        } else {
            System.out.println("Invalid amount");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: " + bankAccount.getBalance());
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(10000.0);
        ATM atm = new ATM(bankAccount);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            atm.displayOptions();
            System.out.print("Enter your choice: ");
            int option = scanner.nextInt();
            atm.performOption(option);
        }
    }
}