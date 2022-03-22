import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 2022.02.21
 * 컵홀더
 */
public class B2_2810 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] seat = br.readLine().toCharArray();

		int cnt = 0; 
		// 커플석 좌석 개수
		for(int i = 0; i < n; i++) {
			if(seat[i] == 'L') cnt++;
		}
				
		if(cnt == 0) {
			System.out.println(n);
		}else {
			// 컵홀더는 항상 n+1개지만, 커플석은 중간에 컵홀더가 하나 없으므로 빼줘야함 
			// LL => cnt는 2지만 커플석은 하나이므로 나누기 2
			System.out.println(n+1-(cnt/2));
		}
	}
}
