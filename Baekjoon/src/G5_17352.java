import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.06.28
 * 여러분의 다리가 되어 드리겠습니다!
 */
public class G5_17352 {
	static int n, parents[]; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		makeSet();
		
		for(int i = 0; i < n-2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			union(from, to);
			
		}
		
		for(int i = 1; i <= n; i++) {
			if(parents[i] == -1) System.out.printf("%d ", i);
		}
		 
	}
	
	// 대표 집합 만들기 
	public static void makeSet() {
		parents = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			parents[i] = -1; 
		}
	}
	
	// a의 집합 찾기
	public static int findSet(int a) {
		if(parents[a] == -1) return a;
		
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
