import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.04.06
 * 사람 네트워크2
 * 플로이드 워셜 알고리즘으로 풀었다 
 * 하지만 주어진 조건에서는 큐에 넣고 bfs로 푸는게 더 빠른 듯 하다. 
 */
public class D6_1263 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[][] matrix = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
					if(i != j && matrix[i][j] == 0) matrix[i][j] = 99999; // 조건이 양의 정수이므로 최대값
				}
			}
			
			for(int k = 0; k < n; k++) { // 경유지
				for(int i = 0; i < n; i++) { // 출발지
					if(k == i) continue;
					for(int j = 0; j < n; j++) { // 도착지 
						if(k == j || i == j) continue; 
						if(matrix[i][j] > matrix[i][k] + matrix[k][j])  matrix[i][j] = matrix[i][k] + matrix[k][j]; // 갱신
							
					}
				}
			}
			
/*			for(int[] m : matrix) {
				System.out.println(Arrays.toString(m));
			}*/
			
			int result = Integer.MAX_VALUE;
			
			for(int i = 0; i < n; i++) {
				int sum = 0;
				for(int j = 0; j < n; j++) {
					sum += matrix[i][j];
				}
				
				result = Math.min(result, sum);
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
			
		}
		
		System.out.println(sb.toString());

	}
}
