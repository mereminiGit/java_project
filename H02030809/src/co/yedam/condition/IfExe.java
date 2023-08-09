package co.yedam.condition;

public class IfExe {
	public static void main(String[] args) {
		int	score = 85;
		score = (int)(Math.random() * 100) + 1; // 랜덤이라는 매소드 0부터 1사이의 실수를 만들어줌
							   // 타입 변환하는건 케스팅 앞에 (int)
							   // 0부터 50사이의 정수가 나옴 *50
		String grade = "";
		
		if(score  > 90) {
			grade = "A";
		}else if(score > 80) 
			grade = "B";
		 else if(score > 70)
			grade = "C";
		 else if(score > 60)
			grade = "D";
		 else
			grade = "F";
		
		int score1 = score / 10; // score 95 -> 10으로 나누면 9

		switch(score1){
		case 9:
			grade = "A";
			break; // switch 구문은 위에꺼가 해당되면 밑으로 계속 이동해 아래 결과를 출력함 -> break를 넣어 해당 영역 끝나고 빠져나오게 해야함
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		default:
			grade = "F";
			break;
		}
		System.out.printf("점수: %d는 %s입니다.", score, grade);
	}
}
