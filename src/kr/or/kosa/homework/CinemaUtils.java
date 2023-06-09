package kr.or.kosa.homework;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CinemaUtils {
 
	//좌석 초기화 함수
  	int[][] initSeat(int[][] seat){
  		for(int i = 0; i < seat.length; i++) {
  			for(int j = 0; j < seat[i].length; j++) {
  				//좌석을 초기화
  				seat[i][j]=0; //빈 의자 배치
  			}
  		}
  		return seat;
  	}
  	
	//좌석 출력하기
  	void printSeat(int[][] seat) {
  		for(int i = 0; i < seat.length; i++) {
  			for(int j = 0; j < seat[i].length; j++) {
  				if(seat[i][j]==0) {
  					System.out.printf("[%d-%d]  ",i+1,j+1);
  				}else {
  					System.out.printf("예약좌석  ");
  				}
  			}
  			System.out.println();
  		}
  	}
  	
  	//내 좌석 출력하기
  	void printSeat(int reservationNum,int[][] seat) {
  		for(int i = 0; i < seat.length; i++) {
  			for(int j = 0; j < seat[i].length; j++) {
  				if(seat[i][j]==reservationNum) {
  					System.out.printf("내좌석  ");
  				}else {
  					System.out.printf("[%d-%d]  ",i+1,j+1);
  				}
  			}
  			System.out.println();
  		}
  	}

    //좌석 예매하기
    void registerSeat(int reservationNum, int[][] seat, int[] selectseat) {
        String message = "";
        boolean reservateYn = false;

        if (seat[selectseat[0]][selectseat[1]] == 0) {
        	seat[selectseat[0]][selectseat[1]] = reservationNum;
            reservateYn = true;
        }
        
        message = reservateYn ? "고객님이 예매하신 예매번호는 [" + reservationNum + "] 입니다\n":"고객님~ 예약이 어려우세요~\n";
        printSeat(reservationNum,seat);
  		System.out.println(message);
    }
    
  	//예매 취소하기
  	void cancleSeat(int reservationNum,int[][] seat){
  		String message = "";
  		boolean cancleYn = false;
  		
  		for(int i=0; i<seat.length; i++) {
			for(int j=0; j < seat[i].length; j++) {
				if(reservationNum == seat[i][j]) {
					seat[i][j] = 0;
					cancleYn = true; 
					break;
				}
			}
		}

  		message = cancleYn ? "고객님이 예매하신 좌석이 취소되었습니다":"고객님~ 예약번호 확인이 안되시네요~";
  		System.out.println(message);
  	}
  	
  	
  	//예매조회 함수
  	void chkSeat(int reservationNum, int[][] seat) {
  		String message = "";
  		boolean reservateYn = false;
  		String seatNum = "";
  		
  		for(int i=0; i<seat.length; i++) {
			for(int j=0; j < seat[i].length; j++) {
				if(reservationNum == seat[i][j]) {
					seatNum = (i+1)+"-"+(j+1);
					reservateYn = true; 
					break;
				}
			}
		}

  		message = reservateYn ? "고객님이 예매하신 좌석은" + seatNum + "입니다":"예매번호 확인이 안됩니다.예매내역을 다시 확인해주세요.";
  		System.out.println(message);
  	}
  	
  	
  	//좌석 선택하기 함수
  	int[] selectSeat(int[][] seat) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("좌석을 선택해 주세요.");
		String inputStr = sc.next();
		
		//정규식
		if(!validSeatNumber(inputStr)) {
			return null;
		}else {
			int i =Integer.parseInt(inputStr.split("-")[0])-1;	//행
			int j =Integer.parseInt(inputStr.split("-")[1])-1;	//열
			int[] rowCol = {i,j};
			return rowCol;
		}
	}
	
	//예약번호 만들기 함수
	int createReservationNum(int[][] seat){
        int serialNum = (int)(Math.random()*100000000)+1;
        //8무조건 8자리 이상으로만 나와야함.
        re : while((String.valueOf(serialNum)).length()!=8){
            serialNum = (int)(Math.random()*100000000)+1;
            for (int i = 0; i < seat.length; i++) {
                for (int j = 0; j < seat[i].length; j++) {
                    if (seat[i][j] == serialNum) {
                        break re;
                    }
                }
            }
        }

        return serialNum;
    }
	
	//선택된 자리가 예약된 자리인지 확인하기 함수(비어있으면 true)
	boolean checkReservationSeat(int[][] seat, int[] selectseat) {
		boolean chkReservation = (seat[selectseat[0]][selectseat[1]]==0)? true:false;
		
		return chkReservation;
	}

	//예매번호 형식검사(8자리)
	int checkReservationNum(int reservationNum) {
		if(reservationNum < 10000000 || reservationNum > 99999999) {
			reservationNum = -1;
		}
		return reservationNum;
	}
	
	//좌석번호 정규식
    boolean validSeatNumber(String seatNumber) {
        Pattern pattern = Pattern.compile("\\d{1}-\\d{1}");//숫자-숫자
        Matcher matcher = pattern.matcher(seatNumber);
        if (matcher.matches()) {
            return true;
        } else {
            System.out.println("유효하지 않은 좌석번호 입니다.");
            return false;
        }
    }
}