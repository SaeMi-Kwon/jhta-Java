package jdbc01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

class MyJDBC06{
	Connection con=null;
	Scanner scan=new Scanner(System.in);
	
	public MyJDBC06() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("드라이버로딩 성공!");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			con=DriverManager.getConnection(url,"c##scott","tiger");
			System.out.println("db접속 성공!");
			
		} catch (ClassNotFoundException ce) {
			System.out.println(ce.getMessage());
			
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}
	
	public void disconnect() {  //db연결해제
		try {
			if(con!=null) con.close();	
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}
	
	public void insert() throws SQLException {
		PreparedStatement pstmt=null;
		
		try {
			System.out.println("회원번호입력");
			int num=scan.nextInt();
			System.out.println("이름입력");
			String name=scan.next();
			System.out.println("전화번호입력");
			String phone=scan.next();
			System.out.println("주소입력");
			String addr=scan.next();
			
			String sql="insert into members values(?,?,?,?,sysdate)";
			pstmt=con.prepareStatement(sql);
			
			pstmt.setInt(1,num);
			pstmt.setString(2,name);
			pstmt.setString(3,phone);
			pstmt.setString(4,addr);
			
			int n=pstmt.executeUpdate();
			System.out.println(n+ "명의 회원추가 성공");
		
		}finally {
			try {
				if(pstmt!=null) pstmt.close();	
			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}
	
	public void selectAll() throws SQLException {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			String sql="select * from members";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
		
			while (rs.next()) {
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String phone=rs.getString("phone");
				String addr=rs.getString("addr");
				Date regdate=rs.getDate("regdate");
				
				System.out.println("회원번호:" + num);
				System.out.println("이름:" + name);
				System.out.println("전화번호:" + phone);
				System.out.println("주소:" + addr);
				System.out.println("가입일:" + regdate);
				System.out.println("--------------------------");
			}
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();		
			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}
	
	public void delete() throws SQLException {
		PreparedStatement pstmt=null;
		
		try {
			System.out.println("삭제할 회원번호 입력");
			int num=scan.nextInt();
			
			String sql="delete from members where num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			int n=pstmt.executeUpdate();
			System.out.println(n + "명의 회원정보 삭제");
		
		}finally {
			try {
				if(pstmt!=null) pstmt.close();	
			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}
	
	public void update() throws SQLException {
		PreparedStatement pstmt=null;
		
		try {
			System.out.println("수정할 회원번호입력");
			int num=scan.nextInt();
			System.out.println("변경할 이름입력");
			String name=scan.next();
			System.out.println("변경할 전화번호입력");
			String phone=scan.next();
			System.out.println("변경할 주소입력");
			String addr=scan.next();
			
			String sql="update members set name=?,phone=?,addr=? where num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			pstmt.setString(3, addr);
			pstmt.setInt(4, num);
			
			int n=pstmt.executeUpdate();
			System.out.println(n + "명의 회원정보 수정완료");
			
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}
	
	//회원번호로 회원조회하기
	public void findNum() throws SQLException {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			System.out.println("조회할 회원번호 입력");
			int findNum=scan.nextInt();

			String sql="select * from members where num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, findNum);
			rs=pstmt.executeQuery();
		
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
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}
	
	//이름으로 회원조회하기
	public void findName() throws SQLException {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
			
		try {
			System.out.println("조회할 이름 입력");
			String findName=scan.next();

			String sql="select * from members where name like '%'||?||'%'";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, findName);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
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
			}
			
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}

}

public class Test06_members {
	public static void main(String[] args) {
		MyJDBC06 db=new MyJDBC06();
		
		try {
			//db.insert();
			//db.selectAll();
			//db.delete();
			//db.update();
			//db.findNum();	
			db.findName();
			
		}catch(SQLException se) {
			System.out.println(se.getMessage());
		}
		
		db.disconnect();
	}
}
