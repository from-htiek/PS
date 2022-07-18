import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
/*
 * 2022.07.18
 * DNA 해독
 * => 메모리 초과 다시 풀기ㅎ
 */
public class B2_1672 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 염기 서열의 길이
		char[] seq = br.readLine().toCharArray();
		
		HashMap<String, Character> map = new HashMap<>(); // 염기서열 해시맵 
		map.put("AA", 'A');
		map.put("AG", 'C');
		map.put("AC", 'A');
		map.put("AT", 'G');
		map.put("GA", 'C');
		map.put("GG", 'G');
		map.put("GC", 'T');
		map.put("GT", 'A');
		map.put("CA", 'A');
		map.put("CG", 'T');
		map.put("CC", 'C');
		map.put("CT", 'G');
		map.put("TA", 'G');
		map.put("TG", 'A');
		map.put("TC", 'G');
		map.put("TT", 'T');
		
		if(n == 1) { // 길이가 1이면 바로 리턴 
			System.out.println(seq[0]);
			return; 
		}
		
		String s = String.valueOf(seq[n-2]).concat(String.valueOf(seq[n-1])); // n-2와 n-1을 연결
		char end = map.get(s); // 해당 염기서열 찾음 
		int cnt = n-3; 
		
		while(cnt >= 0) { // 그 후로 반복
			s = String.valueOf(seq[cnt]).concat(String.valueOf(end));
			cnt--;
			end = map.get(s);
		}
		
		
		System.out.println(end);
		
		
	}
}
