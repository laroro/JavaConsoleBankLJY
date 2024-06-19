package banking;

import java.util.Scanner;

public class BankingSystemMain {
    public static void main(String[] args) {
        
        //메인부분은 실행을위해 스캐너가 있어야함
        Scanner scan = new Scanner(System.in);

        AccountManager manager = new AccountManager();

        

        //반복실행 와일문으로
        while (true) {

        	
            //메뉴를 보여줌
            manager.showMenu();
            
            //아래 스위치문을 숫자로 입력받음
            int choice = scan.nextInt();

            switch (choice) {
                case ICustomDefine.MAKE:
                    manager.makeAccount();
                    break; // 브레이크써줘야 실행후 처음으로 안돌아감
                case ICustomDefine.DEPOSIT:
                    manager.depositMoney();
                    break;
                case ICustomDefine.WITHDRAW:
                    manager.withdrawMoney();
                    break;
                case ICustomDefine.INQUIRE:
                    manager.showAccInfo();
                    break;
                case ICustomDefine.EXIT:
                    System.out.println("프로그램을 종료합니다.");
                    scan.close();
                    return;
                default:
                    System.out.println("잘못된 입력. 다시 입력");
                    break;
            }
        }
    }
}