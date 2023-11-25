import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2_10811 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken()); // 바구니 개수
		int m = Integer.parseInt(st.nextToken()); // 역순으로 바꾸는 수
		
		int[] basket = new int[n]; 
		for(int i = 0; i < n; i++) {
			basket[i] = i+1;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int gap = (end-start)/2;
			int tmp = 0;
			
			for(int j = 0; j <= gap; j++) {
				tmp = basket[start+j];
				basket[start+j] = basket[end-j];
				basket[end-j] = tmp;
			}
		}
		
		for(int i = 0; i < n; i++) {
			sb.append(basket[i]).append(" ");
		}
		
		System.out.println(sb.toString());
		
	}
}
