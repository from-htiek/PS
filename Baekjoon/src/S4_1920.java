import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.03.07
 * 수 찾기
 */
public class S4_1920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int[] list = new int[n];
		for(int i = 0; i < n; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(list); // 오름 차순 정렬
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			sb.append(binarySearch(0, n-1, list, num));
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
	
	public static int binarySearch(int start, int end, int[] list, int key) {
		if(start > end) return 0; // 시작점이 끝을 넘어섬 => 값이 없음
		else {
			int mid = (start+end)/2; 
			
			if(list[mid] == key) return 1; // 값 찾음 
			else if(list[mid] < key) return binarySearch(mid+1, end, list, key);
			else return binarySearch(start, mid-1, list, key);
		}
	}
}
