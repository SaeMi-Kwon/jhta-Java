package test.dto;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.JDBCUtil;

/*
 * [ DAO (Data Access Object) ]
 * - DBMS와 연동하여 CRUD(Create,Read,Update,Delete) 작업을 하는 역할의 클래스
 */

public class MembersDAO {
	
	public int insert(MembersDTO dto) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="insert into members values(?,?,?,?,sysdate)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, dto.getNum());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPhone());
			pstmt.setString(4, dto.getAddr());
			int n=pstmt.executeUpdate();
			
			return n;
			
		} catch (SQLException s) {
			System.out.println(s.getMessage());
			return -1;
		
		}finally {
			JDBCUtil.close(con,pstmt,null);
		}
	}
	
	
	public ArrayList<MembersDTO> selectAll() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="select * from members order by num asc";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			ArrayList<MembersDTO> list=new ArrayList<MembersDTO>();
			while(rs.next()) {
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String phone=rs.getString("phone");
				String addr=rs.getString("addr");
				Date regdate=rs.getDate("regdate");
				
				MembersDTO dto=new MembersDTO(num,name,phone,addr,regdate);
				//객체를 배열에 담기
				list.add(dto);
			}	
			return list;
			
		}catch(SQLException s) {
			System.out.println(s.getMessage());
			return null;
			
		}finally {
			JDBCUtil.close(con, pstmt, rs);
		}
		
	}
	
	public int delete(int num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="delete from members where num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,num);
			int n=pstmt.executeUpdate();

			return n;
			
		} catch (SQLException s) {
			System.out.println(s.getMessage());
			return -1;
			
		}finally {
			JDBCUtil.close(con, pstmt, null);
		}
	}
	
	public int update(MembersDTO dto) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=JDBCUtil.getCon();
		
			String sql="update members set phone=?,addr=? where num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getPhone());
			pstmt.setString(2, dto.getAddr());
			pstmt.setInt(3, dto.getNum());
			int n=pstmt.executeUpdate();
			
			return n;
			
		} catch (SQLException s) {
			System.out.println(s.getMessage());
			return -1;
			
		}finally {
			JDBCUtil.close(con, pstmt, null);
		}
	}
	
	public MembersDTO findNum(int num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="select * from members where num=?";
		
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
		
		if(rs.next()) {
			int n=rs.getInt("num");
			String name=rs.getString("name");
			String phone=rs.getString("phone");
			String addr=rs.getString("addr");
			Date regdate=rs.getDate("regdate");
			
			MembersDTO dto=new MembersDTO(n,name,phone,addr,regdate);
			return dto;
		}
		
		return null;
		
		} catch (SQLException s) {
			System.out.println(s.getMessage());
			return null;
			
		}finally {
			JDBCUtil.close(con, pstmt, rs);
		}
	}
	
	public ArrayList<MembersDTO> findName(String fname) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=JDBCUtil.getCon();
			//String sql="select * from members where name like '%'||?||'%'";
			String sql="select * from members where name=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, fname);
			rs=pstmt.executeQuery();
			
			ArrayList<MembersDTO> list=new ArrayList<>();
			while(rs.next()) {
				int num=rs.getInt("num");
				//String name=rs.getString("name");  
				String phone=rs.getString("phone");
				String addr=rs.getString("addr");
				Date regdate=rs.getDate("regdate");
				
				//MembersDTO dto=new MembersDTO(num,name,phone,addr,regdate);
				MembersDTO dto=new MembersDTO(num,fname,phone,addr,regdate);
				list.add(dto);
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
