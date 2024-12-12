package day12;

import java.io.File;
import java.util.Scanner;

public class Test06_Quiz {
	public static void main(String[] args) {
		//코드로 bb폴더를 삭제해 보세요. bb폴더안에 폴더가 또 있는 경우도 가능하도록
		File f=new File("c:\\2407\\test\\bb");
		
		boolean result=removeDir(f);  //디렉토리 안의 목록들 삭제
		
		if(result) {
			System.out.println(f.getName() + "폴더삭제성공");
		}else {
			System.out.println(f.getName() + "폴더삭제실패");
		}
		
	}
	
	//디렉토리안의 파일들을 모두 삭제하기
	public static boolean removeDir(File f) {
		File[] list=f.listFiles();
		//폴더안의 목록들 삭제
		for(File ff:list) { 
			if(ff.isFile()) {  //파일이면
				ff.delete();  //파일삭제하기
			}else {
				//디렉토리인 경우-디렉토리안의 목록들 삭제하는 메소드(자기자신의 메소드) 호출하기
				removeDir(ff);  
			}
		}
		
		if(f.delete()){ //자신의 폴더 삭제하기
			return true;
		}else {
			return false;
		}

	}
}
