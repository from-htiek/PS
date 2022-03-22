import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_13038 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine())	;
			
			int[] week = new int[7];
			for(int i = 0; i < 7; i++) {
				week[i] = Integer.parseInt(br.readLine());
			}
			
			int min = Integer.MAX_VALUE;
			for(int start = 0; start < 7; start++) {
				if(week[start] == 0) continue;
				
				int day = start, cnt = 0;
				
				while(true) {
					if(week[day%7] == 1) cnt++; // 수업이 열리면 카운팅 
					
					day++; // 하루 지남 
					
					if(cnt == n) {
						min = Math.min(min, day-start);
						break; 
					}
				} 
			}
		}
	}
}
