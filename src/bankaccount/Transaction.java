package bankaccount;

import java.time.LocalDateTime;

public class Transaction {
    public String type;
    public double amount;
    public LocalDateTime time_stamp;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.time_stamp = LocalDateTime.now();
    }


}
