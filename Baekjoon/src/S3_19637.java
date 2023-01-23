import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
 * 2023.01.23
 * IF문 좀 대신 써줘
 * 1. Stringbuilder의 힘은 생각보다 강력함
 * 2. 아직 나는 이분탐색을 잘 모름
 * return을 list[start]로 해줘야하는구나.. 여기서 한참 헤맸다
 */
public class S3_19637 {
	public static int list[], cnt;
	public static HashMap<Integer, String> hashmap;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 칭호 개수
		int m = Integer.parseInt(st.nextToken()); // 캐릭터 개수
		
		hashmap = new HashMap<>();
		list = new int[n];
		Arrays.fill(list, 1000000001);
		cnt = 0; // 중복을 제외한 칭호 개수
		
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
		
		Arrays.sort(list); // 정렬
		
		for(int i = 0; i < m; i++) {
			sb.append((hashmap.get(binarySearch(0, cnt-1, Integer.parseInt(br.readLine()))))).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	// 이분탐색 
	public static int binarySearch(int start, int end, int key) {
		if(start > end ) return list[start]; 
		else {
			int mid = (start + end) / 2;
			
			if(list[mid] == key) return list[mid];
			else if(list[mid] < key) return binarySearch(mid+1, end, key);
			else return binarySearch(start, mid-1, key);
		}
	}
}
