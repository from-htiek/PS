import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2022.02.23
 * 원재의 메모리 복구하기
 */
public class D3_1289 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			char[] bit = br.readLine().toCharArray();
			int cnt = 0;
			char flag = '0';
			
			for(int i = 0, size = bit.length; i < size; i++) {
				if(bit[i] != flag) {
					cnt++;
					flag = flag == '0' ? '1' : '0';
				}
			}
			
			System.out.printf("#%d %d\n", tc, cnt);
			
		}
		
	}
}
