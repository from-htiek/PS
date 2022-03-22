import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2022.02.19
 * 벌집
 */
public class B2_2292 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 1;
		int start = 1; // 1부터 시작
		
		while(true) {
			if(n <= start) {
				System.out.println(cnt);
				break;
			}
			// 6의 배수로 커지는 등비수열
			start += 6*cnt; 
			cnt++;
		}
	}
}
