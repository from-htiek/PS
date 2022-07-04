import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.07.04
 * 랜선 자르기
 * 문제를 보고 바로 이분탐색을 떠올리지 못했다.
 * 처음에는 완전탐색으로 풀었었는데, 시간 복잡도를 계산해보니 최악일 때 2초는 거뿐히 넘길것같아 생각한 방법이 틀렸다는 걸 알았다. 
 * 다른 분들의 해설을 참고하면서 이런 유형이 이분탐색으로 푸는 거구나 생각했다.
 * 그런데 왜인지 완전히 이해를 못한 듯한 느낌이 든다. 다른 유형을 또 풀어봐야겠다 8ㅅ8
 */
public class S2_1654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken()); // 오영식이 가지고 있는 랜선의 개수
		int n = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수
		
		int[] list = new int[k];
		long min = 1; // 자를 수 있는 랜선 길이의 최소값
		long max = 0; // 자를 수 있는 랜선 길이의 최대값 
		
		for(int i = 0; i < k; i++) {
			list[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, list[i]);
		}
		
		while(min <= max) {
			
			long mid = (min + max)/2; // 길이의 중간값 
			long cnt = 0;
			
			
			for(int i = 0; i < k; i++) {
				cnt += (list[i] / mid);
			}
			
//			System.out.println(mid + " " + cnt);
			
			if(cnt < n) {
				max = mid - 1;
			}else {
				min = mid + 1; 
			}
			
//			System.out.println(min + " " + max);
//			System.out.println("-------------");
			
		}
		
		System.out.println(max);

	}
}
