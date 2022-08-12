import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.08.12
 * 물병
 * 문제풀이 방향성을 완전히 잘못잡은것같은데? 
 */
public class S1_1052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 물병 수
		int k = Integer.parseInt(st.nextToken()); // 한번에 옮길 수 있는 물병 수
		
		int result = 0; // 상점에서 사야하는 물병 최소값
		
		
		int quotient = 0; // 몫
		int remain = 0; // 나머지
		int basic = k;
		int prev = 1; 
		while(true) {
			quotient = n/2; 
			remain = n%2; 
			
			if(remain != 0) {
				result += (basic - remain*prev);
				quotient++;
			}
			
			prev *= 2;
			basic *= 2;
			n = quotient; 
			
			System.out.println(n);
			System.out.println(result);
			
			if(quotient == k) break; 
		}
		
		System.out.println(result);
	}
}
