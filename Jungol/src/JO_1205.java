import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.02.27
 * 조커
 * 
 * 90점에서 뭐가 틀린지 모르겠다 . . 
 */
public class JO_1205 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] card = new int[n];
		int joker = 0; // 조커의 수
		
		for(int i = 0; i < n; i++) {
			card[i] = Integer.parseInt(st.nextToken());
			if(card[i] == 0) joker++;
		}
		
		if(n == joker) { // 모두 다 조커라면  n개만큼 스트레이트 만들고 종료
			System.out.println(joker);
			System.exit(0);
		}
		
		
		Arrays.sort(card); // 정렬 
			
		int result = joker+1; // 스트레이트 최댓값 (조커 카드를 제외한 일반 카드가 최소 1장 이상 있기 때문)
		
		for(int i = joker; i < n; i++) { // 0을 제외한 숫자부터 시작
			int _joker = joker;
			int cnt  = 1; // 스트레이트 수
			
			for(int j = i+1; j < n; j++) {
				int num = card[j] - card[j-1] - 1; // 바로 다음 카드와의 수 차이
				
				if(num == -1) break; // 같은 수라면 멈춤
				
				if(num <= _joker) { // 조커로 차이를 메울 수 있으면
					_joker -= num;
					cnt += num+1;
				}else { // 메울 수 없으면
					break;
				}
			}

			result = Math.max(result, cnt+_joker);
		}
		
		System.out.println(result);
	}
}

		
//		int joker = 0; // joker 카드 수
//		int tmp = 0; 
//		int cnt = 0; // 스트레이트 길이
//		int result = 0; // 결과
//
//		for(int i = 0; i < n; i++) {
//			
//			if(card[i] == 0) {
//				joker++;
//				tmp++;
//				if(joker == n) { // 모두 다 조커라면 조커 수 만큼 스트레이트 만들 수 있음
//					result = joker;
//					break;
//				}
//				continue;
//			}
//			
//			if(i == n-1) {
//				result = Math.max(cnt+tmp+1, result);
//				continue;
//			}
//			
//			int num = card[i+1] - card[i];
//			if(num == 0) {
//				cnt++; 
//				result = Math.max(cnt+tmp, result);
//				cnt = 0;
//			}else if(num == 1) {
//				cnt++;
//			}else if(num-1 <= tmp) {
//				cnt++;
//				tmp -= (num-1);
//				cnt += (num-1);
//			}else {
//				result = Math.max(cnt+tmp+1, result);
//				tmp = joker;
//				cnt = 0;
//			}
//			
//		}
//		
//		
//		System.out.println(result);
