import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 2022.04.05
 * 프로세서 연결하기
 * 
 * 순조부를 이렇게 이용하는구나 처음 깨달은 문제 
 * 지금까지 풀었던 문제는 명확하게 순조부를 써야한다고 던져줬던거 같은데, 이 문제는 전혀 그렇지 않음 
 * 이 문제를 풀고나니까 어떻게 시작해야하지? 생각했던 다른문제들도 가닥이 잡힘 
 * 
 * 다만 구현능력은 아직 부족한것같다 
 * 못 풀어서 풀이를 보고 시간이 지난 후 당일 다시 풀어봤는데도 완벽하게 풀지 못했음  
 * 아직 함수 사용에 익숙하지 않은 것 같고, 구현 능력도 ^^.. 눈물나네 
 * 다음에 다시 풀어본다면 풀 수 있을까? 
 */
public class Test_1767 {
	
	static int n, map[][], total, min, max;
	static ArrayList<int[]> list;
	
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			list = new ArrayList<>(); // 가장 자리에 있지 않은 코어 
			max = 0; // 최대 연결 코어 수
			min = Integer.MAX_VALUE; // 최소 연결 전선 수 
			
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if((i != 0 && j != 0 && i != n-1 && j != n-1) && map[i][j] == 1) list.add(new int[] {i, j});
				}
			}
			
			total = list.size();
			
			// 함수 부르기 
			subset(0, 0);
			sb.append("#").append(tc).append(" ").append(min).append("\n");
			
		}
		
		System.out.println(sb.toString());
	}
	
	public static void subset(int idx, int cnt) { // 코어 선택 후 전선 놓기 

		if(idx == total) {
			int result = 0; 
			for(int i = 0; i < n; i++) { // 전선 수 세기
				for(int j = 0; j < n; j++) {
					if(map[i][j] == 2) {
						result++; 
					}
				}
			}
			
			if(max < cnt) { // 기존보다 코어를 더 많이 연결 했다면 갱신 
				max = cnt;
				min = result;
			}else if(max == cnt) { // 코어 수는 똑같지만 연결한 전선 수가 더 적다면 갱신
				if(min > result) min = result;
			}
			
			return; 
		}
		
		int[] cur = list.get(idx); // 현재 코어 
		
		// 현재 코어 선택 O => 4가지 방향으로 전선 놓기 
		for(int d = 0; d < 4; d++) {
			int newy = cur[0];
			int newx = cur[1];
			
			while(true) { // 현재 방향으로 전선 놓을 수 있을지 체크
				newy += dy[d];
				newx += dx[d];
				
				if(map[newy][newx] == 1 || map[newy][newx] == 2) break; // 전선을 놓을 수 없음 
				
				if(newy == 0 || newy == n-1 || newx == 0 || newx == n-1) { // 한쪽 면에 닿음 => 전선 놓을 수 있음
					connect(cur, d, 2); // 전선 놓고 
					subset(idx+1, cnt+1); // 다음 코어 선택 
					connect(cur, d, 0);  // 되돌아 올 때는 map 되돌려 놓기
					
					break;
				}
			}
		}
		
		// 현재 코어 선택 X;
		subset(idx+1, cnt); 
		
	}
	
	public static void connect(int[] cur, int dir, int status) { // map에 전선 놓거나 지우기 
		int newy = cur[0];
		int newx = cur[1];
		while(true) {
			newy += dy[dir];
			newx += dx[dir];
			
			if(newy < 0 || newy >= n || newx < 0 || newx >= n) break; // 범위 벗어나면 빠져나가기
			map[newy][newx] = status; 
		}

	}
	
	
}
