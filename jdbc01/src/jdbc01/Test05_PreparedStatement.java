package jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * [ PreparedStaement ]
 * - Statement를 상속받은 인터페이스로 sql구문을 실행하는 기능의 객체
 * 
 * - 사용방법
 * 	 sql문장에 변수가 들어갈 부분을 ?로 지정하고 대응되는 값을 setXXX메소드로 설정한다.
 * 
 * - 특징
 *   1. Statement는 실행시에 sql명령어를 지정해서 sql구문을 실행한다.
 *      ->하나의 Statement로 여러 sql문장을 실행가능하다-> 보안이 약함    
 *   2. PreparedStatement는 객체 생성시에 지정된 하나의 sql구문만을 실행할 수 있다.(컴파일시에 실행할 sql문장이 지정됨)
 *      ->보안이 좋음
 * 
 */

class MyJDBC05{
	public MyJDBC05() {
		Connection con=null;
		PreparedStatement pstmt1=null;  //sql구문을 실행하기 위한 객체
		PreparedStatement pstmt2=null;
		PreparedStatement pstmt3=null;
		
		try {
			//1. 드라이버로딩
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("드라이버로딩 성공!");
			
			//2. DB 접속 및 connection객체 얻어오기
			String url="jdbc:oracle:thin:@localhost:1521:xe";   
			String id="c##scott";
			String password="tiger";
			con=DriverManager.getConnection(url,id,password);
			System.out.println("DB접속 성공!");
			
//			int num=4;
//			String name="김디비";
//			String phone="010-123-4567";
//			String addr="구로";
//			
//			String sql="insert into members values(?,?,?,?,sysdate)";
//			pstmt1=con.prepareStatement(sql);  //sql구문을 실행하기 위한 객체 얻어오기
//			
//			pstmt1.setInt(1, num);    //setInt(1, num); 1번째 ?에 변수num의 값
//			pstmt1.setString(2, name);
//			pstmt1.setString(3, phone);
//			pstmt1.setString(4, addr);
//			
//			int n=pstmt1.executeUpdate();
//			System.out.println(n+ "명의 회원 추가 완료!");
//			
//			
//			String sql1="delete from members where num=?";
//			pstmt2=con.prepareStatement(sql1); 
//			pstmt2.setInt(1, 3);  //1번째 ?의 위치에 3을 넣기
//			int n2=pstmt2.executeUpdate();
//			System.out.println(n2 + "명의 회원삭제 완료!");
			
			
			//회원수정 기능 -> 회원이름,전화,주소 수정하기
			String sql2="update members set name=?,phone=?,addr=? where num=?";
			pstmt3=con.prepareStatement(sql2);
			pstmt3.setString(1,"김자바");
			pstmt3.setString(2,"010-1122-3344");
			pstmt3.setString(3,"강남");
			pstmt3.setInt(4,4);
			
			int n=pstmt3.executeUpdate();
			System.out.println(n + "명의 회원정보 수정 완료");
			
			
		} catch (ClassNotFoundException ce) {
			System.out.println(ce.getMessage());
			
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		
		}finally {
			try {
				if(pstmt3!=null) pstmt3.close();
				if(pstmt2!=null) pstmt2.close();
				if(pstmt1!=null) pstmt1.close();
				if(con!=null) con.close();
				
			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}
			
		}
	}

}
public class Test05_PreparedStatement {
	public static void main(String[] args) {
		new MyJDBC05();
	}
}
