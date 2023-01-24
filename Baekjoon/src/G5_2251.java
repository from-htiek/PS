import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2023.01.24
 * 물통
 * 다시 풀어도 너무 헷갈린다 @_@..
 * 함수로 빼서 visitied[a][b][c]의 값이 true일 때 바로 return을 해버리면 일일이 체크를 할 필요가 없었네
 * 아니면 그냥 처음에 설계했던 대로 q에 일단 넣고 위에서 체크하는게 더 나았을 것 같기도하다
 */
public class G5_2251 {
	public static class water {
		int a;
		int b;
		int c;
		
		public water(int a, int b, int c) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
		}
		
		@Override
		public String toString() {
			return "water [a=" + a + ", b=" + b + ", c=" + c + "]";
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());		
		
		ArrayList<Integer> result = new ArrayList<>(); // C에 담길 수 있는 용량
		boolean[][][] visitied = new boolean[201][201][201]; // 방문 체크
		Queue<water> q = new LinkedList<>();
		
		q.offer(new water(0, 0, C)); // 시작점
		visitied[0][0][C] = true;
		while(!q.isEmpty()) {
			water cur = q.poll();
			
			if(cur.a == 0) result.add(cur.c); // a가 0일 때 C에 담겨있는 물의 양 
			
			// C -> A
			int min = Math.min(A - cur.a, cur.c);
			if(!visitied[cur.a + min][cur.b][cur.c - min]) {
				visitied[cur.a + min][cur.b][cur.c - min] = true;
				q.offer(new water(cur.a + min, cur.b, cur.c - min));
			}
			
			// C -> B
			min = Math.min(B - cur.b, cur.c);
			if(!visitied[cur.a][cur.b + min][cur.c - min]) {
				visitied[cur.a][cur.b + min][cur.c - min] = true;
				q.offer(new water(cur.a, cur.b + min, cur.c - min));
			}
			
			// A -> B
			min = Math.min(B - cur.b, cur.a);
			if(!visitied[cur.a - min][cur.b + min][cur.c]) {
				visitied[cur.a - min][cur.b + min][cur.c] = true;
				q.offer(new water(cur.a - min, cur.b + min, cur.c));
			}
			
			// A -> C
			min = Math.min(C - cur.c, cur.a);
			if(!visitied[cur.a - min][cur.b][cur.c + min]) {
				visitied[cur.a - min][cur.b][cur.c + min] = true;
				q.offer(new water(cur.a - min, cur.b, cur.c + min));
			}
			
			// B -> A
			min = Math.min(A - cur.a, cur.b);
			if(!visitied[cur.a + min][cur.b - min][cur.c]) {
				visitied[cur.a + min][cur.b - min][cur.c] = true;
				q.offer(new water(cur.a + min, cur.b - min, cur.c));
			}
			
			
			// B -> C
			min = Math.min(C - cur.c, cur.b);
			if(!visitied[cur.a][cur.b - min][cur.c + min]) {
				visitied[cur.a][cur.b - min][cur.c + min] = true;
				q.offer(new water(cur.a, cur.b - min, cur.c + min));
			}
			
		}
		
		Collections.sort(result);

		for(int num : result) {
			System.out.printf("%d ", num);
		}
	}
}
