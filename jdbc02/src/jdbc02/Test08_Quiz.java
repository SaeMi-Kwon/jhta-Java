package jdbc02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

/*
 * SQLPLUS 프로그램을 제작해 보세요.
 * (INSERT,UPDATE,DELETE,SELECT,COMMIT,CREATE TABLE,DROP TABLE)
 */

class MyJDBC {
	Connection con = null;
	
	public MyJDBC(String id, String pwd) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(url, id, pwd);
			con.setAutoCommit(false);
			System.out.println("\nConnected to:\r\n" + 
					"Oracle Database 11g Express Edition Release 11.2.0.2.0 - 64bit Production");
		}catch(ClassNotFoundException ce) {
			System.out.println(ce.getMessage());
		}catch(SQLException se) {
			System.out.println(se.getMessage());
		}
	}
	
	public void close() {
		try {
			if(con != null) con.close();
		}catch(SQLException se) {
			System.out.println(se.getMessage());
		}
	}
	
	// INSERT, UPDATE, DELETE
	public int exeUpdate(String sql) {
		PreparedStatement pstmt = null;
		int n = 0;
		try {
			pstmt = con.prepareStatement(sql);
			n = pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println(se.getMessage());
		}finally {
			try {
				if(pstmt != null) pstmt.close();
			}catch(SQLException se) {
				System.out.println(se.getMessage());
			}
		}
		return n;
	}
	
	// SELECT
	public void select(String sql) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(!rs.next()) {
				System.out.println("no rows selected");
				return;
			}
			rsmd = rs.getMetaData();
			System.out.println();
			for(int i = 1 ; i <= rsmd.getColumnCount() ; i++) {
				String colName = rsmd.getColumnName(i);
				System.out.printf("%-20s", colName);
			}
			System.out.println();
			for(int i = 1 ; i <= rsmd.getColumnCount() ; i++) {
				System.out.print("------------------- ");
			}
			System.out.println();
			while(true) {
				for(int i = 1 ; i <= rsmd.getColumnCount() ; i++) {
					String str = rs.getString(i);
					System.out.printf("%-20s", str);
				}
				System.out.println();
				if(!rs.next()) break;
			}
		}catch(SQLException se) {
			System.out.println(se.getMessage());
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			}catch(SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}
	
	// COMMIT
	public void commit() {
		try {
			con.commit();
			System.out.println("Commit complete.");
		}catch(SQLException se) {
			System.out.println(se.getMessage());
		}
	}
	
	// CREATE TABLE, DROP TABLE
	public void execute(String sql) {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.execute();
		}catch(SQLException se) {
			System.out.println(se.getMessage());
		}finally {
			try {
				if(pstmt != null) pstmt.close();
			}catch(SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}
	
	
}


public class Test08_Quiz {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter user-name: ");
		String id = scan.nextLine();
		System.out.print("Enter password: ");
		String pwd = scan.nextLine();
		MyJDBC db = new MyJDBC(id, pwd);
		
		String order = "";
		int n = 0;
		int ln = 2;
		while(true) {
			String str = "";
			System.out.print("\nSQL> ");
			while(true) {
				str += scan.nextLine() + " ";
				if(str.indexOf(";") != -1) {
					ln = 2;
					break;
				}
				System.out.print(ln++ + "    ");
			}
			System.out.println();
			String sql = str.substring(0, str.indexOf(";"));
			order = sql.substring(0, 3).toLowerCase();
			if(order.equals("exi")) {
				System.out.println("Disconnected from Oracle Database 18c Express Edition Release 11.2.0.2.0 - 64bit Production");
				break;
			}
			switch(order) {
				case "ins":
					n = db.exeUpdate(sql);
					if(n == 1) {
						System.out.println(n + " row created.");
					}else if (n > 1){
						System.out.println(n + " rows created.");
					}
					break;
				case "upd":
					n = db.exeUpdate(sql);
					if(n == 1) {
						System.out.println(n + " row updated.");
					}else if (n > 1){
						System.out.println(n + " rows updated.");
					}
					break;
				case "del":
					n = db.exeUpdate(sql);
					if(n == 1) {
						System.out.println(n + " row deleted.");
					}else if (n > 1){
						System.out.println(n + " rows deleted.");
					}
					break;
				case "sel":
					db.select(sql);
					break;
				case "com":
					db.commit();
					break;
				case "cre":
					db.execute(sql);
					System.out.println("Table created.");
					break;
				case "dro":
					db.execute(sql);
					System.out.println("Table dropped.");
					break;
			}
		}
		db.close();
	}
}	

			
	

