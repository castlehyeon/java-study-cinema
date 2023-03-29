package kr.or.kosa.homework;

import java.util.Scanner;

public class CinemaMenu {
	
	CinemaUtils cinemaService = new CinemaUtils();
	Scanner sc = new Scanner(System.in);

	// 메인함수
	public void main(Cinema theater) {
		
		this.showMenu();
		int menuNum = sc.nextInt();

		switch (menuNum) {
		case 1:	//예매
			ticketingSeat(theater);	
			break;
		case 2: //예매 조회
			checkSeat(theater);
			break;
		case 3:	//예매 취소
			cancleSeat(theater);
		case 4:	//종료
			System.out.println("종료되었습니다.");
			System.exit(0);
			break;
		default:
			System.out.println("정확한 값을 입력하세요");
			break;

		}
	}

	void showMenu() {
		System.out.println("************");
		System.out.println("영화 예매 시스템");
		System.out.println("1. 예매");
		System.out.println("2. 예매조회");
		System.out.println("3. 예매취소");
		System.out.println("4. 종료");
		System.out.println("************");
	}
	
	//1.예매
	void ticketingSeat(Cinema theater) {
		int[][] seat = theater.getCinemaSeat();
		try {
			cinemaService.printSeat(seat);										//좌석 보여주기
			int[] selectseat = cinemaService.selectSeat(seat);					//좌석 선택하기

			if(cinemaService.checkReservationSeat(seat,selectseat)) {			//빈좌석일때만 예약
				int reservationNum = cinemaService.createReservationNum(seat);	//예매번호 생성
				cinemaService.registerSeat(reservationNum,seat,selectseat);		//예매처리 함수
			}else {
				System.out.println("이미 예약된 좌석입니다. 다시 선택해주세요");
				ticketingSeat(theater);
			}

		}catch (Exception e) {
			System.out.println("예매중 오류가 발생하였습니다.");
		}finally {
			this.main(theater);
		}
	}
	
	//2.예매 조회
	void checkSeat(Cinema theater) {
		int[][] seat = theater.getCinemaSeat();
		try {
			System.out.println("조회하실 예매번호를 입력해주세요.");
			int reservationNum = sc.nextInt();
		
			cinemaService.chkSeat(reservationNum,seat);
			cinemaService.printSeat(reservationNum,seat);
		}catch (Exception e) {
			System.out.println("예매조회중 오류가 발생하였습니다.");
		}finally {
			this.main(theater);
		}
	}
	
	//3.예매취소
	void cancleSeat(Cinema theater) {
		int[][] seat = theater.getCinemaSeat();
		try {
			System.out.println("취소하실 예매번호를 입력해주세요.");
			int reservationNum = sc.nextInt();
		
			cinemaService.cancleSeat(reservationNum,seat);
		}catch (Exception e) {
			System.out.println("예매취소중 오류가 발생하였습니다.");
		}finally {
			this.main(theater);
		}
	}
	
	
}