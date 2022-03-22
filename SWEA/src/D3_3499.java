import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.02.09
 * 퍼펙트 셔플
 */
public class D3_3499 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			String[] card = new String[n+1];
			st = new StringTokenizer(br.readLine());
			sb = new StringBuilder();
			
			for(int _ = 0; _ < n; _++) {
				card[_] = st.nextToken();
			}
			
			sb.append("#" + tc + " ");
			
			// n이 짝수일 때
			if(n%2 == 0) {
				for(int _ = 0; _ < n/2; _++) {
					sb.append(card[_]).append(" ");
					sb.append(card[_+n/2]).append(" ");
				}
			// n이 홀수일 때
			}else {
				for(int _ = 0; _ < n/2; _++) {
					sb.append(card[_]).append(" ");
					sb.append(card[_+n/2+1]).append(" ");
				}
				sb.append(card[n/2]);
			}
			
			System.out.println(sb.toString());

		}
	}
}
