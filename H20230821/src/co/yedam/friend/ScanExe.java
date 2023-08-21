package co.yedam.friend;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ScanExe {
	public static void main(String[] args) {
		// 파일을 읽는 스캐너
		File file = new File("src/co/yedam/friend/friends.txt"); // 경로를 적어줌
		Scanner sc = null; // 초기화 필요
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		String line = sc.nextLine(); // 한 라인을 읽는 nextLine
		// next 는 공백을 기준으로

		/*
		while (sc.hasNext()) { // 값이 없을때까지 읽어오도록
			String line = sc.next();
			System.out.println(line);
		}
		*/
		
		List<Friend> friends = new ArrayList<>();
		
		while(true) {	
			String line = null;
			try {
				line = sc.nextLine();
			} catch (NoSuchElementException e) {
				break;
			}
//			if(line.equals("")) {
//				break;
//			}
			
			String[] data =  line.split(" "); // 공백을 기준으로 배열을 만들기
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				friends.add(new Friend(data[0], data[1], sdf.parse(data[2])));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//			System.out.println(data.toString());
		}	
		
		// 반복문 출력
		for(Friend fnd : friends) {
			System.out.println(fnd.toString());
		}
	}

}
