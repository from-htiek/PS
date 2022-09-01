import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.09.01
 * 케빈 베이컨의 6단계 법칙
 * 아니 이게 플로이드 워셜 문제였어? 
 */
public class S1_1389 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 유저의 수
		int m = Integer.parseInt(st.nextToken()); // 친구 관계의 수
		int min = Integer.MAX_VALUE;
		int result = n+1;
		
		ArrayList<Integer>[] list = new ArrayList[n+1]; // 인접 리스트 ㅎ
		for(int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			list[from].add(to);
			list[to].add(from);
		}
		
		for(int i = 1; i <= n; i++) { // 모든 사람 체크
			Queue<Integer> q = new LinkedList<>();
			boolean[] visitied = new boolean[n+1]; // 방문 체크 
			q.offer(i);
			visitied[i] = true;
			int total = 0; // 케빈 베이컨의 수
			int cnt = 0; // a와 b사이의 단계 
			
			while(!q.isEmpty()) { // bfs
				int size = q.size();
				cnt++; // 단계 ↑
				
				while(size-- > 0) {
					int cur = q.poll();
					for(int item : list[cur]){
						if(!visitied[item]) {
							visitied[item] = true;
							q.offer(item);
							total += cnt; 
						}
					}
				}
			
			}
			
			if(min > total) { // 케빈 베이컨 수가 더 적다면 결과 바꾸기 
				min = Math.min(total, min);
				result = i;
			}
			else if(min == total) result = Math.min(i, result); // 같다면 번호가 작은 사람
		}
		
		System.out.println(result);
	}
}
