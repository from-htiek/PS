import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.03.06
 * 바이러스
 */
public class S3_2606 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int v = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());
		
		int[][] computer = new int[v+1][v+1]; // 0 인덱스 사용X 
		
		for(int i = 0; i < e; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			computer[start][end] = 1; // 무방향 그래프 
			computer[end][start] = 1;
		}
		
		// bfs
		Queue<Integer> q = new LinkedList<>();
		boolean[] visitied = new boolean[v+1];
		q.offer(1);
		visitied[1] = true;
		int cnt = 0; // 1번 컴퓨터를 통해 바이러스에 걸리게 되는 컴퓨터 수
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i = 1; i <= v; i++) {
				if(!visitied[i] && computer[cur][i] == 1) {
					q.offer(i);
					visitied[i] = true;
					cnt++;
					
				}
			}
		}
		
		System.out.println(cnt);
		
		
	}
}
