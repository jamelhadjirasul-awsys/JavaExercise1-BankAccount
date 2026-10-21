public class App {
    public static void main(String[] args) throws Exception {
        
        //Test 1
        BankAccount acc1 = new SavingsAccount("Test0");
        SavingsAccount acc = (SavingsAccount) acc1;
        System.out.println("Acount Owner: " + acc.getOwnerName());

        //Test 2
        acc.deposit(1000.125);

        //Test 3
        acc.deposit(0);

        //Test 4
        acc.deposit(-500);

        //Test 5
        acc.withdraw(500);

        //Test 6
        acc.withdraw(1500);

        //Test 7
        acc.withdraw(-100);

        //Test 8 
        acc.freezeAccount();
        acc.deposit(11500);

        //Test 9
        acc.withdraw(500);

        //Test 10
        acc.unfreezeAccount();
        acc.withdraw(100);
    }
}
