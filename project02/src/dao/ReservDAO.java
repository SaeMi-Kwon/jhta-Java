package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import db.JDBCUtil;
import dto.ReservDTO;
import dto.ReservFindDTO;

public class ReservDAO {
	
	public int insert(ReservDTO rvdto) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="insert into parking_reservation "
					+ "values(RESERV_SEQ.NEXTVAL,?,?,to_date(?,'RR/MM/DD HH24:MI'),"
					+ "to_date(?,'RR/MM/DD HH24:MI'),'예정')";   
				
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, rvdto.getUsid());
			pstmt.setInt(2, rvdto.getSid());
			pstmt.setString(3, rvdto.getStart_time());
			pstmt.setString(4, rvdto.getEnd_time());
			int n=pstmt.executeUpdate();
			
			return n;
			
		} catch (SQLException s) {
			System.out.println(s.getMessage());
			return -1;
		
		}finally {
			JDBCUtil.close(con,pstmt);
		}
	}
	
	public int updateTime(ReservDTO rvdto) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="update parking_reservation "
					+ "set start_time=to_date(?,'RR/MM/DD HH24:MI'),"
					+ "end_time=to_date(?,'RR/MM/DD HH24:MI') "
					+ "where rvid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, rvdto.getStart_time());
			pstmt.setString(2, rvdto.getEnd_time());
			pstmt.setInt(3, rvdto.getRvid());
			int n=pstmt.executeUpdate();
			
			return n;
			
		} catch (SQLException s) {
			System.out.println(s.getMessage());
			return -1;
		
		}finally {
			JDBCUtil.close(con,pstmt);
		}
	}
	
	public int updateStatus(int rvid,String status) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="update parking_reservation set status=? where rvid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, status);
			pstmt.setInt(2, rvid);
			int n=pstmt.executeUpdate();
			
			return n;
		
		} catch (SQLException s) {
			System.out.println(s.getMessage());
			return -1;
		
		}finally {
			JDBCUtil.close(con,pstmt);
		}
		
	}
	
	
	public int deleteId(int rvid) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="delete from parking_reservation where rvid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, rvid);
			int n=pstmt.executeUpdate();
			
			return n;
			
		} catch (SQLException s) {
			System.out.println(s.getMessage());
			return -1;
		
		}finally {
			JDBCUtil.close(con,pstmt);
		}
	}
	
	public int deleteCancel() {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="delete from parking_reservation where status='취소'";
			pstmt=con.prepareStatement(sql);
			int n=pstmt.executeUpdate();
			
			return n;
			
		} catch (SQLException s) {
			System.out.println(s.getMessage());
			return -1;
		
		}finally {
			JDBCUtil.close(con,pstmt);
		}
	}
	
	
	public ArrayList<ReservFindDTO> findAll() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=JDBCUtil.getCon();
		
			String sql="select rvid, usid, s.location,"
					+ "to_char(start_time,'YY/MM/DD HH24:MI')start_time, "
					+ "to_char(end_time,'YY/MM/DD HH24:MI')end_time,status "
					+ "from parking_reservation pv join space s "
					+ "on pv.sid=s.sid order by rvid";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();

			ArrayList<ReservFindDTO> list=new ArrayList<>();
			while(rs.next()) {
				int rvid=rs.getInt("rvid");
				String usid=rs.getString("usid");
				String location=rs.getString("location");
				String start=rs.getString("start_time");
				String end=rs.getString("end_time");
				String status=rs.getString("status");
				
				ReservFindDTO rvdto=new ReservFindDTO(rvid,usid,location,start,end,status);
				list.add(rvdto);
			}
			
			return list;
			
		}catch (SQLException s) {
			System.out.println(s.getMessage());
			return null;
			
		}finally {
			JDBCUtil.close(con, pstmt, rs);
		}
	}
	
	public ArrayList<ReservFindDTO> findByUsid(String userid) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=JDBCUtil.getCon();
		
			String sql="select rvid, usid, s.location,"
					+ "to_char(start_time,'YY/MM/DD HH24:MI')start_time, "
					+ "to_char(end_time,'YY/MM/DD HH24:MI')end_time,status "
					+ "from parking_reservation pv join space s "
					+ "on pv.sid=s.sid where usid=? order by rvid";
		
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs=pstmt.executeQuery();

			ArrayList<ReservFindDTO> list=new ArrayList<>();
			while(rs.next()) {
				int rvid=rs.getInt("rvid");
				String usid=rs.getString("usid");
				String location=rs.getString("location");
				String start=rs.getString("start_time");
				String end=rs.getString("end_time");
				String status=rs.getString("status");
				
				ReservFindDTO rvdto=new ReservFindDTO(rvid,usid,location,start,end,status);
				list.add(rvdto);
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
