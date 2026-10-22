package bankaccount;

import java.util.List;
import java.util.ArrayList;

/**
 * A basic bank account that supports deposits, withdrawals and freezing.
 */
public class BankAccount {
  /** The current account balance. */
  double balance;

  /** Whether transactions are currently blocked on this account. */
  boolean isFrozen;

  private List<Transaction> transactionHistory;

  /** Constructs a new, unfrozen account with a zero balance. */
  public BankAccount() {
    this.balance = 0.0;
    this.isFrozen = false;
    this.transactionHistory = new ArrayList<>();
  }

  /**
   * Deposits the specified amount into this account and updates its balance.
   */
  public void deposit(double amount) {
    if (isFrozen) {
      System.out.println("Account is FROZEN.");
      System.out.println("Unable to transact.\n");
      return;
    }

    System.out.printf("Amount deposited: %.2f%n", amount);

    if (amount <= 0) {
      System.out.println("Invalid amount. Must be greater than 0.");
    } else {
      balance += amount;
      transactionHistory.add(new Transaction("Deposit", amount));
      System.out.printf("Current balance: %.2f%n", balance);
    }
    System.out.println();
  }

  /**
   * Withdraws the specified amount from this account.
   */
  public void withdraw(double amount) {
    if (isFrozen) {
      System.out.println("Account is FROZEN.");
      System.out.println("Unable to transact.\n");
      return;
    }

    System.out.printf("Amount withdrawn: %.2f%n", amount);

    if (amount <= 0) {
      System.out.println("Invalid amount. Must be greater than 0.");
    } else if (amount > balance) {
      System.out.println("Insufficient balance.");
      System.out.printf("Current balance: %.2f%n", balance);
    } else {
      balance -= amount;
      transactionHistory.add(new Transaction("Withdraw", amount));
      System.out.printf("Current balance: %.2f%n", balance);
    }
    System.out.println();
  }

  /**
   * Returns the current account balance.
   */
  public double getBalance() {
    return balance;
  }

  /** Freezes this account, preventing deposits and withdrawals. */
  public void freezeAccount() {
    isFrozen = true;
  }

  /** Unfreezes this account, allowing deposits and withdrawals. */
  public void unfreezeAccount() {
    isFrozen = false;
  }

  /**
   * Indicates whether this account is frozen.
   */
  public boolean isFrozen() {
    return isFrozen;
  }

  public List<Transaction> getTransactionHistory() {
    return transactionHistory;
  }

  /**
   * Runs the bank account examples.
   */
  public static void main(String[] args) {

    BankAccount acc1 = new SavingsAccount("Test0");
    SavingsAccount acc = (SavingsAccount) acc1;

    //EXERCISE 1
    // Test 1
    System.out.println("\nAcount Owner: " + acc.getOwnerName() + "\n");

    // Test 2
    acc.deposit(1000.125);

    // Test 3
    acc.deposit(0);

    // Test 4
    acc.deposit(-500);

    // Test 5
    acc.withdraw(500);

    // Test 6
    acc.withdraw(1500);

    // Test 7
    acc.withdraw(-100);

    // Test 8
    acc.freezeAccount();
    acc.deposit(11500);

    // Test 9
    acc.withdraw(500);

    // Test 10
    acc.unfreezeAccount();
    acc.withdraw(100);

    //EXERCISE 2
    // Test 11
    System.out.println("Transaction history:");
    System.out.println(acc.getTransactionHistory());

    // Test 12
    BankAccountManager accM1 = new BankAccountManager();

    // Test 13
    accM1.addAccount(acc);

    // Test 14
    accM1.addAccount(new SavingsAccount("Test1"));

    // Test 15
    accM1.listAccounts();
  }
}
