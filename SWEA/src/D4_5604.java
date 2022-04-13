import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.04.13
 * 구간 합
 * 
 * 혼자서는 아무리 고민해도 못풀겠던 문제ㅠㅠ 
 * 위부분, 아랫부분은 따로 계산하고 블럭단위로 계산하라는 힌트를 주셨지만 결국 어떻게 구현해야 할지 전혀 모르겠더라 
 * 정답 코드가지고 거의 클론코딩한것과 다름없다....
 * cnt*10 해주는 부분이 끝까지 이해가 안갔었는데, 질문 후에 다시 생각해보면  
 * 숫자를 /10해서 나온 값이 1이면 원래 그 숫자는 10이였기 때문에 들어갈 수 있는숫자가 10개이고
 * 100이면 그 숫자는 1000이였기때문에 들어갈 수 있는 숫자가 1000개라 계속 *10을 하면서 늘려가는거였ㄷ ㅏ ..
 * 그래도 역시 어려운 문제인듯하다.
 * 나중에 다시 풀면 풀 수 있을까
 */
public class D4_5604 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			long[] num = new long[10]; // 0~9까지 숫자 체크 할 배열
			long cnt = 1; 
			
			while(a <= b) { 
				while(b % 10 != 9 && a <= b) { // b를 하나씩 줄여가면서 __9 꼴의 숫자로 만들기 
					func(b, num, cnt);
					b--;
				}
				
				if(b < a) break; // __9 의 숫자가 a 보다 작다면 계산 끝 
				
				while(a % 10 != 0 && a <= b) { // a를 하나씩 올려가며 __0 꼴의 숫자로 만들기 
					func(a, num, cnt);
					a++; 
				}
				
				a /= 10;
				b /= 10;
				
				for(int i = 0; i < 10; i++) {
					num[i] += (b - a + 1) * cnt;
				}
				
				cnt *= 10; // 1 -> 10 -> 100 ... 숫자가 커지면 들어갈 수 있는 자리수도 늘어남
			}
			
			
			long result = 0;
			for(int i = 0; i < 10; i++) {
				result += (num[i] * i);
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void func(long n, long[] num, long cnt) {
		while(n > 0) {
			int tmp = (int) (n % 10); 
			num[tmp] += cnt;
			n /= 10;
		}
		
	}
}
