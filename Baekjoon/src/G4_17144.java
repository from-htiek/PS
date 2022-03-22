import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/*
 * 2022.02.25
 * 미세먼지 안녕! 
 */
public class G4_17144 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken()); // 방의 행
		int c = Integer.parseInt(st.nextToken()); // 방의 열
		int t = Integer.parseInt(st.nextToken()); // t초 후

		int[][] dust = new int[r][c];
		int upperIdx = 0;
		int lowerIdx = 0; 
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < c; j++) {
				dust[i][j] = Integer.parseInt(st.nextToken());

				if(dust[i][j] == -1) {
					if(upperIdx == 0) upperIdx = i;
					else lowerIdx = i;	
				}
			}
		}

		int[] dy = {1, -1, 0, 0};
		int[] dx = {0, 0, 1, -1};


		for(int tc = 0; tc < t; tc++) { // t초 동안 반복 
			int[][] diffusion = new int[r][c]; // 확산 후 먼지 
			for(int i = 0; i < r; i++) {
				for(int j = 0 ; j < c; j++) {
					if(dust[i][j] == 0) continue; // 먼지가 없으면 제외 

					int d = dust[i][j];
					int spread = d/5; 
					for(int k = 0; k < 4; k++) {
						int newy = i + dy[k];
						int newx = j + dx[k];

						if(newy < 0 || newy >= r || newx < 0 || newx >= c) continue; // 범위 벗어나면 제외

						if(dust[newy][newx] == -1) continue; // 공기청청기 있으면 제외

						diffusion[newy][newx] += spread;
						d -= spread;
					}

					diffusion[i][j] += d;
				}
			}

			diffusion[upperIdx][0] = -1;
			diffusion[lowerIdx][0] = -1;

			// 확산 후 방 상태 확인 
//			for(int[] d : diffusion) {
//				System.out.println(Arrays.toString(d));
//			}

			dust = diffusion; // t초동안 반복문을 돌아야하므로 할당

			// 공기청정기 윗 부분 
			// 위 -> 아래
			for(int i = upperIdx-1; i > 0 ; i--) {
				dust[i][0] = dust[i-1][0];
			}

			// 우 -> 좌
			for(int i = 0; i < c-1; i++) {
				dust[0][i] = dust[0][i+1];
			}

			// 아래 -> 위
			for(int i = 0; i < upperIdx; i++) {
				dust[i][c-1] = dust[i+1][c-1];
			}

			// 좌 -> 우
			for(int i = c-1; i > 1; i--) {			
				dust[upperIdx][i] = dust[upperIdx][i-1];
			}

			dust[upperIdx][1] = 0;


			// 공기 청정기 아랫부분 

			// 아래 -> 위
			for(int i = lowerIdx+1; i < r-1; i++) {
				dust[i][0] = dust[i+1][0];
			}

			// 우 -> 좌
			for(int i = 0; i < c-1; i++) {
				dust[r-1][i] = dust[r-1][i+1];
			}


			// 위 -> 아래
			for(int i = r-1; i > lowerIdx-1; i--) {
				dust[i][c-1] = dust[i-1][c-1];
			}

			// 좌 -> 우
			for(int i = c-1; i > 1; i--) {
				dust[lowerIdx][i] = dust[lowerIdx][i-1];
			}

			dust[lowerIdx][1] = 0;


//			System.out.println("===========");
//			for(int[] d : dust) {
//				System.out.println(Arrays.toString(d));
//			}

		}
		
		int result = 0; 
		for(int i = 0; i < r; i++) {
			for(int j = 0 ; j < c; j++) {
				result += dust[i][j];
			}
		}

		System.out.println(result+2); // 공기청정기로 빠진 -2 다시 더해줌 
	}
}
