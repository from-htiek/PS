import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.02.21
 * 블랙잭
 */
public class B2_2798 {
	static int n, m, card[], list[], result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		card = new int[n];
		list = new int[3]; // 3장의 카드 넣을 것
		result = -1;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		func(0, 0);
		System.out.println(result);

	}
	
	// Combination
	static void func(int idx, int start) {
		if(idx == 3) { // 길이가 3인 조합 생성해 더하기 
			int sum = 0;
			for(int i = 0; i < 3; i++) {
				sum += card[list[i]];
			}
			
			// m을 넘지 않는 가장 가까운 값 찾기 
			if(sum <= m) result = Math.max(sum, result);
			return;
		}
		
		for(int i = start; i < n; i++) {
				list[idx] = i;
				func(idx+1, i+1);

		}
	}
}
