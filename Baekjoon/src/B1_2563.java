import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.02.10
 * 색종이
 * 
 * dohyonne 
 * paper를 int말고 boolean값으로 준다면 메모리도 덜 차지하고 더 빠르게 계산가능
 */
public class B1_2563 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] paper = new int[100][100];
		int cnt = 0;
		int x = 0;
		int y = 0;
		for(int _ = 0; _ < n; _++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			// 넓이만큼 색칠
			for(int i = x; i < x+10; i++) {
				for(int j = y; j < y+10; j++) {
					paper[i][j] = 1;
				}
			}
		}
		
		// 확인
//		for(int[] p : paper) {
//			System.out.println(Arrays.toString(p));
//		}
		
		// 색칠한 넓이 구하기
		for(int i = 0; i <100; i++) {
			for(int j = 0; j < 100; j++) {
				if(paper[i][j] == 1) cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
