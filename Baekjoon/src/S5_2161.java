import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


/*
 * 2022.09.21
 * 카드1
 */
public class S5_2161 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine()); // 카드 갯수

		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= n; i++) {
			q.offer(i);
		}
		
		while(q.size() >= 1) {
			sb.append(q.poll()).append(" ");
			
			Integer num = q.poll();
			if(num == null) {
				break; 
			}
			
			q.offer(num);
		}
		
		System.out.println(sb.toString());
		
	}
}
