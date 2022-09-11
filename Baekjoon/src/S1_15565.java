import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 2022.09.11
 * 귀여운 라이언
 */
public class S1_15565 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 인형 수
		int k = Integer.parseInt(st.nextToken()); // 라이언 인형 조건
		ArrayList<Integer> lion = new ArrayList<>(); // 라이언 위치 담기위한 리스트
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int doll = Integer.parseInt(st.nextToken());
			if(doll == 1) lion.add(i); // 위치 담기 
		}

		if(k > lion.size()) { // 만들 수 없다면 끝
			System.out.println(-1);
			return;
		}
		
		int result = Integer.MAX_VALUE; 
		for(int i = 0, size = lion.size(); i < size; i++) {
			int j = i + k - 1; // k개 뒤에 있는 라이언 위치 
			if(j >= size) break; // 범위 벗어나면 제외
			result = Math.min(result, lion.get(j) - lion.get(i) + 1); // i, j의 위치 차이로 갱신
			
		}
		
		System.out.println(result);
		
	}
}
