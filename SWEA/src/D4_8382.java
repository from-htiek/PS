import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.04.11
 * 방향 전환 
 */
public class D4_8382 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int dy = Math.abs(y2-y1); // (0, 0) => (dx, dy) 계산
			int dx = Math.abs(x2-x1);
			
			int g = (dx+dy)/2; // 가장 가까운 y=x 좌표
			int result = 2 * g + Math.abs(g-dy) + Math.abs(g-dx);
						
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
			
		}
		
		System.out.println(sb.toString());
		
	}
}
