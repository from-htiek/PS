import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * 2022.12.19
 * 이모티콘
 * 문제 이해를 잘못한것 같은데..?
 */
public class G4_14226 {
	public static class number implements Comparable<number>{
		int num;
		int cnt;
		
		public number(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(number o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cnt, o.cnt);
		}

		@Override
		public String toString() {
			return "number [num=" + num + ", cnt=" + cnt + "]";
		} 
		
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int s = scanner.nextInt();
		
		PriorityQueue<number> pq = new PriorityQueue<>();
		pq.offer(new number(1, 0));

		while(!pq.isEmpty()) {
			number cur = pq.poll();
			
			if(cur.num == s) {
				System.out.println(cur.cnt);
				return;
			}
			
			for(int d = 0; d < 3; d++) {
				int news = -1; 
				int newcnt = -1;
				if(d == 0) {
					news = cur.num * 2;
					newcnt = cur.cnt + 2; 
				}
				else if(d == 1) {
					news = cur.num - 1;
					newcnt = cur.cnt + 1;
				}
				else {
					if(s % cur.num == 0) {
						news = s; 
						newcnt = cur.cnt + s / cur.num;
					}
				}
				
				if(news < 1 || news > 1002) continue;
				pq.offer(new number(news, newcnt));
				
			}
		
		}
	}
}
