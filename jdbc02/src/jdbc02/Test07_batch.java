package jdbc02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.UUID;

import db.JDBCUtil;

/*
 * [ 배치프로그램(일괄처리) ]
 * - 많은 sql구문(DML구문)을 한번에 실행
 * - 대용량 업데이트시 속도 향상을 위해 BATCH를 사용한다.
 * 
 *  PreparedStatement pstmt= ...
 * 
 *  pstmt.addBatch();  //배치에 실행할 sql구문 담기
 *  ..
 *  pstmt.executeBatch();  //저장된 sql문을 한꺼번에 실행하기
 *  pstmt.clearBatch();  //배치 초기화 하기
 * 
 */

class JDBC07{
	Connection con=null;
	PreparedStatement pstmt=null;
		
	public JDBC07() {
		try {
			con=JDBCUtil.getCon();
			con.setAutoCommit(false);
			String sql="insert into batchtest values(?,?,?)";
			pstmt=con.prepareStatement(sql);
			Random rnd=new Random();
				
			for(int i=1;i<=100000;i++) {
				long uid=System.currentTimeMillis()+i;
				String name="홍길동"+i;
				int age=rnd.nextInt(80)+20;
					
				pstmt.setLong(1, uid);
				pstmt.setString(2, name);
				pstmt.setInt(3, age);
				
				//pstmt.executeUpdate();
				//con.commit();
				
				pstmt.addBatch();  //수행할 sql구문 배치에 담기
				if(i%10000==0) {
					pstmt.executeBatch();  //저장된 sql구문을 한꺼번에 실행
					pstmt.clearBatch();  //배치 초기화 하기
					con.commit();
				}
				
				
			}
			System.out.println("작업완료!!");

		}catch(SQLException s) {
			System.out.println(s.getMessage());
		}finally {
			JDBCUtil.close(con,pstmt,null);
		}
		
	}
}

public class Test07_batch {
	public static void main(String[] args) {
		new JDBC07();
	}
}
