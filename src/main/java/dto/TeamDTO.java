package dto;

public class TeamDTO {
	private String t_name;
	private String t_founded;
	private String t_hometown;
	private String t_stadium;
	private int t_win;
	
	public TeamDTO() {}

	public TeamDTO(String t_name, String t_founded, String t_hometown, String t_stadium, int t_win) {
		super();
		this.t_name = t_name;
		this.t_founded = t_founded;
		this.t_hometown = t_hometown;
		this.t_stadium = t_stadium;
		this.t_win = t_win;
	}

	public String getT_name() {
		return t_name;
	}

	public String getT_founded() {
		return t_founded;
	}

	public String getT_hometown() {
		return t_hometown;
	}

	public String getT_stadium() {
		return t_stadium;
	}

	public int getT_win() {
		return t_win;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public void setT_founded(String t_founded) {
		this.t_founded = t_founded;
	}

	public void setT_hometown(String t_hometown) {
		this.t_hometown = t_hometown;
	}

	public void setT_stadium(String t_stadium) {
		this.t_stadium = t_stadium;
	}

	public void setT_win(int t_win) {
		this.t_win = t_win;
	}
	
	
	
}
