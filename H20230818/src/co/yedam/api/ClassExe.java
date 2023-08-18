package co.yedam.api;

import java.lang.reflect.Method;

// Class 클래스
public class ClassExe {
	public static void main(String[] args) {
		try {
			Class cls = Class.forName("co.yedam.api.Member");
			Method[] methods = cls.getDeclaredMethods(); // 선언되어져 있는 메소드의 정보를 반환
			
			for(Method meth : methods) {
				System.out.println(meth); // 해당되는 클래스의 여러가지 정보를 볼 수 있음
			}
		} catch (ClassNotFoundException e) { // 해당 위치에 클래스 없으면 오류반환
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
