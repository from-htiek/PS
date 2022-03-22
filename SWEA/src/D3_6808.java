import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.02.14
 * 규영이와 인영이의 카드게임 
 */
public class D3_6808 {
	static int t, gyuyoung[], inyoung[], win, lose;
	static boolean visitied[]; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		StringTokenizer st; 

		for(int tc = 1; tc <= t; tc++) {
			gyuyoung = new int[9];
			inyoung = new int[9];
			visitied = new boolean[19];
			win = 0;
			lose = 0; 
			st = new StringTokenizer(br.readLine());
			int num = 0; 
			// 규영 카드 입력 
			for(int i = 0; i < 9; i++) {
				num = Integer.parseInt(st.nextToken());
				gyuyoung[i] = num;
				visitied[num] = true;
			}
			
			// 인영 카드 입력
			int j = 0;
			for(int i = 1; i <= 18; i++) {
				if(!visitied[i]) {
					inyoung[j++] = i;
				}
			}
			
			func(0, 0, 0);
			System.out.printf("#%d %d %d\n", tc, win, lose);
			
		}
		
	}
	
	static void func(int idx, int inyoungSum, int gyuyoungSum) {
		if(idx == 9) {
			if(inyoungSum > gyuyoungSum) lose++;
			else if(inyoungSum < gyuyoungSum) win++;
		
		}
		
		int sum = 0;
		for(int i = 0; i < 9; i++) {
			if(visitied[inyoung[i]]) continue;
			
			visitied[inyoung[i]] = true;
			if(gyuyoung[idx] > inyoung[i]) {
				func(idx+1, inyoungSum, gyuyoungSum+gyuyoung[idx]+inyoung[i]);
			}else if(gyuyoung[idx] < inyoung[i]) {
				func(idx+1, inyoungSum+gyuyoung[idx]+inyoung[i], gyuyoungSum);
			}
			
			visitied[inyoung[i]] = false;

		}
		
	}
}
