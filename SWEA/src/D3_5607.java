import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.04.11
 * 조합
 * 페르마 소정리 이용
 * 정적 power함수 이해하는데 더 한참 걸렸다는 아이러니
 */
public class D3_5607 {
	static long[] fac; 
	static int p;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		p = 1234567891; 
		fac = new long[1000001];
		fac[0] = 1;
		for(int i = 1; i <= 1000000; i++) {
			fac[i] = fac[i-1] * i % p; 
		}
		
		for(int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			sb.append("#").append(tc).append(" ").append(combination(n, r, p)).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static long combination(int n, int r, int p) {
		if(r == 0) return 1L;
		
		return fac[n]*((power(fac[r], p-2, p) % p) * (power(fac[n-r], p-2, p) % p) % p) % p ;
	}
	
	static long power(long x, long y, long p) {
		long result = 1L; 
		
		x = x % p;
		while(y > 0) {
			if(y%2 == 1) result = (result*x) % p;
			y = y >> 1; // y를 반으로 줄이고 
			x = (x*x)%p; // x를 제곱 해 결국 x^y의 값은 같음

		}
		
		return result;
	}
}
