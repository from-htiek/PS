import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.03.25
 * 숫자 카드
 * 
 * 다른 방법들 
 * 1. hashset 사용
 * 2. boolean[20000001] 배열
 * 숫자 범위가 -10,000,000 ~ 10,000,000 이므로 배열은 음수값을 가질 수 없으니 양수로 옮겨서 배열 생성하고
 * card[Integer.parseInt(st.nextToken()) + 10000000] = true; 로 들어온 값 true로 바꿔주고
 * 값 체크 !  
 * 
 */
public class S4_10815 {
	
	static int[] card;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		card = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(card); // 정렬

		
		StringBuilder sb = new StringBuilder();
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			sb.append(binarysearch(0, n-1, num)).append(" ");
			
		}
		
		System.out.println(sb.toString());
		
	}
	
	// 이분탐색
	static int binarysearch(int start, int end, int key) {
		
		if(start > end) return 0;
		int mid = (start+end)/2;
			
		if(card[mid] == key) return 1;
		else if(card[mid] < key) return binarysearch(mid+1, end, key);
		else return binarysearch(start, mid-1, key);
		
	}
	

}
