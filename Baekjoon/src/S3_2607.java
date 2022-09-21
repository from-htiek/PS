import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 2022.09.19
 * 비슷한 단어
 */
public class S3_2607 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 단어의 개수
		
		String str = br.readLine();
		int[] alphabet = new int[26]; // 알파벳 체크
		for(int i = 0, size = str.length(); i < size; i++) { // 첫번째 단어 구성하는 알파벳 체크
			alphabet[str.charAt(i) - 'A']++; 
		}
		
		int result = 0;
		
		for(int i = 0; i < n-1; i++) {
			int[] _alphabet = alphabet.clone();
			str = br.readLine();
			for(int j = 0, size = str.length(); j < size; j++) { 
				int idx = str.charAt(j) - 'A';
				_alphabet[idx]--; 
				
			}
			
			// 이게맞냐
			boolean flag1 = false;
			boolean flag2 = false; 
			boolean flag3 = false; 
			for(int j = 0; j < 26; j++) {
				if (_alphabet[j] == -1) {
					if(flag1) {
						flag3 = true; 
						break;
					}
					flag1 = true; 
				}else if(_alphabet[j] == 1) {
					if(flag2) {
						flag3 = true;
						break; 
					}
					flag2 = true; 
				}else if(Math.abs(_alphabet[j]) >= 2) {
					flag3 = true;
					break;
				}
			}
			
			if(!flag3) result++;
			
		}
		
		System.out.println(result);
		
		
		
		
	}
}