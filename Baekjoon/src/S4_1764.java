import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
 * 2022.06.24
 * 듣보잡
 */
public class S4_1764 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken()); // 듣도 못한 사람의 수
		int m = Integer.parseInt(st.nextToken()); // 보도 못한 사람의 수
		
		HashMap<String, String> map = new HashMap<>();
		for(int i = 0; i < n; i++) {
			String name = br.readLine();
			map.put(name, name);
		}
		
		String[] list = new String[m];
		for(int i = 0; i < m; i++) {
			list[i] = br.readLine();
		}
		
		Arrays.sort(list);
		
		int cnt = 0; 
		for(int i = 0; i < m; i++) {
			
			if(map.get(list[i]) != null) {
				cnt++;
				sb.append(list[i]).append("\n");
			}
		}
		
		System.out.println(cnt);
		System.out.println(sb.toString());
	}
}
