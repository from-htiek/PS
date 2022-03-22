import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 2022.02.25
 * 최소 스패닝 트리
 */
public class D4_3124 {
	static class Node implements Comparable<Node>{
		int vertex;
		int weight;
		
		public Node(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}
	
		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}

	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		
		for(int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken()); // 정점 수
			int e = Integer.parseInt(st.nextToken()); // 간선 수 
			List<Node>[] list = new ArrayList[v+1]; // 0 인덱스 사용 X
			
			for(int i = 1; i <= v; i++) { // 리스트 초기화 
				list[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < e; i++) { // 간선 입력 
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				list[start].add(new Node(end, weight)); // 무방향 그래프
				list[end].add(new Node(start, weight));
			}
			
			// 입력 확인
//			for(int i = 0; i < list.length; i++) {
//				System.out.println(list[i]);
//			}
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			boolean[] visitied = new boolean[v+1]; // 신장 트리 포함 여부 체크 
			long result = 0; // 결과, int로 하면 터짐
			int cnt = 0; // 간선 수 카운트
			
			pq.offer(new Node(1, 0)); // 첫 노드 pq에 삽입
			
			while(!pq.isEmpty()) {
				Node cur = pq.poll();
				
				if(visitied[cur.vertex]) continue; // 중복 거르기 
				
				visitied[cur.vertex] = true; // 포함시킴
				result += cur.weight; 

				cnt++;
				if(cnt == v) break; // 노드만큼 선택했다면 멈춤
				
				for(Node node : list[cur.vertex]) {
					if(!visitied[node.vertex]) {
						pq.offer(new Node(node.vertex, node.weight));
					}
				}

			}
			
			System.out.printf("#%d %d\n", tc, result);
			
		}
	}
}
