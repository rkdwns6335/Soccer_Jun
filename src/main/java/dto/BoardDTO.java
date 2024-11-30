package dto;

import java.util.Date;

public class BoardDTO {
	private int b_seq;
	private String b_title;
	private String b_content;
	private String b_name;
	private Date b_logtime;
	
	
	public BoardDTO() {}


	public BoardDTO(int b_seq, String b_title, String b_content, String b_name, Date b_logtime) {
		super();
		this.b_seq = b_seq;
		this.b_title = b_title;
		this.b_content = b_content;
		this.b_name = b_name;
		this.b_logtime = b_logtime;
	}


	public int getB_seq() {
		return b_seq;
	}


	public String getB_title() {
		return b_title;
	}


	public String getB_content() {
		return b_content;
	}


	public String getB_name() {
		return b_name;
	}


	public Date getB_logtime() {
		return b_logtime;
	}


	public void setB_seq(int b_seq) {
		this.b_seq = b_seq;
	}


	public void setB_title(String b_title) {
		this.b_title = b_title;
	}


	public void setB_content(String b_content) {
		this.b_content = b_content;
	}


	public void setB_name(String b_name) {
		this.b_name = b_name;
	}


	public void setB_logtime(Date b_logtime) {
		this.b_logtime = b_logtime;
	}
	
	
	
}
