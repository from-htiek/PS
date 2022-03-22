import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.02.18
 * Z
 * 
 * 아마 처음했던 size가 2일 때 cnt를 세는 방법도 모든 4분할 재귀를 다 돌지 않으면 터지지않을지도
 */
public class S1_1074 {
	static int r, c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		//cnt = 0;
		
		
		func(0, 0, (int)Math.pow(2, n), 0);
		
	}
	
	static void func(int y, int x, int size, int cnt){
		
		// 값 찾으면 종료
		if(y == r && x == c) {
			System.out.println(cnt);
			System.exit(0);
		}
		
		// 크기가 1이면 return
		if(size == 1) return;
		
		
		int half = size/2;
		// 조건이 없으면 터짐
		// 4분할 모두 돌기때문에
		// r, c의 위치에 따라 재귀 돌 부분만 들어감
		if(r < y+half && c < x+half) func(y, x, half, cnt);
		else if(r < y+half && c >= x+half) func(y, x+half, half, cnt+half*half);
		else if(r >= y+half && c < x+half) func(y+half, x, half, cnt+half*half*2);
		else func(y+half, x+half, half, cnt+half*half*3);		
	}
}
