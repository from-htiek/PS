import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.07.27
 * 점프 점프
 */
public class S2_14248 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] list = new int[n+1]; // 돌다리 리스트
		for(int i = 1; i <= n; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		int s = Integer.parseInt(br.readLine()); // 출발 지점  
		
		int[] dy = {1, -1}; 
		boolean[] visitied = new boolean[n+1]; // 방문 체크 배열
		Queue<Integer> q = new LinkedList<>();
		q.offer(s);
		visitied[s] = true;
		
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			cnt++; 
			
			for(int d = 0; d < 2; d++) {
				int newCur = cur + list[cur] * dy[d];
				if(newCur <= 0 || newCur > n) continue; // 범위 벗어나면 제외
				if(visitied[newCur]) continue; // 이미 방문 했다면 제외
				
				q.offer(newCur);
				visitied[newCur] = true; 
				
			}
		}
		
		System.out.println(cnt);
		
	}
}
