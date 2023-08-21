package co.yedam.stream;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterExe {
	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("C:/temp/names.txt");
			Scanner sc = new Scanner(System.in);

			System.out.println("start");

			while (true) {
				String line = sc.nextLine();
				if(line.equals("quit")) {
					break;
				}
				fw.write(line + "\n");
			}
			fw.flush();
			fw.close();
			sc.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
