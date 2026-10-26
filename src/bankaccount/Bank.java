package bankaccount;

/**
 * Represents a bank that manages bank accounts.
 */
public interface Bank {

  void addAccount(BankAccount account);
  
  BankAccount getAccount(int id);

}
