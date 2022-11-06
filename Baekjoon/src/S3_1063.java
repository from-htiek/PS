import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 222.11.06
 * 킹
 */
public class S3_1063 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		String kingPos = st.nextToken(); 
		String stonePos = st.nextToken();
		
		// 킹과 돌의 위치 좌표 변환 A1 => (0, 0)
		int[] king = new int[2];
		king[1] = kingPos.charAt(0) - 'A';
		king[0] = kingPos.charAt(1) - '1';
		int[] stone = new int[2];
		stone[1] = stonePos.charAt(0) - 'A';
		stone[0] = stonePos.charAt(1) - '1';
		
		int n = Integer.parseInt(st.nextToken()); // 움직이는 횟수
		
		int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};
		int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
		for(int i = 0; i < n; i++) {
			if(i == 2) System.out.println("hello");
			String command = br.readLine();
			int dir = -1; 
			switch (command) {
			case "R": // 한 칸 오른쪽 
				dir = 0; 
				break;
			case "L": // 한 칸 왼쪽
				dir = 1; 
				break;
			case "B": // 한 칸 아래로
				dir = 2; 
				break; 
			case "T": // 한 칸 위로
				dir = 3; 
				break; 
			case "RT": // 오른쪽 위 대각선으로
				dir = 4; 
				break; 
			case "LT": // 왼쪽 위 대각선으로
				dir = 5; 
				break; 
			case "RB": // 오른쪽 아래 대각선으로
				dir = 6; 
				break; 
			case "LB": // 왼쪽 아래 대각선으로
				dir = 7; 
				break; 
			}
			
			int newy = king[0] + dy[dir]; // 킹의 새로운 위치 
			int newx = king[1] + dx[dir];
			if(newy < 0 || newy >= 8 || newx < 0 || newx >= 8) continue; // 범위 벗어나면 제외
			if(newy == stone[0] && newx == stone[1]) { // 만약 돌이 있으면 
				int snewy = stone[0] + dy[dir]; // 돌의 새로운 위치 
				int snewx = stone[1] + dx[dir];
				
				if(snewy < 0 || snewy >= 8 || snewx < 0 || snewx >= 8) continue; // 범위 벗어나면 제외
				stone[0] = snewy; // 돌 위치 갱신 
				stone[1] = snewx;
			}
			
			king[0] = newy; // 킹 위치 갱신
			king[1] = newx;
		}
	
		sb.append((char)(king[1] + 'A')).append((char)(king[0] + '1')).append("\n");
		sb.append((char)(stone[1] + 'A')).append((char)(stone[0] + '1')).append("\n");
		System.out.println(sb.toString());

	}
}
