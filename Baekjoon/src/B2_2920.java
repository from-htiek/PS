import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.07.06
 * 음계
 */
public class B2_2920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int prev = Integer.parseInt(st.nextToken());
		int cur = Integer.parseInt(st.nextToken());
		int check = prev-cur;
		prev = cur; 
		while(st.hasMoreTokens()) {
			cur = Integer.parseInt(st.nextToken());
			
			if(prev - cur != check) {
				check = 2;
				break; 
			}
			
			prev = cur;
		}
		
		if(check == 1) System.out.println("descending");
		else if(check == -1) System.out.println("ascending");
		else System.out.println("mixed");
	}
}
