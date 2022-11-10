import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 2022.11.10
 * 강의실
 */
public class G5_1374 {
	public static class lecture implements Comparable<lecture>{
		int no;
		int start;
		int end;
		
		public lecture(int no, int start, int end) {
			super();
			this.no = no;
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(lecture o) {			
			return Integer.compare(this.end, o.end);
		}

		@Override
		public String toString() {
			return "lecture [no=" + no + ", start=" + start + ", end=" + end + "]";
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine()); // 강의 개수
		
		lecture[] list = new lecture[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int no = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list[i] = new lecture(no, start, end);
		}
		
		// 강의시간이 일찍 시작하고 일찍 끝나는 순서대로 정렬
		Arrays.sort(list, new Comparator<lecture>() {

			@Override
			public int compare(lecture o1, lecture o2) {
				if(o1.start == o2.start) {
					return Integer.compare(o1.end, o2.end);
				}
				return Integer.compare(o1.start, o2.start);
			}
		});
		
		
		PriorityQueue<lecture> pq = new PriorityQueue<>();
		pq.offer(list[0]);
		
		for(int i = 1; i < n; i++) {
			lecture cur = pq.peek(); // 가장 일찍 끝나는 강의
			
			if(list[i].start >= cur.end) { // 그 강의보다 늦게 시작하면 강의실 사용 가능 
				pq.poll();
			}
			
			pq.offer(list[i]);
		}
		
		System.out.println(pq.size());
	}
}
