import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.06.27
 * 여행 가자
 */
public class G4_1976 {
	static int n, parents[]; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		makeSet(); // 집합 만들기
		
		for(int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++) {
				if(Integer.parseInt(st.nextToken()) == 1) { // 연결된 도시는 합치기 
					union(i, j);
				}
			}
			
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int prev = findSet(Integer.parseInt(st.nextToken()));
		for(int i = 1; i < m; i++) {
			int cur = findSet(Integer.parseInt(st.nextToken()));
			if(prev != cur) { // 전과 비교해 집합이 다르다면 여행할 수 없음 
				System.out.println("NO");
				return; 
			}
			prev = cur; 
		}
		
		System.out.println("YES");
		
		
	}
	
	// 단위 집합 생성
	public static void makeSet() {
		parents = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			parents[i] = i; 
		}
		

	}
	
	// a가 속해있는 집합 찾기 
	public static int findSet(int a) {
		if(a == parents[a]) return a;
		
		return parents[a] = findSet(parents[a]);
	}
	
	// a, b 집합 합치기 
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		// 이미 같은 집합
		if(aRoot == bRoot) return false; 
		
		// 다른 집합 합치기
		parents[bRoot] = aRoot;
		return true; 
		
	}
}
