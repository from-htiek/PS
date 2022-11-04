import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 2022.11.03
 * 수퍼바이러스
 * long의 최대값이 10^19라고한다.
 * num * num * p의 순간 최대값은 10억 * 10억 * 1억.... 
 *  (num * num % 1000000007)이렇게 고쳐줬더니  드디어 풀림
 */
public class 수퍼바이러스 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long k = Long.parseLong(st.nextToken());
        long p = Long.parseLong(st.nextToken());
        long n = Long.parseLong(st.nextToken());
        
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
			return (num * num % 1000000007) * p % 1000000007;
		}
	}
}
