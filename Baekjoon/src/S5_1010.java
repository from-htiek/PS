import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.04.01
 * 다리놓기
 * 조합을 구하는 문제였는데 이걸 dp로 풀라고? 하는 생각을 했으나 
 * 테이블을 그려놓고 조합 규칙을 찾으니 금방 찾을 수 있었음 
 * 조합도 dp로 풀 수 있구나.. 새롭다 
 */
public class S5_1010 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		int[][] map = new int[31][31];
		
		Arrays.fill(map[0], 1);
		for(int i = 1; i < 31; i++) {
			for(int j = i ; j < 31; j++) {
				map[i][j] = map[i][j-1] + map[i-1][j-1];
			}
		}
		
		
		StringBuilder sb = new StringBuilder();
		for(int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			sb.append(map[n][m]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
