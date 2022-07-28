import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.07.28
 * 로봇
 */
public class S4_13567 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken()); // 정사각형 길이
		int n = Integer.parseInt(st.nextToken()); // 로봇이 수행할 명령어 수 
		
		int[] dy = {0, -1, 0, 1};
		int[] dx = {1, 0, -1, 0};
		int dir = 0; // 처음은 동쪽 방향 
		int cury = 0; // 시작점은 (0, 0);
		int curx = 0; 
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			if(command.equals("MOVE")) { // MOVE 일 때
				cury += dy[dir] * num;
				curx += dx[dir] * num;
			}else { // TURN 일 때
				if(num == 0) dir = (dir + 3) % 4;
				else dir = (dir + 1) % 4; 
				
			}
			
			if(cury < 0 || cury > m || curx < 0 || curx > m) { // 범위 벗어나면 끝
				System.out.println(-1);
				return;
			}
		}

		
		System.out.println(curx + " " + cury);
		
		
		
	}
}
