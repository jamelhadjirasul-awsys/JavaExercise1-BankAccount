public class BankAccount {
    double balance;
    boolean isFrozen;

    public BankAccount() {
        this.balance = 0.0;
        this.isFrozen = false;
    }

    public void deposit(double amount) {
        if (isFrozen) {
            System.out.println("Account is frozen. Cannot deposit.");
            return;
        }
        if (amount <= 0) {
            System.out.printf("Amount deposited: %.2f%nInvalid amount. Must be greater than 0.", amount);

        } else {
            balance += amount;
            System.out.printf("Current balance: %.2f%n", getBalance());
        }

        System.out.printf("\nAmount Deposited: %.2f%n", balance);

    }

    public void withdraw(double amount) {

        if (isFrozen) {
            System.out.println("Account is FROZEN");
            return;
        }
        if (amount <= 0) {
            System.out.printf("\nAmount withdrawn: %.2f%nInsufficient balance", amount);
            System.out.printf("\nCurrent balance: %.2f%n", balance);
            return;
        }
        if (amount > balance) {
            System.out.printf("\nAmount withdrawn: %.2f%nInvalid amount. Must be greater than 0", amount);
            System.out.printf("\nCurrent balance: %.2f%n", balance);
            return;
        }else {
        balance -= amount;
        System.out.printf("\nCurrent balance: %.2f%n", balance);
        }
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

}
