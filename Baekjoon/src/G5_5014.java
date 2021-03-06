import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.03.21
 * 스타트링크
 */
public class G5_5014 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int f = Integer.parseInt(st.nextToken()); // 건물 전체 층수
		int s = Integer.parseInt(st.nextToken()); // 강호 층수
		int g = Integer.parseInt(st.nextToken()); // 스타트 링크 층수 
		int u = Integer.parseInt(st.nextToken()); // 위로 u층 가는 버튼
		int d = Integer.parseInt(st.nextToken()); // 아래로 d층 가는 버튼 
		boolean[] visitied = new boolean[f+1]; // 인덱스 1 사용 X
		
		// bfs 
		Queue<Integer> q = new LinkedList<>();
		q.offer(s);
		visitied[s] = true;
		int cnt = 0; 
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			while(size-->0) {
				int cur = q.poll();
				
				if(cur == g) {
					System.out.println(cnt);
					return;
				}
				
				int newcur;
				for(int i = 0; i < 2; i++) {
					if(i == 0) newcur = cur+u;
					else newcur = cur-d;
					
					if(newcur < 1 || newcur > f) continue; // 범위를 벗어나면 제외
					if(visitied[newcur]) continue; // 이미 방문했다면 제외 
					
					q.offer(newcur);
					visitied[newcur] = true; 
					
				}
				
			}
			cnt++;
		}
		
		System.out.println("use the stairs");
	}
}
