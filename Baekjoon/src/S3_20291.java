import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 2022.12.05
 * 파일 정리
 */
public class S3_20291 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null; 
		int n = Integer.parseInt(br.readLine()); // 파일 수
		
		HashMap<String, Integer> hashmap = new HashMap<>();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), "."); // "."으로 분리
			st.nextToken();
			
			String extension = st.nextToken();
			if(hashmap.get(extension) == null) hashmap.put(extension, 1); // 처음 카운트 하는 확장자는 1
			else hashmap.put(extension, hashmap.get(extension)+1); // 이미 있는 확장자는 +1
		}
		
		List<String> keys = new ArrayList<>(hashmap.keySet()); // key로 정렬하기 위한 리스트 
		keys.sort((s1, s2) -> s1.compareTo(s2)); // 정렬
		for(String key : keys) {
			sb.append(key).append(" ").append(hashmap.get(key)).append("\n");
		}
		
		System.out.println(sb.toString());
		
		
	}
}
