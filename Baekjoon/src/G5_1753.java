import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 2022.02.24
 * 최단경로
 * 
 * uhuru0614
 * pq에 넣는 부분 코드가 정말 깔끔함  => 따로 변수를 만드는 것도 좋은 듯
 * 
 */
public class G5_1753 {
	static class Node implements Comparable<Node>{
		int vertex;
		int weight;

		public Node(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", weight=" + weight + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		final int INF = Integer.MAX_VALUE;
		int v = Integer.parseInt(st.nextToken()); // 정점 수
		int e = Integer.parseInt(st.nextToken()); // 간선 수
		int s = Integer.parseInt(br.readLine()); // 시작점

		List<Node>[] list = new ArrayList[v+1]; // 0 인덱스 사용 X
		for(int i = 1; i <= v; i++) { // 리스트 초기화 
			list[i] = new ArrayList<>(); 
		}

		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list[start].add(new Node(end, weight));

		}

		// list 입력 확인
		//		for(int i = 0; i < list.length; i++) {
		//			System.out.println(list[i]);
		//		}

		int[] distance = new int[v+1]; // 0 인덱스 사용 X, 출발지에서 오는 최소비용 
		boolean[] visitied = new boolean[v+1]; // 최소 비용 확정 체크
		PriorityQueue<Node> pq = new PriorityQueue<>();

		Arrays.fill(distance, INF); // 최댓값으로 초기화
		distance[s] = 0; // 시작점 s 최소비용 초기화
		pq.offer(new Node(s, distance[s]));

		while(!pq.isEmpty()) {
			// 1. 최소 비용 정점 선택
			Node cur = pq.poll();
			if(visitied[cur.vertex]) continue; // pq의 중복값 거르기

			visitied[cur.vertex] = true;


			// 2. 현재 노드와 연결된 다른 인접 노드 확인해 최소 비용 갱신
			// 아직 방문하지 하지 않음 & 기존 distance값보다 현재 cur을 경유지 삼아 계산한 값이 더 최소 비용일 때 갱신
			// 개선된 for문 쓸 것 
			// iterator 패턴 (개선된 for문 나오기전에는 이런 방식으로 많이 씀) 
			// Iterator<Node> it2=vertexList[v1].iterator(); 
            // while(it2.hasNext()) {
            //    pq.offer(it2.next());
            // }
			for(int i = 0; i < list[cur.vertex].size(); i++) {
				if(!visitied[list[cur.vertex].get(i).vertex] && 
						distance[list[cur.vertex].get(i).vertex] > distance[cur.vertex] + list[cur.vertex].get(i).weight) {
					distance[list[cur.vertex].get(i).vertex] = distance[cur.vertex] + list[cur.vertex].get(i).weight;
					pq.offer(new Node(list[cur.vertex].get(i).vertex, distance[list[cur.vertex].get(i).vertex]));

				}
			}

		}

		for(int i = 1; i <= v; i++) {
			if(distance[i] == INF) {
				System.out.println("INF");
				continue;
			}

			System.out.println(distance[i]);
		}

	}

}
