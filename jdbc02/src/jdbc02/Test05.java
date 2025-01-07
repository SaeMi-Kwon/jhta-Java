package jdbc02;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

import db.JDBCUtil;

class JDBC05{
	public JDBC05() {
		Connection con=null;
		Statement stmt=null;
		try {
			con=JDBCUtil.getCon();
			String sql="create table mytest(num number(5) primary key,name varchar2(20))";
			stmt=con.createStatement();
			stmt.execute(sql);
			System.out.println("요청작업 완료");
			
		} catch (SQLException s) {
			System.out.println(s.getMessage());
			
		}finally {
			JDBCUtil.close(con,stmt,null);
		}
	}
}

public class Test05 {
	public static void main(String[] args) {
		new JDBC05();
	}
}
