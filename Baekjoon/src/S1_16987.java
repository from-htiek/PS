import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.02.17
 * 계란으로 계란치기
 */
public class S1_16987 {
	static int n, total, result, egg[][];
	static boolean broken[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		egg = new int[n][2];
		broken = new boolean[n];
		total = n; // 전체 계란 수
		result = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 2; j++) {
				egg[i][j] = Integer.parseInt(st.nextToken()); // [0] : 내구도, [1] : 무게
			}
		}
		
		brokenEgg(0, 0); // 가장 왼쪽 계란부터 시작
		System.out.println(result);
	}
	
	static void brokenEgg(int idx, int cnt) {

		//result = Math.min(cnt, result);

		int e1 = 0;
		int e2 = 0;
		//int cnt = 0; 
		
		for(int i = 0; i < n; i++) {
			if(idx == i) continue; // 같은 계란끼리는 칠 수 없음
			if(!broken[i]) {
				e1 = egg[idx][0]; // 계란1의 원래 내구도 저장
				e2 = egg[i][0]; // 계란2의 원래 내구도 저장
			
				egg[idx][0] -= egg[i][1]; // 서로의 무게 만큼 내구도 깎임
				egg[i][0] -= egg[idx][1];
				
				if(egg[idx][0] <= 0) { // 깨졌으면 표시
					broken[idx] = true;
					cnt++;
				}
				
				if(egg[i][0] <= 0) {
					broken[i] = true;
					cnt++;
				}
				
				//total -= cnt; // 깨진 계란 빼기
				if(!broken[idx]) {
					brokenEgg((idx+1)%n, cnt);
					
					egg[idx][0] = e1; // 복구
					egg[i][0] = e2;
					broken[idx] = false;
					broken[i] = false;
					//total += cnt;
				}
			}
		}
		
	}
}
