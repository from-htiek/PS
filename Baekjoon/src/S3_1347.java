import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 2022.07.16
 * 미로 만들기
 * 이런 문제를 풀 때는 나의 구현력이 얼마나 부족한지를 다시 느낀다ㅠ..
 * 길이가 0 ~ 50라는 조건에서 그럼 한쪽으로만 가면 최대 50칸이네. 까지는 생각했지만 
 * 그 다음 단계인 어느 방향으로 갈지 모르잖아? 라는 질문에 대답하지 못했고 해당 범위만을 어떻게 출력할지도 결국 생각하지 못해 검색을 했다..
 * 쉽지않다 정말
 * 참고 : https://suhyeokeee.tistory.com/111
 */
public class S3_1347 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] note = br.readLine().toCharArray();
		
		char[][] map = new char[101][101]; // 어느 방향으로든 최대 50칸 이동할 수 있는 배열 준비 
		for(int i = 0; i < 101; i++) { // 기본값은 벽인 #로 채워넣기 
			Arrays.fill(map[i], '#');
		}
		
		int[] dy = {1, 0, -1, 0};
		int[] dx = {0, -1, 0, 1};
		int d = 0; // 기본 방향은 남쪽
		int y = 50; // 시작 지점은 (50, 50)으로 세팅 
		int x = 50; 
		map[y][x] = '.'; 
		
		int maxy = 50; // 해당 직사각형을 그리기 위해 직사각형 좌표의 최소값과 최대값 기록
		int maxx = 50;
		int miny = 50;
		int minx = 50; 

		for(int i = 0, size = note.length; i < size; i++) {
			char move = note[i];

			if(move == 'F') { // F이면 앞으로 한칸 전진 
				y += dy[d];
				x += dx[d];
			}else if(move == 'R') { // R이면 오른쪽으로 방향 바꿈
				d = (d + 1) % 4;  
			}else { // L이면 왼쪽으로 방향 바꿈 
				d = (d + 3) % 4;
			}

			map[y][x] = '.'; // 방문 한 곳은 .로 표시
			maxy = Math.max(maxy, y); // 최대값, 최소값 갱신 
			maxx = Math.max(maxx, x);
			miny = Math.min(miny, y);
			minx = Math.min(minx, x);
			
//			System.out.println(move + " " + d + " " + y + " " + x);

		}
		

		
		for(int i = miny; i <= maxy; i++) { // 해당 범위만 출력
			for(int j = minx; j <= maxx; j++) {
				System.out.printf("%c", map[i][j]);
			}
			System.out.println();
		}
		
	}
}
