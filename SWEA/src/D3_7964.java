import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.02.23
 * 부먹왕국의 차원 관문
 */
public class D3_7964 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 부먹 왕국 도시 수
			int d = Integer.parseInt(st.nextToken()); // 제한 거리 
			
			int village = 0; 
			int cnt = 0; 
			int idx = 0; // 최근 차원관문 위치에서의 거리
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				village = Integer.parseInt(st.nextToken());
				
				if(village == 1) {
					idx = 0; 
				}else {
					idx++; // 차원관문 없으면 거리 늘려줌 
					
					if(idx == d) { // 제한 거리 동안 차원관문 없으면 추가
						cnt++;
						idx = 0; 
					}
				}
			}
			
			System.out.printf("#%d %d\n", tc, cnt);
			
			
		}
		
		
	}
}
