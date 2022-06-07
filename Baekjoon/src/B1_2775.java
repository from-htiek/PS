import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2022.06.07
 * 부녀회장이 될테야
 */
public class B1_2775 {
	public static void main(String[] args) throws IOException {
		int[][] apt = new int[15][15]; // 전체 아파트 인구수 계산
		for(int i = 0; i < 15; i++) {
			apt[0][i] = i;
		}
		
		for(int i = 1; i < 15; i++) {
			for(int j = 1; j < 15; j++) {
				apt[i][j] = apt[i][j-1] + apt[i-1][j];
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < t; tc++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			System.out.println(apt[k][n]);
		}
				
		
	}
}
