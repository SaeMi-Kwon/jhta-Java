package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import db.JDBCUtil;
import dto.FeeDTO;


public class FeeDAO {
	
	public int insert(Double fee) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="insert into fee values(FEE_SEQ.NEXTVAL,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setDouble(1, fee);
			int n=pstmt.executeUpdate();
			
			return n;
			
		} catch (SQLException s) {
			System.out.println(s.getMessage());
			return -1;
		
		}finally {
			JDBCUtil.close(con,pstmt);
		}
	}

	public int update(int fid,Double fee) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="update fee set hourly_rate=? where fid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setDouble(1, fee);
			pstmt.setDouble(2, fid);
			int n=pstmt.executeUpdate();
			
			return n;
			
		} catch (SQLException s) {
			System.out.println(s.getMessage());
			return -1;
		
		}finally {
			JDBCUtil.close(con,pstmt);
		}
		
	}
	
	public int delete(int fid) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="delete from fee where fid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setDouble(1, fid);
			int n=pstmt.executeUpdate();
			
			return n;
			
		} catch (SQLException s) {
			System.out.println(s.getMessage());
			return -1;
		
		}finally {
			JDBCUtil.close(con,pstmt);
		}
		
	}
	
	public ArrayList<FeeDTO> findAll() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="select * from fee order by fid";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			ArrayList<FeeDTO> list=new ArrayList<>();
			while(rs.next()) {
				int fid=rs.getInt("fid");
				double fee=rs.getDouble("hourly_rate");
				
				FeeDTO fdto=new FeeDTO(fid,fee);
				
				list.add(fdto);
				
			}
			
			return list;
			
		} catch (SQLException s) {
			System.out.println(s.getMessage());
			return null;
		}
		
		
		
	}
	
}
