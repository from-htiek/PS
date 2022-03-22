package Recursion;
/*
 * 2022.02.04
 */
public class Recur_3 {

	public static void main(String[] args) {
		// 특정한 위치에 문자 0 또는 1을 결합해주는 메소드 
		func_5(3, ""); // 숫자 : 자릿수 => 점점 내려가면서 하나씩 붙임
	}
	
	// 2진수 3자리를 구성 000 ~ 111
	static void func_5(int cnt, String result) {
		// 종료
		if(cnt == 0) {
			System.out.println(result);
			return;
		}
		
		// 실행 + 실행
		//result = result + "0"; 
		// => 첫번째 실행은 괜찮으나 두번째 실행에서 문제 
		func_5(cnt-1, result + "0");
		func_5(cnt-1, result + "1");
		
		/*
		 * 만약 4진수라면, 위의 과정 4번 => for문 
		 * for(int i = 0; i < 4; i++){
		 * 	func_5(cnt - 1, result + i)
		 * } 
		 * 
		 * 4방위, 8방위에도 쓸 수 있지 않을까?
		 */
		
	}
	
	

}
