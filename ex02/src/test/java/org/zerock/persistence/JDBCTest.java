package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTest {

	@Test
	public void testConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
					"book_ex", "book_ex");
			log.info("jdbc 연결 성공");
			
		} catch (Exception e) {
			e.printStackTrace();
			fail("오류");						
		}
	}
}
