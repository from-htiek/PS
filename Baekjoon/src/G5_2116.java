import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.12.01
 * 주사위 쌓기
 */
public class G5_2116 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null; 
		int n = Integer.parseInt(br.readLine());
		int[][] dices = new int[n][7];
		
		for(int i = 0; i < n; i++) { // 주사위 입력
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < 7; j++) {
				dices[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] order = {0, 6, 4, 5, 2, 3, 1}; // 서로 마주보는 인덱스
		int result = 0; // 옆면의 합 최대값 
		
		for(int i = 1; i <= 6; i++) { // 첫번째 주사위의 바닥에 올 수 있는 숫자는 1~6 
			int num = i; // 현재 기준이 되는 숫자
			int opposite = order[num]; 
			int sum = 0; // 현재 숫자를 기준으로 쌓았을 때 최대값
			
			for(int j = 0; j < n; j++) { // n개의 주사위 쌓기
				int max = 0; // 현재 주사위에서의 최대값 
				int tmp = 0; // 다음 주사위의 아랫면
				
				for(int k = 1; k <= 6; k ++) { // 주사위 6개의 면 보기 
					if(j != n-1 && dices[j+1][k] == dices[j][opposite]) tmp = k; 
					if(k == dices[j][num] || k == dices[j][opposite]) continue;
					max = Math.max(max, k);
				}

				sum += max;
				num = tmp; // 다음 주사위 아랫면
				opposite = order[num]; // 다음 주사위 윗면
			}

			result = Math.max(sum, result); // 최대값 갱신 
		}
		
		System.out.println(result);
		
		
		
		
	}
}
