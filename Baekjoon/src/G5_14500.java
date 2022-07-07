import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.07.07
 * 테트로미노
 * 참고했던 반례
 * https://www.acmicpc.net/board/view/61597
 */
public class G5_14500 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		int result = 0;
		
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				int sum = 0; 
				// 'ㅣ' 모양
				if(i+3 < n && i+2 < n && i+1 < n) sum = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+3][j];
				result = Math.max(result, sum);
				
				// 'ㅡ' 모양
				if(j+3 < m && j+2 < m && j+1 < m) sum = map[i][j] + map[i][j+1] + map[i][j+2] + map[i][j+3];
				result = Math.max(result, sum);				
				
				// 'ㅁ' 모양
				if(i+1 < n && j+1 < m) sum = map[i][j] + map[i+1][j] + map[i][j+1] + map[i+1][j+1];
				result = Math.max(result, sum);
				
				// 'L' 모양
				if(i+1 < n && i+2 < n && j+1 < m) sum = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+2][j+1];
				result = Math.max(result, sum);
				
				// 'L' 대칭 모양
				if(i+1 < n && i+2 < n && j-1 >= 0) sum = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+2][j-1];
				result = Math.max(result, sum);
				
				// 긴 'ㄱ' 모양
				if(i+1 < n && i+2 < n && j+1 < m) sum = map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i+2][j+1];
				result = Math.max(result, sum);
				
				// 긴 'ㄱ' 대칭 모양
				if(i+1 < n && i+2 < n && j+1 < m) sum = map[i][j] + map[i][j+1] + map[i+1][j] + map[i+2][j];
				result = Math.max(result, sum);
				
				// 'ㄱ' 모양
				if(j+1 < m && j+2 < m && i+1 < n) sum = map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j+2];
				result = Math.max(result, sum);
				
				// 'ㄱ' 대칭 모양
				if(j+1 < m && j+2 < m && i+1 < n) sum = map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j];
				result = Math.max(result, sum);
				
				//' ㄴ' 모양
				if(j+1 < m && j+2 < m && i+1 < n) sum = map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+1][j+2];
				result = Math.max(result, sum);
				
				// 'ㄴ' 대칭 모양
				if(j+1 < m && j+2 < m && i-1 >= 0) sum = map[i][j] + map[i][j+1] + map[i][j+2] + map[i-1][j+2];
				result = Math.max(result, sum);
				
				// 'ㄹ' 모양
				if(j+1 < m && j+2 < m && i+1 < n) sum = map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i+1][j+2];
				result = Math.max(result, sum);
				
				// 'ㄹ' 대칭 모양
				if(j+1 < m && j+2 < m && i-1 >= 0) sum = map[i][j] + map[i][j+1] + map[i-1][j+1] + map[i-1][j+2];
				result = Math.max(result, sum);
				
				// 'ㄹ' 왼쪽 회전
				if(i-1 >= 0 && i-2 >= 0 && j-1 >= 0) sum = map[i][j] + map[i-1][j] + map[i-1][j-1] + map[i-2][j-1];
				result = Math.max(result, sum);
				
				// 'ㄹ' 오른쪽 회전
				if(i-1 >= 0 && i-2 >= 0 && j+1 < m) sum = map[i][j] + map[i-1][j] + map[i-1][j+1] + map[i-2][j+1];
				result = Math.max(result, sum);
				
				// 'ㅜ' 모양
				if(j+1 < m && j+2 < m && i+1 < n) sum = map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j+1];
				result = Math.max(result, sum);
				
				// 'ㅗ' 모양
				if(j+1 < m && j+2 < m && i-1 >= 0) sum = map[i][j] + map[i][j+1] + map[i][j+2] + map[i-1][j+1];
				result = Math.max(result, sum);
				
				// 'ㅏ' 모양
				if(i+1 < n && i+2 < n && j+1 < m) sum = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+1][j+1];
				result = Math.max(result, sum);
				
				// 'ㅓ' 모양
				if(i+1 < n && i+2 < n && j-1 >= 0) sum = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+1][j-1];
				result = Math.max(result, sum);
			}
			
		}
		
		System.out.println(result);
	}
}
