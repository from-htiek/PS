import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.06.24
 * 마인크래프트
 * 이 문제를 왜 이렇게 헤맸을까? 
 * 들어오는 입력값이 500*500이라서 3중 for문을 돌면서 완전 탐색을 해도 충분한 문제인데 결국 다른 분들 코드를 참고함ㅠ
 * 
 * 나와 다른 생각으로 구현된 코드 
 * https://www.acmicpc.net/source/18056892
 * 1차원 배열로 입력을 받아 해당 높이의 땅이 몇 개 있는지 구한 다음 
 * for문으로 0~256을 돌면서 1차원 배열의 값이 0이 아닐 때 차이를 더해주거나 빼주는 코드 
 */
public class S2_18111 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); 
		int m = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken()); // 인벤토리에 들어있는 블록 수 
		
		int[][] map = new int[n][m];
		
		int max = 0; // 최대 높이
		int min = 9999; // 최소 높이 
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				max = Math.max(max, map[i][j]);
				min = Math.min(min, map[i][j]);
			}
		}

		int resultHeight = -1; // 높이
		int resultTime = Integer.MAX_VALUE; // 시간  

		for(int i = min; i <= max; i++) { // 땅의 높이가 가장 낮은 것부터 높은 것 까지 비교 
			int inventory = b; // 인벤토리에 들어 있는 블록 수 
			int time = 0;

			for(int j = 0; j < n; j++) {
				for(int k = 0; k < m; k++){
					int diff = map[j][k] - i; // 만들려고 하는 땅이 높이와 해당 땅의 높이 차이
					
					if(diff > 0) { // 블록을 제거해야할 때 
						inventory += diff;
						time += (2*diff);
					}else if(diff < 0) { // 블록을 쌓아야 할 때 
						inventory -= Math.abs(diff);
						time += Math.abs(diff); 
					}
				}
			}
			
			if(inventory >= 0) { // 블록이 0개 이상 남았을 때 
				if(resultTime > time) {
					resultTime = time;
					resultHeight = i; 
				}else if(resultTime == time && resultHeight < i) {
					resultHeight = i;
				}
			}
		}
		
		System.out.printf("%d %d", resultTime, resultHeight);
		
		 
	}
}
