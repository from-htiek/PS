import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.02.06
 * 시각 덧셈
 * 다른 코드를 보니 plus가 꼭 필요할까? 하는 생각이 듦 => 없애자
 */
public class D2_1976 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc < t+1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int h1 = Integer.parseInt(st.nextToken());
			int m1 = Integer.parseInt(st.nextToken());
			int h2 = Integer.parseInt(st.nextToken());
			int m2 = Integer.parseInt(st.nextToken());
			int hour = h1 + h2;
			int minutes = m1 + m2; 
			
			if(minutes > 59) {
				minutes -= 60;
				hour += 1;
			}
			
			if(hour > 12) {
				hour -= 12;
			}
			
//			if(m1 + m2 > 59) {
//				plus = 1;
//				minutes = m1 + m2 -60; 
//			}else {
//				minutes = m1 + m2;
//			}
//			
//			if(h1 + h2 + plus> 12) {
//				hour = h1 + h2 + plus - 12;
//			}else {
//				hour = h1 + h2 + plus;
//			}
			
			System.out.printf("#%d %d %d\n", tc, hour, minutes);
			
		}

	}

}
