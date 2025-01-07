package jdbc01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.connector.OracleConnectionManager;

/*
 * emp테이블과 연동해서 CRUD(Create,Read,Update,Delete)작업을 구현해 보세요.
 * hiredate -> rs.getString("regdate");
 */

class MyJDBC03{
	public MyJDBC03() {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;

		try {
			//드라이버로딩
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("드라이버로딩 성공!");
			
			//Connection객체 얻어오기
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			con=DriverManager.getConnection(url,"c##scott","tiger");
			System.out.println("DB접속 성공!");
			
			//Statement객체 얻어오기
			stmt=con.createStatement();
			
			//sql작성
			//String insql="insert into emp(empno,ename,job,sal,deptno) values(2001,'홍씨','인사부',1400,61)";
			String readsql="select * from emp";
			//String upsql="update emp set sal=1800 where empno=2001";
			//String delsql="delete from emp where empno=2001";
			
			//stmt.executeUpdate(insql);
			rs=stmt.executeQuery(readsql);
			//stmt.executeUpdate(upsql);
			//stmt.executeUpdate(delsql);
			
			while(rs.next()) {
				int empno=rs.getInt("empno");
				String ename=rs.getString("ename");
				String job=rs.getString("job");
				int mgr=rs.getInt("mgr");
				//String hiredate=rs.getString("hiredate");
				Date hiredate=rs.getDate("hiredate");
				int sal=rs.getInt("sal");
				int comm=rs.getInt("comm");
				int deptno=rs.getInt("deptno");
				
				System.out.println(empno+' '+ename+' '+job+' '+mgr+' '+
						hiredate+' '+sal+' '+comm+' '+deptno);
			}
			
			
			
			
		} catch (ClassNotFoundException ce) {
			System.out.println(ce.getMessage());
		
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			
		}finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();
					
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
}



public class Test03_Quiz {
	public static void main(String[] args) {
		new MyJDBC03();
	}
}
