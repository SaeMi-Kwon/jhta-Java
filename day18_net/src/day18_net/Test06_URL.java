package day18_net;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Test06_URL {
	public static void main(String[] args) {
		
		//이미지를 c:\\2407폴더에 download폴더에 저장되도록 코드를 완성해 보세요.
		try {
			String s="https://ssl.pstatic.net/melona/libs/1515/1515612/70a9d2309188dd4f10f9_20241216151320144.jpg";
			URL url = new URL(s);
			
			//InputStream is=url.openStream();
			String path=url.getPath();
			System.out.println("path" + path);
			String fileName=path.substring(path.lastIndexOf("/")+1);
			
			BufferedInputStream bis=new BufferedInputStream(url.openStream(),1024);

			File f=new File("c:\\2407\\download");
			if(!f.exists()) {
				f.mkdirs(); //다운로드할 디렉토리 생성하기
			}
			
			FileOutputStream fos=new FileOutputStream(f.getAbsolutePath() + File.separator + fileName);
			
			byte[] b=new byte[1024];
			int n=0;
			while((n=bis.read(b))!=-1) {
				fos.write(b, 0, n);
			}
			
			fos.close();
			bis.close();
			System.out.println("파일 저장완료");
			
		} catch (MalformedURLException me) {
			System.out.println(me.getMessage());
			
		} catch(IOException ie) {
			System.out.println(ie.getMessage());
		}
		
		
		
		
	
	}
}
