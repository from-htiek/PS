import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 * 2022.02.26
 * 오류교정
 */

/* 기존 코드, 90퍼 센트에서 오류남, 원인을 못 찾음 => 예제도 잘려서 나옴 ㅠㅠ 
public class JO_1037 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] message = new int[n][n];

		int[] row = new int[n]; // i행의 1의 개수
		int[] col = new int[n]; // i열의 1의 개수

		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				message[i][j] = Integer.parseInt(st.nextToken());
				if(message[i][j] == 1) {
					row[i]++;
					col[j]++;				
				}
			}
		}

		for(int i = 0; i < n; i++) {
			if(row[i]%2 != 0) break;
			if(col[i]%2 != 0) break;

			if(i == n-1) {
				System.out.println("OK"); // 패리티 성질 가지고 있으면 끝냄
				System.exit(0);
			}
		}





		for(int i = 0; i < n; i++) {
			if(row[i] % 2 != 0) {
				for(int j = 0; j < n; j++) {
					if(message[i][j] == 0) {
						if((col[j]+1) % 2 == 0) {
							System.out.printf("Change bit (%d,%d)", i+1, j+1);
							System.exit(0);
						}
					}else {
						if((col[j]-1) % 2 == 0) {
							System.out.printf("Change bit (%d,%d)", i+1, j+1);
							System.exit(0);
						}
					}
				}
			}
		}

		for(int i = 0; i < n; i++) {
			if(col[i] % 2 != 0) {
				for(int j = 0; j < n; j++) {
					if(message[i][j] == 0) {
						if((row[j]+1) % 2 == 0) {
							System.out.printf("Change bit (%d,%d)", i+1, j+1);
							System.exit(0);
						}
					}else {
						if((row[j]-1) % 2 == 0) {
							System.out.printf("Change bit (%d,%d)", i+1, j+1);
							System.exit(0);
						}
					}
				}
			}
		}

		System.out.println("Corrupt");


	}
}
*/
public class JO_1037 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] message = new int[n][n];
		
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				message[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		int rowCnt = 0;
		int colCnt = 0;
		boolean rowCheck = false;
		boolean colCheck = false;
		int rowIdx = 0;
		int colIdx = 0;
		
		for(int i = 0; i < n; i++) {
			rowCnt = 0;
			colCnt = 0;
			for(int j = 0; j < n; j++) {
				if(message[i][j] == 1) {
					rowCnt++;
				}
				
				if(message[j][i] == 1) {
					colCnt++;
				}
			}
			
			if(rowCnt%2 != 0) {
				// 이 부분이 없으면 90점임 이 3줄 . 
				if(rowCheck) {
					System.out.println("Corrupt");
					System.exit(0);
				}
				rowCheck = true;
				rowIdx = i;
			}
			
			if(colCnt%2 != 0) {
				// 이 부분이 없으면 90점임  ㅇ
				if(colCheck) {
					System.out.println("Corrupt");
					System.exit(0);
				}
				colCheck = true;
				colIdx = i;
			}
		}
		
		if(!rowCheck && !colCheck) {
			System.out.println("OK");
		}else if(rowCheck && colCheck) {
			System.out.printf("Change bit (%d,%d)\n", rowIdx+1, colIdx+1);
		}else {
			System.out.println("Corrupt");
		}
	}
}
