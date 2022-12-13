import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/*
 * 2022.12.13
 * 소트인사이드
 */
public class S5_1427 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] list = br.readLine().toCharArray();
		
		Arrays.sort(list);
		
		System.out.println(Arrays.toString(list));
		
		StringBuilder sb = new StringBuilder();
		
		for(int size = list.length, i = size-1; i >= 0; i--) {
			sb.append(list[i]);
		}
		
		System.out.println(sb.toString());
		
		
	}
}
