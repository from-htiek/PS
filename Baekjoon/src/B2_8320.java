import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2022.02.24
 * 직사각형을 만드는 방법
 */
public class B2_8320 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0; 
		
		// 만들 수 있는 직사각형의 수 = n까지 수의 약수 페어들의 수
		// 약수 페어 ex) 8 => (1,8), (2,4)
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= (int)Math.sqrt(i); j++) { // 1부터 제곱근까지 돌면서 나눠보기
				if(i % j == 0) cnt++;
				
			}
		}
		
		System.out.println(cnt);

	}
}
