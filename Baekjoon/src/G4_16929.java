import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.12.03
 * Two Dots
 * 사이클을 찾기위해 DFS를 돌렸다, 처음에는 void로 리턴받았었는데 다 풀고나서 다른 분 코드를 보다가 boolean으로 리턴받으면 훨씬 빠르겠다 싶어 바꿨음
 * 그리고 훨씬 빨라졌다. 당연. 가지치기를 엄청 하는걸.
 * 재귀는 아직도 먼 느낌이다 8ㅅ8..
 */
public class G4_16929 {
	public static int n, m, starty, startx;
	public static char map[][];
	public static boolean visitied[][], flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		visitied = new boolean[n][m];
		for(int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				flag = false;
				starty = i;
				startx = j;
				visitied[i][j] = true;
				
				if(dfs(i, j, 0, map[i][j])) {
					System.out.println("Yes");
					return;
				}
			}
		}
		
		
		System.out.println("No");
		
	}
	
	public static int[] dy = {1, -1, 0, 0};
	public static int[] dx = {0, 0, 1, -1}; 
	public static boolean dfs(int y, int x, int cnt, char ch) {
		for(int d = 0; d < 4; d++) {
			int newy = y + dy[d];
			int newx = x + dx[d];
			
			
			if(newy < 0 || newy >= n || newx < 0 || newx >= m) continue;
			if(map[newy][newx] != ch) continue;
			if(newy == starty && newx == startx && cnt >= 3) return true; 
			if(visitied[newy][newx]) continue;
			
			visitied[newy][newx] = true; 
			if(dfs(newy, newx, cnt+1, ch)) return true;
			visitied[newy][newx] = false; 
		}
		
		return false;
	}
}
