import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.07.24
 * 투명
 */
public class S5_1531 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 종이 수
		int m = Integer.parseInt(st.nextToken()); // 그림을 가릴 수 있는 최소 종이 수
		
		int[][] painting = new int[101][101]; 
		
		for(int t = 0; t < n; t++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken()); // 종이의 모서리 좌표
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken()); 
			
			
			for(int i = x1; i <= x2; i++) {
				for(int j = y1; j <= y2; j++) {
					painting[i][j]++; // 올려진 종이
				}
			}
		}
		
		
		int cnt = 0; 
		for(int i = 0; i < 101; i++) {
			for(int j = 0; j < 101; j++) {
				if(painting[i][j] > m) cnt++; // m개보다 많이 올려져 있어 보이지 않는 그림 체크
			}
		}
		
		System.out.println(cnt);
		
	}
}
