import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2023.01.09
 * 토너먼트
 * 아 다른 분들 코드가 눈에 안들어온다.. 
 * 토너먼트 규칙을 찾은것같은데 나처럼 늘여가는 방식보다는 줄여가는 방식을 훨씬 많이 쓰는 듯 하다 
 */
public class S4_1057 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 참가자의 수
		int kim = Integer.parseInt(st.nextToken()); // 김지민
		int im = Integer.parseInt(st.nextToken()); // 임한수
		
		int multiple = 1; // 2의 배수 
		int cnt = 0; // 라운드 체크
		int num = 1; // 올라가는 숫자 체크
		
		while(true) {
			multiple *= 2; // 토너먼트이므로 2의 배수로 체크, 같은 구간안에 있으면 둘은 같은 라운드에 대결함ㅁ
			cnt++; 
			num = 0; 
			
			while(num <= n) {
				num += multiple;

				if(num - multiple < kim && num - multiple < im && kim <= num && im <= num) {
					System.out.println(cnt);
					return;
				}
			}
	
		}
	}
}
