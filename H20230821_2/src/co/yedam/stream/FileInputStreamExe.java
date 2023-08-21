package co.yedam.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamExe {
	public static void main(String[] args) {
		// 읽는 입력 스트립
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("C:/Temp/out.data");
			
			while (true) {
				int val = fis.read(); // 1byte씩 읽어드림
				if (val == -1) // 파일값을 다 읽으면 -1일 반환됨
					break;
				System.out.println(val);
			}
			
			fis.close(); // 안 하면 파일을 계속 읽는 작업함
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("end");

	}
}
