import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.04.05
 * 회전 초밥 (고)
 * 
 * 완탐으로 하면 터진다 n의 최댓값이 3백만이기때문.. => 슬라이딩 윈도우 
 */
public class JO_2577 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 회전 초밥 벨트 위에 놓인 접시의 수
		int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호 
		
		
		int[] belt = new int[n]; 
		int[] visitied = new int[d+1];
		int result; // 회전 초밥 벨트에서 먹을 수 있는 최밥의 가짓수의 최대값 
		for(int i = 0; i < n; i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}
		
		
		visitied[c] = 1; 
		int cnt = 1; // 쿠폰 초밥 
		for(int i = 0; i < k; i++) { // 0부터 k개까지 계산해 기준 cnt 만들기
			if(visitied[belt[i]] == 0) cnt++;
			visitied[belt[i]]++; 
		}
		
		result = cnt; 
		
		for(int i = 0; i < n-1; i++) { // i가 0일 때 0번값을 빼고 k+1 값을 넣기 때문에 n-1까지만 계산
			int start = belt[i];
			
			visitied[start]--; // 처음 값 빼기 
			if(visitied[start] == 0) cnt--; // 만약 0이 되면 카운트 줄여주기 
			
			int end = belt[(i+k)%n]; 
			if(visitied[end] == 0) cnt++; // 새로운 값 추가, 만약 처음 들어온 메뉴면 카운트 늘리기 
			visitied[end]++; 
			
//			System.out.println(cnt);
			result = Math.max(result, cnt);
		}
		
		System.out.println(result);
		
	}
}
