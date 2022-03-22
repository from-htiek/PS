import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.02.17
 * 색종이 만들기
 */
public class S3_2630 {
	static int white, blue, paper[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		paper = new int[n][n];
		white = 0; // 하얀색 색종이 개수
		blue = 0; // 파란색 색종이 개수
				
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//System.out.println(Arrays.deepToString(paper));
		
		func(0, 0, n);
		System.out.println(white);
		System.out.println(blue);

	}
	
	public static void func(int y, int x, int size) {
		// 정사각형 넓이 구하기
		int sum = 0;
		for(int i = y; i < y+size; i++) {
			for(int j = x; j < x+size; j++) {
				sum += paper[i][j];
			}
		}
		
		// 합 0 => 모두 하얀색 
		if(sum == 0) {
			white++;
			return;
		}
		
		// 사이즈의 제곱은 정사각형의 넓이와 동일 => 모두 파란색
		if(sum == (size*size)) {
			blue++;
			return; 
		}
		
		// 아니라면 4분할
		int half = size/2;
		func(y, x, half);
		func(y, x+half, half);
		func(y+half, x, half);
		func(y+half, x+half, half);
	}
}
