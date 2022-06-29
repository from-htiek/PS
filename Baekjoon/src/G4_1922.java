import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.06.29
 * 네트워크 연결
 */
public class G4_1922 {
	
	public static class Edge implements Comparable<Edge>{

		int from, to, weight;
			
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	
	static int n, parents[];
	static Edge[] edgeList; 
	
	// Kruskal
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); // 컴퓨터 수
		int m = Integer.parseInt(br.readLine()); // 선의 수 
		edgeList = new Edge[m];
		StringTokenizer st = null;
		
		for(int i = 0; i < m; i++) { // 간선 추가 
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edgeList[i] = new Edge(from, to, weight);
		}
		
		Arrays.sort(edgeList); // 간선 비용의 오름차순 정렬
		makeSet();
		
		int result = 0; // 최소비용
		int cnt = 0; // 간선 수 
		
		for(Edge edge : edgeList) {
			if(union(edge.from, edge.to)) { // 서로 다른 집합일 때 연결 
				result += edge.weight;
				cnt++; 
				
				if(cnt == n-1) break; // n-1개의 간선으로 연결되면 MST 완성
			}
		}
		
		System.out.println(result);
	}
	
	public static void makeSet() {
		parents = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			parents[i] = i;
		}
	}
	
	public static int findSet(int a) {
		if(parents[a] == a) return a;
		
		return parents[a] = findSet(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return false; 
		
		parents[bRoot] = aRoot;
		return true; 
	}
	
}
