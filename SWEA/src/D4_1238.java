import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.02.21
 * Contact
 * 
 * 따로 리스트로 관리하지 않고 size 초기화해주는 부분에서 max값을 초기화화면서
 * Math.max로 비교했어도 괜찮지않을까 
 */
public class D4_1238 {
	static int n, route[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken()); // 정점의 수
			int m = Integer.parseInt(st.nextToken()); // 시작점
			route = new int[n+1][n+1]; // 0 인덱스 사용 X

			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n/2; i++) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				route[start][end] = 1; // 방향성 있는 그래프
			}

			System.out.printf("#%d %d\n", tc, bfs(m));
		}
	}

	static int bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visitied = new boolean[n+1]; // 방문 확인 배열
		ArrayList<Integer> tmp = new ArrayList<Integer>(); // 연락받은 사람 목록
		int result = 0; // 반환 결과값
		int length = 0; // 마지막 레벨의 큐 길이
		q.offer(start);

		while(!q.isEmpty()) {
			int size = length = q.size();

			while(size-- > 0) { // 한 레벨에서 연락받을 사람 큐에 넣기
				int cur = q.poll();
				visitied[cur] = true;

				for(int i = 0; i < n+1; i++) {
					if(route[cur][i] == 1 && !visitied[i]) {
						tmp.add(i); // 연락받은 사람 목록에 추가
						q.offer(i);
						visitied[i] = true;
					}

				}

			}

		}

		//System.out.println(tmp);

		// 연락 받은 사람 목록 중, 마지막 레벨의 큐의 길이 만큼 반복문 => 최댓값 찾기
		for(int idx = tmp.size()-1, i = idx; i > idx-length; i--) {
			result = Math.max(result, tmp.get(i));
		}
		
		return result;

	}
}
