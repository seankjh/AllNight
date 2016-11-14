package edu.spring.ex02;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


// root-context.xml에서 선언한 DataSource 빈(bean)이 생성되었는지 테스트
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class TestDataSource {
	public static final Logger logger = LoggerFactory.getLogger(TestDataSource.class);
	
	//  DataSource 빈을 주입받음
	// -> root-context.xml에서 선언한 OracleDataSource 객체를 주입함
	@Autowired // ▲ 중요!! 
	   // : DI(Dependency Injection: 의존성 주입) 사용 
	private DataSource ds; // 데이터 소스를 주입해주세요
	// = private DataSource ds = new OracleDataSource();
	// 자기가 가지고 있는 빈들의 목록을 뒤져서 그 데이터소스나 데이터소스를 상속받고있는걸 찾아서 그 객체를 넣는다.
		
	@Test
	public void testDataSource() {
		logger.info("Oracle Data Source: " + ds);
		Connection conn = null;
		try {
			conn = ds.getConnection();
			logger.info("커넥션 풀을 이용한 DB 접속 성공!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("DB접속 실패");
		} finally {
			try {
				if (conn != null) {
				conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
} // end class TestDataSource
