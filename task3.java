import java.util.Scanner;
//user's bank account
class BankAccount {
    private double balance;// declare balance 

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    //get balance from user input
    public double getBalance() {
        return balance;
    }
    //add amount to bank account as intial balance
    public void deposit(double amount) {
        balance += amount;
    }
    //withdraw amount from account
    public boolean withdraw(double amount) {
        //withdraw amount from account, if sufficient funds are available in the account
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        //acknowledge user that there are no ssufficient funds in account to withdraw the quoted amount 
        else {
            System.out.println("Insufficient funds!");
            return false;
        }
    }
}
//ATM interface
class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount account) {
        this.userAccount = account;
    }
    //display current balance on screen
    public void withdraw(double amount) {
        if (userAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful. Remaining balance: Rs. " + userAccount.getBalance());//acknowledge user that withdrawl was successful and show cuurent balance after withdrawl
        } 
        else {
            System.out.println("Withdrawal failed. Insufficient funds in account.");//acknowledge user that there are insufficient funds 
        }
    }

    public void deposit(double amount) {
        userAccount.deposit(amount);
        System.out.println("Deposit successful. New balance: Rs. " + userAccount.getBalance());//deposit amount into bank and show current balance
    }

    public void checkBalance() {
        System.out.println("Current balance: Rs. " + userAccount.getBalance());//Show current account balance
    }
}
//Main class
class task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //start an account with some initial balance
        System.out.print("Enter initial account balance: Rs. ");
        double initialBalance = sc.nextDouble();

        BankAccount userAccount = new BankAccount(initialBalance);//stores amount
        ATM atm = new ATM(userAccount);//manages transactions

        while (true) {
            //list of methods at atm
            System.out.println("\nChoose an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Exit");
            //enter your choice
            int choice = sc.nextInt();
            //use switch case to access methods
            switch (choice) {
                case 1:
                    atm.checkBalance();//checks bank balancce
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: Rs. ");
                    double withdrawAmount = sc.nextDouble();
                    atm.withdraw(withdrawAmount);//withdrawing amount from bank account
                    break;
                case 3:
                    System.out.print("Enter deposit amount: Rs. ");
                    double depositAmount = sc.nextDouble();
                    atm.deposit(depositAmount);//depositing amount into bank account
                    break;
                case 4:
                    System.out.println("Thank you! Please visit again!");//exit atm
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");//invalid option
            }
        }
    }
}
