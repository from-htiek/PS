import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.08.2
 * 공 넣기
 */
public class B2_10810 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 바구니 수
		int m = Integer.parseInt(st.nextToken()); // 공 넣는 횟수
		
		int[] list = new int[n+1];
		
		for(int i = 0; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int ball = Integer.parseInt(st.nextToken());
			
			for(int j = start; j <= end; j++) {
				list[j] = ball; 
			}
		}
		
		for(int i = 1; i <= n; i++) {
			sb.append(list[i]).append(" ");
		}
		
		System.out.println(sb.toString());
		
		
	}
}
