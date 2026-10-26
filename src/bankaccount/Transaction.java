package bankaccount;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a bank account transaction with its type, amount, and timestamp.
 */
public class Transaction {
  private String type;
  private double amount;
  private LocalDateTime timeStamp;

  /**
   * Creates a transaction with the specified type and amount.
   */
  public Transaction(String type, double amount) {
    this.type = type;
    this.amount = amount;
    this.timeStamp = LocalDateTime.now();
  }

  /**
   * Returns the type, amount and time stamp of the transaction.
   */
  public String toString() {
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    return "\nTransaction [type=" + type + ", amount=" + amount
        + ", time_stamp=" + timeStamp.format(format) + "]";
  }

  public double getAmount() {
    return amount;
  }

}
