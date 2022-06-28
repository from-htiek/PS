import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.06.28
 * 최소 스패닝 트리
 */
public class G4_1197 {
	static class Edge implements Comparable<Edge>{
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
		
		@Override
		public String toString() {
			return start + " " + end + " " + weight;  
		}
	}
	
	static int v, parents[];
	static Edge[] edgeList; 
	
	// Kruskal 알고리즘 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken()); // 정점 개수
		int e = Integer.parseInt(st.nextToken()); // 간선 개수
		edgeList = new Edge[e];
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edgeList[i] = new Edge(start, end, weight); // 간선 값 입력 
		}
		
		Arrays.sort(edgeList); // 오름차순으로 정렬		
		makeSet();
		
		int result = 0; // MST의 가중치
		int cnt = 0; // MST는 v-1개의 선의 가짐 
		
		for(Edge edge : edgeList) { // 전체 간선을 돌면서 
			if(union(edge.start, edge.end)) { // 두 정점을 연결 할 수 있을때만 MST에 포함 시킴
				result += edge.weight;
				if(++cnt == v-1) break; 
			}
		}
		
		System.out.println(result);
	}
	
	// 단위 집합 만들기 
	public static void makeSet() {
		parents = new int[v+1];
		
		for(int i = 1; i <= v; i++) {
			parents[i] = i;
		}
	}
	
	// a의 집합 찾기
	public static int findSet(int a) {
		if(parents[a] == a) return a;
		
		return parents[a] = findSet(parents[a]);
	}
	
	// a, b 집합 합치기 
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return false; 
		
		parents[bRoot] = aRoot;
		return true;
	}
}
