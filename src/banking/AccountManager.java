package banking;

import java.util.Scanner;

public class AccountManager implements ICustomDefine {

    // 계좌정보를 저장할  배열 50개 생성
    private Account[] accounts = new Account[50];
    // 만든 계좌수 추적
    private int numOfAccounts = 0;

    public void showMenu() {
        System.out.println("---------Menu----------");
        System.out.println(MAKE + ".계좌개설");
        System.out.println(DEPOSIT + ".입금");
        System.out.println(WITHDRAW + ".출금");
        System.out.println(INQUIRE + ".계좌정보출력");
        System.out.println(EXIT + ".프로그램종료");
        System.out.print("-------메뉴선택------>>");
        
    }

 
    
    
    // 계좌 개설 
    public void makeAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------");
        System.out.println("******신규계좌개설******"); 
        
        System.out.print("계좌번호:"); 
		String accNum = scanner.nextLine();

        System.out.print("고객이름:");
		 String name = scanner.nextLine();

        System.out.print("잔고:");
		int balance = scanner.nextInt();

        //입력받은 정보를 통해 인스턴스 생성
        Account account = new Account(accNum, name, balance);
                
        //만든걸 인스턴스 배열에 추가
        accounts[numOfAccounts++] = account;
        
        System.out.println("---★계좌 생성 완료★---");
        System.out.println("-----------------------");
    }

    // 계좌 검색 메소드
    private Account findAccount(String accNum) {
        for (int i = 0; i < numOfAccounts; i++) { // numOfAccounts 만든계좌의 총개수에서
            if (accounts[i].getaccNum().equals(accNum)) {  // accounts 객체에서 accNum과 일치하는 계좌번호를 찾음
                return accounts[i]; // 일치하는 계좌번호를 가진 Account 객체를 반환
            }
        }
        return null;  // 일치하는 계좌번호를 가진 Account 객체를 찾지 못한 경우 null 반환
    }
    
    
    // 입금 
    public void depositMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------입금----------");
        System.out.println("계좌번호,입금할 금액을 입력"); 
        
        System.out.print("계좌번호:");
        String accNum = scanner.nextLine();
        
        System.out.print("입금액:");
        int balance = scanner.nextInt();
        
        /*계좌찾기
        findAccount 메소드를 호출 accNum (계좌번호)에 해당하는 Account 객체를 찾고, 결과를 account 변수에 저장
        */
        Account account = findAccount(accNum);
        
        
        
        // 금액 입금
        if (account != null) { // 계좌객체확인
            account.deposit(balance); // 있다면 계좌객체에 잔액에 입금액을 저장
            System.out.println(balance + "원이 입금되었습니다.");
            System.out.println(account.getName() + "의" + "현재 잔액: " + account.getBalance() + "원"); //account가 가진금액을 getBalance로 불러옴
            
        } else {
            System.out.println("해당 계좌번호를 찾을 수 없습니다.");
        }
    }
    

    // 출금 
    public void withdrawMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------출금----------");
        System.out.println("계좌번호,출금할 금액을 입력"); 
        
        System.out.print("계좌번호:");
        //accNum에 저장한것을 scanner를 통해 읽어오고 accNum이라는 String타입의 변수에 저장
        String accNum = scanner.nextLine();
        
        
        System.out.print("출금액: ");
        //amount에 저장한것을 scanner를 통해 읽어오고 amount라는 int타입의 변수에 저장
        int amount = scanner.nextInt();
        
       /*계좌찾기
        findAccount 메소드를 호출 accNum (계좌번호)에 해당하는 Account 객체를 찾고, 결과를 account 변수에 저장
        */
        Account account = findAccount(accNum);
     
        if (account != null) { // 계좌객체확인
            if (account.getBalance() >= amount) { //입력받은  int amount가 account의 금액보다 작은지 확인
                account.withdraw(amount); //잔액이 충분하다면 amount를 호출해서 차감함
                System.out.println(amount + "원이 출금되었습니다.");
                System.out.println(account.getName() + "의" + "현재 잔액: " + account.getBalance() + "원"); ////account가 가진금액을 getBalance로 불러옴
            } else {
                System.out.println("잔액이 부족합니다.");
            }
        } else {
            System.out.println("해당 계좌번호를 찾을 수 없습니다.");
        }
        
    }

    // 전체계좌정보
    public void showAccInfo() {
        System.out.println("=====전체계좌정보======");
        for(int i=0 ; i<numOfAccounts ; i++) {
            accounts[i].showInfo();
        }
        System.out.println("-전체계좌정보출력완료-");
    }
    
    
}