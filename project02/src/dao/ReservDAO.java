package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.JDBCUtil;
import dto.ReservDTO;

public class ReservDAO {
	
	public int insert(ReservDTO rvdto) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="insert into parking_reservation values(?,?,?,sysdate,sysdate+1,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, rvdto.getRvid());
			pstmt.setString(2, rvdto.getUsid());
			pstmt.setInt(3, rvdto.getSid());
			pstmt.setString(4, rvdto.getStatus());
			int n=pstmt.executeUpdate();
			
			return n;
			
		} catch (SQLException s) {
			System.out.println(s.getMessage());
			return -1;
		
		}finally {
			JDBCUtil.close(con,pstmt);
		}
	}
	
	public void findByUsid() {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		
		con=JDBCUtil.getCon();
		
		String sql="";
		
	}
}
