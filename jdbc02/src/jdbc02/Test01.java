package jdbc02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * [ 트랜잭션 ]
 * 1. 트랜잭션 - 분리되어서는 안되는 연속적으로 수행되어야 할 작업의 묶음
 * 2. JDBC에서의 트랜잭션 처리
 * 	  - JDBC에서는 자동커밋이 기본으로 설정되어있다. 트랜잭션 처리는 Connection객체를 통해서 설정한다.
 * 	  - 방법
 * 	  	Connection con=DriverManger.getConnection(...);
 * 		con.setAutoCommit(false);
 * 		..  //DML작업
 * 		con.commit(); 또는 con.rollback();
 * 
 */

class JDBC01{
	public JDBC01() {
		Connection con=null;
		PreparedStatement pstmt=null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("드라이버로딩 성공");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			con=DriverManager.getConnection(url,"c##scott","tiger");
			con.setAutoCommit(false);   //자동커밋 해제
			
			System.out.println("db접속 성공==>" + con);
			
			//members 테이블에 데이터를 추가해 보세요.
			String sql="insert into members values(?,?,?,?,sysdate)";
			pstmt=con.prepareStatement(sql);
			
			pstmt.setInt(1, 5);
			pstmt.setString(2, "이길동");
			pstmt.setString(3, "010-111-1111");
			pstmt.setString(4, "대구");
			int n=pstmt.executeUpdate();  //DML동작
			
			pstmt.setInt(1, 6);
			pstmt.setString(2, "오길동");
			pstmt.setString(3, "010-222-2222");
			pstmt.setString(4, "인천");
			int n1=pstmt.executeUpdate();  //DML동작

			con.commit();  //커밋하기
			
			System.out.println(n + "명의 회원추가");
			System.out.println(n1 + "명의 회원추가");
	
		} catch (ClassNotFoundException ce) {
			System.out.println(ce.getMessage());
			
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			try {
				con.rollback();  //롤백하기
			} catch (SQLException s) {
				System.out.println(s.getMessage());
			} 
			
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException s) {
				System.out.println(s.getMessage());
			}
		}
	}
}

public class Test01 {
	public static void main(String[] args) {
		new JDBC01();
	}
}
