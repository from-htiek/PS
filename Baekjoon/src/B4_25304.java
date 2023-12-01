import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2023.12.01
 * 영수증
 */
public class B4_25304 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int x = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int total = 0; 
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int price = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			
			total += (price * cnt);
		}
		
		if(x == total) System.out.println("yes");
		else System.out.println("no");
	}
}
