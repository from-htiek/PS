import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2023.11.28
 * 팰린드롬인지 확인하기
 */
public class B2_10988 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine(); // 입력 단어
		int len = word.length(); // 단어 길이
		boolean flag = false; // 팰린드롬 체크
		
		
		for(int i = 0; i < len; i++) {
			if(word.charAt(i) != word.charAt(len - 1 - i)) {
				flag = true;
				break; 
			}
		}
		
		if(flag) System.out.println(0);
		else System.out.println(1);
		
	}
}
