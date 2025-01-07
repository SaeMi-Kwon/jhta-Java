package jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * JDBC(Java DataBase Connectivity)
 * - JDBC수행단계
 * 1. 드라이버로딩
 * 2. DB 접속 및 connection객체 얻어오기
 * 3. 원하는 작업 구현(추가/수정/삭제/조회 등)
 * 4. DB 접속 해제
 * 
 */

class MyJDBC01{
	public MyJDBC01() {
		Connection con=null;  //DB연결 / DB해제/ 트랜잭션 처리
		Statement stmt=null;  //sql구문 실행하기 위한 객체
		try {
			//1.드라이버로딩
			Class.forName("oracle.jdbc.OracleDriver"); //다운받은 JDBC
			System.out.println("드라이버로딩 성공!");
			
			//2. DB 접속 및 connection객체 얻어오기
			String url="jdbc:oracle:thin:@localhost:1521:xe";   
			//jdbc:oracle:thin: 오라클 접속시, DB마다 다름.
			//xe -> sid (xe는 무료버전, 회사가면 회사버전으로 설정)
			String id="c##scott";
			String password="tiger";
			con=DriverManager.getConnection(url,id,password);
			System.out.println("DB접속 성공!");
			
			//3. 원하는 작업 구현(추가/수정/삭제/조회 등)
			stmt=con.createStatement();  //sql구문을 실행하기 위한 객체 얻어오기
//			String sql="insert into dept values(70,'개발부','강남')";   //오라클구문뒤에 ; 주의 || 자동 commit
//			stmt.executeUpdate(sql);  //sql구문 실행
//			System.out.println("요청작업 완료!"); 
			
//			String sql1="delete from dept where deptno=60";
//			stmt.executeUpdate(sql1);
//			System.out.println("부서 삭제 완료"); 
			
			//10번 부서의 위치를 서울로 변경해 보세요
			String sql2="update dept set loc='서울' where deptno=10";
			int n=stmt.executeUpdate(sql2);   //n에는 DML명령어가 적용된 행의 갯수가 반환(저장됨)
			System.out.println(n +"개의 부서위치 변경 완료");  
			
		} catch (ClassNotFoundException ce) {
			System.out.println("드라이버로딩 실패! ==> " + ce.getMessage());
		} catch (SQLException se) {
			System.out.println("에러==>" + se.getMessage());
		}finally {
			//4.DB 접속 해제 --> 꼭 해야함(finally절에서 해준다.)
			//해제할때는 생성된 순의 역순으로 close한다.
			try {
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();
			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}
		}
		
	}
}
public class Test01 {
	public static void main(String[] args) {
		new MyJDBC01();
	}

}
