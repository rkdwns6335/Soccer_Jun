package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.TeamDTO;

public class TeamDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "c##java";
	private String pass = "1234";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static TeamDAO instance = new TeamDAO(); // 싱글톤 패턴을 사용한 TeamDAO 객체 생성
	
	//DB Driver 연결
	public TeamDAO() {
		try {
			Class.forName(driver); // JDBC 드라이버를 메모리에 로드
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // 드라이버 클래스가 없을 때 예외 처리
		}
	}
	
	//싱글톤
	public static TeamDAO getInstance() {
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
	
	//팀 상세 조회
	public TeamDTO team_view(String t_name) {
		TeamDTO teamDTO = null;
        String sql = "SELECT * FROM team WHERE t_name = ?";
        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
             
            pstmt.setString(1, t_name);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
            	teamDTO = new TeamDTO();
                teamDTO.setT_name(rs.getString("t_name"));
                teamDTO.setT_founded(rs.getString("t_founded"));
                teamDTO.setT_hometown(rs.getString("t_hometown"));
                teamDTO.setT_stadium(rs.getString("t_stadium"));
                teamDTO.setT_win(rs.getInt("t_win"));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teamDTO;
    }
	
}

