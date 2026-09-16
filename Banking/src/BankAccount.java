package banking;
public class BankAccount {
    private int balance = 1000;
    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName()+ " Deposited: " + amount  + " Balance: " + balance);         
    }
    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName()+ " Withdraw: " + amount+ " Balance: " + balance);                    
        } else {
            System.out.println(Thread.currentThread().getName() + " Insufficient Balance");
                   
        }
    }
    public int getBalance() {
        return balance;
    }
}