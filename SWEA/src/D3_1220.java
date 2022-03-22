import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.02.23
 * Magnetic
 */
public class D3_1220 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int tc = 1; tc <= 10; tc++) {
			br.readLine(); 
			int[][] table = new int[100][100]; // 100*100 배열
			int cnt = 0; // 교착 상태 수
			
			
			// 1 : N극 성질 가지는 자성체, 2 : S극 성질을 가지는  자성체
			for(int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 1을 만난 상태(flag = true)에서 2를 만나면 무조건 교착상태 생김
			for(int i = 0; i < 100; i++) {
				boolean flag = false; // 새로운 열이 시작되면 flag 초기화
				for(int j = 0; j < 100; j++) {
					if(table[j][i] == 1) {
						flag = true;
					}else if(table[j][i] == 2 && flag) {
						cnt++; 
						flag = false; // 연속된 교착상태 있을 수 있으므로 flag 초기화
					}
					
				}
			}
			
			System.out.printf("#%d %d\n", tc, cnt);

		}
	}
}
