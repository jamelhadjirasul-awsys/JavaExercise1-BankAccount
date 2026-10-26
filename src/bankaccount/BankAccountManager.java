package bankaccount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Stores and manages bank accounts by id.
 */
public class BankAccountManager implements Bank {

  private static final int MAX_ACCOUNTS = 100;
  private Map<Integer, BankAccount> accounts;
  private int id;

  /**
   * Creates an empty manager with ids starting at 0.
   */
  public BankAccountManager() {
    this.accounts = new HashMap<>();
    this.id = 0;
  }

  /**
   * Adds an account to the manager if the account limit has not been reached.
   */
  public void addAccount(BankAccount account) {
    if (accounts.size() >= MAX_ACCOUNTS) {
      System.out.println("\nAccount limit reached. Cannot add more accounts.");
      return;
    }
    accounts.put(id, account);
    System.out.println("\nAccount added successfully with ID: " + id);
    id++;
  }

  @Override
  public BankAccount getAccount(int id) {
    return accounts.get(id);
  }

  /**
   * Displays every account's id, owner name and balance.
   */
  public void listAccounts() {
    for (Map.Entry<Integer, BankAccount> entry : accounts.entrySet()) {
      BankAccount account = entry.getValue();
      String owner = "Unknown";
      if (account instanceof SavingsAccount) {
        owner = ((SavingsAccount) account).getOwnerName();
      }
      double shown = Math.round(account.getBalance() * 100.0) / 100.0;
      System.out.println("\nAccount ID: " + entry.getKey()
          + ", Account Name: " + owner + ", Balance: " + shown);
    }
  }

  /**
   * Filters transactions whose amount is at or above the given amount.
   */
  public List<Transaction> filterTransactionsAtOrAbove(
      double amount, List<Transaction> txList) {
    return txList.stream()
        .filter(tx -> tx.getAmount() >= amount)
        .collect(Collectors.toList());
  }

  /**
   * Sorts transactions by amount in ascending order.
   */
  public List<Transaction> sortTransactionsByAmount(List<Transaction> txList) {
    List<Transaction> sorted = new ArrayList<>(txList);
    sorted.sort((a, b) -> Double.compare(a.getAmount(), b.getAmount()));
    return sorted;
  }

}