import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * 2022.05.10
 * 보물
 */
public class S4_1026 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n]; // a 배열
		int[] b = new int[n]; // b 배열
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}

		// 정렬
		Arrays.sort(a);
		Arrays.sort(b);
		
		int result = 0; // 최소값
		for(int i = 0; i < n; i++) {
			result += a[i]*b[n-i-1];
		}
		
		System.out.println(result);
	}
}
