import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
 * 2022.06.25
 * 비밀번호 찾기
 */
public class S4_17219 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken()); // 저장된 사이트 주소 수
		int m = Integer.parseInt(st.nextToken()); // 비밀번호 찾으려는 사이트 주소 수 
		
		HashMap<String, String> map = new HashMap<>();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			map.put(st.nextToken(), st.nextToken());
		}
		
		for(int i = 0; i < m; i++) {
			String pw = map.get(br.readLine());
			sb.append(pw).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
