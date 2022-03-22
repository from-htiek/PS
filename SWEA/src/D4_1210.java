import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 22.02.09
 * Ladder1
 */
public class D4_1210 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int tc = 1; tc <= 10; tc++) {
			br.readLine(); // 테스트 케이스 번호
			int[][] map = new int[100][100];
			String str = null;
			int point = 0; // 도착 지점(2) 좌표
			List<Integer> ladder = new ArrayList<>(); // 사다리 좌표
			
			for(int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i == 0 && map[i][j] == 1) ladder.add(j); // 사다리 있는 곳 추가
					if(i == 99 && map[i][j] == 2) point = j; // 도착 지점 좌표 
				}
			}
			
			
			int idx = 98; // 도착지점 y축 - 1 부터 탐색
			int ladderIdx = ladder.indexOf(point); // 리스트에서 시작점의 인덱스 => 8
			while(idx > 0) {
				// map[idx][point] 도착지점(2) 좌표 
				// 벽인지 체크  & 리스트 이용해 사다리 좌표로 바로 넘어가기
				if(wall(idx, point-1) && map[idx][point-1] == 1) {
					point = ladder.get(--ladderIdx); 
				}else if(wall(idx, point+1) && map[idx][point+1] == 1) {
					point = ladder.get(++ladderIdx);
				}
				idx--;
			}
			
			System.out.printf("#%d %d\n", tc, point);
		}
	}
	
	static boolean wall(int x, int y) {
		if(x >= 0 && x < 100 && y >= 0 && y < 100) return true;
		else return false;
	}
}
