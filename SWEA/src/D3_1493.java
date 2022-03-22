import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.02.23
 * 수의 새로운 연산
 * 
 * 디피 
 * 간결한 코드
 * 왜 이렇게 짠건지 알 것 같으면서도 잘 모르겠음... 설명 듣고싶다 ㅠㅠ 
 */
public class D3_1493 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = 0; // 두 숫자의 x, y를 더한 좌표값
			int x = 0;
			
			// 1. 두 숫자를 좌표값으로 변환
			for(int i = 0; i < 2; i++) {
				int n = Integer.parseInt(st.nextToken());
				
				int start = 0; 
				int newy = 0; // 각 숫자의 x, y 값
				int newx = 0; 
				for(int j = 1; j <= 141; j++) { // 141*142/2 > 10000, 해당 대각선의 끝지점 구하기(1, 2, 3 ... 등차수열로 커짐)
					start += j;
					if(start >= n) {
						newy = 1;
						newx = j;
						break;
					}
				}
				
				while(true) { // 끝지점에서 대각선으로 x, y 값 1씩 조정하며 해당 좌표 찾기
					if(start == n) {
						y += newy; // 찾았으면 더하기
						x += newx;
						break;
					}
					start--; 
					newy++;
					newx--; 
				}

			}
			
			
			// 2. 더한 좌표값 숫자로 변환
			int cnt = 0;
			while(true) {
				if(y == 1) { // 값 1씩 조정하며 해당 다각선 끝지점으로 조정(끝지점은 y=1임) 
					break; 
				}
				y--;
				x++; 
				cnt++;  // 몇 칸 이동했는지 기억해서 나중에 빼줌
			}

			int start = 0; 
			for(int i = 1; i <= x; i++) {
				start += i;
			}
			
			System.out.printf("#%d %d\n", tc, start-cnt);

			
		}
		
	}
}
