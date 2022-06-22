import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.06.22
 * ACM 호텔
 */
public class B3_10250 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken()); // 호텔의 층 수
			int w = Integer.parseInt(st.nextToken()); // 각 층의 방수
			int n = Integer.parseInt(st.nextToken()); // 몇 번째 손님인가 
			
			int floor = (n % h == 0 ? h : n % h);
			int room =  (n % h == 0 ? n/h : n/h+1); 
			
			if(room < 10) System.out.printf("%d0%d\n", floor, room);
			else System.out.printf("%d%d\n", floor, room);
		}
	}
}
