import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 2022.02.07
 * 햄버거 다이어트
 */
public class D3_5215 {
	static int n, total, scoreResult, score[], calorie[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for(int tc = 1; tc < t+1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			total = Integer.parseInt(st.nextToken());
			score = new int[n];
			calorie = new int[n];
			scoreResult = 0;

			for(int _ = 0; _ < n; _++) {
				st = new StringTokenizer(br.readLine(), " ");
				score[_] = Integer.parseInt(st.nextToken());
				calorie[_] = Integer.parseInt(st.nextToken());
			}

//			System.out.println(Arrays.toString(score));
//			System.out.println(Arrays.toString(calorie));
			
			func(0, 0, 0);
			System.out.printf("#%d %d\n", tc, scoreResult);

		}
	}
	
	static void func(int idx, int scoreSum, int calSum) {
		if(idx == n) {
			if(calSum <= total && scoreSum > scoreResult) scoreResult = scoreSum;
			return;
		}
		
		func(idx+1, scoreSum+score[idx], calSum+calorie[idx]);
		func(idx+1, scoreSum, calSum);
	}
}
