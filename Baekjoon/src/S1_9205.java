import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.04.13
 * 맥주 마시면서 걸어가기
 * 
 * 처음에 pq와 q를 같이 사용해서 풀었었는데, 틀렸다
 * 나는 아직 연습이 더 많이 필요한듯하다 
 * 이 코드는 한참 풀다가 .. 대회에서 제공한 정답 소스를 참고해서 풀었다.
 * 풀고나니 내가 생각했던것보다 훨씬 간단하지만 더 강력하다 
 * 언제쯤 이런 코드를 짤 수 있을까?
 */
public class S1_9205 {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] pos = new int[n+2][2]; // 집, 편의점 n개, 페스티벌 좌표  = n+2개
			
			for(int i = 0; i < n+2; i++) {
				st = new StringTokenizer(br.readLine());
				pos[i][0] = Integer.parseInt(st.nextToken());
				pos[i][1] = Integer.parseInt(st.nextToken());
			}
			
			boolean[]visitied = new boolean[n+2];
			Queue<Integer> q = new LinkedList<>();
			q.add(0); // 출발인 집 인덱스 
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				if(visitied[cur]) continue; // 방문했으면 제외
				
				visitied[cur] = true; 
				
				for(int i = 0; i < n+2; i++) { // 방문할 수 있는 거리 탐색
					if(cur == i) continue;
					if(Math.abs(pos[cur][0]-pos[i][0]) + Math.abs(pos[cur][1]-pos[i][1]) <= 1000) {
						q.add(i);
					}
				}
			}
			
			System.out.println(visitied[n+1] ? "happy" : "sad");
		}
	}
}
