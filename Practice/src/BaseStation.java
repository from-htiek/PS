
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 2022.02.09
 * 기지국 
 * IM 대비문제
 */
public class BaseStation {
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			char map[][] = new char[n][n];
			List<int[]> list = new ArrayList<>();
			int type = 0; // 기지국 타입 A : 1, B : 2, C : 3
			int cnt = 0;  // 집의 수
			String str = null;
			
			// H : 집  A,B,C : 기지국
			for(int i = 0; i < n; i++) {
				str = br.readLine();
				for(int j = 0; j < n; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == 'H') cnt++; // 집 개수 
					else if(map[i][j] != 'H' && map[i][j] != 'X') { // 기지국에 번호 할당해 리스트에 넣기
						if(map[i][j] == 'A') type = 1;
						if(map[i][j] == 'B') type = 2;
						if(map[i][j] == 'C') type = 3;
						list.add(new int[]{type, i,j});
					}
				}
			}
			
			// 확인 
			/*
			for(char[] m : map) {
				System.out.println(Arrays.toString(m));
			}
			
			System.out.println(cnt);
			for(int _ = 0; _ < list.size(); _++) {
				System.out.println(list.get(_)[0] + " : " +  list.get(_)[1] + " : " + list.get(_)[2]);
			}
			*/
			
			// 4 방향 이동
			int[] dx = {-1, 0, 1, 0};
			int[] dy = {0, -1, 0, 1};
			int x = 0;
			int y = 0;
			for(int i = 0; i < list.size(); i++) {
				for(int j = 1; j < list.get(i)[0]+1; j++) { // A는 1칸, B는 2칸, C는 3칸 
					//x = list.get(i)[2] + j;
					//y = list.get(i)[1] + j;
					
					for(int k = 0; k < 4; k++) { // 기지국 종류마다 해당 칸만큼 탐색
						x = list.get(i)[1] + j * dy[k];
						y = list.get(i)[2] + j * dx[k];
						
						if(wall(x, y) && map[x][y] == 'H') { // 집이면 'X'로 바꾸기
							map[x][y] = 'X';
							cnt--;
						}
					}
				}
			}

			
			System.out.printf("#%d %d\n", tc, cnt);
			
		}
	}
	
	static boolean wall(int x, int y) {
		if(x >= 0 && x < n && y >= 0 && y < n) return true;
		else return false;
	}
}
