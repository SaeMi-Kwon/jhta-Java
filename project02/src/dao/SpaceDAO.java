package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.JDBCUtil;
import dto.SpaceDTO;

public class SpaceDAO {

	public int insert(SpaceDTO spdto) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		//사용가능여부 에러잡기(Y,n)아닌거
		try {
			con=JDBCUtil.getCon();
			String sql="insert into space values(?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, spdto.getSid());
			pstmt.setString(2, spdto.getLocation());
			pstmt.setString(3, spdto.getUseyn());
			int n=pstmt.executeUpdate();
			
			return n;
			
		} catch (SQLException s) {
			System.out.println(s.getMessage());
			return -1;
		
		}finally {
			JDBCUtil.close(con,pstmt);
		}
	}
	
	public int update(SpaceDTO spdto) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JDBCUtil.getCon();
			String sql="update space set location=?,useyn=? where sid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, spdto.getLocation());
			pstmt.setString(2, spdto.getUseyn());
			pstmt.setInt(3, spdto.getSid());
			int n=pstmt.executeUpdate();
			
			return n;
		
		} catch (SQLException s) {
			System.out.println(s.getMessage());
			return -1;
		
		}finally {
			JDBCUtil.close(con, pstmt);
		}
	}
	
	public ArrayList<SpaceDTO> findAll() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="select * from space";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			ArrayList<SpaceDTO> list=new ArrayList<>();
			while(rs.next()) {
				int sid=rs.getInt("sid");
				String location=rs.getString("location");
				String useyn=rs.getString("useyn");
				
				SpaceDTO spdto=new SpaceDTO(sid,location,useyn);
				
				list.add(spdto);
			}
			
			return list;
			
		}catch(SQLException s) {
			System.out.println(s.getMessage());
			return null;
			
		}finally {
			JDBCUtil.close(con, pstmt, rs);
		}
	}
	
}
