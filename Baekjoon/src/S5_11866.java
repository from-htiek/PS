import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.06.24
 * 요세푸스 문제 0
 */
public class S5_11866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= n; i++) {
			q.offer(i);
		}
		
		while(!q.isEmpty()) {
			for(int i = 0; i < k-1; i++) {
				q.offer(q.poll());
			}
			
			sb.append(q.poll()).append(",").append(" ");
		}
		
		
		sb.deleteCharAt(sb.lastIndexOf(" "));
		sb.deleteCharAt(sb.lastIndexOf(","));
		sb.append(">");
		System.out.println(sb.toString());
		
	}
}
