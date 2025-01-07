package jdbc02;

import java.sql.Statement;

import db.JDBCUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/*
 * [ ResultSetMetaData ]
 * - 조회된 테이블에 대한 정보(컬럼명,컬럼갯수,컬럼타입,...)를 갖는 클래스
 */

class JDBC06{
	public JDBC06() {
		Connection con=null;;
		Statement stmt=null;
		ResultSet rs=null;
		ResultSetMetaData rsmd=null;   //close 해줄 필요없다.

		try {
			con=JDBCUtil.getCon();
			stmt=con.createStatement();
			String sql="select * from members";
			rs=stmt.executeQuery(sql);
			
			rsmd=rs.getMetaData();  //테이블에 대한 정보를 갖는 객체 얻어오기
			
			for(int i=1;i<=rsmd.getColumnCount();i++) {  //컬럼의 갯수만큼 반복(오라클은 1부터 시작)
				String colName=rsmd.getColumnName(i);  //1번째 컬럼명 얻어오기
				System.out.printf("%-15s",colName);  //왼쪽부터 15자리
			}
			System.out.println();
			
			for(int i=1;i<=rsmd.getColumnCount();i++) {
				String colType=rsmd.getColumnTypeName(i);
				System.out.printf("%-15s",colType);
			}
			System.out.println();
			System.out.println("---------------------------------------");
			
			//전체 결과 출력하고 db연결 해제하기
			while(rs.next()) {
				int num=rs.getInt("num"); //rs.getInt(1); 1번째 컬럼값 얻어오기 => 권장하지않음
				String name=rs.getString("name");  //rs.getInt(2); 2번째 컬럼값 얻어오기
				String phone=rs.getString("phone");
				String addr=rs.getString("addr");
				Date regdate=rs.getDate("regdate");
				
				System.out.printf("%-15d %-15s %-15s %-15s %-15s \n",num,name,phone,addr,regdate);
			}
			
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			
		} finally {
			JDBCUtil.close(con,stmt,rs);
		}	
	}
}

public class Test06 {
	public static void main(String[] args) {
		new JDBC06();
	}
}
