import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 2022.11.03
 * 왜 안되는거지? 
 */
public class 수퍼바이러스 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long k = Integer.parseInt(st.nextToken());
        long p = Integer.parseInt(st.nextToken());
        long n = Integer.parseInt(st.nextToken());
        
        long result = func(p, n*10);
        System.out.println(k * result % 1000000007);
	}
	
	public static long func(long p, long n) {
		if(n == 1) {
			return p;
		}else if(n % 2 == 0) {
			long num = func(p, n/2);
			return num * num % 1000000007;
		}else {
			long num = func(p, n/2);
			return num * num * p % 1000000007;
		}
	}
}
