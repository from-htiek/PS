import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 2022.02.22
 * 나머지
 * 
 * 
 * set을 이용하는 방법 => 중복 허용 X 
 */
public class B2_3052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] visitied = new boolean[42]; // 나머지 체크 
		int cnt = 0; // 서로 다른 나머지 개수
		
		for(int i = 0; i < 10; i++) {
			int num = Integer.parseInt(br.readLine());
			int remainder = num % 42;
			
			if(!visitied[remainder]) { // 배열값이 false면 아직 해당 나머지였던적이 없었다는 뜻
				visitied[remainder] = true;
				cnt++;
			}
			
		}
		
		System.out.println(cnt);
	}
}