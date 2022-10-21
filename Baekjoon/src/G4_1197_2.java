import java.awt.geom.Area;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 2022.10.21
 * 최소 스패닝 트리
 * Prim + List
 * matrix를 쓰면 pq를 써도 무조건 터지는구나..
 */
public class G4_1197_2 {
	static class Data implements Comparable<Data>{
		int vertex;
		int weight;

		public Data(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Data [vertex=" + vertex + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Data o) {
			return Integer.compare(this.weight, o.weight);
		}

	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken()); // 정점의 개수
		int e = Integer.parseInt(st.nextToken()); // 간선의 개수

		List<Data>[] list = new ArrayList[v+1];
		boolean[] visitied = new boolean[v+1];

		for(int i = 1; i <= v; i++) {
			list[i] = new ArrayList<>();
		}

		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list[from].add(new Data(to, weight));
			list[to].add(new Data(from, weight));
		}

		int result = 0; // MST 비용

		PriorityQueue<Data> pq = new PriorityQueue<>();
		pq.offer(new Data(1, 0)); // 시작점

		Data cur = null;
		int cnt = 0; 
		while(!pq.isEmpty()) {
			
			// 최소값 선택
			cur = pq.poll();
			if(visitied[cur.vertex]) continue; 

			// MST 포함
			visitied[cur.vertex] = true;
			result += cur.weight;
			cnt++;

			if(cnt == v) break; 

			for(Data data : list[cur.vertex]) {
				if(!visitied[data.vertex]) {
					pq.offer(new Data(data.vertex, data.weight));
				}
			}

		}

		System.out.println(result);


	}

}
