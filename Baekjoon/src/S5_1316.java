import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2023.11.26
 * 그룹 단어 체커
 */
public class S5_1316 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 단어의 개수
		int result = 0;
		
		for(int i = 0; i < n; i++) {
			String word = br.readLine(); // 입력 단어
			int len = word.length();
			
			boolean flag = false; // 그룹 단어 체크 
			int[] alphabet = new int[26]; // 알파벳 리스트
			char ch = word.charAt(0); // 첫글자 미리 계산
			alphabet[ch - 'a']++;
			
			for(int j = 1; j < len; j++) { // 단어의 길이까지 체크
				if(ch != word.charAt(j) && alphabet[word.charAt(j) - 'a'] != 0) { // 바로 전 단어와 다른데 나온 적 있다면 그룹 단어 아님
					flag = true;
					break;
				}
				
				alphabet[ch - 'a']++;
				ch = word.charAt(j);
				
			}
			
			if(!flag) result++; 
		}
		
		System.out.println(result);
		
		
	}
}
