import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.07.26
 * 특정 거리의 도시 찾기
 * 정답이 오름차순 정렬을 해야만 해서 PQ로 풀었다가 틀렸다고 해서 일반적인 Q로 바꿔보았더니 통과
 * N이 아주 클 때 시간초과가 나는걸까?
 */
public class S2_18352 {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 도시의 개수
		int m = Integer.parseInt(st.nextToken()); // 도로의 개수
		int k = Integer.parseInt(st.nextToken()); // 거리 정보
		int x = Integer.parseInt(st.nextToken()); // 출발 도시의 번호
		
		ArrayList<Integer>[] list = new ArrayList[n+1]; // 리스트 생성 및 초기화
		for(int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		
		for(int i = 0; i < m; i++) { // 도로 추가
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			list[from].add(to); 
		}
		
		boolean[] visitied = new boolean[n+1]; // 방문 체크
//		PriorityQueue<Integer> q = new PriorityQueue<>(); // 오름차순을 위한 PQ
		Queue<Integer> q = new LinkedList<>();
		q.add(x); // 출발 번호 넣기
		visitied[x] = true; 
		
		int cnt = 0;
		while(true) { 
			cnt++;			
			int size = q.size();
			
			while(size-- > 0) { // 현재 거리(cnt)의 도시 계산
				int cur = q.poll();
				
				for(int num : list[cur]) {
					if(!visitied[num]) {
						q.add(num);
						visitied[num] = true; 
					}
				}
			}
			
			if(cnt == k) break; // 거리가 K가 되면 멈춤 
		}
		
		int size = q.size();
		List<Integer> result = new ArrayList<>();
		if(size == 0) sb.append(-1); // 최단 거리가 k인 도시가 없음 
		
		else {
			
			while(!q.isEmpty()) {
//				sb.append(q.poll()).append("\n");
				result.add(q.poll());
			}
			
			Collections.sort(result);
			
			for(int r : result) {
				sb.append(r).append("\n");
			}
		}
		

		
		System.out.println(sb.toString());
		
		
		
	}
}
