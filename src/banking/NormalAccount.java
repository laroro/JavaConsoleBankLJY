package banking;

public class NormalAccount extends Account {
    protected double interestRate;

    public NormalAccount(String accountNumber, String accountHolder, int balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(int amount) {
        int interest = (int)(amount * interestRate);
        balance += (amount + interest);
    }
}