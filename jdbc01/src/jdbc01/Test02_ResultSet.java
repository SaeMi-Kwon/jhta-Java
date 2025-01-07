package jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class MyJDBC02{
	public MyJDBC02() {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;   //커서와 비슷
		
		try {
			//드라이버로딩
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("드라이버로딩 성공!");
		
			//Connection객체 얻어오기
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			con=DriverManager.getConnection(url,"c##scott","tiger");
			System.out.println("db접속 성공!");
			
			//sql구문을 실행하기 위한 Statement객체 얻어오기
			stmt=con.createStatement();
		
			//원하는 작업 구현
			String sql="select * from dept";
			
			//select 구문을 실행할때는 exexuteQuery메소드를 사용한다 -> 
			//ResultSet객체를 통해서 조회된 컬럼값들을 얻어온다.
			rs=stmt.executeQuery(sql);
			
			//하나의 행만 조회하려고 해도 무조건 rs.next(); 를 작성해줘야한다.
			while(rs.next()) {  //다음 레코드(행)가 존재하면 true
				int deptno=rs.getInt("deptno");   //현재행의 deptno컬럼값 얻어오기
				String dname=rs.getString("dname");  //현재행의 dname컬럼값 얻어오기
				String loc=rs.getString("loc");   //현재행의 loc컬럼값 얻어오기
				System.out.println(deptno + "," + dname + "," + loc);
			}
		
		} catch (ClassNotFoundException ce) {
			System.out.println("드라이버로딩실패..." + ce.getMessage());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}finally {
			//DB접속 해제
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();
			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}
		}

	}
}

public class Test02_ResultSet {
	public static void main(String[] args) {
		new MyJDBC02();
	}
}
