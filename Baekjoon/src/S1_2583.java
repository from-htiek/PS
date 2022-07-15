import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.07.15
 * 영역 구하기
 */
public class S1_2583 {
	static int n, m, map[][];
	static boolean visitied[][];
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken()); // 세로
		n = Integer.parseInt(st.nextToken()); // 가로
		int k = Integer.parseInt(st.nextToken()); // 직사각형 좌표 수 
		
		map = new int[m][n]; // 모눈 종이
		visitied = new boolean[m][n]; // 방문 체크
		for(int i = 0; i < k ; i++) { // 직사각형 표시 
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int y = y1; y < y2; y++) {
				for(int x = x1; x < x2; x++) {
					map[y][x] = 1;
				}
			}
		}
		
		ArrayList<Integer> result = new ArrayList<>();
		int cnt = 0; 
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 0 && !visitied[i][j]) {
					cnt++; 
					result.add(bfs(i, j));
				}
			}
		}
		
		result.sort(Comparator.naturalOrder()); // 정렬
		
		System.out.println(cnt);
		for(int i = 0; i < result.size(); i++) {
			System.out.printf("%d ", result.get(i));
		}
		
	}
	
	static int bfs(int y, int x) {
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {y, x});
		visitied[y][x] = true;
		int cnt = 0; 
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			cnt++; 
		
			for(int d = 0; d < 4; d++) {
				int newy = cur[0] + dy[d];
				int newx = cur[1] + dx[d];
				
				if(newy < 0 || newy >= m || newx < 0 || newx >= n) continue; // 범위 벗어나면 제외
				if(map[newy][newx] == 1) continue; // 직사각형이라면 제외
				if(visitied[newy][newx]) continue; // 이미 방문했다면 제외
				
				q.offer(new int[] {newy, newx});
				visitied[newy][newx] = true; 
			}
		}
		
		
		return cnt; 
	}
}
