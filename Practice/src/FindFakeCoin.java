import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 2022.02.15
 * 박채림
 */
public class FindFakeCoin {
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] list = new int[n];
		int result = 0; // 가짜 코인의 인덱스 
		cnt = 0; // 비교 횟수
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int _ = 0; _ < n; _++) {
			list[_] = Integer.parseInt(st.nextToken());
		}
	
		result = binarySearch(n, list, 0, n);
		
		System.out.println(result);
		System.out.println(cnt);
	}
	
	static int binarySearch(int n, int[] list, int start, int end) {
//		if(start == end) {
//			
//			return end;
//		}
		
		cnt++;
		if(n == 3) {
			if(list[start] == list[start+1]) return start+2;
			else if(list[start] < list[start+1]) return start;
			else return start+1;
		}else if(n == 2) {
			if(list[start] > list[start+1]) return start+1;
			else return start;
		}

		
		 
		int mid = (start+end)/2;
		int leftSum = 0;
		int rightSum = 0;
		
		if(n%2 == 0) { // n이 짝수 일 때
			for(int _ = start; _ < mid; _++) leftSum += list[_];
			for(int _ = mid; _ < end; _++) rightSum += list[_];
			
			if(leftSum < rightSum) return binarySearch(n/2, list, start, mid);
			else return binarySearch(n/2, list, mid, end);
		
		}else { // n이 홀수 일 때 
			for(int _ = start; _ < mid; _++) leftSum += list[_];
			for(int _ = mid; _ < end-1; _++) rightSum += list[_]; // 마지막 하나 빼고 각 합 구하기
			
			if(leftSum == rightSum) return end-1;
			else if(leftSum < rightSum) return binarySearch(n/2, list, start, mid);
			else return binarySearch(n/2, list, mid, end-1);
		}
		
	}
}
