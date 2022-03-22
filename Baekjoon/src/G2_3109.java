import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.02.18
 * 빵집
 */
public class G2_3109 {
	static int dy[], dx[], r, c, cnt;
	static boolean visitied[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		String string = null;
		char[][] map = new char[r][c];
		visitied = new boolean[r][c]; // 확인 체크
		dy = new int[] {-1, 0, 1}; // 오른쪽 위 대각선, 오른쪽 , 오른쪽 아래 대각선
		dx = new int[] {1, 1, 1};
		cnt = 0;
		
		for(int i = 0; i < r; i++) {
			string = br.readLine();
			for(int j = 0; j < c; j++) {
				map[i][j] = string.charAt(j);
				if(map[i][j] == 'x') visitied[i][j] = true;
			}
		}
		
		//System.out.println(Arrays.deepToString(map));
		for(int i = 0; i < r; i++) {
			dfs(i, 0);
		}
		
		System.out.println(cnt);
		
	}
	
	static boolean dfs(int y, int x) {
		visitied[y][x] = true;
		
		if(x == c-1) {
			cnt++;
			return true;
		}
				
		// 3방위 탐색 
		for(int i = 0; i < 3; i++) {
			int newY = y + dy[i];
			int newX = x + dx[i];
			
			if(newY >= 0 && newY < r && newX < c && !visitied[newY][newX]) {
				// if문안에 dfs를 넣지 않으면 x가 c-1에 닿고 나서 그 다음 진행해야하는 방향으로 계속 호출 됨
				// 하지만 if문 안에 넣고 c-1에 true를 리턴하면 dfs(1, 0) 자체가 true로 반환되면서 탐색 끝남
				if(dfs(newY, newX)) return true;
				//dfs(newY, newX);
			}
		}
		
		return false;
	}
	
}
