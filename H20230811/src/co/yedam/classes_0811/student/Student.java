package co.yedam.classes_0811.student;

// 라이브러리 클래스
public class Student {
	// 필드. - 정의하고 싶은 속성들 -> score은 -가 들어가면 맞지 않아서 외부에서 접근하는걸 막는게 좋다
	private int stdNo; // int는 초기값 0으로 만들어주고
	private String stdName; // String 초기값은 null로
	private int score;
	// 이 클래스 안에서만 필드 접근 가능, 외부에서 접근시 메소드를 통해 값이 들어가게 해준다.
	
	// 생성자. - 필드의 값을 초기화하기 위해, 여러개 정의할 수 있다.
	Student() { // 클래스 이름과 똑같은 메소드가 생성자
		// 기본 생성자

	}
	
	Student(int stdNo){ // 매게변수
		this.stdNo = stdNo; // 필드이름과 매게변수 이름 같아서 인스턴스의 필드를 선택할때
							// 앞에 this를 붙이기 / 없으면 매게변수로 인식하기에
		
		//this(stdNo,"");
	}

	Student(int stdNo, String stdName){
		this.stdNo = stdNo;
		this.stdName = stdName;
	}
	
	Student(int stdNo, String stdName, int score){
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.score = score;
	}
	
	
	
	// 메소드. - 기능
	void stdInfo() { // 정보를 출력해주는 기능
		System.out.println("학번: " + stdNo + ", 힉생이름: " + stdName + ", 점수: " + score);

	}
	
	// 메소드 - 필드의 값을 넣어주는
	void setStdNo(int stdNo) {
		this.stdNo = stdNo;
	}
	
	void setStdName(String stdName) {
		this.stdName = stdName;
	}
	
	void setScore(int score) {
		if(score < 0) {
			this.score = 0;
		}else
			this.score = score;
	}
	// getter - 우클릭 - 소스 - generate getter 클릭하면 나온

	public int getStdNo() {
		return stdNo;
	}

	public String getStdName() {
		return stdName;
	}

	public int getScore() {
		return score;
	}
	
}














