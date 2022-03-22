import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 2022.02.21
 * 비밀 이메일
 * 
 * Stringbuffer를 이용한다면 ? 
 * 
 */
public class B1_2999 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int size = str.length();
		int r = 0; 
		int c = 0;
		
		// R <= C 이고 R*C = N인 R과 C 고르기, 여러개일경우 R이 가장 큰 값
		for(int i = 1; i <= size; i++) {
			if(size%i == 0 && size/i <= i) {
				r = size/i;
				c = i;
				break;
			}
		}
		
		// 첫번째 행의 첫번째 열부터, c번째 열까지 메세지 옮기기
		char[][] list = new char[r][c];
		int idx = 0;
		for(int i = 0; i < c; i++) {
			for(int j = 0; j < r; j++) {
				list[j][i] = str.charAt(idx);
				idx++;
			}
		}
		
		// 출력
		for(char[] l : list) {
			for(char i : l) {
				System.out.print(i);
			}
		}
		
	}
}
