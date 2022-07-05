import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 2022.07.05
 * 파티
 * 맞는 방법인지는 모르겠지만 올 때와 갈 때 다익스트라를 각각 써서 풀었다 
 * 풀고나니 함수로 빼는게 나았나 하는 생각을 잠깐 했다.
 * 다른 분들 코드를 보니 나처럼 distance 배열을 2개를 만들어서 for문으로 모든 학생들이 x로 가는 길을 찾기보다는
 * Vertex 배열을 리버스로 하나 만들어서 쓰는 경우가 더 많은 듯하다
 * 내 코드는 효율이 굉장히 좋지 않은듯하다 
 */
public class G3_1238 {
	public static class Vertex implements Comparable<Vertex>{
		int to, weight;

		public Vertex(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}	
	
	}
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 학생 수
		int m = Integer.parseInt(st.nextToken()); // 도로 수 
		int x = Integer.parseInt(st.nextToken()); // 파티가 열리는 마을

		List<Vertex>[] list = new ArrayList[n+1];
		for(int i = 1; i <= n; i++) { // 리스트 초기화
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[from].add(new Vertex(to, weight));
		}
		
		// 1. 모든 학생이 x로 가는길 구하기 
		int[] goDistance = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			if(i == x) continue;
			
			int[] tmpDistance = new int[n+1];
			boolean[] visitied = new boolean[n+1];
			
			Arrays.fill(tmpDistance, Integer.MAX_VALUE);
			PriorityQueue<Vertex> pq = new PriorityQueue<>();
			tmpDistance[i] = 0;
			pq.offer(new Vertex(i, 0));
			
			while(!pq.isEmpty()) {
				Vertex cur = pq.poll();
				if(visitied[cur.to]) continue;
				visitied[cur.to] = true; 
				
				if(cur.to == x) {
					goDistance[i] = tmpDistance[x];
					break; 
				}
				
				for(Vertex vertex : list[cur.to]) {
					if(visitied[vertex.to]) continue;
					
					if(tmpDistance[vertex.to] > tmpDistance[cur.to] + vertex.weight) {
						tmpDistance[vertex.to] = tmpDistance[cur.to] + vertex.weight;
						pq.offer(new Vertex(vertex.to, tmpDistance[vertex.to]));
					}
				}
			}
		}
		
//		System.out.println(Arrays.toString(goDistance));
		
		// 2. x에서 돌아오는 길 구하기
		int[] backDistance = new int[n+1];
		boolean[] visitied = new boolean[n+1];
		
		Arrays.fill(backDistance, Integer.MAX_VALUE);
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		backDistance[x] = 0;
		pq.offer(new Vertex(x, 0));
		
		while(!pq.isEmpty()) {
			Vertex cur = pq.poll();
			if(visitied[cur.to]) continue;
			visitied[cur.to] = true; 
			
			for(Vertex vertex : list[cur.to]) {
				if(visitied[vertex.to]) continue;
				
				if(backDistance[vertex.to] > backDistance[cur.to] + vertex.weight) {
					backDistance[vertex.to] = backDistance[cur.to] + vertex.weight;
					pq.offer(new Vertex(vertex.to, backDistance[vertex.to]));
				}
			}
		}
		
//		System.out.println(Arrays.toString(backDistance));
		
		int result = 0; 
		for(int i = 1; i <= n; i++) {
			result = Math.max(result, goDistance[i] + backDistance[i]);
		}
		
		System.out.println(result);
		
	}
	
}
