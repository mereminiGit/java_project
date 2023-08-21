package co.yedam.inheritance;

public class MainExe {
	public static void main(String[] args) {
		Cellphone cell = new Cellphone(); // 인스턴스 하나 생성

		cell.setModel("SM1100");
		cell.setColor("Black");
		cell.turnOn();
		cell.turnOff();

		DmbCellphone dmb = new DmbCellphone(); // 아무것도 정의하지 않음
		dmb.setModel("Dmb1100"); // Cellphone의 기능들을 (부모 기능을) 자식 dmb가 사용할 수 있다.
		dmb.setColor("White");
		dmb.turnOn();
		dmb.turnOff();

		dmb.turnOnDmb();
		dmb.changeChannel(5);

		System.out.println("---------------------------------------");
		
		Cellphone cell2 = new Cellphone(); // 왼, 오 데이터 타입 같아야함
		Cellphone cell3 = new DmbCellphone(); // promotion - 이렇게 인스턴스 생성 가능
		
		cell3.turnOn();
		// cell3.turnOnDmb(); // 인스턴스는 Dmb의 인스턴스인데 변수가 부모 클래서라서 부모 기능만 사용 가능
		// 부모 타입으로 자동 타입 변환된 이후 부모 클래스에 선언된 필드아 메소드만 접근이 가능
		// 하지만, turnOn은 자식 클래스에서 재정의 되었기 때문에, 자식 클래스의 메소드가 호출됨!
		
		if (cell3 instanceof DmbCellphone) {
			DmbCellphone dmb2 = (DmbCellphone) cell3; // casting 강제로 변환 가능
			dmb2.turnOnDmb();// 자식클래스에 정의된 기능 사용 가능
		}

		if (cell instanceof DmbCellphone) { // 인스턴스 값이 DmbCellphone이 맞는지 확인하는 작업
			DmbCellphone dmb3 = (DmbCellphone) cell; // cellphone 인스턴스라서
			dmb3.turnOnDmb();
		}
		
		// 
		Cellphone[] phones = new Cellphone[5];
		// Cellphone과 DmbCellphone의 인스턴스 정의할 수 있음
		phones[0] = cell;
		phones[1] = dmb;
		
		
		phones[0].turnOn(); // Cellphone 인스턴스
		phones[1].turnOn(); // DmbCellphone 인스턴스
		// 다형성 - 유용하게 사용
		
		
		
		
		
		
	}
}
