package bankaccount;

import exception.AccountFrozenException;
import exception.InsufficientFundsException;
import exception.InvalidAmountException;
import java.util.ArrayList;
import java.util.List;

/**
 * A basic bank account that supports deposits, withdrawals and freezing.
 */
public class BankAccount {

  private double balance;
  private boolean isFrozen;
  private List<Transaction> transactionHistory;

  /**
   * Constructs a new, unfrozen account with a zero balance.
   */
  public BankAccount() {
    this.balance = 0.0;
    this.isFrozen = false;
    this.transactionHistory = new ArrayList<>();
  }

  /**
   * Deposits the specified amount into this account and updates its balance.
   */
  public void deposit(double amount) {
    try {
      if (isFrozen) {
        throw new AccountFrozenException("Account is FROZEN. Unable to transact.");
      }

      System.out.printf("Amount deposited: %.2f%n", amount);

      if (amount <= 0) {
        throw new InvalidAmountException("Invalid amount. Must be greater than 0");
      }

      balance += amount;
      transactionHistory.add(new Transaction("Deposit", amount));
      printBalance();
      System.out.println();
    } catch (InvalidAmountException | AccountFrozenException e) {
      System.out.println(e.getMessage() + "\n");
    }
  }

  /**
   * Withdraws the specified amount from this account.
   */
  public void withdraw(double amount) {
    try {
      if (isFrozen) {
        throw new AccountFrozenException("Account is FROZEN. Unable to transact.");
      }

      System.out.printf("Amount withdrawn: %.2f%n", amount);

      if (amount <= 0) {
        throw new InvalidAmountException("Invalid amount. Must be greater than 0");
      }
      if (amount > balance) {
        throw new InsufficientFundsException("Insufficient balance.");
      }

      balance -= amount;
      transactionHistory.add(new Transaction("Withdraw", amount));
      printBalance();
      System.out.println();
    } catch (InsufficientFundsException e) {
      System.out.println(e.getMessage());
      printBalance();
      System.out.println();
    } catch (InvalidAmountException | AccountFrozenException e) {
      System.out.println(e.getMessage() + "\n");
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

  private void printBalance() {
    System.out.printf("Current balance: %.2f%n", balance);
  }

  public List<Transaction> getTransactionHistory() {
    return transactionHistory;
  }

  /**
   * Runs the bank account test cases.
   */
  public static void main(String[] args) {

    BankAccount acc1 = new SavingsAccount("Test0");
    SavingsAccount acc = (SavingsAccount) acc1;

    // EXERCISE 1
    // Test 1
    System.out.println("\nAccount Owner: " + acc.getOwnerName() + "\n");

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

    // EXERCISE 2
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

    // EXERCISE 3
    // Test 16
    System.out.println();
    acc.deposit(-500);

    // Test 17
    acc.freezeAccount();
    acc.deposit(11500);
    acc.unfreezeAccount();

    // Test 18
    acc.withdraw(-100);

    // Test 19
    acc.withdraw(1500);

    // Test 20
    acc.freezeAccount();
    acc.withdraw(500);
    acc.unfreezeAccount();

    // Test 21
    System.out.println("Filtering transactions at or above 200...");
    System.out.println(
        accM1.filterTransactionsAtOrAbove(200, acc.getTransactionHistory()));

    // Test 22
    System.out.println("\nSorting transactions by amount...");
    System.out.println(
        accM1.sortTransactionsByAmount(acc.getTransactionHistory()));
  }
}
