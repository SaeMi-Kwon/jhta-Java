package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.JDBCUtil;
import dto.UserDTO;

public class UserDAO {
	
	public int insert(UserDTO uedto) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		//아이디 중복체크
		try {
			con=JDBCUtil.getCon();
			String sql="insert into parking_user values(?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,uedto.getUsid());
			pstmt.setString(2, uedto.getUname());
			pstmt.setString(3, uedto.getPhone());
			pstmt.setString(4, uedto.getCar_number());
			int n=pstmt.executeUpdate();
		
			return n;
			
		} catch (SQLException s) {
			System.out.println(s.getMessage());
			return -1;
			
		}finally {
			JDBCUtil.close(con, pstmt);
		}
	}
	
	public int update(UserDTO uedto) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="update parking_user set phone=?,car_number=? where usid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, uedto.getPhone());
			pstmt.setString(2, uedto.getCar_number());
			pstmt.setString(3,uedto.getUsid());
			int n=pstmt.executeUpdate();
		
			return n;
			
		} catch (SQLException s) {
			System.out.println(s.getMessage());
			return -1;
			
		}finally {
			JDBCUtil.close(con, pstmt);
		}
	}
	
	//삭제시 외래키까지 삭제되도록
	public int delete(String usid) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="delete from parking_user where usid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,usid);
			int n=pstmt.executeUpdate();
			
			return n;
			
		} catch (SQLException s) {
			System.out.println(s.getMessage());
			return -1;
			
		}finally {
			JDBCUtil.close(con, pstmt);
		}
	}
	
	public ArrayList<UserDTO> findAll() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="select * from parking_user";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			ArrayList<UserDTO> list=new ArrayList<>();
			while(rs.next()) {
				String usid=rs.getString("usid");
				String uname=rs.getString("uname");
				String phone=rs.getString("phone");
				String car_number=rs.getString("car_number");
				
				UserDTO uedto=new UserDTO(usid,uname,phone,car_number);
				
				list.add(uedto);
			}
			
			return list;
			
		} catch (SQLException s) {
			System.out.println(s.getMessage());
			return null;
			
		}finally {
			JDBCUtil.close(con, pstmt, rs);
		}
		
	}

}
