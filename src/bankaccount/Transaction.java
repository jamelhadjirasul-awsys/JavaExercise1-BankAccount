package bankaccount;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private String type;
    private double amount;
    private LocalDateTime time_stamp;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.time_stamp = LocalDateTime.now();
    }

    /**
   * Returns the type, amount and time stamp of the transaction.
   *
   * @return a description of the transaction
   */
  @Override
  public String toString() {
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    return "Transaction [type=" + type + ", amount=" + amount
        + ", time_stamp=" + time_stamp.format(format) + "]";
  }



}
