import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 2022.02.12
 * 숨바꼭질
 * 
 * https://velog.io/@leeinae/Algorithm-%EB%B0%B1%EC%A4%801697-%EC%88%A8%EB%B0%94%EA%BC%AD%EC%A7%88
 * visitied를 int 배열로주고 +1해서 cnt로 쓰기
 */
public class S1_1697 {
	static int n, k;
	static boolean visitied[] = new boolean[100001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		bfs();
	}

	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		int cnt = 0;
		while(!q.isEmpty()) {
			int size = q.size();

			while(--size >= 0) {
				int cur = q.poll(); // 현재 위치
				visitied[cur] = true;

				if(cur == k) { // 동생 위치에 도착하면 종료
					System.out.println(cnt);
					return;
				}
				
				if(cur+1 < 100001 && !visitied[cur+1] ) q.offer(cur+1);
				if(cur-1 >= 0 && !visitied[cur-1] ) q.offer(cur-1);
				if(cur*2 < 100001 && !visitied[cur*2] ) q.offer(cur*2);
			}
			System.out.println(q);
			cnt++;
		}

	}
}
