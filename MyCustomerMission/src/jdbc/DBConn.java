package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConn {

	public static void main(String[] args) {
		final String driver = "org.mariadb.jdbc.Driver";
		final String DB_IP = "localhost";
		final String DB_PORT = "3306";
		final String DB_NAME = "boot_db";
		final String DB_URL = 
				"jdbc:mariadb://" + DB_IP + ":" + DB_PORT + "/" + DB_NAME;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			//1.Driver Class Loading
			Class.forName(driver);
			System.out.println("DB_URL = " + DB_URL);
			//2. DB와의 연결을 담당하는 Connection 객체 생성
			conn = DriverManager.getConnection(DB_URL, "boot", "boot");
			System.out.println("Connection ClassName ="+ conn.getClass().getName());
			if (conn != null) {
				System.out.println("DB 접속 성공");
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB 접속 실패");
			e.printStackTrace();
		}

		try {
			String sql = "select * from customer where cname=?";
			pstmt = conn.prepareStatement(sql);
			System.out.println("Statement ClassName :"+pstmt.getClass().getName());
			pstmt.setString(1, "dooly");
			rs = pstmt.executeQuery();
			System.out.println("ResultSet ClassName :"+ rs.getClass().getName());
			String cid = null;
			String cname = null;
			String cemail = null;
			String cage = null;
			String centrydate = null;
			
//			System.out.println(rs.next()); 커서를 이동한 그 다음꺼만 나옴/ true까지만 나옴
			while (rs.next()) {
				//해당 컬럼의 값을 가져오기
				cid = rs.getString("cname"); 
				cname = rs.getString("cname");
				cemail = rs.getString("cemail");
				cage = rs.getString("cage");
				centrydate = rs.getString("centrydate");
				
				System.out.print(cid);
				System.out.print(cname);
				System.out.print(cemail);
				System.out.print(cage);
				System.out.print(centrydate);
				System.out.println();
			}

		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}