package banking;

class HighCreditAccount extends NormalAccount {
    private String creditRating;

    public HighCreditAccount(String accNum, String name, int balance, double interestRate, String creditRating) {
        super(accNum, name, balance, interestRate);
        this.creditRating = creditRating;
    }

    @Override
    public void deposit(int amount) {
        int interest = (int)(getBalance() * getInterestRate());
        int additionalInterest = 0;
        switch (creditRating) {
            case "A":
                additionalInterest = (int)(getBalance() * 0.07);
                break;
            case "B":
                additionalInterest = (int)(getBalance() * 0.04);
                break;
            case "C":
                additionalInterest = (int)(getBalance() * 0.02);
                break;
        }
        super.deposit(interest + additionalInterest + amount);
    }
}