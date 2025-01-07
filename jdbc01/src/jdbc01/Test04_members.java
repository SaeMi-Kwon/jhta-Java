package jdbc01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class MyJDBC04{
	Connection con=null;
	Statement stmt=null;
	Scanner scan=new Scanner(System.in);
	
	public MyJDBC04() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("드라이버로딩 성공!");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			con=DriverManager.getConnection(url,"c##scott","tiger");
			System.out.println("db접속 성공!");
			
			stmt=con.createStatement();
			
		} catch (ClassNotFoundException ce) {
			System.out.println(ce.getMessage());
			
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}
	
	public void disconnect() {  //db연결해제
		try {
			if(stmt!=null) stmt.close();
			if(con!=null) con.close();
			
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}
	
	public void insert() throws SQLException {
		System.out.println("회원번호입력");
		int num=scan.nextInt();
		System.out.println("회원이름입력");
		String name=scan.next();
		System.out.println("전화번호입력");
		String phone=scan.next();
		System.out.println("주소입력");
		String addr=scan.next();
		
		String sql="insert into members values("+num+",'"+name+"','"+phone + "','" +addr+"',sysdate)";
		int n=stmt.executeUpdate(sql);
		System.out.println(n+"명의 회원등록!");
	}
	
	public void selectAll() throws SQLException {
		ResultSet rs=null;
		
		try {
			String sql="select * from members";
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String phone=rs.getString("phone");
				String addr=rs.getString("addr");
				Date regdate=rs.getDate("regdate");  //java.sql.Date
				
				System.out.println("회원번호:" + num);
				System.out.println("이름:" + name);
				System.out.println("전화번호:" + phone);
				System.out.println("주소:" + addr);
				System.out.println("가입일:" + regdate);
				System.out.println("--------------------------");		
			}
			
		}finally {
			rs.close();
		}
	}
	
	
	//삭제할 회원번호를 입력받아 해당 회원을 삭제해 보세요.
	public void delete() throws SQLException {
		System.out.println("삭제할 회원번호를 입력");
		int num=scan.nextInt();
		
		String sql="delete from members where num="+ num;
		
		int n=stmt.executeUpdate(sql);
		System.out.println(n+"명의 회원삭제!");
	}
	
	
	//회원번호를 입력받아 임의의 정보로 수정해보세요(전화번호,주소)
	public void update() throws SQLException {
		System.out.println("수정할 회원번호 입력");
		int num=scan.nextInt();
		
		System.out.println("변경할 전화번호 입력");
		String phone=scan.next();
		System.out.println("변경할 주소 입력");
		String addr=scan.next();
		
		String sql="update members set phone='"+ phone +"', addr='"+ addr +"' where num=" + num;
		int n=stmt.executeUpdate(sql);
		System.out.println(n+"명의 회원정보 수정!");
	}
	
	
	//회원번호를 입력받아 해당 회원의 모든 정보를 출력해 보세요.
	public void find() throws SQLException {
		ResultSet rs=null;
		
		try {
			System.out.println("조회할 회원번호 입력");
			int num1=scan.nextInt();
			
			String sql="select * from members where num=" + num1;
			rs=stmt.executeQuery(sql);
			
			if(rs.next()) {
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String phone=rs.getString("phone");
				String addr=rs.getString("addr");
				Date regdate=rs.getDate("regdate");
				
				System.out.println("[검색된 회원정보]");
				System.out.println("회원번호:" + num);
				System.out.println("이름:" + name);
				System.out.println("전화번호:" + phone);
				System.out.println("주소:" + addr);
				System.out.println("가입일:" + regdate);
			}else {
				System.out.println("조회된 회원이 없습니다.");
			}
			
		}finally {
			if(rs!=null) rs.close();
		}
		
	}
}
public class Test04_members {
	public static void main(String[] args) {
		MyJDBC04 mm=new MyJDBC04();
		try {
		//mm.insert();
		//mm.selectAll();
		//mm.delete();
		//mm.update();
		mm.find();
		
		}catch(SQLException se) {
			System.out.println(se.getMessage());
		}
		mm.disconnect();
	}
}
