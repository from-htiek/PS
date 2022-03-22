import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2022.02.17
 * N-Queen
 */
public class D3_2806 {
	static int n, list[], result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t ; tc++) {
			n = Integer.parseInt(br.readLine());
			list = new int[n+1]; // Queen이 놓아진 열
			result = 0;
			
			setQueen(0);
			System.out.printf("#%d %d\n", tc, result);
		}
	}
	
	public static void setQueen(int idx) { // 현재 Queen의 열
		if(idx == n) {
			result++;
			return;
		}
		
		for(int _ = 0; _ < n; _++) { // n개의 열까지
			list[idx] = _;
			if(pruning(idx)) { // 유망하다면
				setQueen(idx+1);
			}
		}
	}
	
	public static boolean pruning(int idx) {
		for(int _ = 0; _ < idx; _++) {
			if(list[idx] == list[_]) { // 놓아진 열이 같으면 false
				return false;
			}
			
			if(Math.abs(idx-_) == Math.abs(list[idx]-list[_])) { // 대각선에 위치하면 false
				return false;
			}
		}
		return true;
	}
}
