import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.02.18
 * 스도쿠 검증
 */
public class D2_1974 {
	static int sumAns, mulAns; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		int[][] sudoku = new int[9][9];
		sumAns = 45; // 1~9까지 합
		mulAns = 362880; // 1~9까지 곱

		for(int tc = 1; tc <= t; tc++) {
			for(int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 9; j++) {
					sudoku[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			if(calculate(sudoku)) System.out.printf("#%d %d\n", tc, 1);
			else  System.out.printf("#%d %d\n", tc, 0);
//			calculate(sudoku);

		}
	}

	static boolean calculate(int[][] sudoku) {

		int xSum = 0;
		int xMul = 1;
		int ySum = 0;
		int yMul = 1;
		int sum = 0;
		int mul = 1; 

		// 가로, 세로 더해 비교
		for(int i = 0; i < 9; i++) {
			xSum = 0;
			xMul = 1;
			ySum = 0;
			yMul = 1;
			for(int j = 0; j < 9; j++) {
				xSum += sudoku[i][j];
				xMul *= sudoku[i][j];
				ySum += sudoku[j][i];
				yMul *= sudoku[j][i];
			}
			
//			System.out.println(xSum + ":" + xMul + " " + ySum + " " + yMul);
			if(xSum != sumAns || xMul != mulAns || ySum != sumAns || yMul != mulAns) {
				return false;
			}
		}

		
		// 9칸씩 나눠 비교
		for(int i = 0; i < 9; i += 3) {
			for(int j = 0; j < 9; j += 3) {
				sum = 0;
				mul = 1;
				for(int k = 0; k < 3; k++) {
					for(int l = 0; l < 3; l++) {
						sum += sudoku[i+k][j+l];
						mul *= sudoku[i+k][j+l];
						//System.out.println((i+k) + " : " + (j+l));
					}
				}
				
				//System.out.println();
				if(sum != sumAns || mul != mulAns) {
					return false;
				}
			}
		}

		return true;

	}
}
