package bankaccount;
public class BankAccount {
    double balance;
    boolean isFrozen;

    public BankAccount() {
        this.balance = 0.0;
        this.isFrozen = false;
    }

    public void deposit(double amount) {
        System.out.printf("Amount deposited: %.2f%n", amount);

        if (isFrozen) {
            System.out.println("\nAccount is FROZEN.");
            System.out.println("Unable to transact.");
        } else if (amount <= 0) {
            System.out.println("Invalid amount. Must be greater than 0.");
        } else {
            balance += amount;
            System.out.printf("Current balance: %.2f%n", balance);
        }
        System.out.println();
    }

    public void withdraw(double amount) {
        if (isFrozen) {
            System.out.println("Account is FROZEN.");
            System.out.println("Unable to transact.");
        } else if (amount <= 0) {
            System.out.printf("Invalid amount. Must be greater than 0.");
        } else if (amount > balance) {
            System.out.printf("Insufficient balance. ");
            System.out.printf("\nCurrent balance: %.2f%n", balance);
        } else {
            balance -= amount;
            System.out.printf("Amount withdrawn: %.2f%n", amount);
            System.out.printf("Current balance: %.2f%n", balance);
        }
        System.out.println();
    }

    public double getBalance() {
        return balance;
    }

    public void freezeAccount() {
        isFrozen = true; 
    }

    public void unfreezeAccount() {
        isFrozen = false;
    }

    public boolean isFrozen() {
        return isFrozen;
    }

    public static void main(String[] args) {
        
        //Test 1
        BankAccount acc1 = new SavingsAccount("Test0");
        SavingsAccount acc = (SavingsAccount) acc1;
        System.out.println("\nAcount Owner: " + acc.getOwnerName() + "\n");

        //Test 2
        acc.deposit(1000.125);

        //Test 3
        acc.deposit(0);

        //Test 4
        acc.deposit(-500);

        //Test 5
        acc.withdraw(500);

        //Test 6
        acc.withdraw(1500);

        //Test 7
        acc.withdraw(-100);

        //Test 8 
        acc.freezeAccount();
        acc.deposit(11500);

        //Test 9
        acc.withdraw(500);

        //Test 10
        acc.unfreezeAccount();
        acc.withdraw(100);
    }

}
