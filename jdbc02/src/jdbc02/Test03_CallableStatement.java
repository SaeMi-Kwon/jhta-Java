package jdbc02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//CallableStatement : 저장프로시져를 호출하는 기능을 갖는 객체
// {call <procedure-name>[(<arg1>,<arg2>,...)]}
/*
 * PROCEDURE addmember(num number,name VARCHAR2,phone VARCHAR2,addr VARCHAR2)
 * IS
 * BEGIN
 * INSERT INTO MEMBERS VALUES(num,name,phone,addr,sysdate);
 * COMMIT;
 * END;
 * /
 * 
 */

class JDBC03{
	public JDBC03() {
		Connection con=null;
		CallableStatement cstmt=null;
		Properties props=new Properties(); //database.properties에서 설정정보를 읽어오기 위한 객체 생성
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("드라이버로딩 성공");

			props.load(new FileReader("database.properties"));

			String url=props.getProperty("url");
			
			String user=props.getProperty("user");
			String pwd=props.getProperty("password");
			
			con=DriverManager.getConnection(url,user,pwd);
			System.out.println("db접속성공");
			
			String sql="{call addmember(?,?,?,?)}";
			cstmt=con.prepareCall(sql);   //저장프로시져를 호출하기 위한 CallableStatement객체 얻어오기
			cstmt.setInt(1, 3);
			cstmt.setString(2, "이영희");
			cstmt.setString(3, "010-123-4567");
			cstmt.setString(4, "대구");
			cstmt.execute();  //프로시져 수행하기
			System.out.println("요청작업 완료");
			
		} catch (ClassNotFoundException ce) {
			System.out.println(ce.getMessage());
		} catch (IOException ie) {
			System.out.println(ie.getMessage());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
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

public class Test03_CallableStatement {
	public static void main(String[] args) {
		new JDBC03();
	}
}
