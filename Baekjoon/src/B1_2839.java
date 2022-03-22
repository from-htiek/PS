import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2022.02.15
 * 설탕 배달
 * 
 * fman1335
 * %5가 0일때까지 -3을 해주고 그 후 /5 값을 더함
 * 
 */
public class B1_2839 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result = -1;
		int n = Integer.parseInt(br.readLine());

		if(n < 3) result = -1;
		else if(n%5 == 0) result = n/5;
		else {
			int num1 = Integer.MAX_VALUE;
			if(n%3 == 0) num1 = n/3;
			
			int num2 = 0;
			while(n >= 3) {
				n -= 3; 
				num2++;
				
				//System.out.println(n);
				if(n%5 == 0) {
					result = Math.min(num1, num2+n/5);
					break;
				}else if(num1 != Integer.MAX_VALUE) result = num1;
			}
			
			
		}
		
		System.out.println(result);
		
	}
}
