import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.02.11
 * 배열 돌리기 3
 */
public class S1_16935 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken()); // 회전수
		int[][] arr = new int[n][m];
		int[][] rotation = new int[m][n];
		int tmp = 0;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		// r만큼 반복
		for(int cnt = 0; cnt < 1; cnt++) {
			switch(st.nextToken()) {
			case "1" : // 1. 상하반전
				for(int i = 0; i < n/2; i++) {
					for(int j = 0; j < m; j++) {
						tmp = arr[i][j];
						arr[i][j] = arr[n-i-1][j];
						arr[n-i-1][j] = tmp;
					}
				}
				break;
				
			case "2" : // 좌우반전
				for(int i = 0; i < n; i++) {
					for(int j = 0; j < m/2; j++) {
						tmp = arr[i][j];
						arr[i][j] = arr[i][m-j-1];
						arr[i][m-j-1] = tmp;
					}
				}
				break;
				
			case "3" : // 오른쪽 90도
				// 상하 반전 후
				for(int i = 0; i < n/2; i++) {
					for(int j = 0; j < m; j++) {
						tmp = arr[i][j];
						rotation[i][j] = arr[n-i-1][j];
						rotation[n-i-1][j] = tmp;
					}
				}
				// 대각선 교환 
//				for(int i = 0; i < n; i++) {
//					for(int j = 0; j < n; j++) {
//						if(i==j) continue;
//						tmp = rotation[i][j];
//						rotation[j][i] = rotation[i][j];
//						rotation[i][j] = rotation[j][i];
//					}
//				}
				
			}

			
			for(int[] a : arr) {
				System.out.println(Arrays.toString(a));
			}

		}
		
	}
}
