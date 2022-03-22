import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.02.22
 * 서로소 집합
 */
public class D4_3289 {
	static int n, parent[];
	
	// 기본 집합 생성 
	public static void makeSet() {
		parent = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			parent[i] = i;
		}
	}
	
	// a의 대표자 찾기 
	public static int findSet(int a) {
		// 스스로가 대표자 => 본인 리턴
		if(a == parent[a]) return a;
		
		
		// path compression 
		parent[a] = findSet(parent[a]);
		return parent[a];
	}
	
	public static void union(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		
		// 대표자가 같으므로 합칠 수 없음 
		if(a == b) return;
		
		parent[b] = a;
		return;
		
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			makeSet(); // 기본 리스트 생성 
			
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				switch(Integer.parseInt(st.nextToken())) {
				case 0 : // 0일 때는 합치기
					union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
					break;
				case 1 : // 1일 때, 같다면 1 다르면 0
					if(findSet(Integer.parseInt(st.nextToken())) == findSet(Integer.parseInt(st.nextToken()))){
						sb.append(1);	
					}else {
						sb.append(0);
					}
					break;
				}
			}
			sb.append("\n");
			
		}
		
		
		System.out.println(sb.toString());
	}
}
