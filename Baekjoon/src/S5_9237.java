import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * 2022.11.18
 * 이장님 초대
 */
public class S5_9237 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] list = new int[n];
		for(int i = 0; i < n; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(list);
		
		int result = 0;
		int step = 2; // 1일부터 시작, 제일 처음 묘목 심는데는 하루가 걸림 
		
		for(int i = n-1; i >= 0; i--) {
			result = Math.max(result, list[i]+step++);
		}
		
		System.out.println(result);
		
	}
}
