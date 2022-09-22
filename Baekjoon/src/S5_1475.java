import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 2022.09.22
 * 방 번호
 */
public class S5_1475 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		
		int[] number = new int[10];
		for(int i = 0, size = n.length(); i < size; i++) {
			int num = n.charAt(i) - '0';
			if(num == 9 || num == 6) {
				if(number[9] < number[6]) number[9]++;
				else number[6]++; 
			}else number[num]++;
		}
		
		int result = 0;
		for(int i = 0; i < 10; i++) {
			result = Math.max(result, number[i]);
		}
		
		System.out.println(result);
		
	}
}
