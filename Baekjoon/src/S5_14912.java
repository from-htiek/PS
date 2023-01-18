import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2023.01.18
 * 숫자 빈도수
 */
public class S5_14912 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		int[] list = new int[10];
		
		for(int i = 1; i <= n; i++) {
			int num = i;
			while(num > 0) {
				list[num%10]++;
				num /= 10;
			}
		}
		
		
		System.out.println(list[d]);
	}
}
