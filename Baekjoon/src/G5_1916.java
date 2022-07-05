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
 * 최소비용 구하기
 */
public class G5_1916 {
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

		@Override
		public String toString() {
			return "Vertex [to=" + to + ", weight=" + weight + "]";
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		List<Vertex>[] list = new ArrayList[n+1];
		
		for(int i = 1; i <= n; i++) { // 리스트 초기화
			list[i] = new ArrayList<>();
		}
		
		
		
		
		StringTokenizer st = null; 
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[from].add(new Vertex(to, weight)); 
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken()); // 출발 도시 
		int end = Integer.parseInt(st.nextToken()); // 도착 도시 
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		boolean[] visitied = new boolean[n+1]; // 최소 비용 확정 여부
		int[] distance = new int[n+1]; // 출발지에서 오는 최소비용
		
		Arrays.fill(distance, Integer.MAX_VALUE); // 최대값으로 초기화
		distance[start] = 0; // 출발지점 거리 초기화
		pq.offer(new Vertex(start, 0));
			
		while(!pq.isEmpty()) {
			Vertex cur = pq.poll();
			if(visitied[cur.to]) continue; // 이미 최소비용 확정됐다면 제외 
			visitied[cur.to] = true; 
			
			if(cur.to == end) break; // 도착점 확정 됐다면 멈추기 
			
			for(Vertex vertex : list[cur.to]) { // 현재 도시에서 연결된 도시 최소비용 갱신
				if(!visitied[vertex.to]
					&& distance[vertex.to] > distance[cur.to] + vertex.weight){
					distance[vertex.to] = distance[cur.to] + vertex.weight;
					pq.offer(new Vertex(vertex.to, distance[vertex.to]));
					}
			}
			
//			System.out.println(Arrays.toString(distance));
		}
		
		System.out.println(distance[end]);
	}
}
