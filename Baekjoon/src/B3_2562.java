import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2023.02.14
 * 최댓값
 */
public class B3_2562 {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int max = 0;
		int idx = 0;
		
		for(int i = 1; i <= 9; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num > max) {
				max = num;
				idx = i;
			}
		}
		
		System.out.println(max);
		System.out.println(idx);
		
	}
}
