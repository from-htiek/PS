import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.02.21
 * 롤 케이크
 * 
 * 백준 정답 코드 1페이지에 갔다 !! 
 */
public class B1_3985 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int l = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		boolean[] cake = new boolean[l+1]; // 0 인덱스 사용X
		int p1 = 0; // 가장 많은 조각을 받을 것으로 기대하고 있던 방청객 
		int p2 = 0; // 실제로 가장 많은 조각을 받은 방청객
		int result1 = 0; // p1이 받은 케이크 조각 수
		int result2 = 0; // p2가 받은 케이크 조각 수
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			// 기대되는 방청객
			if(result1 < end-start+1) {
				p1 = i;
				result1 = end-start+1;
			}
			
			// 실제 방청객
			int cnt = 0;
			for(int j = start; j <= end; j++) {
				if(!cake[j]) {
					cake[j] = true;
					cnt++;
				}
			}
			// 여러명인 경우에는 번호가 작은사람 출력하므로 '=' 쓰지 않음
			if(result2 < cnt) {
				p2 = i;
				result2 = cnt;
			}
			
			
		}
		
		System.out.println(p1);
		System.out.println(p2);
		
		
	}
}
