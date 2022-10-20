import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.10.20
 * 전력난
 * MST를 복습하면서 Kruskal을 이용해서 문제를 풀었다.
 * 오랜만에 풀어서인지 바로 손에 익지는 않지만, 확실히 여름에 한번 더 봤다고 전에 비해 이해가 빨리 되는것같긴하다.
 * Prim 코드를 보고 Kruskal pq를 이용해서 풀 수 있을 것 같아서 풀어봤는데 생각외로 정렬이 훨씬 빨랐다
 */
public class G4_6497 {
	public static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int weight;
		
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	public static int m, n, parents[];
	public static Edge[] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			m = Integer.parseInt(st.nextToken()); // 집의 수
			n = Integer.parseInt(st.nextToken()); // 길의 수
			
			if(m == 0 && n == 0) break; 
			
			int total = 0;
			
			list = new Edge[n];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				list[i] = new Edge(from, to, weight);
				total += weight;
			}
			
			
			Arrays.sort(list);
			makeSet();
			
			int result = 0;
			int cnt = 0;
			
			for(Edge edge : list) {
				if(union(edge.from, edge.to)) {
					result += edge.weight;
					if(++cnt == n-1) break;
				}
			}
			
			System.out.println(total - result);
		}
	}
	
	public static void makeSet() {
		parents = new int[n];
		
		for(int i = 0; i < n; i++) {
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
		
		parents[aRoot] = bRoot;
		return true;
	}
}	
