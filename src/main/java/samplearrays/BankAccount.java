package samplearrays;

public class BankAccount {

    String name;
    double currentBalance;
    //TO-DO: Initialize an Array with 1000 in size that stores Double called 'transactions' to keep track of the user's transactions
    double[] transactions;
    int transactionCount;

    public BankAccount(String name, int startingBalance){
        this.name = name;
        this.currentBalance = startingBalance;
        this.transactions = new double[1000];
        this.transactionCount=0;
    }

    public void deposit(double amount){
        if (amount > 0){
            currentBalance+=amount;
            transactions[transactionCount]=amount;
            transactionCount++;
            System.out.println(name+" deposited "+amount+". New balance: $"+currentBalance);
        }
        else{
            System.out.println("deposit failed: Amount is negative");

        }
    }

    public void withdraw(double amount){
        if (amount<=this.currentBalance){
            currentBalance-=amount;
            transactions[transactionCount]=-amount;
            transactionCount++;
            System.out.println(name+" withdrew "+amount+". New balance: $"+currentBalance);
        }
        else {
            System.out.println("withdraw failed: Insufficient  balance");
        }
    }

    public void displayTransactions(){
        for (double transaction :transactions ){
            if (transaction>0){
                System.out.println("Deposit: "+transaction);
        }
            else if (transaction<0){
                System.out.println("Withdraw: "+transaction);
            }
            else{
                break;
            }
    }}

    public void displayBalance(){
            System.out.println(name+" current balance: "+currentBalance);

    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }

}
