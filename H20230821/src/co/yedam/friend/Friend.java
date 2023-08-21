package co.yedam.friend;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Friend {
	// 필드
	private String name;
	private String phone;
	private Date birth; // 1998-08-05 simpleDateFormat 활용해서 변환해서 넣어줘야함
						// sdf.parse() 메소드로 값을 넣어줘야함
	
	// 생성자
	public Friend(String name, String phone, Date birth) {
		super();
		this.name = name;
		this.phone = phone;
		this.birth = birth;
	}

	// get set 메소드
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return "Friend [name=" + name + ", phone=" + phone + ", birth=" + sdf.format(birth) + "]";
	}
	
	
	
	
}
