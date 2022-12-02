import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.12.02
 * 회장뽑기
 * 그렇네.. a=>b로가는 최소값 찾기니까 플로이드워셜... 알고리즘 공부도 해야겠다 정말
 */
public class G5_2660 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine()); // 회원 수
		 
		ArrayList<Integer>[] list = new ArrayList[n+1]; // 관계를 나타내는 어레이리스트
		for(int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		while(true) { 
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			if(from == -1 && to == -1) break; // 종료
			
			list[from].add(to);
			list[to].add(from);
		}
		
		int[] distance = new int[n+1]; // 회원 사이의 거리 
		int score = Integer.MAX_VALUE; // 최소 거리 
		
		for(int i = 1; i <= n; i++) {
			boolean[] visitied = new boolean[n+1]; // 중복 체크
			visitied[i] = true;
			
			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[] {i, 0});
			
			int[] cur = null; 
			while(!q.isEmpty()) {
				cur = q.poll();
				
				for(int num : list[cur[0]]) { // 아는 회원 계산
					if(visitied[num]) continue;
					q.offer(new int[] {num, cur[1]+1});
					visitied[num] = true;
				}
			}
			
			distance[i] = cur[1]; // 가장 마지막 거리가 해당 회원에게서 가장 먼 회원임 
			score = Math.min(score, cur[1]);
		}
		
		
		int result = 0; // 후보 수
		for(int i = 1; i <= n; i++) { // 최소 거리의 사람 몇 명인지 구하고, 후보 출력
			if(distance[i] == score) {
				sb.append(i).append(" ");
				result++;
			}
		}
		
		
		System.out.println(score + " " + result);
		System.out.println(sb.toString());
	}
}
