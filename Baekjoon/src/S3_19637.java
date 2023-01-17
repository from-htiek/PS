import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
 * 2023.01.17
 * IF문 좀 대신 써줘
 * 내일 범위 바꿔서 다시 풀어보는걸로
 */
public class S3_19637 {
	public static int list[], cnt;
	public static HashMap<Integer, String> hashmap;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 칭호 개수
		int m = Integer.parseInt(st.nextToken()); // 캐릭터 개수
		
		hashmap = new HashMap<>();
		list = new int[n];
		Arrays.fill(list, 1000000001);
		cnt = 0;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			
			if(hashmap.get(num) == null) {
				hashmap.put(num, str);
				list[cnt] = num;
				cnt++;
			}
		}
		
		Arrays.sort(list);
		System.out.println(hashmap);
//		System.out.println(Arrays.toString(list));
		
		for(int i = 0; i < m; i++) {
			System.out.println(binarySearch(0, cnt-1, Integer.parseInt(br.readLine()), 0));
		}
		
	}
	
	public static int binarySearch(int start, int end, int key, int idx) {
		if(start > end || end < 0 || start >= cnt) return idx;
		else {
			int mid = (start + end) / 2;
			
			if(list[mid] == key) return mid;
			else if(list[mid] < key) return binarySearch(mid+1, end, key, mid+1);
			else return binarySearch(start, mid-1, key, mid-1);
		}
	}
}
