import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.03.13
 * 집합의 표현
 */
public class G4_1717 {
	static int n, parents[]; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		
		makeSet();
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(command == 0) {
				union(a, b);
			}else {
				if(findSet(a) == findSet(b)) sb.append("YES").append("\n");
				else sb.append("NO").append("\n");
			}
			
			
//			System.out.println(Arrays.toString(parents));
		}
		
		System.out.println(sb.toString());
	
	}
	
	// 자기 자신이 대표인 크기 n 배열 만들기 
	public static void makeSet() {
		parents = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			parents[i] = i;
		}
	}
	
	// num의 집합 찾기 
	public static int findSet(int num) {
		if(num == parents[num]) return num; 
		
		// path compression, 찾은 루트노드로 부모 바꾸기
		return parents[num] = findSet(parents[num]);
	}
	
	// 두 집합 합치기 
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		// 이미 두 집합의 대표자가 같으므로 합칠 수 없음
		if(aRoot == bRoot) return false; 
		
		// 다르다면 한쪽의 대표자를 다른 대표자로 바꿈
		parents[bRoot] = aRoot; 
		return true;
	}
	

}
