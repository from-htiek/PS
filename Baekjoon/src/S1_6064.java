import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.09.03
 * 카잉 달력
 * 내 코드를 더 간결화 하면 이렇게 되지 않을까 
 * https://www.acmicpc.net/source/42046366
 */
public class S1_6064 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < t; tc++) { // t개의 테스트만큼 반복
			 st = new StringTokenizer(br.readLine());
			 int m = Integer.parseInt(st.nextToken());
			 int n = Integer.parseInt(st.nextToken());
			 int x = Integer.parseInt(st.nextToken());
			 int y = Integer.parseInt(st.nextToken());
			 
			 boolean[] remain = new boolean[n+1]; // 나머지 체크 
			 int cnt = x; // 결과 (몇 번째 해인지) 
			 int a = x; // x에 대응 되는 값, x는 n보다 작으므로 초기값으로 세팅 
			 int b = x % n == 0 ? n : x % n; // y에 대응 되는 값, y < N 조건으로 y == n일 때 y = n 이여야 함 

			 // 예시) m : 10, n : 12, x : 3, y : 9
			 // x, y는 m과 n의 나머지값으로 계산 됨 ex) x가 13이 되면 x는 x % 10 = 3이 됨 
			 // x에 m을 더해주면 x 값은 나머지 값으로 계산되므로 항상 x임 
			 // 초기값으로 a를 x로 먼저 세팅 하였기 때문에 b만 y를 만들면 된다 
			 // b에 m을 더해주면서 모듈러 연산 진행 => 하지만 나머지 값은 반복되고, 반복이 시작되는 순간까지 y가 나오지 않았다면 y는 앞으로도 나올 수 X 
			 while(true) {
				 if(b == y) { // 값이 같아지면 끝
					 sb.append(cnt).append("\n");
					 break; 
				 }
				 
				 cnt += m;
				 b = (b + m) % n == 0 ? n : (b + m) % n;
				 
				 if(remain[b]) { // 이미 나왔던 나머지값이면 유효하지 않음 
					 sb.append(-1).append("\n");
					 break; 
				 }
				 
				 remain[b] = true;
			 }
			 
		}
		
		System.out.println(sb.toString());
	}
}
