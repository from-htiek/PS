import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.09.10
 * 미친 로봇
 * 처음에는 이걸 어떻게 풀어야하는거지? 생각했었는데, 평범한 DFS처럼 풀되 
 * 그 방향으로 이동하면 값을 계속 곱해주면 되는 문제였음! 
 * 미친 로봇은 동/서/남/북으로 갈 수 있으니 2n+1로 가로세로를 주고 (n, n)에서 시작할 수 있게 했음
 */
public class G5_1405 {
	public static int n; 
	public static double p[], result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		p = new double[4];
		for(int i = 0; i < 4; i++) {
			p[i] = Double.parseDouble(st.nextToken()) / 100;
		}
		
		result = 0; 
		dfs(n, n, new boolean[2*n+1][2*n+1], 0, 1);
		System.out.println(result);
	}
	
	public static int[] dy = {0, 0, 1, -1};
	public static int[] dx = {1, -1, 0, 0};
	public static void dfs(int y, int x, boolean[][] visitied, int cnt, double prob) {
		visitied[y][x] = true; 
		
		if(cnt == n) {
//			System.out.println(prob);
			result += prob; 
			return;
		}
		
		for(int d = 0; d < 4; d++) {
			int newy = y + dy[d];
			int newx = x + dx[d];
			
			if(newy < 0 || newy > 2 * n || newx < 0 || newx > 2 * n ) continue; // 범위 벗어나면 제외
			if(visitied[newy][newx]) continue; // 이미 방문했다면 제외
			if(p[d] == 0.0) continue; // 해당 방향 확률이 0이라면 곱해도 0이므로 제외
			
			// visitied[newy][newx] = true; 
			dfs(newy, newx, visitied, cnt+1, prob * p[d]);
			visitied[newy][newx] = false; 
		}
	}
	
}
