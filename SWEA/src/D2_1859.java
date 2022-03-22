import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.02.06
 * 백만 장자 프로젝트
 * 
 * 다른 배열을 하나 만들어서 max값 저장 후 기존 배열과 빼서 더함
 * https://swexpertacademy.com/main/code/problem/problemSolverCodeDetail.do
 */
public class D2_1859 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc < t+1; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] price = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < n; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			
			// 20억을 넘어가는 숫자가 들어가므로 int => long
			long profit = 0;
			int max = price[n-1];
			// 뒤에서부터 체크
			for(int i = n-2; i >= 0; i--) {
				if(max > price[i]) {
					profit += max-price[i];
				}else {
					max = price[i];
				}
			}
			
			System.out.printf("#%d %d\n", tc, profit);
		}
	}
}
