import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.09.14
 * 톱니바퀴
 * 바퀴는 순차적으로 돌지 않는다! 
 */
public class G5_14891 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		char[][] wheel = new char[5][8];
		for(int i = 1; i < 5; i++) {
			wheel[i] = br.readLine().toCharArray();
		}
		
		int k = Integer.parseInt(br.readLine()); // 회전 횟수
		
		int[][] index = new int[5][2]; // 위치 저장
		for(int i = 1; i < 5; i++) {
			index[i][0] = 2;
			index[i][1] = 6;
		}
		
		int[] dx = {-1, 1}; 
		for(int t = 0; t < k; t++) { // 회전 횟수만큼 반복
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()); // 회전시킨 톱니바퀴 번호
			int direction = Integer.parseInt(st.nextToken()); // 방향, 1은 시계 방향 -1은 반시계방향
			
			boolean[] visitied = new boolean[5];
 			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[] {num, direction});
			visitied[num] = true;
			
			int[][] _index = new int[5][2];
			for(int i = 1; i < 5; i++) {
				_index[i][0] = index[i][0];
				_index[i][1] = index[i][1];
			}
			
			
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				
				for(int d = 0; d < 2; d++) {
					int next = cur[0] + dx[d];
					
					if(next <= 0 || next > 4) continue; // 범위 벗어나면 제외
					if(visitied[next]) continue; // 이미 체크했다면 제외
					
					if(d == 0) {
						if(wheel[next][index[next][0]] == wheel[cur[0]][index[cur[0]][1]]) continue;
					}else {
						if(wheel[next][index[next][1]] == wheel[cur[0]][index[cur[0]][0]]) continue;
					}

					_index[next][0] = (index[next][0] + cur[1] + 8) % 8; 
					_index[next][1] = (index[next][1] + cur[1] + 8) % 8; 
					q.offer(new int[] {next, cur[1] * -1});
					visitied[next] = true;
				}
			}
			
			_index[num][0] = (index[num][0] + direction * -1 + 8) % 8; 
			_index[num][1] = (index[num][1] + direction * -1 + 8) % 8; 
			
			index = _index; 
			
//			for(int[] i : index) {
//				System.out.println(Arrays.toString(i));
//			}
//			for(int i = 1; i < 5; i++) {
//				System.out.println(wheel[i][index[i][0]] + " " + wheel[i][index[i][1]]);
//			}
			
			
		}
		
		int[] score = {0, 1, 2, 4, 8};
		int result = 0; 
		for(int i = 1; i < 5; i++) {
			if(wheel[i][(index[i][0] - 2 + 8) % 8] == '1') {
				result += score[i];
			}
		}
		
		System.out.println(result);
		
		
	}
}
