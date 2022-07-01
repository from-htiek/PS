import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.07.01
 * 도시  분할 계획
 * 마을을 나눈다는게 이런 뜻이였구나 했던 문제였다.
 * 최소 비용으로 집들을 연결하면서 마을을 나누려면 MST를 연결하고나서 제일 마지막에 연결한 집을 끊어버리면 
 * 마을은 두개가 되고 최소비용으로 유지가 가능하다
 * MST는 원래 v-1개의 선을 가지지만 마을을 나누기 위해 v-2로 선을 가지면 분리 가능하다. 
 */
public class G4_1647 {
	public static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}
		
	}
	
	static int n, parents[];
	
	// Kruskal
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Edge[] edgeList = new Edge[m];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
		
			edgeList[i] = new Edge(from, to, weight);
		}
		
		Arrays.sort(edgeList); // weight 기준으로 정렬 
		
		makeSet();
		
		double result = 0; // 최소 유지비 
		int cnt = 0; 
		
		for(Edge edge : edgeList) {
			if(union(edge.from, edge.to)) {
//				System.out.println(edge);
				result += edge.weight;
				cnt++;
				
				if(cnt == n-2) break; // 마을을 2개로 나누기 위해 마지막 선 제거  
			}
		}
		
		System.out.printf("%.0f", result);

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
