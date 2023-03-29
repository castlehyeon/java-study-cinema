package kr.or.kosa.homework;

import java.util.Scanner;

public class Ex09_Array_Cinema {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Cinema cinema = new Cinema(5,5,"스즈메의 문단속","16:30","18:00");	//행,열,영화제목
		Cinema cinema2 = new Cinema(5,5,"스즈메의 문단속","17:15","18:45");	//행,열,영화제목

		CinemaMenu cinemaController = new CinemaMenu();
		cinemaController.main(cinema);
	}

}