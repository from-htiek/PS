import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.04.27
 * 양
 */
public class S2_3184 {
	static int r, c, sheep, wolf;
	static char map[][]; 
	static boolean visitied[][]; 
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1}; 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken()); // r
		c = Integer.parseInt(st.nextToken()); // c
		map = new char[r][c]; // 마당 배열 
		visitied = new boolean[r][c]; // 방문체크 배열

		for(int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int totalSheep = 0; // 아침까지 살아있는 양
		int totalWolf = 0; // 아침까지 살아있는 늑대

		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(!visitied[i][j]) { // 아직 방문하지 않았을 때 dfs로 탐색
					sheep = 0; // 해당 지역의 양과 늑대 마리수 초기화 
					wolf = 0; 
					dfs(i, j);
					
					if(sheep > wolf) totalSheep += sheep; // 양이 더 많으면 양이 살아남음
					else totalWolf += wolf; // 그렇지 않다면 늑대가 잡아먹음
				}
				
			}
		}

		System.out.println(totalSheep + " " + totalWolf);

	}

	static public void dfs(int y, int x) {
		visitied[y][x] = true; // 방문 체크 

		if(map[y][x] == 'o') sheep++; // 양, 늑대 마리수 체크
		else if(map[y][x] == 'v') wolf++; 

		for(int d = 0; d < 4; d++) { // 4방위 탐색 
			int newy = y + dy[d];
			int newx = x + dx[d];

			if(newy < 0 || newy >= r || newx < 0 || newx >= c) continue; // 범위 벗어나면 제외
			if(map[newy][newx] == '#') continue; // 울타리라면 제외
			if(visitied[newy][newx]) continue; // 방문했다면 제외

			dfs(newy, newx); 
		}

	}
}
