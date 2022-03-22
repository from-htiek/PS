import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.02.16
 * 영식이와 친구들
 * 
 * dlwodnsdl
 * 짝수일 때 조건 => idx = (idx-l+n)%n 
 * 
 * while문 시작을 list[idx]++ 로 했으면 list[0] = 1을 주지 않아도 될 듯
 */
public class B2_1592 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // n까지 자리
		int m = Integer.parseInt(st.nextToken()); // 공 받는 횟수
		int l = Integer.parseInt(st.nextToken()); // 공 던지는 간격
		int[] list = new int[n]; // 0 인덱스 사용 X
		list[0] = 1; // 1번은 제일 먼저 공을 받음 
		int cnt = 0; // 공 던진 횟수
		
		int idx = 0; // 현재 공 가진 사람 
		while(true) {	
			if(list[idx] == m) break;
			
			if(list[idx] % 2 == 1) { // 받은 횟수 홀수
				idx = (idx+l)%n; 
				list[idx]++;
			}else { // 받은 횟수 짝수
				idx -= l; 
				if(idx < 0) idx += n; 
				list[idx]++;
			}
			
			cnt++;
		}
		
		System.out.println(cnt);
		
	}
}
