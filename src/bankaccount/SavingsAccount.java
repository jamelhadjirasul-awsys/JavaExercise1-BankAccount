package bankaccount;
public class SavingsAccount extends BankAccount {
    
    public String ownerName;

    public SavingsAccount(String ownerName) {
        this.ownerName = ownerName;     
    }

    public String getOwnerName() {
        return ownerName;
    }
}