import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthSplitPaneUI;

/*
 * 2022.02.23
 * 아기 상어
 * 
 * 못 풀어서 교수님 코드 보면서 따라적듯이 풀었음 => 다시 꼭 풀어보자. 
 */
public class G3_16236 {
	static int n, area[][], dy[], dx[], result;
	static Shark shark; 

	static class Shark{
		int y;
		int x;
		int size; 
		int cnt;

		Shark(int y, int x, int size, int cnt) {
			this.y = y;
			this.x = x;
			this.size = size;
			this.cnt = cnt;
		}

	}

	static class Fish implements Comparable<Fish>{
		int y;
		int x;
		int distance; 

		public Fish(int y, int x) {
			this.y = y;
			this.x = x;
		}

		public Fish(int y, int x, int distance) {
			this.y = y;
			this.x = x;
			this.distance = distance;
		}

		@Override
		public int compareTo(Fish o) {
			if(this.distance == o.distance) {
				if(this.y == o.y) return this.x - o.x; // 거리 같고, y축도 같다면 왼쪽 
				else return this.y - o.y; // 거리만 간다면 위쪽
			}else return this.distance - o.distance; // 기본은 거리순
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		n = Integer.parseInt(br.readLine()); // 공간 크기
		area = new int[n][n];
		result = 0; // d

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());

				if(area[i][j] == 9) { // 상어 입력
					shark = new Shark(i, j, 2, 0);
					area[i][j] = 0; // 상어 위치 기록 후 0으로 초기화
				}
			}
		}

		while(bfs());
		
		System.out.println(result);


	}

	public static boolean bfs() {
		Queue<Fish> q = new LinkedList<>();
		int[][] visitied = new int[n][n]; // 방문배열 & 거리 
		List<Fish> list = new ArrayList<>(); // 먹을 수 있는 물고기 리스트
		dy = new int[]{1, 0, -1, 0}; // 4 방위
		dx = new int[]{0, 1, 0, -1};

		for(int i = 0; i < n; i++) {
			Arrays.fill(visitied[i], -1); // 0번 이동 포함 => -1로 초기화
		}

		q.offer(new Fish(shark.y, shark.x));
		visitied[shark.y][shark.x] = 0; // 상어 위치 


		while(!q.isEmpty()) {
			Fish cur = q.poll();

			for(int i = 0; i < 4; i++) { // 4 방위 탐색
				int newy = cur.y + dy[i];
				int newx = cur.x + dx[i];

				// 바운더리 범위를 넘지않음 & 상어의 크기보다 물고기가 같거나 작음 & 방문하지 않았을 경우
				if(newy >= 0 && newy < n && newx >= 0 && newx < n && shark.size >= area[newy][newx]
						&& visitied[newy][newx] == -1) {
					visitied[newy][newx] = visitied[cur.y][cur.x]+1;

					// 물고기가 있음 & 그 물고기가 상어보다 작음 => 먹을 수 있는 물고기
					if(area[newy][newx] != 0 && area[newy][newx] < shark.size) {
						list.add(new Fish(newy, newx, visitied[newy][newx]));
					}

					q.offer(new Fish(newy, newx));
					
				}
			}
		}
		
		
		if(list.size() == 0) return false; // 더 이상 잡아 먹을 물고기 없음 
		Collections.sort(list); // 조건 대로 정렬
		Fish fish = list.get(0); // 0번째 => 지금 잡아먹을 수 있는 물고기 

		result += fish.distance; // 이동한 거리(= 시간)
		shark.y = fish.y; // 잡아먹은 물고기로 위치 변경
		shark.x = fish.x;
		area[fish.y][fish.x] = 0; // 먹은 물고기 자리 초기화

		shark.cnt++;

		if(shark.cnt == shark.size) { // 먹은 물고기와 크기가 같아지면 커짐 
			shark.size++;
			shark.cnt = 0;
		}

		return true;


	}
}
