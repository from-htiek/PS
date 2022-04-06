import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.04.06
 * 키 순서
 */
public class D4_5643 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine()); // 학생 수
			int m = Integer.parseInt(br.readLine()); // 키 비교 횟수
			
			int[][] student = new int[n][n];
			List<Integer>[] list = new ArrayList[n+1]; // 본인 보다 큰 키를 나타내는 리스트
			List<Integer>[] reverseList = new ArrayList[n+1]; // 본인보다 작은 키를 나타내는 리스트 
			for(int i = 1; i <= n; i++) {
				list[i] = new ArrayList<>(); // 초기화
				reverseList[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < m; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				list[start].add(end);
				reverseList[end].add(start);
			}
			
			// 입력확인
/*			for(List l : list) {
				System.out.println(l);
			}
			
			for(List l : reverseList) {
				System.out.println(l);
			}*/

			int result = 0; 
			for(int i = 1; i <= n; i++) {
				boolean[] v1 = new boolean[n+1]; // 큰 키 방문 체크
				boolean[] v2 = new boolean[n+1]; // 작은 키 방문 체크
				int cnt = 0; // 본인 보다 큰 학 생 + 작은 학생의 합
				Queue<Integer> q = new LinkedList<>();
				q.offer(i);
				v1[i] = true;
				
				while(!q.isEmpty()) { 
					int cur = q.poll();
					for(int num : list[cur]) {
						if(!v1[num]) {
							v1[num] = true; 
							q.offer(num);
							cnt++;
						}
					}
				}
				
				q.offer(i);
				v2[i] = true;
				
				while(!q.isEmpty()) {
					int cur = q.poll();
					for(int num : reverseList[cur]) {
						if(!v1[num]) {
							v1[num] = true; 
							q.offer(num);
							cnt++;
						}
					}
				}
				
				if(cnt == n-1) result++; // // 본인을 제외한 키큰 학생과 작은 학생을 더한 수는 n-1과 같음  
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
			
		}
		
		System.out.println(sb.toString());
	}
}
