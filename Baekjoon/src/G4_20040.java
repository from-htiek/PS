import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.06.28
 * 사이클 게임
 */
public class G4_20040 {
	static int n, parents[]; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 점의 개수
		int m = Integer.parseInt(st.nextToken()); // 진행된 차례의 수 
		
		makeSet();
		
		for(int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			if(!union(from, to)) {
				System.out.println(i);
				return;
			}
		}
		
		System.out.println(0);
		
		
	}
	
	// 집합 만들기 
	public static void makeSet() {
		parents = new int[n];
		
		for(int i = 0; i < n; i++) {
			parents[i] = i;
		}
	}
	
	// 집합 찾기
	public static int findSet(int a) {
		if(parents[a] == a) return a;
		
		return parents[a] = findSet(parents[a]);
	}
	
	// 집합 합치기
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return false; 
		
		parents[bRoot] = aRoot;
		return true; 
	}
}
