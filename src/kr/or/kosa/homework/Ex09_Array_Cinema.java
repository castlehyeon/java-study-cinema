package kr.or.kosa.homework;

public class Ex09_Array_Cinema {

	public static void main(String[] args) {

		Cinema cinema = new Cinema(5,5,"스즈메의 문단속");	//행,열,영화제목
		
		CinemaController cinemaController = new CinemaController();
		cinemaController.main(cinema);
	}

}
