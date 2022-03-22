import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.02.24
 * 중간 평균값 구하기
 * 
 * Arrays.sort이용해 처음과 끝값 빼고  구하기
 */
public class D2_1984 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] num = new int[10];
			int min = 10001;
			int minIdx = -1;
			int max = -1;
			int maxIdx = -1;
			int result = 0;
			
			for(int i = 0; i < 10; i++) {
				num[i] = Integer.parseInt(st.nextToken());
				
				if(num[i] < min) {
					min = num[i];
					minIdx = i;
				}
				
				if(num[i] > max) {
					max = num[i];
					maxIdx = i;
				}
			}
			
			for(int i = 0; i < 10; i++) {
				if(i == minIdx || i == maxIdx) continue;
				
				result += num[i];
			}
			
			result = (int) Math.round(result*1.0/8);
			
			System.out.printf("#%d %d\n", tc, result);
			
		}
	}
}
