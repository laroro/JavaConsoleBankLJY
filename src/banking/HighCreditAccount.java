package banking;

public class HighCreditAccount extends NormalAccount {
  public HighCreditAccount(String accountNumber, String accountHolder, int balance, double interestRate) {
      super(accountNumber, accountHolder, balance, interestRate);
  }

  @Override
  public void deposit(int amount) {
      int additionalInterest = (int)(amount * (interestRate + 0.01)); // 가정: 신용등급에 따른 추가 이자율 1%
      balance += (amount + additionalInterest);
  }
}