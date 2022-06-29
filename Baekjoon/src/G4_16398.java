import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 2022.06.29
 * 행성 연결
 * 타입을 잘 보자. result를 int로 하면 틀린다! 값의 최대값이 1억이기 때문에. 
 */
public class G4_16398 {
	static class Data implements Comparable<Data>{
		int vertex, weight;

		public Data(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Data o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
		
		
	}
	
	// Prim + PQ 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine()); // 행성의 수
		int[][] map = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		double result = 0; // 최소 플로우의 관리비용
		boolean[] visitied = new boolean[n]; // MST 포함 여부 체크하는 배열
		PriorityQueue<Data> pq = new PriorityQueue<>();
		pq.offer(new Data(0, 0)); // 임의의 시작점 0 초기화
		
		Data cur = null;
		int cnt = 0; 
		
		while(!pq.isEmpty()) {
			// 1. 행성 선택
			cur = pq.poll();
			if(visitied[cur.vertex]) continue; // 이미 MST에 포함된 행성이면 제외
			
			// 2. 행성 포함 
			visitied[cur.vertex] = true; 
			result += cur.weight;
			cnt++;
				
			if(cnt == n) break; // 행성 n개를 다 선택했다면 MST 완성
			
			// 3. 현재 행성과 연결된 행성들의 최소 관리 비용 갱신
			for(int i = 0; i < n; i++) {
				if(visitied[i]) continue; // 이미 MST에 포함된 행성이면 제외 
				if(map[cur.vertex][i] == 0) continue; // 선택된 행성과 연결되지 않은 행성이면 제외
				
				pq.offer(new Data(i, map[cur.vertex][i])); 
			}
		}
		
		System.out.printf("%.0f", result);
	}
}
