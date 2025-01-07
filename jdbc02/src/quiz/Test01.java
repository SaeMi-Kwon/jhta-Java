package quiz;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

import db.JDBCUtil;

/*
 * 1. << 구매테이블 >>
 * 구매번호(PK),구매자아이디,상품명,가격,수량,구매일
 * create table purchase(
 * 		num number(5) primary key,
 *		id varchar2(15), 
 *		item varchar2(10),
 *		price number(10),
 *		amount number(10),
 *		buydate date
 * );
 * 
 * create sequence purchase_seq;
 * 
 * << 결제테이블 >>
 * 결제번호(PK), 구매번호(FK), 결제금액, 결제수단
 * create table payment(
 *		pnum number(5) primary key,
 *		num number(5) references purchase(num),
 *		pay number(10),
 *		pmethod varchar2(15)
 * );
 * 
 * create sequence payment_seq;
 * 
 * 위의 정보를 갖는 테이블을 만들고 구매기능을 구현해 보세요.(PreparedStatement를 사용합니다.)
 * [실행결과]
 * 1. 제품구매  2.구매정보수정 3.구매정보조회  4.구매취소 
 * ..
 * 제품구매:구매자아이디,상품명,가격,수량,결제수단 입력 받아서 저장
 * 구매정보조회:전체구매정보 조회
 * 구매정보수정:상품명,가격,수량,결제금액,결제수단을 변경합니다.
 * 구매취소:구매정보와 결제정보가 모두 삭제됩니다.
 * 
 * 트랜잭션 처리가 가능하도록 만들어 보세요
 */

class JDBC01{
	Connection con=null;
	Scanner scan=new Scanner(System.in);

	public JDBC01(){
		try {
			con=JDBCUtil.getCon();
			con.setAutoCommit(false);

		} catch (SQLException s) {
			System.out.println(s.getMessage());
		}
	}
	
	public void insert() { //제품구매:구매자아이디,상품명,가격,수량,결제수단 입력 받아서 저장
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		
		try {
			System.out.println("구매자아이디입력");
			String id=scan.next();
			
			System.out.println("상품명입력");
			String item=scan.next();
			System.out.println("가격입력");
			int price=scan.nextInt();
			System.out.println("수량입력");
			int amount=scan.nextInt();
			System.out.println("결제수단입력");
			String pmethod=scan.next();
			int pay=price*amount;  //결제금액

			String sql1="insert into purchase values(purchase_seq.nextval,?,?,?,?,sysdate)";
			pstmt1=con.prepareStatement(sql1);
			pstmt1.setString(1, id);
			pstmt1.setString(2, item);
			pstmt1.setInt(3, price);
			pstmt1.setInt(4, amount);
			pstmt1.executeUpdate();
			
			String sql2="insert into payment values(payment_seq.nextval,purchase_seq.currval,?,?)";
			pstmt2=con.prepareStatement(sql2);
			pstmt2.setInt(1, pay);
			pstmt2.setString(2, pmethod);
			pstmt2.executeUpdate();
			
			con.commit();
			System.out.println("추가완료");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}
			
		}finally {	
			JDBCUtil.close(con, pstmt1, null); 
			JDBCUtil.close(pstmt2);	
		}
	}
	
	public void update() { //구매정보수정:상품명,가격,수량,결제금액,결제수단을 변경합니다.
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		
		try {
			System.out.println("수정할 구매번호입력");
			int num=scan.nextInt();
			
			System.out.println("상품명 변경");
			String item=scan.next();
			System.out.println("가격 변경");
			int price=scan.nextInt();
			System.out.println("수량 변경");
			int amount=scan.nextInt();
			System.out.println("결제수단 변경");
			String pmethod=scan.next();
			int pay=price*amount;  //결제금액

			String sql1="update purchase set item=?,price=?,amount=? where num=?";
			pstmt1=con.prepareStatement(sql1);
			pstmt1.setString(1, item);
			pstmt1.setInt(2, price);
			pstmt1.setInt(3, amount);
			pstmt1.setInt(4, num);
			pstmt1.executeUpdate();
			
			String sql2="update payment set pay=?,pmethod=? where num=?";
			pstmt2=con.prepareStatement(sql2);
			pstmt2.setInt(1, pay);
			pstmt2.setString(2, pmethod);
			pstmt2.setInt(3, num);
			pstmt2.executeUpdate();
			
			con.commit();
			System.out.println("수정완료");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}
			
		}finally {
			JDBCUtil.close(con, pstmt1, null); 
			JDBCUtil.close(pstmt2);
		}
	}
	
	public void findAll() { //구매정보조회:전체구매정보 조회
		PreparedStatement pstmt1=null;
		ResultSet rs=null;
		ResultSetMetaData rsmd=null;
		
		try {
			String sql1="select * from purchase";
			pstmt1=con.prepareStatement(sql1);
			rs=pstmt1.executeQuery();
			
			rsmd=rs.getMetaData();
			
			System.out.println("[구매정보 출력]");
			for(int i=1;i<=rsmd.getColumnCount();i++) {  
				String colName=rsmd.getColumnName(i);  
				System.out.printf("%-10s",colName); 
			}
			System.out.println();
			System.out.println("===================================================");
			
			while(rs.next()) {
				int num=rs.getInt("num");
				String id=rs.getString("id");
				String item=rs.getString("item");
				int price=rs.getInt("price");
				int amount=rs.getInt("amount");
				Date buydate=rs.getDate("buydate");
				
				System.out.printf("%-10d %-10s %-10s %-10d %-10d %-10s \n",num,id,item,price,amount,buydate);
			}
			
			System.out.println();
			System.out.println("회원조회 완료");
			
		}catch(SQLException s) {
			System.out.println(s.getMessage());
			
		}finally {
			JDBCUtil.close(con, pstmt1, rs);
		}
	}
	
	public void delete() { //구매취소:구매정보와 결제정보가 모두 삭제됩니다.
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		
		System.out.println("삭제할 회원번호 입력");
		int num=scan.nextInt();
		
		try {	
			//자식테이블먼저 삭제하기
			String sql1="delete from payment where num=?";
			pstmt1=con.prepareStatement(sql1);
			pstmt1.setInt(1, num);
			pstmt1.executeUpdate();
			
			String sql2="delete from purchase where num=?";
			pstmt2=con.prepareStatement(sql2);
			pstmt2.setInt(1, num);
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
			JDBCUtil.close(con, pstmt1, null); 
			JDBCUtil.close(pstmt2);
		}
	}
		
}

public class Test01 {
	public static void main(String[] args) {
		JDBC01 db=new JDBC01();
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("1. 제품구매  2.구매정보수정 3.구매정보조회  4.구매취소");
		int n=scanner.nextInt();
		switch(n) {
			case 1: 
				db.insert(); break;
			case 2:
				db.update(); break;
			case 3:	
				db.findAll(); break;
			case 4:
				db.delete(); break;
			default:
			System.out.println("번호를 다시 선택해주세요.");
		}
		
	}
	
}
