package banking;

public class Account {
	private String accNum;
	private String name;
	private int balance;

    public Account(String accNum, String name, int balance) {
        this.accNum = accNum;
        this.name = name;
        this.balance = balance;
    }
    
    
    public void showInfo() {
    	System.out.println("-----------------------");
        System.out.println("계좌번호: " + this.accNum);
        System.out.println("고객성명: " + this.name);
        System.out.println("잔고 : " + this.balance + "원");
        System.out.println("-----------*-----------");
    }
    	

    public String getaccNum() {
        return accNum;
    }

    public String getName() {
        return this.name;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
        }
    }
    



}