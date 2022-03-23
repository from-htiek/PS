import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.03.23
 * A -> B
 * 
 * long으로 바꿨더니 풀렸다 
 * 최대값이 10^9였으면 int로 해결이 안되는걸까..?
 * 
 * 다른분들 풀이를 보니 a->b 말고 b->a로 내려오는 방법도 있는듯하다
 */
public class S1_16953 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		
		if(a > b) { // 방법이 모두 숫자가 커질 수 있는것밖에 없으므로 같거나 작은 숫자로는 만들 수 없음
			System.out.println(-1);
			return; 
		}else if(a == b) {
			System.out.println(1);
			return; 
		}
		
		Queue<Long> q = new LinkedList<>();
		long cnt = 1;
		
		q.offer(a);	
		
		while(!q.isEmpty()) {
			
			int size = q.size();
			while(size-->0) {
				long cur = q.poll();
				
				if(cur == b) {
					System.out.println(cnt);
					return;
				}
				
				long newcur = -1; 
				
				for(int i = 0; i < 2; i++) {
					if(i == 0) newcur = cur*2;
					else newcur = cur*10+1;
					
					if(newcur < 0 || newcur > b) continue; // 범위 벗어나면 제외, b보다 커지면 큐에 넣을 필요 없음 
	
					q.offer(newcur);

				} 
			}
			
			cnt++; 

		}
		
		System.out.println(-1);
	}

}
