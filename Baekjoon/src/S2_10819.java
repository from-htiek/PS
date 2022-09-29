import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 2022.09.28
 * 차이를 최대로
 */
public class S2_10819 {
	static int n, input[], list[], result;
	static boolean visitied[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		input = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		result = 0;
		list = new int[n];
		visitied = new boolean[n];
		permutation(0);
		
		System.out.println(result);
		
		
	}
	
	public static void permutation(int idx) {
		if(idx == n) {
			int value = 0; 
			for(int i = 1; i < n; i++) {
				value += Math.abs(list[i-1] - list[i]);
			}
			result = Math.max(value, result);
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(visitied[i]) continue;
			visitied[i] = true; 
			
			list[idx] = input[i];
			permutation(idx+1);
			visitied[i] = false;
		}
		
	}
}
