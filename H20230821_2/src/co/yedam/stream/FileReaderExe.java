package co.yedam.stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExe {
	public static void main(String[] args) {
		try {
			File file = new File("src/co/yedam/stream/Filecopy.java");
			FileReader fr = new FileReader(file);
			// 파일양이 많을때
			char[] buf = new char[100]; // 100 char씩 읽고 쓰고 하겟다

			while (true) {
				int val = fr.read(buf); // int 타입으로 반환, buf가 들어가면 크기가 들어간다 / 없으면 문자가 들어가는데
				if (val == -1) {
					break;
				}
				for (int i = 0; i < val; i++) {
					System.out.print(buf[i]);
				}
			}
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
