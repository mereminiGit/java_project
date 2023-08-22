package co.yedam.stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FriendApp {
	List<Friend> friends = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	
	public FriendApp() { // 생성자를 호출하면 실행하게 되라고 loadFile을 안에 넣는것
		loadFile(); 
	}

	public void start() {
		boolean run = true;
		
		while (run) {
			System.out.println("1.등록 | 2.목록 | 3.종료");
			System.out.print("선택>> ");

			int menu = sc.nextInt(); //
			sc.nextLine();

			if (menu == 1) {
				add();
			} else if (menu == 2) {
				list();
			} else if (menu == 3) {
				System.out.println("end of prog");
				saveFile();
				run = false;
			}
		}
	} // end of start

	SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");

	private void add() {
		String name = printString("이름입력입력");
		String phone = printString("연락처입력");
		String birth = printString("생일입력(yy-mm-dd)");
		try {
			Friend fnd = new Friend(name, phone, sdf.parse(birth));
			friends.add(fnd);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void list() {
		for (Friend fnd : friends) {
			System.out.println(fnd.toString());
		}
	}

	private void saveFile() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // SDF하고 자동완성하면 됨
		// friends 컬랙션에 있는 값을 -> 텍스트 저장
		// char기반으로 저장해서 문자로 보여짐
		try {
			FileWriter fw = new FileWriter("C:/temp/friendList.txt");
			for(Friend fnd : friends) {
				String line = fnd.getName() + " " + fnd.getPhone() + " " + sdf.format(fnd.getBirth());
				fw.write(line + "\n"); // 파일에 작성하는 것
			}
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void loadFile() {
		File file = new File("C:/temp/friendList.txt"); // 파일에 대한 정보를 가져오는 클래스
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(true) {
			String line = null;
			try {
				line = sc.nextLine();				
			} catch (NoSuchElementException e) {
				break;
			}
			String[] data = line.split(" ");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				friends.add(new Friend(data[0], data[1], sdf.parse(data[2])));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	// 입력, 출력해주는 메소드
	private String printString(String msg) {
		System.out.println(msg + ">> ");
		return sc.nextLine();
	}
}









