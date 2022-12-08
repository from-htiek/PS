import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

/*
 * 2022.12.08
 * CD
 * 문제를 잘 읽자! 0, 0이 들어올때까지 입력이 멈추지 않는다. 즉 테스트 케이스가 여러개다... 이걸 놓쳐서 한번 틀리고
 * while문을 처음에 for(int i = 0, size = Math.min(m, n); i < size) 이렇게 돌렸는데
 * 아닐 수도 있다는걸 깨달았다. 바꿨더니 해결.
 * 사실 이분탐색 공부하려고 뽑았던 문제인데, 투 포인터가 더 나은것같다. 내일은 이분탐색 문제를 꼭 풀어야지.
 */
public class S5_4158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 상근이가 가진 CD
			int m = Integer.parseInt(st.nextToken()); // 선영이가 가진 CD
			
			if(n == 0 && m == 0) break; 
			
			int[] geunCD = new int[n];
			int[] youngCD = new int[m];
			for(int i = 0; i < n; i++) {
				geunCD[i] = Integer.parseInt(br.readLine());
			}
			
			for(int i = 0; i < m; i++) {
				youngCD[i] = Integer.parseInt(br.readLine());
			}
			
			int result = 0; // 동시에 가지고 있는 CD 개수
			
			int geun = 0; // 각각 리스트의 포인터
			int young = 0; 
			
			while(true) {
				if(geunCD[geun] == youngCD[young]) { // 같다면 둘 다 포인터 옮기기
					result++;
					young++;
					geun++;
				}
				else if(geunCD[geun] > youngCD[young]) young++; // 상근이 값이 더 크면 선영이 포인터 옮기기
				else geun++; // 반대라면 상근이 포인터 옮기기
			
			
				if(geun >= n || young >= m) break; 
			}
			
			System.out.println(result);
		}
		
	}
}
