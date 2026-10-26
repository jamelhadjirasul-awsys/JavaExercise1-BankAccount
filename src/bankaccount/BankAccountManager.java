package bankaccount;

import java.util.HashMap;
import java.util.Map;

/**
 * * Stores and manages bank accounts by id.
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
      System.out.println("Account limit reached. Cannot add more accounts.");
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
}