import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.10.19
 * 친구비
 */
public class G4_16562 {
	public static int n, parents[], cost[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 학생 수
		int m = Integer.parseInt(st.nextToken()); // 친구 관계 수
		int k = Integer.parseInt(st.nextToken()); // 가지고 있는 돈 
		
		cost = new int[n+1]; // 친구비 배열 
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
	
		makeSet(); // 최소 단위 집합 만들기
		
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); // 친구 관계 형성
		}
		
		int money = 0;
		for(int i = 1; i <= n; i++) {
			if(parents[i] == -1) money += cost[i]; // 대표자 찾아 친구비 계산
		}
		
		if(money <= k) System.out.println(money);
		else System.out.println("Oh no");
		
	}
	
	public static void makeSet() {
		parents = new int[n+1];
		for(int i = 1; i <= n; i++) {
			parents[i] = -1; // -1로 초기화 => -1 개수를 세면 집단 개수 확인 가능
		}
	}
	
	public static int findSet(int a) {
		if(parents[a] == -1) return a;
		
		// path compression
		return parents[a] = findSet(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return false;
		
		if(cost[aRoot] > cost[bRoot]) parents[aRoot] = bRoot;
		else parents[bRoot] = aRoot;
		return true;
	}
}
