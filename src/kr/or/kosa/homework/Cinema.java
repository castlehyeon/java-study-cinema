package kr.or.kosa.homework;

public class Cinema {
	private int[][] cinemaSeat;
	private String subject;

	
	public Cinema(int row, int col , String subject) {
		this.cinemaSeat = new int[row][col];
		this.subject = subject;
	}

	public int[][] getCinemaSeat() {
		return cinemaSeat;
	}

	public void setCinemaSeat(int[][] cinemaSeat) {
		this.cinemaSeat = cinemaSeat;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
}
