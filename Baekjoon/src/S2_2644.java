import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.02.23
 * 촌수계산
 * 
 * swon962
 * visitied를 방문체크 겸 촌수 계산으로 넣어도 됨 
 * 
 * bfs로 구현해도 인접 노드들을 방문하므로 상관 없음 
 * 
 * 인접 리스트로 구하면 더 빠를 가능성이 높음
 */
public class S2_2644 {
	static int n, family[][], y, cnt;
	static boolean visitied[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		n = Integer.parseInt(br.readLine()); // 총 n명
		family = new int[n+1][n+1]; // 0 인덱스 사용 X
		visitied = new boolean[n+1]; // 방문 체크
		cnt = 0; // 촌수 
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken()); // x와 y의 촌수 찾기
		
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			// 인접 행렬 생성
			family[start][end] = 1;
			family[end][start] = 1;
		}
		
		if(dfs(x)) System.out.println(cnt);
		else System.out.println(-1);
		
	}
	
	public static boolean dfs(int x) {
		visitied[x] = true;
		
		if(x == y){
			return true; 
		}
		
		for(int i = 1; i <= n; i++) {
			 if(!visitied[i] && family[x][i] == 1){
				cnt++;
				if(dfs(i)) return true;
				
				// 백트래킹
				cnt--;
				visitied[i] = false; 
			}
		}
		
		return false;
	}
}
