import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 2022.10.31
 * Fly me to the Alpha Centauri
 * y의 최대값이 21억인데 이걸 어떻게 하면 풀 수 있을까
 */
public class G5_1011 {
	public static class point implements Comparable<point>{
		long pos;
		long prev;
		long cnt;

		public point(long pos, long prev, long cnt) {
			super();
			this.pos = pos;
			this.prev = prev;
			this.cnt = cnt;
		}


		@Override
		public String toString() {
			return "point [pos=" + pos + ", prev=" + prev + ", cnt=" + cnt + "]";
		}


		@Override
		public int compareTo(point o) {
			return Long.compare(o.pos, this.pos);
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int t = Integer.parseInt(br.readLine()); 
		
		for(int tc = 0; tc < t; tc++) { // 테스트 케이스만큼 반복
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); // 현재 위치
			int y = Integer.parseInt(st.nextToken()); // 목표 위치 
			
			
			long result = 0; 
			int[] dx = {1, 0, -1};
//			boolean[] visitied = new boolean[y];
			PriorityQueue<point> pq = new PriorityQueue<>();
//			visitied[x] = true;
			pq.offer(new point(x, 0, 0));
			
			while(!pq.isEmpty()) {
				point cur = pq.poll();
				
//				System.out.println(cur);
				if(cur.pos == y-1) {
					result = cur.cnt+1;
					break; 
				}
				
				for(int d = 0; d < 3; d++) {
					long newPos = cur.pos + (cur.prev + dx[d]);
					
					if(newPos >= y || newPos < 0) continue;
//					if(visitied[newPos]) continue;
					
					
//					visitied[newPos] = true;
					pq.offer(new point(newPos, (cur.prev + dx[d]), cur.cnt+1));
				}
			}
			
			System.out.println(result);
			
		}
	}
}
