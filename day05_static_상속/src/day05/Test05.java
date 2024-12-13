package day05;
class DBConnect{
	private String userName;
	private String userPwd;
	private static String dbServer; //생성자에 초기화하지않는다(생성자는 객체를 생성될때 사용하는 것이므로 static멤버에 맞지않는다.)
	
	static {  	//static멤버를 초기화 할때는 static블록을 사용한다.
		System.out.println("접속할 서버 주소를 읽어옵니다.");
		dbServer="127.0.0.1";
	}
	
	public static String getDbServer() {
		return dbServer;
	}
	
	public DBConnect(String userName,String userPwd) {
		this.userName=userName;
		this.userPwd=userPwd;
	}
	
	public static void changeServer(String ip) {
		//this.dbServer=ip;  에러 -> static멤버는 this를 사용 못함. (this-> new 로 생성된 객체의 주소값)
		dbServer=ip;    
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getUserPwd() {
		return userPwd;
	}
	
	public void connectInfo() {
		System.out.println("접속자 아이디:" + userName);
		System.out.println("접속자 비밀번호:" + userPwd);
		System.out.println("접속된 서버 주소:" + dbServer);
	}
	
}

public class Test05 {
	public static void main(String[] args) {
		System.out.println("서버주소:" + DBConnect.getDbServer());
		
		//DBConnent객체를 생성하고 설정된 값들을 출력해 보세요.
		DBConnect db=new DBConnect("admin1","1111");
		db.connectInfo();
//		String id=db.getUserName();
//		System.out.println("접속자아이디:"+ id);
//		String pw=db.getUserPwd();
//		System.out.println("비밀번호:"+pw);
		
		DBConnect db1=new DBConnect("admin2","2222");
		db1.connectInfo();
//		System.out.println("접속자아이디:"+ db1.getUserName());
//		System.out.println("비밀번호:"+ db1.getUserPwd());
		
		DBConnect.changeServer("192.168.0.1");
		db.connectInfo();
		db1.connectInfo();
		
	}

}
