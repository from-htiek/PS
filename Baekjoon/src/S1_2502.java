import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.09.02
 * 떡 먹는 호랑이
 */
public class S1_2502 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int d = Integer.parseInt(st.nextToken()); // 할머니가 넘어온 날
		int k = Integer.parseInt(st.nextToken()); // 그 날 호랑이에게 준 떡의 개수 
		
		int[][] list = new int[d+1][2];
		list[1][0] = 1; 
		list[1][1] = 0;
		list[2][0] = 0;
		list[2][1] = 1; 
		
		// ax + by의 꼴일 때 계수 계산
		for(int i = 3; i <= d; i++) {
			list[i][0] = list[i-2][0] + list[i-1][0];
			list[i][1] = list[i-2][1] + list[i-1][1];
//			System.out.println(Arrays.toString(list[i]));
		}
		
		int a = 1; // 첫째날
		int b = 0; // 둘째날
		
		int x = list[d][0];
		int y = list[d][1];
		
		while(true) {
			if((k - (x * a)) % y == 0) {
				b = (k - (x * a)) / y;
				if(a <= b) {
					System.out.println(a);
					System.out.println(b);
					return;
				}
			}
			a++;
		}
				
	}
}
