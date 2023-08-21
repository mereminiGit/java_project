package co.yedam.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamExe {
	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("C:/Temp/out.data"); // 폴더는 생성해주지 않음
			fos.write(100); // byte 값이라 직업 확인 불가
			fos.write(110);
			fos.write(120); 
			// byte는 -128 ~ 127까지 값을 가짐 x
			// 여기서는 0 ~ 255까지 가질 수 있음 

			fos.flush(); // 버퍼에 남아있는 캐시값을 비움
			fos.close(); // 사용한 리소드를 환원

			// 읽는 입력 스트립
//			FileInputStream fis = new FileInputStream("C:/Temp/out.data");
//
//			while (true) {
//				int val = fis.read(); // 1byte씩 읽어드림
//				if(val == -1) // 파일값을 다 읽으면 -1일 반환됨
//					break;
//				System.out.println(val);
//			}
//			
//			fis.close(); // 안 하면 파일을 계속 읽는 작업함

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("end");
	}
}
