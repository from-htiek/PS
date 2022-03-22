import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.02.24
 * ATM
 * 
 * for(int i = 0; i < n; i++) {
 * 	result += atm[i]*(n-i);
 * } // a[1]이 n개, a[2]이 n-1개 . . . 더한것과 같음 
 */
public class S3_11399 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] atm = new int[n];
		int result = 0;
		
		for(int i = 0; i < n; i++) {
			atm[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(atm);
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				result += atm[j];
			}
		}
		
		System.out.println(result);
		
		
	}
}
