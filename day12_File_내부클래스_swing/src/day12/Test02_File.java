package day12;

import java.io.File;

public class Test02_File {
	public static void main(String[] args) {
		File f=new File("c:\\2407\\test\\aa");
		
		//디렉토리 안의 목록들을 String배열로 얻어옴
		String[] slist=f.list();
		System.out.println(f.getName() + "폴더안의 목록들");
		for(String s:slist) {
			System.out.println(s);
		}
		
		//디렉토리 안의 목록들을 File배열로 얻어옴
		File[] flist=f.listFiles();
		for(File ff:flist) {
			if(ff.isDirectory()) {  //디렉토리인지 검사
				System.out.println("[dir]" + ff.getName());
			}else {
				System.out.println("[file]" + ff.getName() + " " + ff.length() + "bytes");
			}
		}
		
	}
}
