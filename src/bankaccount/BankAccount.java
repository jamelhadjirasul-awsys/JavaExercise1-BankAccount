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
  public void deposit(double amount)
      throws InvalidAmountException, AccountFrozenException {
    if (isFrozen) {
      throw new AccountFrozenException("Account is FROZEN. Unable to transact.");
    }

    System.out.printf("\nAmount deposited: %.2f%n", amount);

    if (amount <= 0) {
      throw new InvalidAmountException("Invalid amount. Must be greater than 0");
    }

    balance += amount;
    transactionHistory.add(new Transaction("Deposit", amount));
    printBalance();
    System.out.println();
  }

  /**
   * Withdraws the specified amount from this account.
   */
  public void withdraw(double amount)
      throws InvalidAmountException, InsufficientFundsException,
      AccountFrozenException {
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
   * Deposits into an account and prints any error instead of crashing.
   */
  private static void tryDeposit(BankAccount acc, double amount) {
    try {
      acc.deposit(amount);
    } catch (InvalidAmountException | AccountFrozenException e) {
      System.out.println(e.getMessage() + "\n");
    }
  }

  /**
   * Withdraws from an account and prints any error instead of crashing.
   */
  private static void tryWithdraw(BankAccount acc, double amount) {
    try {
      acc.withdraw(amount);
    } catch (InsufficientFundsException e) {
      System.out.println(e.getMessage());
      acc.printBalance();
      System.out.println();
    } catch (InvalidAmountException | AccountFrozenException e) {
      System.out.println(e.getMessage() + "\n");
    }
  }

  /**
   * Runs the bank account test cases.
   */
  public static void main(String[] args) {

    BankAccount acc1 = new SavingsAccount("Test0");
    SavingsAccount acc = (SavingsAccount) acc1;

    // EXERCISE 1
    // Test 1
    System.out.println("\nAccount Owner: " + acc.getOwnerName());

    // Test 2
    tryDeposit(acc, 1000.125);

    // Test 3
    tryDeposit(acc, 0);

    // Test 4
    tryDeposit(acc, -500);

    // Test 5
    tryWithdraw(acc, 500);

    // Test 6
    tryWithdraw(acc, 1500);

    // Test 7
    tryWithdraw(acc, -100);

    // Test 8
    acc.freezeAccount();
    tryDeposit(acc, 11500);

    // Test 9
    tryWithdraw(acc, 500);

    // Test 10
    acc.unfreezeAccount();
    tryWithdraw(acc, 100);

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
    tryDeposit(acc, -500);

    // Test 17
    acc.freezeAccount();
    tryDeposit(acc, 11500);
    acc.unfreezeAccount();

    // Test 18
    tryWithdraw(acc, -100);

    // Test 19
    tryWithdraw(acc, 1500);

    // Test 20
    acc.freezeAccount();
    tryWithdraw(acc, 500);
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
