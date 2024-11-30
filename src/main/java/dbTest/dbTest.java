package dbTest;

import dao.MemberDAO;

public class dbTest {
	public static void main(String[] args) {
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.getConnection();
	}
}
