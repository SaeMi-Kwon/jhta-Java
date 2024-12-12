package day06_2;

import test.MemberDB;
import test.MemberMySql;
import test.MemberOracle;

public class Test10 {
	public static void main(String[] args) {
		//MemberOracle member = new MemberOracle();
		//MemberMySql member=new MemberMySql();
		MemberDB member=new MemberMySql();
		member.conn();
		member.insert("홍길동1");
		member.select("홍길동2");
		member.update("홍길동3");
		member.delete("홍길동4");
		member.disconn();
		
		
	}
}
