import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.07.12
 * 어디에 단어가 들어갈 수 있을까
 */
public class D2_1979 {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 퍼즐의 가로, 세로 길이
			int k = Integer.parseInt(st.nextToken()); // 단어의 길이 
			
			int[][] puzzle = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					puzzle[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = 0; // 결과
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j <= n-k; j++) {
					boolean flag = true; 
					for(int l = 0; l < k; l++) {
						if(puzzle[i][j+l] == 0) {
							flag = false; 
							break; 
						}
					}
					
					if(flag && (j+k == n || puzzle[i][j+k] == 0) && (j-1 < 0 || puzzle[i][j-1] == 0)) {
//						System.out.println(i + " " + j);
						result++;
					}
				}
					
			}
			
			
			for(int i = 0; i <= n-k; i++) {
				for(int j = 0; j < n; j++) {
					boolean flag = true; 
					for(int l = 0; l < k; l++) {
						if(puzzle[i+l][j] == 0) {
							flag = false; 
							break; 
						}
					}
					
					if(flag && (i+k == n || puzzle[i+k][j] == 0) && (i-1 < 0 || puzzle[i-1][j] == 0)) {
//						System.out.println(i + " " + j);
						result++;
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
