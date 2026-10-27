package bankaccount;

/**
 * Represents a savings account.
 */
public class SavingsAccount extends BankAccount {

  private String ownerName;

  public SavingsAccount(String ownerName) {
    this.ownerName = ownerName;
  }

  public String getOwnerName() {
    return ownerName;
  }
}