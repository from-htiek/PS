import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.07.08
 * 사탕
 */
public class S5_11256 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int j = Integer.parseInt(st.nextToken()); // 사탕의 개수
			int n = Integer.parseInt(st.nextToken()); // 상자의 개수
			
			int[] box = new int[n];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken()); // 상자 세로 길이
				int c = Integer.parseInt(st.nextToken()); // 상자 가로 길이
				
				box[i] = r*c;
			}
			
			Arrays.sort(box);
			int result = 0; // 필요한 상자의 개수 
			
			for(int i = n-1; i >= 0; i--) {
				if(j <= 0) break; 
				
				j -= box[i];
				result++;
			}
			
			sb.append(result).append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
}
