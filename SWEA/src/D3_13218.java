import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2022.07.30
 * 조별과제
 * ..? 1초컷 
 */
public class D3_13218 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			sb.append("#").append(tc).append(" ").append(n/3).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
