import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/*
 * 2022.02.11
 * 배열 돌리기 1
 * 
 * https://yongku.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-16926%EB%B2%88-%EB%B0%B0%EC%97%B4%EB%8F%8C%EB%A6%AC%EA%B8%B01-%EC%9E%90%EB%B0%94Java
 * dx, dy 이용해 범위 안에서 방향 바꾸기
 */
public class S2_16926 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken()); // 회전수
		int[][] arr = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int start = Math.min(m, n) / 2;
		
		for(int cnt = 0; cnt < r; cnt++) {
			for(int idx = 0; idx < start; idx++) {
				int tmp = arr[idx][idx]; // 시작점 저장 배열 크기에 따라 0,0 => 1,1 => 2,2...  
				int nMax = n-idx-1;
				int mMax = m-idx-1;

				// 우 -> 좌
				for(int j = idx; j < mMax; j++) {
					arr[idx][j] = arr[idx][j+1];	
				}

				//아래 -> 위
				for(int j = idx; j < nMax; j++) {
					arr[j][mMax] = arr[j+1][mMax];
				}

				// 좌 -> 우
				for(int j = mMax; j > idx; j--) {
					arr[nMax][j] = arr[nMax][j-1];
				}

				// 위 -> 아래
				for(int j = nMax; j > idx; j--) {
					arr[j][idx] = arr[j-1][idx];
				}
				arr[idx+1][idx] = tmp;
				
			}

//			for(int[] a : arr) {
//				System.out.println(Arrays.toString(a));
//			}
//			System.out.println();

		}
		
		for(int[] a : arr) {
			for(int i : a) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
