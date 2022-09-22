import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 2022.09.22
 * Base Conversion
 */
public class S5_11576 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int num = 0;
		for(int i = 0; i < m; i++) {
			num += Integer.parseInt(st.nextToken()) * Math.pow(a, m-i-1);
		}
		
		int idx = 0;
		while(true) {
			if(Math.pow(b, idx) > num) break; 
			idx++;
		}
		
		
		for(int i = idx-1; i >= 0; i--) {
			sb.append((int) (num / Math.pow(b, i))).append(" ");
			num = num % (int)Math.pow(b, i);
		}
		
		System.out.println(sb.toString());
		
		
	}
}
