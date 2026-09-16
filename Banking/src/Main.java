package banking;
public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        Transaction t1 = new Transaction(account, 500, true);
        Transaction t2 = new Transaction(account, 300, false);
        Transaction t3 = new Transaction(account, 200, true);
        Transaction t4 = new Transaction(account, 700, false);

        t1.setName("Customer-1");
        t2.setName("Customer-2");
        t3.setName("Customer-3");
        t4.setName("Customer-4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nFinal Balance = " + account.getBalance());
    }
}