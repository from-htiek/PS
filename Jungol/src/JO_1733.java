import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.02.27
 * 오목
 */
public class JO_1733 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] board = new int[19][19];
		
		for(int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 19; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] dy = {0, 1, 1, -1}; // 4방위
		int[] dx = {1, 1, 0, 1};
		int flag = 0; // 승부 확인  
		int resulty = 0;
		int resultx = 0;
		
		for(int i = 0; i < 19; i++) {
			for(int j = 0; j < 19; j++) {
				if(board[i][j] != 0) { // 바둑돌이 있을 때
					int num = board[i][j]; // 해당 바둑돌 색깔 저장
					
					for(int k = 0; k < 4; k++) {
						for(int l = 1; l < 5; l++) { // 해당위치로 부터 차례로 확인 
							int newy = i + dy[k]*l; // 4방위 탐색
							int newx = j + dx[k]*l;
							
							if(newy < 0 || newy >= 19 || newx < 0 || newx >= 19) break; // 범위 벗어나면 제외
							
							if(board[newy][newx] != num) break; // 색깔 다르면 제외
							
							if(l == 4) { // 오목 완성했을 때, 육목 확인 
								newy += dy[k];
								newx += dx[k];
								
								if(newy >= 0 && newy < 19 && newx >= 0 && newx < 19 && board[newy][newx] == num) { 
									break; 
								}
								
								newy = i - dy[k];
								newx = j - dx[k];
								
								if(newy < 0 || newy >= 19 || newx < 0 || newx >= 19 || board[newy][newx] != num) { 
									flag += num;
									resulty = i;
									resultx = j; 
								}
								
							}
							
						}
					}
				}
			}
		}
		
		if(flag == 0) {
			System.out.println(0);
		}else {
			System.out.println(flag);
			System.out.printf("%d %d\n", resulty+1, resultx+1);
		}
		 
	}
}
