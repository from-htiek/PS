import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.02.16
 * 요리사
 * 
 * Arrays.deepToString : 2차원 배열 한번에 보기
 */
public class Test_4012 {
	static int n, result, dish[][];
	static boolean visitied[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			dish = new int[n][n];
			visitied = new boolean[n];
			visitied[0] = true;
			result = Integer.MAX_VALUE;
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					dish[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			

			func(1, 1);
			System.out.printf("#%d %d", tc, result);
		}
		
	}
	
	// 조합 생성
	static void func(int idx, int start) {
		if(idx == n/2) {
			calculate(visitied);
			return;
		}
		
		for(int i = start; i < n; i++) {
			visitied[i] = true;
			func(idx+1, i+1);
			visitied[i] = false;
		}		
	}
	
	// 시너지 계산
	static void calculate(boolean[] visitied) {
		int[] a = new int[n/2];
		int[] b = new int[n/2];
		int aSum = 0;
		int bSum = 0;
		
		for(int i = 0, j = 0, k = 0; i < n; i++) {
			if(visitied[i]) a[j++] = i;
			else b[k++] = i;
		}

		for(int i = 0; i < n/2; i++) {
			for(int j = 0; j < n/2; j++) {
				if (i == j) continue;
				aSum += dish[a[i]][a[j]];
				bSum += dish[b[i]][b[j]];
			}
		}
		
		result = Math.min(result, Math.abs(aSum-bSum));
		return;
	}
}
