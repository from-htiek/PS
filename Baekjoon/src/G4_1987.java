import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.02.17
 * 알파벳
 * 
 * visitied 대신에 비트 마스킹을 쓴다면 ?
 * 
 * result = 26일 떄는 이미 모든 알파벳을 다 지나왔으므로 return
 */
public class G4_1987 {
	static int r, c, dy[], dx[], cnt, result;
	static char board[][];
	static boolean visitied[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken()); // 세로 r칸
		c = Integer.parseInt(st.nextToken()); // 가로 c칸 
		board = new char[r][c];
		visitied = new boolean[26]; // 알파벳 방문 체크
		
		dy = new int[]{0, -1, 0, 1}; // 좌, 상, 우, 하 
		dx = new int[]{-1, 0, 1, 0};
		cnt = 0; // 지날 수 있는 칸수
		result = 0; // 최대 칸수
		
		String string = null;
		for(int i = 0; i < r; i++) {
			string = br.readLine();
			for(int j = 0; j < c; j++) {
				board[i][j] = string.charAt(j);
			}
		}
		
		//System.out.println(Arrays.deepToString(board));
		
		dfs(0, 0); // 시작점
		System.out.println(result);
		
	}
	//public static boolean dfs(int y, int x) {
	public static void dfs(int y, int x) {
		cnt++;
		visitied[board[y][x] - 'A'] = true;
		result = Math.max(cnt, result);
		
		//if(result == 26) return true;
		
		// 4방위 탐색
		for(int i = 0; i < 4; i++) {
			int newY = y + dy[i];
			int newX = x + dx[i];
			
			// 범위를 벗어나지 않고, 해당 알파벳을 방문하지 않았을 때
			if(wall(newY, newX) && !visitied[board[newY][newX] - 'A']) {
			//if(wall(newY, newX) && !visitied[board[newY][newX] - 'A'] && !dfs(newY, newX)) {
				//dfs(newY, newX);
				visitied[board[newY][newX] - 'A'] = false; 
				cnt--;
			}
			
		}
		
		//return false;
		
	}
	
	// 범위 체크
	public static boolean wall(int y, int x) {
		if(y >= 0 && y < r && x >= 0 && x < c) return true;
		return false;
	}
}
