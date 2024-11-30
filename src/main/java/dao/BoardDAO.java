 package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import dto.BoardDTO;
import dto.MemberDTO;

public class BoardDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "c##java";
	private String pass = "1234";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private static BoardDAO instance = new BoardDAO();

	public BoardDAO() {
		try {
			Class.forName(driver); // JDBC 드라이버를 메모리에 로드
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // 드라이버 클래스가 없을 때 예외 처리
		}
	}

	public static BoardDAO getInstance() {
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

	// DB 연결
	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("Database connection successful.");
		} catch (SQLException e) {
			System.out.println("Database connection failed.");
			e.printStackTrace();
		}
		return con;
	}
	
	//글 조회
	public List<BoardDTO> list() {
	    List<BoardDTO> boardList = new ArrayList<BoardDTO>();
	    Connection con = getConnection();
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    String sql = "SELECT b_seq, b_title, b_content, b_name, b_logtime FROM board ORDER BY b_logtime DESC";
	    try {
	        pstmt = con.prepareStatement(sql);
	        rs = pstmt.executeQuery();
	        while (rs.next()) {
	            BoardDTO boardDTO = new BoardDTO();
	            boardDTO.setB_seq(rs.getInt("b_seq"));
	            boardDTO.setB_title(rs.getString("b_title"));
	            boardDTO.setB_content(rs.getString("b_content"));
	            boardDTO.setB_name(rs.getString("b_name"));
	            boardDTO.setB_logtime(rs.getDate("b_logtime"));
	            boardList.add(boardDTO);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        closeResources(rs, pstmt, con);
	    }
	    return boardList;
	}

	//글 등록
	public boolean write(String b_title,String b_content, String b_name) {
        String sql = "INSERT INTO board (b_seq, b_title, b_content, b_name, b_logtime) VALUES (board_seq.NEXTVAL, ?, ?, ?, SYSDATE)";
        try (Connection con = getConnection(); 
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, b_title);
            pstmt.setString(2, b_content);
            pstmt.setString(3, b_name);

            int result = pstmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
	
	//글 상세 조회
	public List<BoardDTO> view(int b_seq) {
	    List<BoardDTO> boardList = new ArrayList<BoardDTO>();
	    Connection con = getConnection();
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    String sql = "SELECT * FROM board WHERE B_SEQ = ? ORDER BY b_logtime DESC";
	    try {
	        pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, b_seq);
	        rs = pstmt.executeQuery();
	        
	        while (rs.next()) {
	            BoardDTO boardDTO = new BoardDTO();
	            boardDTO.setB_seq(rs.getInt("b_seq"));
	            boardDTO.setB_title(rs.getString("b_title"));
	            boardDTO.setB_content(rs.getString("b_content"));
	            boardDTO.setB_name(rs.getString("b_name"));
	            boardDTO.setB_logtime(rs.getDate("b_logtime"));
	            boardList.add(boardDTO);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        closeResources(rs, pstmt, con);
	    }
	    return boardList;
	}
	
}
