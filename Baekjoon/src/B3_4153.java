import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.06.27
 * 직각삼각형
 */
public class B3_4153 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			if(x == 0 && y == 0 && z == 0) break; 
			
			if(x >= y && x >= z) {
				if(x * x == z * z + y * y) sb.append("right").append("\n");
				else sb.append("wrong").append("\n");
			}else if(y >= x & y >= z) {
				if(y * y == x * x + z * z) sb.append("right").append("\n");
				else sb.append("wrong").append("\n");
			}else {
				if(z * z == x * x + y * y) sb.append("right").append("\n");
				else sb.append("wrong").append("\n");
			}
			
			
		}
		
		System.out.println(sb.toString());
	}
}
