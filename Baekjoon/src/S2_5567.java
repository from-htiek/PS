import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 2022.09.29
 * 결혼식
 */
public class S2_5567 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine()); // 동기의 수
		int m = Integer.parseInt(br.readLine()); // 리스트의 길이
		
		int result = 0; // 결혼식에 초대할 동기 수
		ArrayList<Integer>[] list = new ArrayList[n+1];
		for(int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			list[from].add(to);
			list[to].add(from);
		}
		
		
		boolean check[] = new boolean[n+1];
		check[1] = true; 
		for(int num1 : list[1]) {
			if(!check[num1]) {
				check[num1] = true;
				result++;
			}
			
			for(int num2 : list[num1]) {
				if(!check[num2]) {
					check[num2] = true;
					result++;
				}
			}
		}
		
		System.out.println(result);
	}
}
