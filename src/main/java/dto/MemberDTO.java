package dto;

public class MemberDTO {
	private String u_id;
	private String u_pw;
	private String u_name;
	private String u_addr;
	private String u_phone;
	private String grade;

	public MemberDTO() {}

	public MemberDTO(String u_id, String u_pw, String u_name, String u_addr, String u_phone, String grade) {
		super();
		this.u_id = u_id;
		this.u_pw = u_pw;
		this.u_name = u_name;
		this.u_addr = u_addr;
		this.u_phone = u_phone;
		this.grade = grade;
	}

	public String getU_id() {
		return u_id;
	}

	public String getU_pw() {
		return u_pw;
	}

	public String getU_name() {
		return u_name;
	}

	public String getU_addr() {
		return u_addr;
	}

	public String getU_phone() {
		return u_phone;
	}

	public String getGrade() {
		return grade;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public void setU_addr(String u_addr) {
		this.u_addr = u_addr;
	}

	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
}
