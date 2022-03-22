import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.02.21
 * DFS와 BFS
 */
public class S2_1260 {
	static int n, m, list[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		list = new int[n+1][n+1];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list[start][end] = list[end][start] = 1;
			
		}
		
		dfs(v, new boolean[n+1]);
		System.out.println();
		bfs(v);
		
	}
	
	static public void bfs(int idx) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visitied = new boolean[n+1];
		
		q.offer(idx);
		visitied[idx] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			System.out.print(cur + " ");
			
			for(int i = 0; i < n+1; i++) {
				if(!visitied[i] && list[cur][i] == 1) {
					q.offer(i);
					visitied[i] = true;
				}
			}

		}

	}
	
	static public void dfs(int idx, boolean visitied[]) {
		
		visitied[idx] = true;
		System.out.print(idx + " ");
		
		for(int i = 0; i < n+1; i++) {
			if(!visitied[i] && list[idx][i] == 1) {
				dfs(i, visitied);
			}
		}
	}
}
