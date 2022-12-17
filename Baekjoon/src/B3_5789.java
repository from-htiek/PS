import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2022.12.17
 * 한다 안한다
 */
public class B3_5789 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < n; tc++) {
			String input = br.readLine();
			int idx = input.length()/2;
			System.out.println(idx);
			if(input.charAt(idx) == input.charAt(idx-1)) sb.append("Do-it").append("\n");
			else sb.append("Do-it-Not").append("\n");
			
		}
		
		System.out.println(sb.toString());
	}
}
