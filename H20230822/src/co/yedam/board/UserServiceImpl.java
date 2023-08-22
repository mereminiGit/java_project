package co.yedam.board;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserServiceImpl implements UserService {
// board_user.txt에서 정보를 읽고 User 정보를 List컬렉션에 저장
// User 클래스 생성	
	List<User> userList = new ArrayList<>();

	public UserServiceImpl() {
		loadUser();
	}

	private void loadUser() {
		File file = new File("C:/Temp/board_user.txt");
		Scanner sc = null;
		// 파일 불러오기
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// 파일 List 컬렉션에 저장
		while (true) {
			// 한 줄씩 읽어와 배열에 저장
			String line = null;
			try {
				line = sc.nextLine();
			} catch (Exception e) {
				break;
			}
			String[] data = line.split(" ");

			// 저장한 배열 리스트에 저장
			userList.add(new User(data[0], data[1], data[2]));
		}

	}

	// user이 맞는지 체크
	@Override
	public boolean checkLogin(User user) {
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getId().equals(user.getId())) {
				if (userList.get(i).getPw().equals(user.getPw())) {
					user.setName( userList.get(i).getName());
					// 아이디, 비번 일치
					return true;
				}

			}
		}
		return false;
	}

}
