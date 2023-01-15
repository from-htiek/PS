import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2023.01.15
 * 암기왕
 * 공유기 설치 스노우 볼이 여기까지.. 이분탐색은 왜 볼때마다 새로울까
 * 익숙해지면 매개변수 탐색으로 넘어갑시당
 */
public class S4_2776 {
	public static int note1[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		
		for(int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine()); // 수첩1에 적은 숫자 개수
			st = new StringTokenizer(br.readLine());
			
			note1 = new int[n];
			for(int i = 0; i < n; i++) {
				note1[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(note1); // 정렬
			
			int m = Integer.parseInt(br.readLine()); // 수첩2에 적은 숫자 개수
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < n; i++) {
				sb.append(binarySearch(0, n-1, Integer.parseInt(st.nextToken()))).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	// 이분 탐색
	public static int binarySearch(int start, int end, int key) {
		if(start > end) return 0;
		else {
			int mid = (start + end) / 2;
			
			if(note1[mid] == key) return 1;
			else if(note1[mid] < key) return binarySearch(mid+1, end, key);
			else return binarySearch(start, mid-1, key);
		}
	}
}
