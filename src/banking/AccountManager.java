package banking;

import java.util.Scanner;

public class AccountManager implements ICustomDefine {

	// 계좌정보를 저장할 배열 50개 생성
	private Account[] accounts = new Account[50];
	// 만든 계좌수 추적
	private int numOfAccounts = 0;

	public static void main(String[] args) {
		AccountManager manager = new AccountManager();
	}

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

		// 입력받은 정보를 통해 인스턴스 생성
		Account account = new Account(accNum, name, balance);

		// 만든걸 인스턴스 배열에 추가
		accounts[numOfAccounts++] = account;

		System.out.println("---★계좌 생성 완료★---");
		System.out.println("-----------------------");

	}

	// 입금
	public void depositMoney() {
		Scanner scanner = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성
		System.out.println("---------입금----------");
		System.out.println("계좌번호,입금할 금액을 입력");

		System.out.print("계좌번호:");
		String accNum = scanner.nextLine(); // 사용자로부터 계좌번호 입력 받음
		int amount = 0; // 입금액을 저장할 변수 선언 및 초기화

		try {
			System.out.print("입금액:");
			amount = Integer.parseInt(scanner.nextLine()); // 문자열로 입력받은 입금액을 정수로 변환

			if (amount < 0) { // 입금액이 음수일 경우
				System.out.println("실패 음수를 입금불가");
				return;
			}

			if (amount % 500 != 0) { // 입금액이 500원 단위가 아닐 경우
				System.out.println("실패 입금액은 500원 단위로 가능");
				return;
			}

		} catch (NumberFormatException e) { // 입금액 입력이 숫자가 아닐 경우 오류 메시지 출력
			System.out.println("입금은 문자불가");
			return;
		}

		Account account = findAccount(accNum); // 입력받은 계좌번호로 계좌 객체를 찾는 메소드 호출
		if (account != null) {
			account.deposit(amount); // 계좌 객체가 존재하면, 해당 계좌에 입금액 추가
			System.out.println(amount + "원이 입금되었습니다.");
			System.out.println(account.getName() + "의 현재 잔액: " + account.getBalance() + "원");
		} else {
			System.out.println("해당 계좌번호를 찾을 수 없습니다.");
		}
	}

	// 출금
	public void withdrawMoney() {
		Scanner scanner = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성
		System.out.println("---------출금----------");
		System.out.println("계좌번호,출금할 금액을 입력");

		System.out.print("계좌번호:");
		String accNum = scanner.nextLine(); // 사용자로부터 계좌번호 입력 받음

		System.out.print("출금액: ");
		int amount; // 출금액을 저장할 변수 선언

		try {
			amount = Integer.parseInt(scanner.nextLine()); // 문자열로 입력받은 출금액을 정수로 변환
		} catch (NumberFormatException e) {
			System.out.println("출금액은 숫자만 가능합니다.");
			return;
		}

		if (amount < 0) { // 출금액이 음수일 경우
			System.out.println("음수를 출금할 수 없습니다.");
			return;
		}

		if (amount % 1000 != 0) { // 출금액이 1000원 단위가 아닐 경우
			System.out.println("출금은 1000원 단위로만 가능합니다.");
			return;
		}

		Account account = findAccount(accNum); // 입력받은 계좌번호로 계좌 객체를 찾는 메소드 호출

		if (account == null) { // 계좌번호에 해당하는 계좌가 없을 경우 오류 메시지 출력
			System.out.println("해당 계좌번호를 찾을 수 없습니다.");
			return;
		}

		if (account.getBalance() < amount) { // 계좌의 잔액이 출금액보다 적을 경우

			System.out.println("잔고가 부족합니다. 금액 전체를 출금할까요? (Y/N)");
			String response = scanner.nextLine().trim().toUpperCase(); // 사용자 응답 입력 받음
			if ("Y".equals(response)) { // 사용자가 전체 잔액 출금에 동의한 경우
				System.out.println(account.getBalance() + "원이 출금되었습니다.");
				account.withdraw(account.getBalance());
			} else {
				System.out.println("출금 요청이 취소되었습니다.");
			}
		} else {
			account.withdraw(amount); // 계좌에서 출금액만큼 출금
			System.out.println(amount + "원이 출금되었습니다.");
		}

		System.out.println("현재 잔액: " + account.getBalance() + "원");
	}

	// 계좌 검색 메소드
	private Account findAccount(String accNum) {
		for (int i = 0; i < numOfAccounts; i++) { // numOfAccounts 만든계좌의 총개수에서
			if (accounts[i].getaccNum().equals(accNum)) { // accounts 객체에서 accNum과 일치하는 계좌번호를 찾음
				return accounts[i]; // 일치하는 계좌번호를 가진 Account 객체를 반환
			}
		}
		return null; // 일치하는 계좌번호를 가진 Account 객체를 찾지 못한 경우 null 반환
	}

	// 전체계좌정보
	public void showAccInfo() {
		System.out.println("=====전체계좌정보======");
		for (int i = 0; i < numOfAccounts; i++) {
			accounts[i].showInfo();
		}
		System.out.println("-전체계좌정보출력완료-");
	}

}