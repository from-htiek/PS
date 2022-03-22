import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.03.05
 * 암호 만들기
 * 
 * arcane1028
 * boolean 배열 만들어 모음 체크
 */
public class G5_1759 {
	static int l, c;
	static char ch[], result[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		ch = new char[c];
		result = new char[l];
		
		String string = br.readLine();
		for(int i = 0, j = 0; i < c; i++) {
			ch[i] = string.charAt(j);
			j += 2; 
		}
	
		Arrays.sort(ch); // 사전식을 위한 오름차순 정렬
		combination(0, 0);

	}
	
	// 조합 
	public static void combination(int idx, int start) {
		if(idx == l) {
			int con = 0; // 자음 수
			int vowels = 0; // 모음 수
			
			for(int i = 0; i < l; i++) {
				if(result[i] == 'a' || result[i] == 'e' || result[i] == 'i' || result[i] == 'o' || result[i] == 'u') {
					vowels++;
				}else con++;
				
				if(con > 1 && vowels > 0) break; 
			}
			
			if(con < 2 || vowels < 1) return;
			
			for(int i = 0; i < l; i++) {
				System.out.print(result[i]);
			}
			System.out.println();
			return; 
		}
		
		for(int i = start; i < c; i++) {
			result[idx] = ch[i];
			combination(idx+1, i+1);
		}
	}
}
