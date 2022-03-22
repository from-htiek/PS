import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2022.02.27
 * 달팽이 숫자
 * 
 * 참고 
 * https://gist.github.com/ii200400/290795e2e78a992b0a014b4ac8c449c9
 * 진짜 엄청나다 .. @_@
 */
public class D2_1954_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] snail = new int[n][n];
			int num = 1; // 숫자 1부터 시작
			int max = (int) Math.pow(n, 2); // 입력될 최대 숫자 
			int dy = 0; // y의 변화값, x의 변화값 
			int dx = 1;
			
			// 입력값이 조건값보다 작을동안 y, x를 달팽이 모양으로 옮김
			for(int y = 0, x = 0; num <= max; y += dy, x += dx) {
				snail[y][x] = num; 
				num++;
				
				// 범위를 벗어남 OR 이미 값이 있음 => 방향 바꿔야함
				if(y + dy < 0 || y + dy >= n || x + dx < 0 || x + dx >= n || snail[y+dy][x+dx] != 0) {
					// 달팽이 순서 dx(+) => dy(+) => dx(-) => dy(-)
					// dy = 0, dx = 1
					// dy = 1, dx = 0
					// dy = 0, dx = -1
					// dy = -1, dx = 0
					int tmp = dy;
					dy = dx;
					dx = -tmp; 
					
				}
			}
			
			for(int[] y : snail) {
				for(int x : y) {
					System.out.print(x + " ");
				}
				System.out.println();
			}
		}
	}
}
