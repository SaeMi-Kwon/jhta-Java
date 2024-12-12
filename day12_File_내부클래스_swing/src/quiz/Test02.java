package quiz;

import java.io.File;

/*
 	2. 디렉토리 복사하는 프로그램을 작성해 보세요.(조금 어려워요) 
	예)
   	복사할 폴더
   	c:\java
   	복사본 폴더
   	c:\java_copy
   	java폴더가 java_copy폴더에 복사됨 
 */

//2. 복사할 폴더 안에 txt,디렉토리 모든걸 복사(재귀메소드이용)
//겉에 복사본(이름만다름)
public class Test02 {
	public static void main(String[] args) {
		
		String orgPath = "c:\\java";
		String copyPath = "c:\\java_copy";


		boolean result=copyDir(orgPath,copyPath);


		if(result){
			System.out.println("폴더 복사 완료");
		}else {
			System.out.println("폴더 복사 실패");
		}


	}


	public static boolean copyDir(String inFile,String outFile){
		File orgFile=new File(inFile);
		File copyFile=new File(outFile);


		if (!copyFile.exists()) {
			copyFile.mkdirs();
		}
		File[] list=orgFile.listFiles();


		if(list!=null){
			for(File ff:list){
				System.out.println(ff.getName());
			}
		}


			return false;
		}

	
}
