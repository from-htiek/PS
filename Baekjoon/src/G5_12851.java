import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.03.04
 * 숨바꼭질 2
 * 
 * 참고 블로그 : https://bcp0109.tistory.com/154
 * https://maetdori.tistory.com/entry/BOJ-12851-%EC%88%A8%EB%B0%94%EA%BC%AD%EC%A7%88-2-JAVA?category=852190
 */
public class G5_12851 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 수빈이 위치
		int k = Integer.parseInt(st.nextToken()); // 동생 위치
		int visitied[] = new int[100_001]; // 방문체크 및 시간 저장
		int cnt = 0; // 방법 수

		// 같은 위치일 때, 시간 0 방법 1 => 이 부분이 없으면 현재 위치를 먼저 동생위치와 비교하지 않기때문에 반례 생김
		// 동생 위치가 더 작을 때는 -1 방법 밖에 없음 
		if(n >= k) {
			System.out.println(n-k);
			System.out.println(1);
			return;
		}
		
		
		// bfs
		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		visitied[n] = 1;
		int min = Integer.MAX_VALUE;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(visitied[cur] > min) {
				break; 
			}
			
			for(int i = 0; i < 3; i++) {
				int next;
				
				if(i == 0) next = cur+1;
				else if(i == 1) next = cur*2;
				else next = cur-1;
				
				if(next < 0 || next > 100_000) continue; // 범위 벗어나면 제외
				
				if(next == k) { // 동생 위치에 도착했다면 
					cnt++; // 방법 추가 
					min = visitied[cur]; // 최소 시간 갱신					
				}
				
				// 아직 방문하지 않음 OR 방문했다면, 방문 시간이 동일 할 때 
				if(visitied[next] == 0 || visitied[next] == visitied[cur]+1) { 
					visitied[next] = visitied[cur]+1; 
					q.offer(next);
				}
				
				
				
			}
		}
		
		System.out.println(visitied[k]-1);
		System.out.println(cnt);
		
	}
}
