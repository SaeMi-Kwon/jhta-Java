package quiz;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/*
 * 회원아이디/비밀번호/이메일/전화번호/가입일에 대한 정보를 갖는 테이블을 생성하고 
 * 아래와 같은 기능을 갖는 프로그램을 완성해 보세요.
 * 
 * 1.회원가입 2.회원조회 3.회원수정 4.회원삭제 5.전체조회
 * - 회원가입시 아이디 중복체크를 하세요.
 */

class MyJDBC01{
	Connection con =null;
	Scanner scan=new Scanner(System.in);
			
	public MyJDBC01() {
		try {
			//드라이버로딩
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("드라이버로딩 성공");
			
			//Connection 객체 얻어오기
			String url="jdbc:oracle:thin:@localhost:1521:xe";
	
			con=DriverManager.getConnection(url,"c##scott","tiger");
			System.out.println("db접속 성공");
			
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
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			System.out.println("아이디입력");
			String id=scan.next();
			
			//아이디 중복 체크
			String sqlCheck="select id from member where id = ?";
			pstmt1=con.prepareStatement(sqlCheck);
			pstmt1.setString(1, id);
			rs=pstmt1.executeQuery();
			
			if(rs.next()) {
				System.out.println("이미 존재하는 아이디입니다.");
				return;	
			}
			
			System.out.println("비밀번호입력");
			String pwd=scan.next();
			System.out.println("이메일입력");
			String email=scan.next();
			System.out.println("전화번호입력");
			String phone=scan.next();

			String sql="insert into member values(?,?,?,?,sysdate)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, email);
			pstmt.setString(4, phone);
			
			int n=pstmt.executeUpdate();
			System.out.println(n + "명의 회원추가");

		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(pstmt1!=null) pstmt.close();
			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}
		}
		
	}
	
	public void findId() throws SQLException {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			System.out.println("조회할 아이디입력");
			String findid=scan.next();
			
			String sql="select * from member where id like '%'||?||'%'";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, findid);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				String id=rs.getString("id");
				String pwd=rs.getString("pwd");
				String email=rs.getString("email");
				String phone=rs.getString("phone");
				String regdate=rs.getString("regdate");
	
				System.out.println("[검색된 회원정보]");
				System.out.println("아이디:" + id);
				System.out.println("비밀번호:" + pwd);
				System.out.println("이메일:" + email);
				System.out.println("전화번호:" + phone);
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
	
	public void update() throws SQLException {
		PreparedStatement pstmt=null;
		
		try {
			System.out.println("수정할 아이디입력");
			String id=scan.next();
			System.out.println("비밀번호 변경");
			String pwd=scan.next();
			System.out.println("이메일 변경");
			String email=scan.next();
			System.out.println("전화번호 변경");
			String phone=scan.next();
			
			String sql="update member set pwd=?,email=?,phone=? where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, pwd);
			pstmt.setString(2, email);
			pstmt.setString(3, phone);
			pstmt.setString(4, id);
			
			int n=pstmt.executeUpdate();
			System.out.println(n + "명의 회원정보 수정");
			
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}
	
	public void delete() throws SQLException {
		PreparedStatement pstmt=null;
		
		try {
			System.out.println("삭제할 아이디 입력");
			String id=scan.next();
			
			String sql="delete from member where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			
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
	
	public void findAll() throws SQLException {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			String sql="select * from member";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
		
			while (rs.next()) {
				String id=rs.getString("id");
				String pwd=rs.getString("pwd");
				String email=rs.getString("email");
				String phone=rs.getString("phone");
				Date regdate=rs.getDate("regdate");
				
				System.out.println("아이디:" + id);
				System.out.println("비밀번호:" + pwd);
				System.out.println("이메일:" + email);
				System.out.println("전화번호:" + phone);
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
}


public class Test01 {
	public static void main(String[] args) {
		MyJDBC01 db=new MyJDBC01();
		Scanner scanner=new Scanner(System.in);
		
		try {
			while(true) {
				System.out.println("1.회원가입 2.회원조회 3.회원수정 4.회원삭제 5.전체조회 6.종료");
				int num=scanner.nextInt();
				if(num==1) {
					db.insert();
				}else if(num==2) {
					db.findId();
				}else if(num==3) {
					db.update();
				}else if(num==4) {
					db.delete();
				}else if(num==5) {
					db.findAll();
				}else if(num==6) {
					System.out.println("프로그램종료");
					System.exit(0);
				}else {
					System.out.println("다시 입력해주세요.");
				}
			}			
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		
		db.disconnect();
	}

}
