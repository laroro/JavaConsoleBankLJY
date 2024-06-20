package banking;

class NormalAccount extends Account {
    private double interestRate;

    public NormalAccount(String accNum, String name, int balance, double interestRate) {
        super(accNum, name, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(int amount) {
        int interest = (int)(getBalance() * interestRate);
        super.deposit(interest + amount);
    }
    
    public double getInterestRate() {
        return this.interestRate;
    }
}

