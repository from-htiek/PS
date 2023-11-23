import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 2023.11.23
 * 초콜릿 자르기
 * 
 * 이게 도대체 얼마만이지? 풀다가 소리지름
 */
public class B1_2163 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		
		System.out.println((n-1)+(m-1)*n);
	}
}
