package jdbc02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

class JDBC02{
	Connection con=null;
	Scanner scan=new Scanner(System.in);
	public JDBC02() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("드라이버로딩 성공");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			con=DriverManager.getConnection(url,"c##scott","tiger");
			con.setAutoCommit(false);   //자동커밋 해제
			System.out.println("db접속 성공");
			
			
		} catch (ClassNotFoundException ce) {
			System.out.println(ce.getMessage());
		} catch (SQLException s) {
			System.out.println(s.getMessage());
		}
	}
	
	public void close() {
		try {
			if(con!=null) con.close();
		} catch (SQLException s) {
				System.out.println(s.getMessage());
		}
	}
	
	//회원가입 - members테이블에 추가/ points테이블에 추가
	public void insert() {
			PreparedStatement pstmt1=null;
			PreparedStatement pstmt2=null;
			
		try {	
			System.out.println("회원번호 입력");
			int n=scan.nextInt();
			System.out.println("회원이름 입력");
			String name=scan.next();
			System.out.println("전화번호 입력");
			String phone=scan.next();
			System.out.println("주소 입력");
			String addr=scan.next();
			System.out.println("적립금 입력");
			int p=scan.nextInt();
			
			String sql1="insert into members values(?,?,?,?,sysdate)";
			pstmt1=con.prepareStatement(sql1);
			pstmt1.setInt(1, n);
			pstmt1.setString(2, name);
			pstmt1.setString(3, phone);
			pstmt1.setString(4, addr);
			pstmt1.executeUpdate();   //members테이블에 회원추가
			
			String sq12="insert into point values(point_seq.nextval,?,?)";
			pstmt2=con.prepareStatement(sq12);
			pstmt2.setInt(1, n);
			pstmt2.setInt(2, p);
			pstmt2.executeUpdate();   //point테이블에 추가
			
			con.commit();   //커밋하기
			System.out.println("회원가입완료");
			
		}catch(SQLException s) {
			System.out.println("오류발생==>" + s.getMessage());
			try {
				con.rollback();  //작업취소
			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}
	
	//회원삭제
	public void delete() {
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		
		System.out.println("삭제할 회원번호 입력");
		int n=scan.nextInt();
		
		try {	
			//자식테이블먼저 삭제
			String sql1="delete from point where num=?";
			pstmt1=con.prepareStatement(sql1);
			pstmt1.setInt(1, n);
			pstmt1.executeUpdate();
			
			String sql2="delete from members where num=?";
			pstmt2=con.prepareStatement(sql2);
			pstmt2.setInt(1, n);
			pstmt2.executeUpdate();
			
			con.commit();
			System.out.println("회원삭제 완료");
			
		} catch (SQLException s) {
			System.out.println(s.getMessage());
			try {
				con.rollback();
			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}
			
		} finally {
			try {
				if(pstmt2!=null) pstmt2.close();
				if(pstmt1!=null) pstmt1.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());	
			}
			
		}
		
	}
	
	//회원번호를 입력받아 회원의 정보와 적립금 정보를 조회해 출력해 보세요.
	public void find() {
		PreparedStatement pstmt1=null;
		ResultSet rs=null;
		
		System.out.println("조회할 회원번호입력");
		int n=scan.nextInt();
		
		try {
			String sql1="select m.num,name,phone,addr,nvl(mpoint,0) mpoint,regdate "
					+ "from members m left join point p "
					+ "on m.num=p.num "
					+ "where m.num=?";
			pstmt1=con.prepareStatement(sql1);
			pstmt1.setInt(1, n);
			rs=pstmt1.executeQuery();
			
			if(rs.next()) {
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String phone=rs.getString("phone");
				String addr=rs.getString("addr");
				int mpoint=rs.getInt("mpoint");
				Date regdate=rs.getDate("regdate");
				
				System.out.println("[조회 결과]");
				System.out.println("회원번호:" + num);
				System.out.println("이름:" + name);
				System.out.println("전화번호:" + phone);
				System.out.println("주소:" + addr);
				System.out.println("포인트:" + mpoint);
				System.out.println("가입일:" + regdate);
			}
		
		} catch(SQLException s) {
			System.out.println(s.getMessage());
			
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt1!=null) pstmt1.close();
			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}
		}
		
	}

	
}


public class Test02 {
	public static void main(String[] args) {
		JDBC02 db=new JDBC02();
		//db.insert();
		//db.delete();
		db.find();
		
		
		db.close();
	}
}
