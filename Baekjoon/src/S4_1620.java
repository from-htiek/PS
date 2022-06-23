import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
 * 2022.06.23
 * 나는야 포켓몬 마스터 이다솜
 * 오랜만에 사용하는 해시맵. 
 * 처음에 숫자 + 포켓몬 조합으로만 해시에 집어넣었었는데, 문자열로 값이 들어오면 해시를 처음부터 값을 찾을 때 까지 다 돌아야해서 시간초과가 났다.
 * 결국 다른 코드를 참고해 포켓몬 + 숫자 조합도 집어 넣어 해결.
 * 그리고 역시 Stringbuilder와 그냥 print의 차이는 크다 
 */


public class S4_1620 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder(); 
		int m = Integer.parseInt(st.nextToken()); // 포켓몬 개수
		int n = Integer.parseInt(st.nextToken()); // 문제 수 
		
		HashMap<String, String> map = new HashMap<>();
		for(int i = 1; i <= m; i++) {
			String pokemon = br.readLine();
			String num = Integer.toString(i);
			map.put(num, pokemon);
			map.put(pokemon, num);
		}
		
		for(int i = 0; i < n; i++) {
			String question = br.readLine();
			sb.append(map.get(question)).append("\n");
			
//			System.out.println(map.get(question));
		}
		
		System.out.println(sb.toString());
		
	}
}
