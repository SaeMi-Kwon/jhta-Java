package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.JDBCUtil;
import dto.RecordDTO;
import dto.RecordDTO;

public class RecordDAO {

	public ArrayList<RecordDTO> findAll() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="select rcid, rvid, usid, s.location,"
					+ "to_char(start_time,'YY/MM/DD HH24:MI')start_time,"
					+ "to_char(end_time,'YY/MM/DD HH24:MI') end_time,"
					+ "total_fee from parking_record pr join space s "
					+ "on pr.sid=s.sid order by rcid";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			ArrayList<RecordDTO> list=new ArrayList<>();
			while(rs.next()) {
				int rcid=rs.getInt("rcid");
				int rvid=rs.getInt("rvid");
				String usid=rs.getString("usid");
				String location=rs.getString("location");
				String start=rs.getString("start_time");
				String end=rs.getString("end_time");
				double total=rs.getDouble("total_fee");
				
				RecordDTO rcdto=new RecordDTO(rcid,rvid,usid,location,start,end,total);
				
				list.add(rcdto);
			}
			
			return list;
			
		} catch (SQLException s) {
			System.out.println(s.getMessage());
			return null;
			
		}finally {
			JDBCUtil.close(con, pstmt, rs);
		}
	}
	
	public ArrayList<RecordDTO> findByUserId(String userid) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="select rcid, rvid, usid, s.location,"
					+ "to_char(start_time,'YY/MM/DD HH24:MI')start_time,"
					+ "to_char(end_time,'YY/MM/DD HH24:MI') end_time,"
					+ "total_fee from parking_record pr join space s "
					+ "on pr.sid=s.sid where usid=? order by rcid desc";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs=pstmt.executeQuery();
			
			ArrayList<RecordDTO> list=new ArrayList<>();
			while(rs.next()) {
				int rcid=rs.getInt("rcid");
				int rvid=rs.getInt("rvid");
				String usid=rs.getString("usid");
				String location=rs.getString("location");
				String start=rs.getString("start_time");
				String end=rs.getString("end_time");
				double total=rs.getDouble("total_fee");
				
				RecordDTO rcdto=new RecordDTO(rcid,rvid,usid,location,start,end,total);
				
				list.add(rcdto);
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
