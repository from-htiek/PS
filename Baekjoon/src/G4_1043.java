import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 2022.09.17
 * 거짓말
 */
public class G4_1043 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 사람 수
		int m = Integer.parseInt(st.nextToken()); // 파티 수
		
		
		boolean[][] check = new boolean[n+1][n+1];
		st = new StringTokenizer(br.readLine());
		Queue<Integer> q = new LinkedList<>(); // 진실을 알고 있는 사람 
		int num = Integer.parseInt(st.nextToken());
		for(int i = 0; i < num; i++) {
			q.offer(Integer.parseInt(st.nextToken()));
		}
		
		int[] party = new int[n+1]; // 파티에 몇 번 가는지 체크 하는 배열
		for(int p = 0; p < m; p++) { // m번의 파티만큼 반복
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			
			if(num == 1) {
				party[Integer.parseInt(st.nextToken())]++; //
			}else {
				int index = Integer.parseInt(st.nextToken());
				party[index]++;
				while(st.hasMoreTokens()) { // 같이 온 사람 체크
					check[index][Integer.parseInt(st.nextToken())] = true; 
				}	
			}
		}
		
//		for(boolean[] c : check) {
//			System.out.println(Arrays.toString(c));
//		}
		
		while(!q.isEmpty()) { // 진실을 알고 있는 사람 체크
			int cur = q.poll();
			party[cur] = -1;
			
			for(int i = 1; i <= n; i++) {
				if(check[i][cur] || check[cur][i]) { // 같이 파티에 온 적 있다면 체크 
					if(party[i] == -1) continue;
					party[i] = -1;
					q.offer(i);
				}
			
			}
		}
		
//		System.out.println(Arrays.toString(party));
		
		
		int result = 0;
		for(int i = 1; i <= n; i++) {
			if(party[i] != -1) result += party[i];
		}
		
		System.out.println(result);
		
	}
}
