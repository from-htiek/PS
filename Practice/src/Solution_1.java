import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1 {
	public static class pos{
		int y;
		int x;
		int value;
		
		public pos(int y, int x, int value) {
			super();
			this.y = y;
			this.x = x;
			this.value = value;
		}

		@Override
		public String toString() {
			return "pos [y=" + y + ", x=" + x + ", value=" + value + "]";
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine().trim());
			
			boolean[][] map = new boolean[31][31];
			pos[] house = new pos[n];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()) + 15;
				int y = Integer.parseInt(st.nextToken()) + 15;
				int value = Integer.parseInt(st.nextToken());
				house[i] = new pos(y, x, value);
				map[y][x] = true; // 집 표시
			}
			
			int result = Integer.MAX_VALUE; 
			for(int i = 0; i < 31; i++) {
				for(int j = 0; j < 31; j++) {
					if(map[i][j]) continue; // 집이 있는 곳은 불가능
					boolean flag = true; 
					int sum = 0;
					for(int h = 0; h < house.length; h++) {
						int len = Math.abs(house[h].y - i) + Math.abs(house[h].x - j); // 거리 계산 
						if(len > house[h].value) { // 거리 벗어나면 더이상 계산 할 필요 없음 
							flag = false;
							break; 
						}
						sum += len; 
 					}
					
					if(flag) { // 유효할 때만 거리 계산
//						System.out.println(sum);
						result = Math.min(result, sum);
					}
				}
			}
			
			if(result != Integer.MAX_VALUE) { // 1개로 모든 집을 커버할 수 있다면 
				sb.append("#").append(tc).append(" ").append(result).append("\n");
				continue; 
			}
			

			for(int i = 0; i < 31; i++) {
				for(int j = 0; j < 31; j++) {
					for(int k = 0; k < 31; k++) {
						for(int l = 0; l < 31; l++) {
							if(i == k && j == l) continue; // 같은 위치면 제외
							if(map[i][j]) continue; // 집이 있는 곳은 불가능
							if(map[k][l]) continue; 
							
							boolean flag = true; 
							int sum = 0; 
							for(int h = 0; h < house.length; h++) {
								int len1 = Math.abs(house[h].y - i) + Math.abs(house[h].x - j);
								int len2 = Math.abs(house[h].y - k) + Math.abs(house[h].x - l);
		 					
								if(len1 > house[h].value && len2 > house[h].value) {
									flag = false;
									break;
								}
								else if(len1 > house[h].value && len2 <= house[h].value) sum += len2;
								else if(len1 <= house[h].value && len2 > house[h].value) sum += len1;
								else sum += Math.min(len1, len2);
//								sum += Math.min(len1, len2);
							}
							
							if(flag) {
//								System.out.println(sum);
								result = Math.min(result, sum);
							}

						}
					}
				}
			}
			
			if(result != Integer.MAX_VALUE) { // 1개로 모든 집을 커버할 수 있다면 
				sb.append("#").append(tc).append(" ").append(result).append("\n");
			}else {
				sb.append("#").append(tc).append(" ").append(-1).append("\n");
			}
			
		}
		
		System.out.println(sb.toString());
	}

}
