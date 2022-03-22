import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.02.18
 * 최적 경로
 */
public class D5_1247 {
	public static class position{
		int y;
		int x;
		
		position(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	static int n;
	static boolean visitied[];
	static position customer[], company, home;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			visitied = new boolean[n];
			
			customer = new position[n];
			st = new StringTokenizer(br.readLine());
			company = new position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for(int _ = 0; _ < n; _++) {
				customer[_] = new position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			func(0, 0);
			
		}
		
	}
	
	//permutation
	static void func(int idx, int distance) {
		if(idx == n) {
			return;
		}
		
		for(int i = 0; i < n; i++) {
			
		}
	}
}
