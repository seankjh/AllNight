package edu.spring.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import oracle.jdbc.OracleDriver;

public class TestOracleJDBC {
	public static final Logger	logger = LoggerFactory.getLogger(TestOracleJDBC.class);
	
	@Test
	public void testOracleJDBC() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 1. JDBC 드라이버 로드
			DriverManager.registerDriver(new OracleDriver());
			// 2. JDBC 드라이버를 사용해서 Connection 맺음
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String password = "tiger";
			conn = DriverManager.getConnection(url, user, password);
			
			logger.info("conn: " + conn);
			// 3. Statement 준비
			String sql = "Select userid from tbl_member";
			pstmt = conn.prepareStatement(sql);
			
			// 4. Statement 실행
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String userid = rs.getString(1);
				logger.info(userid);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("connection 실패!");
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}		
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} // end testOracleJDBC()
	
} // end class TestOracleJDBC









