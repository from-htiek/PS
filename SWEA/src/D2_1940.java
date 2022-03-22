import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.02.16
 * 가랏!RC카!
 */
public class D2_1940 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int distance = 0; // 이동 거리
			int cur = 0; // 현재 속도
			int accel = 0; // 가속도
			for(int _ = 0; _ < n; _++) {
				st = new StringTokenizer(br.readLine());
				switch(Integer.parseInt(st.nextToken())) {
				case 0: // 현재 속도 유지
					distance += cur;
					break;
				case 1: // 가속
					accel = Integer.parseInt(st.nextToken());
					cur += accel;
					distance += cur;
					break;
				case 2: // 감속
					accel = Integer.parseInt(st.nextToken());
					if(accel > cur) cur = 0; // 현재 속도보다 클 때는 0
					else cur -= accel; 
					distance += cur; 
					break; 
				}
			}
			
			System.out.printf("#%d %d\n", tc, distance);
		}
		
		br.close();
	}
}
