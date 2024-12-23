package quiz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

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


//오정빈씨 정답
class HW02 {
	static FileInputStream fis = null;
	static FileOutputStream fos = null;
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("복사할 폴더: ");
			String srcFolder = br.readLine();
			System.out.print("복사될 폴더: ");
			String dstFolder = br.readLine();
			File srcFile = new File(srcFolder);
			File dstFile = new File(dstFolder);
			dstFile.mkdir();
			for (File file: srcFile.listFiles()) {
				copy(file, dstFile.getAbsolutePath());
			}
			System.out.println("파일 복사 성공!");
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe.getMessage());
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		} finally {
			try {
				if (fos != null) fos.close();
				if (fis != null) fis.close();
			} catch (IOException ioe) {
				System.out.println(ioe.getMessage());
			}
		}
	}
	
	public static void copy(File file, String absolutePath) throws FileNotFoundException, IOException {
		if (file.isFile()) {
			fis = new FileInputStream(file.getAbsolutePath());
			fos = new FileOutputStream(absolutePath + "\\" + file.getName());
			byte[] b = new byte[1024];
			int n;
			while ((n = fis.read(b)) != -1) {
				fos.write(b, 0, n);
			}
		} else {
			File cpyFile = new File(absolutePath + "\\" + file.getName());
			cpyFile.mkdir();
			for (File f: file.listFiles()) {
				copy(f, absolutePath + "\\" + file.getName());
			}
		}
	}
}


//이재원씨 정답
class HW02_1 {

    public static void main(String[] args) {
        try {
            copyDirectory();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void copyDirectory() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("복사할 폴더");
        String orgPath = scanner.next();
        File orgDirectory = new File("c:\\2407\\" + orgPath);
        System.out.println("복사본 폴더");
        String copyPath = scanner.next();
        File copyDirectory = new File("c:\\2407\\" + copyPath);
        copyDirectory.mkdir();
        System.out.println("복사완료!");
        copyFile(orgDirectory, copyDirectory);
    }

    public static void copyFile(File orgFile, File copyFile) throws IOException {
        File[] org = orgFile.listFiles();
        assert org != null;
        for (File of : org) {
            if (of.isFile()) {
                System.out.println(of.getAbsolutePath());
                BufferedWriter bw = new BufferedWriter(
                        new FileWriter(copyFile.getAbsolutePath() + "\\" + of.getName()));
                BufferedReader br = new BufferedReader(
                        new FileReader(of.getAbsolutePath()));
                while (true) {
                    if (br.read() == -1) break;
                    bw.write(br.readLine());
                }
                br.close();
                bw.close();
            } else if (of.isDirectory()) {
                File file = new File(copyFile.getAbsolutePath() + "\\" + of.getName());
                File or = new File(of.getAbsolutePath() + "\\");
                file.mkdir();
                System.out.println(of.getAbsolutePath());
                copyFile(or, file);
            }
        }


    }
}
