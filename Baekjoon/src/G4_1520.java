import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.04.30
 * 내르막 길
 * 풀지 못해서 다른 사람의 코드를 참고한 문제.
 * 일반적인 dfs로 풀면 터진다. 또 지점의 최대 높이가 10000이기 때문에, 맥스인 500*500을 모두 계산한다고 한다면 result를 int로 하면 범위 벗어남
 * 일단 이 문제의 포인트는 memoization을 사용하는 것. 
 * 어떤 지점 (y, x)는 (y, x)로 갈 수 있는 지점들의 갈 수 있는 경우의 수를 합한 것과 같다.
 * 가닥을 잡고나서 방문체크에서 헤맸는데 사실 방문했다면 memoization에 값이 이미 들어가있어서 방문체크는 따로 하지 않아도 된다. 
 * 나중에 다시 풀어봤을 때 풀 수 있을까?
 */
public class G4_1520 {
	static int m, n, map[][];
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	static boolean visitied[][];
	static long memo[][], result; 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken()); // m
		n = Integer.parseInt(st.nextToken()); // n
		map = new int[m][n]; // 지도의 각 지점 높이
		memo = new long[m][n]; // 각 지점에 내리막길로만 이동할 수 있는 경우의 수 저장, memoization
		visitied = new boolean[m][n]; // 방문 체크 
		result = 0; // 항상 내리막길로만 이동하는 경우의 수

		for(int i = 0; i < m; i++) { // 지도의 각 지점 높이 값 입력 
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		result = dfs(m-1, n-1); // (m-1, n-1)에 도착하기 위한 경로의 개수

		// 확인용
//		for(long[] a : memo) {
//			System.out.println(Arrays.toString(a));
//		}
		
		System.out.println(result);
	}

	public static long dfs(int y, int x) {

		if(y == 0 && x == 0) { // 출발점에서 어떤 지점으로 이동할 수 있는 경우의 수는 1
			return 1;
		}

		if(memo[y][x] != 0) { // 이미 값이 계산된 상태라면 값 넘김 
			return memo[y][x];
		}
		
		if(!visitied[y][x]) {
			visitied[y][x] = true;
			
			for(int d = 0; d < 4; d++) { // 4방위 탐색
				int newy = y + dy[d];
				int newx = x + dx[d];
				
				if(newy < 0 || newy >= m || newx < 0 || newx >= n) continue; // 범위 벗어나면 제외
				
				if(map[newy][newx] > map[y][x]) { // 내리막길이라면 
					memo[y][x] += dfs(newy, newx); // (y, x)에 올 수 있는 지점들의 경우의 수 더하기
				}
			}
		}


		return memo[y][x];
				
	}

}
