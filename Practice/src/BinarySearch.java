import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 2022.02.15
 * BinarySearch
 */
public class BinarySearch {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] list = new int[n];
		int result = 0;
		for(int _ = 0; _ < n; _++) {
			list[_] = Integer.parseInt(st.nextToken());
		}
		
		int key = Integer.parseInt(br.readLine()); // 찾는 값
		
		Arrays.sort(list);
//		result = iterFunc(list, n, key);
		result = recurFunc(list, 0, n-1, key);
		System.out.println(result);
		
	}
	
	// binarysearch 반복문
	static int iterFunc(int[] list, int n, int key) {
		int start = 0;
		int end = n-1;
		int mid = 0;
		
		while(start <= end) {
			mid = (start+end)/2;
			
			if(list[mid] == key) return mid;
			else if(list[mid] < key) start = mid+1;
			else end = mid-1;
		}
		return -1;
	}
	
	// binarysearch 재귀
	static int recurFunc(int[] list, int start, int end, int key) {
		if(start > end) return -1;
		else {
			int mid = (start+end)/2;
			
			if(list[mid] == key) return mid;
			else if(list[mid] < key) return recurFunc(list, mid+1, end, key);
			else return recurFunc(list, start, mid-1, key);
		}
	}
	
}
