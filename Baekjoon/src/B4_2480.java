import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2023.12.02
 * 주사위 세개
 */
public class B4_2480 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] dice = new int[7];
		for(int i = 0; i < 3; i++) {
			dice[Integer.parseInt(st.nextToken())]++;
		}
		
		int max = 0; 
		int num = 0; 
		for(int i = 1; i < 7; i++) {
			if(dice[i] > max) {
				max = dice[i];
				num = i;
			}else if(dice[i] == max && i > num) {
				num = i;
			}
		}
		
		if(max == 3) System.out.println(10000 + num * 1000);
		else if(max == 2) System.out.println(1000 + num * 100);
		else System.out.println(num * 100);
	}
}
