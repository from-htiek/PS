import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.06.25
 * 프린터 큐
 */
public class S3_1966 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 문서의 개수
			int m = Integer.parseInt(st.nextToken()); // 찾는 문서 번호
			
			Queue<int[]> q = new LinkedList<>();
			int[] list = new int[n]; 
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				int num = Integer.parseInt(st.nextToken());
				q.offer(new int[] {i, num});
				list[i] = num;
				
			}
			
			Arrays.sort(list);
			
			int idx = n-1;
			int cnt = 0; 
			while(true) {
				int[] cur = q.poll();
				if(cur[1] == list[idx]) {
					idx--; 
					cnt++;
					
					if(cur[0] == m) {
						 break; 
					}
				}else {
					q.offer(cur);
				}
			}
			
			System.out.println(cnt);
			
		}
	}
}
