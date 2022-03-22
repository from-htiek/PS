import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.02.28
 * 숨바꼭질
 * 
 * 입정 배열을 사용하면 n의 최댓값이 20_000의 제곱은 4억으로 메모리 초과 
 * 
 */
public class S1_6118 {
	//static int n, m, map[][], visitied[], num, distance, qty;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<Integer>[] list = new ArrayList[n+1]; // 인접배열로 하니 메모리 초과 -> 인접 리스트로 변경
		int[] visitied = new int[n+1];
		
		for(int i = 1; i <= n; i++) { // 리스트 초기화
			list[i] = new ArrayList<>();
		}
		
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b); // 양방향 그래프
			list[b].add(a);
		}

		//System.out.println(Arrays.toString(list));
		
		// bfs 
		Queue<Integer> q = new LinkedList<>();
		q.offer(1); // 수혀니는 1번부터 찾음 
		visitied[1] = 1; 
		
		int cnt = 0; // 같은 거리를 갖는 헛간의 개수
		int num = 0; // 헛간 번호 
		while(!q.isEmpty()) {
			num = Integer.MAX_VALUE;
			cnt = q.size();
			int size = q.size();

			while(size-- > 0) { // 같은 깊이의 헛간 계산위해 
				int cur = q.poll();
				num = Math.min(num, cur); // 거리가 같은 헛간이 여러개면 가장 작은 헛간 번호 출력 
				
				for(int i : list[cur]) {
					if(visitied[i] == 0) {
						q.offer(i);
						visitied[i] = visitied[cur]+1;
					}
				}

			}
			
		}
		
		
		System.out.printf("%d %d %d\n", num, visitied[num]-1, cnt);
		
	
	}
}
