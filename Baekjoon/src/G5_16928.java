import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.09.03
 * 뱀과 사다리 게임
 * 처음에는 hash map을 썼다. 배열을 쓰면 최대 n, m이 각각 최대 15라 30칸 밖에 쓰지않으니 낭비라고 생각했으니까.
 * 하지만 돌려보니 배열이 메모리를 더 적게 썼다...... 또 이건 당연한거지만 hash.get(key)를 하는 것보다 map[key]가 훨씬 빨랐다
 * 결국 hashmap을 써서 좋을 게 하나도 없었던.. 
 * 그리고 처음에는 visitied에 최대값을 넣고 방문 횟수가 작을때만 q에 넣을 수 있도록 했는데 다른 분들 코드를 보다보니 그럴 필요가 없다는 걸 알았다
 * 결국 먼저 방문하는 값이 장땡이였음
 */
public class G5_16928 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 사다리 수
		int m = Integer.parseInt(st.nextToken()); // 뱀의 수
		
		int[] map = new int[101]; // 이동 정보 저장 
		for(int i = 0; i < n+m; i++) { 
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			map[from] = to;
		}
		
		int[] visitied = new int[101]; // 최소값 방문 체크 
//		Arrays.fill(visitied, Integer.MAX_VALUE);
		
		// BFS
		Queue<Integer> q = new LinkedList<>();
		q.offer(1); // 시작점
		visitied[1] = 1;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(cur == 100) { // 도착했다면 끝
				System.out.println(visitied[100] - 1);
				return;
			}
			for(int d = 1; d <= 6; d++) { // 주사위는 1~6까지 
				int next = cur + d;
				
				if(next > 100) continue; // 범위 벗어나면 제외
				if(map[next] != 0) next = map[next]; // 사다리나 뱀이 있다면 이동
				if(visitied[next] != 0) continue;
//				if(visitied[next] < visitied[cur] + 1) continue; // 방문체크 값이 더 크다면 제외
				
				q.offer(next);
				visitied[next] = visitied[cur] + 1; 
			}
		}
		
		
	}
}
