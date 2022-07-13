import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
 * 2022.07.13
 * 일요일
 */
public class D3_13229 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		HashMap<String, Integer> days = new HashMap<>();
		days.put("SUN", 7);
		days.put("MON", 6);
		days.put("TUE", 5);
		days.put("WED", 4);
		days.put("THU", 3);
		days.put("FRI", 2);
		days.put("SAT", 1);
	
		for(int tc = 1; tc <= t; tc++) {
			String s = br.readLine();
			sb.append("#").append(tc).append(" ").append(days.get(s)).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
