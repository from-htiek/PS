import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.08.23
 * 물병
 * 나중에 다시 풀면 달라질까? 개인적으로 어려웠던 문제. 사실 지금도 잘 모르겠음()
 * 처음에 구현했던 방법에는 어떤 문제가 있었던 건지도 찾지못했다 결국..ㅠㅠ 
 * 꼭 비트마스킹으로 문제를 풀어야하는건아니지만, 비트마스킹을 이용하면 더 쉽게 풀 수 있는 문제인것같긴하다.
 * 물론 나는...... 비트 마스킹은 언제봐도 생소하다 이럴수가
 *  
 * 많은 블로그 글들을 찾아봤는데 확실히 이거다! 하는건 없었다.
 * 다만 나는 나누는 방법으로 이진수를 구했었는데, 이걸 이진수로 바꿔서 1의 개수와 k를 체크하는건 신기했다. 
 * 물론 지금 내가 푼 방법은 무지성이긴하지만... 
 * 공부할게 또 늘었네! 3일 안에 비트마스킹 공부할 수 있으면 좋겠다. 
 */
public class S1_1052 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 물병 수
		int k = Integer.parseInt(st.nextToken()); // 옮길 수 있는 물병 수, 1 <= k <= 1000
		int result = 0; // 구매해야 하는 물병 수
		
		while(Integer.bitCount(n) > k) { // 너무 비효율적인데 
			result++;
			n++; 
		}
		
		System.out.println(result);
		
	}
}
