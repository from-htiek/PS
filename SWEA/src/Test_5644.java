import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.02.16
 * 무선 충전 
 */
public class Test_5644 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken()); // 총 이동시간
			int a = Integer.parseInt(st.nextToken()); // BC 개수
			int[][] move = new int[2][m+1]; // A, B의 이동정보, 0 인덱스 : 시작
			int[][] ap = new int[a][4]; // AP의 정보,  0: x 위치, 1 : y위치, 2 : 충전범위, 3 : 성능
			int[] personA = {0, 0}; // 현재 A의 위치
			int[] personB = {9, 9}; // 현재 B의 위치
			int[] dx = {0, 0, 1, 0, -1}; // 0 : 이동X, 1 : 위, 2 : 우, 3 : 하, 4: 좌
			int[] dy = {0, -1, 0, 1, 0};
			
			// 이동정보 입력
			for(int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j < m+1; j++) {
					move[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			
			// AP 정보 입력
			for(int i = 0; i < a; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 4; j++) {
					ap[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			for(int i = 0; i <= m; i++) {
				// 1초당 A,B 위치 변화
				personA[0] += dy[move[0][i]];
				personA[1] += dx[move[0][i]];
				personB[0] += dy[move[1][i]];
				personB[1] += dx[move[1][i]];
				
				System.out.println(personA[0] + " " + personA[1] + " " + personB[0] + " " + personB[1]);
			}
			
			
			

		}
		
	}
}
