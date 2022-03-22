import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2022.02.27
 * 오목 판정
 */
public class D3_11315 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			char[][] board = new char[n][n];
			
			for(int i = 0; i < n; i++) {
				board[i] = br.readLine().toCharArray();
			}
			
			int[] dy = {-1, 0, 1, 1}; // 4방위 
			int[] dx = {1, 1, 1, 0};
			boolean flag = false; 
			
			outerloop : for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++){
					if(board[i][j] != '.') { // 돌이 있을 때 
						
						for(int k = 0; k < 4; k++) { // 4방위 탐색
							for(int l = 1; l < 5; l++) { // 현재 돌을 제외한 4개의 돌 더 확인 
								int newy = i + dy[k]*l;
								int newx = j + dx[k]*l;
								
								if(newy < 0 || newy >= n || newx < 0 || newx >= n) break; // 범위 벗어나면 제외
								
								if(board[newy][newx] == '.') break;// 돌이 아니면 제외
									
								if(l == 4) { // 오목 판정이 가능하다면 더이상 탐색 X
									flag = true;
									break outerloop;
								}
							}
						}
					}
				}
			}
			
			if(flag) {
				System.out.println("#" + tc + " YES");
			}else {
				System.out.println("#" + tc + " NO");
			}
		}
	}

}
