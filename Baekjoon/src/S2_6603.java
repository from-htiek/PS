import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.08.24
 * 로또
 */
public class S2_6603 {
	public static StringBuilder sb = new StringBuilder();
	public static int k, list[], result[]; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		
		while(k != 0) { // 입력이 0이 아닐 때까지 반복
			
			list = new int[k]; // 번호 입력
			for(int i = 0; i < k; i++) {
				list[i] = Integer.parseInt(st.nextToken());
			}
			
			result = new int[6]; // 결과 담는 리스트
			combination(0, 0);
			sb.append("\n");
			
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(sb.toString());
	}
	
	public static void combination(int idx, int start) {
		if(idx == 6) {
			for(int i = 0; i < 6; i++) sb.append(result[i]).append(" ");
			sb.append("\n");
			return; 
		}
		
		for(int i = start; i < k; i++) {
			result[idx] = list[i];
			combination(idx+1, i+1);
		}
		
		
	}
}
