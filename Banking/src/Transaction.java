package banking;
public class Transaction extends Thread {
    private BankAccount account;
    private int amount;
    private boolean deposit;
    public Transaction(BankAccount account, int amount, boolean deposit) {
        this.account = account;
        this.amount = amount;
        this.deposit = deposit;
    }
    public void run() {
        if (deposit) {
            account.deposit(amount);
        } else {
            account.withdraw(amount);
        }

    }
}