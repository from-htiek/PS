import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.07.26
 * 공
 */
public class B3_1547 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int m = Integer.parseInt(br.readLine()); // 컵의 위치를 바꾼 횟수
		
		int[] cup = {0, 1, 0, 0}; // 1번 위치에 공 넣고 시작
		
		for(int i =0 ; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// swap
			int tmp = cup[x];
			cup[x] = cup[y];
			cup[y] = tmp;
		}
		
		for(int i = 1; i <= 3; i++) { // 공 찾고 끝
			if(cup[i] == 1) {
				System.out.println(i);
				return;
			}
		}
		
		System.out.println(-1); // 공 없으면 -1 출력
	}
}
