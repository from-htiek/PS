import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.02.22
 * 창용 마을 무리의 개수
 * 
 * dfs로 풀어도 터지지 않음 => 1부터 n까지 돌면서 dfs 호출 횟수 세면 마을 무리의 수 
 */
public class D4_7465 {
	
	static int n, parent[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 사람 수(노드)
			int m = Integer.parseInt(st.nextToken()); // 관계 수(간선)
			parent = new int[n+1]; // 0 인덱스 사용 X
			int cnt = 0; // 전체 그룹 수
			
			for(int i = 1; i <= n; i++) {
				parent[i] = -1; // i가 -1이면 본인이 그룹의 대표
			}
			
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				union(start, end);
			}
			
			
			for(int i = 1; i <= n; i++) {
				if(parent[i] == -1) cnt++;
			}
			
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}
	
	 // n이 어느 그룹에 있는지 찾기
	public static int findSet(int n) {
		if(parent[n] == -1) return n;
		
		// path compression
		parent[n] = findSet(parent[n]);
		return parent[n];
		
	}
	
	// a, b 그룹으로 합치기 
	public static void union(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		
		if(a == b) return;
		
		parent[b] = a; 
		return;
	}

}
