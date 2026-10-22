package bankaccount;

import java.util.HashMap;
import java.util.Map;

/**
 * Stores and manages bank accounts by id.
 */
public class BankAccountManager implements Bank {

  /** The maximum number of accounts that can be created. */
  private static final int MAX_ACCOUNTS = 100;

  /** Maps each account id to its account. */
  private Map<Integer, BankAccount> accounts;

  /** The id given to the next account. */
  private int id;

  /**
   * Creates an empty manager with ids starting at 0.
   */
  public BankAccountManager() {
    this.accounts = new HashMap<>();
    this.id = 0;
  }

  @Override
  public void addAccount(BankAccount account) {
    if (accounts.size() >= MAX_ACCOUNTS) {
      System.out.println("Account limit reached. Cannot add more accounts.");
      return;
    }
    accounts.put(id, account);
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
      System.out.printf("ID: %d | Owner: %s | Balance: %.2f%n",
          entry.getKey(), owner, account.getBalance());
    }
  }
}