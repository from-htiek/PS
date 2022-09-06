import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.09.05
 * 두 용액
 * 터졌어용! 내일 다시!
 */
public class G5_2470 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] list = new int[n]; // 용액 입력
		for(int i = 0; i < n; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(list); // 정렬 
		
		
		if(list[n-1] <= 0) { // 모두 다 알칼리성 용액
			System.out.println(list[n-1] + " " + list[n-2]);
			return;
		}else if(list[0] >= 0) { // 모두 다 산성 용액
			System.out.println(list[0] + " " + list[1]);
			return; 
		}
		
		
		// 알칼리성 + 산성 섞여있다면
		int index = -1; // 0 이상 값을 가지는 첫번째 인덱스
		int a = 0; // 용액 1
		int b = 0;  // 용액 1
		int sum = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) { 
			if(list[i] >= 0) {
				index = i;
				break; 
			}
		}
		
	
		for(int i = 0; i <= index ; i++) { // 인덱스까지만 
			int _a = 0;
			int _b = 0;
			int _sum = Integer.MAX_VALUE;
			for(int j = index-1; j < n; j++) { // 인덱스부터 n까지 
				if(i == j) continue; 
				
				int check = Math.abs(list[i] + list[j]);
				if(check > _sum) break; 
				if(check < _sum) { // 절대값이 작으면 값 갱신
					_a = list[i];
					_b = list[j];
					_sum = check;
				}
			}
			
			if(_sum < sum) { // 합 비교해 갱신
				a = _a;
				b = _b;
				sum = _sum;
			}
		}
		
		System.out.println(a + " " + b);
		
	}
}
