package co.yedam.loop;

public class ForExe {
	public static void main(String[] args) {
		int sum = 0;
		
		for (int i=1; i<=5; i++) {
			sum += i;
		}
		System.out.println(sum);
		
		
		int result = 0;
		
		for(int i=1; i<=100; i++) {
			if(i%3 == 0)
				result += i;
			else continue;
		}
		System.out.printf("1에서 100까지 3의 배수 합: %d\n", result);
	
		while(true) {
			int ran1 = (int)(Math.random()*5+1);
			int ran2 = (int)(Math.random()*5+1);
			
			System.out.printf("숫자1: %d, 숫자2: %d\n", ran1, ran2);
			if(ran1 + ran2 != 5) {
				continue;
			}else break;
		}
		System.out.println("end of frog");
	}
}

