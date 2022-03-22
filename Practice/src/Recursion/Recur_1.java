package Recursion;
/*
 * 2022.02.04
 */
public class Recur_1 {
	public static void main(String[] args) {
		// 재귀는 내려가는 방법을 많이 씀
		// top-down 방식
//		for(int i = 9; i > 0; i--) {
//			System.out.println(i);
//		}
		
		func_1(9);
		System.out.println(func_2(10, 0));
		
	}
	
	
	// 9부터 1까지 출력
	static void func_1(int n) { // 매개변수가 매번 호출되면서 변화되는 값 관리
		// 종료 조건(base case)
		if(n == 0) return;
		
		// 실행 구문
		System.out.println("num : " + n);
		
		// 재귀 호출
		func_1(--n);
	}
	
	
	// 1부터 10까지 합 출력
	// 매개변수를 int n만 주고 return n + func_2(n-1)도 가능
	static int func_2(int n, int sum) { // 매개변수 => 변화되는 값 무조건 선언 (10개도 괜찮음) 
		// 종료 조건
		if(n == 0) return sum;
		
		// 실행 구문
		sum += n;
		
		// 재귀 호출
		return func_2(n-1, sum);
	}
}
