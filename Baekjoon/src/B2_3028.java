import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 2022.07.19
 * 창영마을
 */
public class B2_3028 {
	static boolean[] ball;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] order = br.readLine().toCharArray(); // 입력
		ball = new boolean[]{false, true, false, false};  // 공 초기 위치 : 1번 
		
		for(int i = 0, size = order.length; i < size; i++) {
			switch(order[i]) {
			case 'A':
				swap(1, 2);
				break;
			case 'B' :
				swap(2, 3);
				break;
			case 'C' :
				swap(1, 3);
				break; 
			}
			
//			System.out.println(Arrays.toString(ball));
		}
		
		
		for(int i = 1; i <= 3; i++) {
			if(ball[i]) System.out.println(i);
		}
	}
	
	public static void swap(int x, int y) { // x, y 위치를 바꾸는 함수
		boolean tmp = ball[x];
		ball[x] = ball[y];
		ball[y] = tmp; 
	}
}
