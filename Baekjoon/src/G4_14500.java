import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.08.26
 * 테트로미노
 * 다시 풀자
 * 
 * 이 문제를 dfs로 풀 수 있다고 해서 다시 풀어봄. 
 * 하지만 아무리 생각해도 이걸 어떻게 dfs로 풀지? 하는 생각이 들었고 결국 검색했다. 
 * 하나의 좌표에서 상, 하, 좌, 우 어떤 방향으로든 depth 4까지 가면 모든 테트로미노를 만들 수 있다.(너무 충격적이였다) 
 * 시작점 => 상 => 좌 => 좌 이런식으로 가면 ㄴ 모양의 테트로미노를 만들 수 있고
 * 시작점 => 상 => 하 => 좌 같은 건, 방문체크에서 걸러주기때문에 괜찮다.
 * 즉 어느 방향으로든 3번만 이동하면 테트로미노가 되는거다... 어떻게 다들 이런 생각을 하는거지
 * 여기서 예외적으로 'ㅏ' 모양은 한번 더 생각해줘야하는데 (유일하게 한붓그기리가 안됨) 
 * 이거 때문에 dfs를 기존 위치 그대로에서 한번 더 불러준다 
 * 시간이 흘러서 또 풀면 풀 수 있을까? 
 */
public class G4_14500 {
	public static int n, m, map[][], result;
	public static boolean visitied[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 종이 세로
		m = Integer.parseInt(st.nextToken()); // 종이 가로
		
		map = new int[n][m]; // 종이 배열 입력
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visitied = new boolean[n][m]; // 방문체크 
		result = 0; // 최댓값 
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				visitied[i][j] = true;
				dfs(i, j, 1, map[i][j]);
				visitied[i][j] = false;
			}
		}
		
		System.out.println(result);
		
	}
	
	public static int dy[] = {1, -1, 0, 0};
	public static int dx[] = {0, 0, 1, -1}; 
	
	public static void dfs(int y, int x, int depth, int sum) {
		if(depth == 4) { // 4개 탐색했으면(=> 테트로미노가 만들어졌다면) 끝 
			result = Math.max(result, sum); // 최대값 갱신
			return; 
		}
		
		for(int d = 0; d < 4; d++) { // 4방위 탐색 
			int newy = y + dy[d];
			int newx = x + dx[d];
			
			if(newy < 0 || newy >= n || newx < 0 || newx >= m) continue; // 범위 벗어나면 제외
			if(visitied[newy][newx]) continue; // 이미 방문했다면 제외
			
			visitied[newy][newx] = true; 
			dfs(newy, newx, depth+1, sum + map[newy][newx]);
			dfs(y, x, depth+1, sum + map[newy][newx]); // 'ㅏ' 모양 위해 값만 더하고 현재 위치 유지
			visitied[newy][newx] = false; 
		}
	}
	
	
}
