import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.08.30
 * 종이의 개수
 * 다시 풉시당
 * 
 * 문제를 읽고 분할정복이라는건 알았는데 정말 기억이 하나도 안났다.....
 * 재귀를 어디서부터 어떻게 손대야할지돔 몰라서 결국 강의를 다시봤다!
 * 결국 내 손으로 풀었지만 내 손으로 풀지 않는 문제가 되었다 
 * 오랜만에 다시 봐서 좋았던 유형이였다
 */
public class S2_1780 {
	public static int paperA, paperB, paperC; // 차례대로 0, 1, -1 종이 수
	public static int paper[][]; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());
		paper = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		func(0, 0, n);
		
		System.out.println(paperC);
		System.out.println(paperA);
		System.out.println(paperB);
			
	}
	
	// 분할 정복 
	public static void func(int y, int x, int size) {
		int cur = paper[y][x];
		boolean flag = true;
		loop : for(int i = y; i < y + size; i++) {
			for(int j = x; j < x + size; j++) {
				if(cur != paper[i][j]) { // 현재의 종이와 다르다면 멈춤
					flag = false; 
					break loop;
				}
			}
		}
		
		if(flag) { // 종이가 같다면 
			if(cur == 0) paperA++;
			else if(cur == 1) paperB++;
			else paperC++; 
		}else { // 다르면 분할정복
			int _size = size/3;
			func(y, x, _size);
			func(y, x+_size, _size);
			func(y, x+_size*2, _size);
			func(y+_size, x, _size);
			func(y+_size, x+_size, _size);
			func(y+_size, x+_size*2, _size);
			func(y+_size*2, x, _size);
			func(y+_size*2, x+_size, _size);
			func(y+_size*2, x+_size*2, _size);
		}
	}
}
