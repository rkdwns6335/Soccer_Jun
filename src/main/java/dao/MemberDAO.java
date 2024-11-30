package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.MemberDTO;

public class MemberDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "c##java";
	private String pass = "1234";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static MemberDAO instance = new MemberDAO(); // 싱글톤 패턴을 사용한 MemberDAO 객체 생성
	
	//DB Driver 연결
	public MemberDAO() {
		try {
			Class.forName(driver); // JDBC 드라이버를 메모리에 로드
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // 드라이버 클래스가 없을 때 예외 처리
		}
	}
	
	//싱글톤
	public static MemberDAO getInstance() {
		return instance; // 싱글톤 인스턴스를 반환
	}
	
	// 자원 해제 메서드
	private void closeResources(ResultSet rs, PreparedStatement pstmt, Connection con) {
		if (rs != null) {
	        try {
	            rs.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		if (pstmt != null) {
	        try {
	            pstmt.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    if (con != null) {
	        try {
	            con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	}
	
	//DB 연결
	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, pass); // 데이터베이스 연결 설정
		} catch (SQLException e) {
			e.printStackTrace(); // 데이터베이스 연결 중 예외 처리
		}
		return con;
	}
	
	//회원가입
	public boolean join(String u_id, String u_pw, String u_name, String u_addr, String u_phone, String grade) {
	    Connection con = getConnection(); // 데이터베이스 연결
	    PreparedStatement pstmt = null;
	    boolean isSuccess = false;

	    try {
	        String sql = "INSERT INTO soccer_member (u_id, u_pw, u_name, u_addr, u_phone, grade) VALUES (?, ?, ?, ?, ?, ?)";
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, u_id);
	        pstmt.setString(2, u_pw);
	        pstmt.setString(3, u_name);
	        pstmt.setString(4, u_addr);
	        pstmt.setString(5, u_phone);
	        pstmt.setString(6, grade); // 데이터베이스 컬럼에 맞는 데이터 타입으로 변경

	        int result = pstmt.executeUpdate(); // SQL 쿼리 실행
	        isSuccess = (result > 0); // 성공 여부 판단

	    } catch (SQLException e) {
	        e.printStackTrace(); // SQL 실행 중 예외 처리
	    } finally {
	        closeResources(rs, pstmt, con); // 자원 해제
	    }

	    return isSuccess;
	}
	
	//아이디 중복 확인
	public boolean isExistId(String u_id) {
		boolean exist = false;
		Connection con = getConnection(); // 데이터베이스 연결
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from soccer_member where u_id = ?"; // 아이디 중복 여부를 확인하는 SQL 쿼리
			pstmt = con.prepareStatement(sql); // SQL 쿼리 준비
			pstmt.setString(1, u_id); // 첫 번째 ?에 아이디 설정
			rs = pstmt.executeQuery(); // SQL 쿼리 실행하여 결과 집합 반환
			if(rs.next()) {
				exist = true; // 결과 집합에 데이터가 있으면 아이디가 중복됨
			}
		} catch (SQLException e) {
			e.printStackTrace(); // SQL 실행 중 예외 처리
		} finally {
			closeResources(rs, pstmt, con); // 자원 해제
		}
		return exist; // 아이디 중복 여부 반환
	}
	
	//로그인
	public MemberDTO login(String u_id, String u_pw) {
		MemberDTO memberDTO = null;
		Connection con = getConnection(); // 데이터베이스 연결
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from soccer_member where u_id = ? and u_pw = ?"; // 아이디와 비밀번호로 로그인 확인하는 SQL 쿼리
		try {
			pstmt = con.prepareStatement(sql); // SQL 쿼리 준비
			pstmt.setString(1, u_id); // 첫 번째 ?에 아이디 설정
			pstmt.setString(2, u_pw); // 두 번째 ?에 비밀번호 설정
			rs = pstmt.executeQuery(); // SQL 쿼리 실행하여 결과 집합 반환
			while(rs.next()) {
				memberDTO = new MemberDTO();
				memberDTO.setU_id(rs.getString("u_id"));
				memberDTO.setU_pw(rs.getString("u_pw"));
				memberDTO.setU_name(rs.getString("u_name"));
				memberDTO.setU_addr(rs.getString("u_addr"));
				memberDTO.setU_phone(rs.getString("u_phone"));
				memberDTO.setGrade(rs.getString("grade"));
			}
		} catch (SQLException e) {
			e.printStackTrace(); // SQL 실행 중 예외 처리
		} finally {
			closeResources(rs, pstmt, con); // 자원 해제
		}
		System.out.println("memberDTO : "+ memberDTO);
		return memberDTO; 
	}
	
}
