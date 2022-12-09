import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 2022.12.09
 * 하얀 칸
 */
public class B2_1100 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] map = new char[8][8];
		
		for(int i = 0; i < 8; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int[] dy = {1, 1, -1, -1};
		int[] dx = {1, -1, 1, -1};
		
		int result = 0; 
		boolean[][] visitied = new boolean[8][8];
		Queue<int[]> q = new LinkedList<>();
		if(map[0][0] == 'F') result++;
		q.offer(new int[] {0, 0});
		visitied[0][0] = true;
			
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int newy = cur[0] + dy[d];
				int newx = cur[1] + dx[d];
				
				if(newy < 0 || newy >= 8 || newx < 0 || newx >= 8) continue;
				if(visitied[newy][newx]) continue;
				
				if(map[newy][newx] == 'F') result++;
				q.offer(new int[] {newy, newx});
				visitied[newy][newx] = true;
			}
		}
		
		System.out.println(result);
		
	}
}
