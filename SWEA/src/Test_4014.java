import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.10.14
 * 활주로 건설
 * 함수화 시켜보자
 */
public class Test_4014 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 절벽지대 길이
			int x = Integer.parseInt(st.nextToken()); // 경사로 길이
			
			int[][] map = new int[n][n];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			int result = 0; 
			for(int i = 0; i < n; i++) { // 가로 체크 
				int cnt = 1; 
				boolean up = false; // 오르막
				boolean down = false; // 내리막 
				boolean flag = false;
				int prev = map[i][0];
				int max = map[i][0];
				
				for(int j = 1; j < n; j++) {
					max = Math.max(max, map[i][j]);
					if(Math.abs(prev - map[i][j]) >= 2) { // 높이가 2이상 차이나면 불가능 
						flag = true;
						break;
					}
					
					if(prev == map[i][j]) cnt++; // 높이가 같을 때
					else { // 높이가 다를 때 
						if(prev - map[i][j] == 1) {	// 내리막일 때		
							if(down) { // 그 전도 내리막이였다면 
								if(cnt < x) { // 활주로 세울 수 있는지 체크 
									flag = true;
									break; 
								}
							}
							
							up = false; 
							down = true;
						}else { // 오르막일 때 
							up = true;
							if(down) { // 그 전이 내리막이였다면 
								down = false; 
								if(cnt < 2 * x) { // 활주로 2개 세울 수 있는지 체크 
									flag = true;
									break; 
								}	
							}else { // 오르막이었다면 
								if(cnt < x) { // 활주로 세울 수 있는지 체크
									flag = true;
									break; 
								}
							}
						}
						prev = map[i][j]; 
						cnt = 1; // 다시 해당높이가 몇 개 있는지 체크 
					}
				}
				
				if(prev != max && down) { // 최대 높이가 아니면서 내리막이면
					if(cnt < x) { // 활주로 세울 수 있는지 체크 
						flag = true;
					}
				}
				
				if(!flag) result++; 

			}
			
			
			
			
			for(int i = 0; i < n; i++) { // 세로 체크 
				int cnt = 1; 
				boolean up = false;
				boolean down = false;
				boolean flag = false;
				int prev = map[0][i];
				int max = map[0][i];
				
				for(int j = 1; j < n; j++) {
					max = Math.max(max, map[j][i]);
					if(Math.abs(prev - map[j][i]) >= 2) {
						flag = true;
						break;
					}
					
					if(prev == map[j][i]) cnt++;
					else {
						if(prev - map[j][i] == 1) {							
							if(down) {
								if(cnt < x) {
									flag = true;
									break; 
								}
							}
							
							up = false;
							down = true;
						}else {
							up = true;
							if(down) {
								down = false; 
								if(cnt < 2 * x) {
									flag = true;
									break; 
								}	
							}else {
								if(cnt < x) {
									flag = true;
									break; 
								}
							}
						}
						prev = map[j][i];
						cnt = 1;
					}
				}
				
				if(prev != max && down) {
					if(cnt < x) {
						flag = true;
					}
				}
				
				if(!flag) result++; 

			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
//			System.out.println("#" + tc + " " + result);
		}
		
		System.out.println(sb.toString());
	}
}    
