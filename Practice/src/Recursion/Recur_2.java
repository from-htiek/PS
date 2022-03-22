package Recursion;
/*
 * 2022.02.04
 */
public class Recur_2 {
	static int result = 0;
	
	public static void main(String[] args) {
		func_3(12345, 0);
		System.out.println(result);
		
		// 변하는 것 : idx, 결과값 => 매개변수
		String str = "SSAFY";
		String result = "";
		for(int i = 0; i < str.length(); i++) {
			result = result + str.charAt(i);
			result += ",";
		}
		result = result.substring(0, result.length()-1);
		
		result = func_4(str, 0, "");
		System.out.println(result);
		
	}
	
	// 문자열 사이에 "," 결합
	// 그런데 작성하고 보니 str은 변하지 않음 => static ! 
	static String func_4(String str, int idx, String result) {
		// 종료
		if(idx == str.length()) {
			return result.substring(0, result.length()-1);
		}
		// 실행
		result = result + str.charAt(idx);
		result += ',';
		
		// 재귀
		return func_4(str, idx + 1, result);
	}
	
	
	// 자연수의 각 자리 수의 합 반환 
	static void func_3(int n, int sum) {
		// 종료
		if(n == 0) {
			result = sum; 
			return;
		}
		
		// 실행
		int nam, mok;
		nam = n % 10;
		mok = n / 10;
		sum += nam;
		
		// 재귀
		func_3(mok, sum);
	}
	
	// 매번 리턴을 할지, static 변수를 쓸지, 매개변수로 돌릴지 경우에 따라 선택! 


}
