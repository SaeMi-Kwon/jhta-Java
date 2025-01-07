package jdbc02;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//삭제할 회원번호를 파라미터로 전달받아 삭제하는 저장프로시져를 만들고
//자바프로그램에서 호출해 보세요

class JDBC04{
	public JDBC04() {
		Connection con=null;
		CallableStatement cstmt=null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("드라이버로딩 성공");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			con=DriverManager.getConnection(url,"c##scott","tiger");
			System.out.println("db접속성공");
			
			String sql="{call delmember(?)}";
			cstmt=con.prepareCall(sql);   
			cstmt.setInt(1, 3);
			cstmt.execute();   
			System.out.println("요청작업 완료");
			
		} catch (ClassNotFoundException ce) {
			System.out.println(ce.getMessage());
		
		} catch (SQLException s) {
			System.out.println(s.getMessage());
			
		}finally {
			try {
				if(cstmt!=null) cstmt.close();
				if(con!=null) con.close();
			} catch (SQLException s) {
				System.out.println(s.getMessage());
			}
		}

	}
}


public class Test04_Quiz {
	public static void main(String[] args) {
		new JDBC04();
	}
}
