package banking;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingSystemMain {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		AccountManager manager = new AccountManager();

		while (true) {
			try {
				manager.showMenu();
				int choice = scanner.nextInt();
				scanner.nextLine();

				switch (choice) {
				case ICustomDefine.MAKE:
					manager.makeAccount();
					break;
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
					scanner.close();
					return;
				default:
					System.out.println("메뉴는 1~5 사이의 숫자를 입력해주세요.");
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("메뉴입력 예외 발생됨.");
				System.out.println("숫자를 입력해야 함");
				scanner.nextLine();
			} catch (Exception e) {
				System.out.println("알 수 없는 오류가 발생");
				scanner.nextLine();
			}
		}
	}
}