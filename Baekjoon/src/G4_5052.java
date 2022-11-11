import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 2022.11.11
 * 전화번호 목록
 * n^2으로 풀면 터진다. 정렬을 해서 적어도 앞자리가 제일 같은 전화번호끼리만 비교했다
 * 그럼에도 시간이 굉장히 오래 걸린다.
 * 트라이를 공부해봐야겠다.
 */
public class G4_5052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for(int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			String[] list = new String[n];
			for(int i = 0; i < n; i++) {
				list[i] = br.readLine();
			}
			
			Arrays.sort(list); // 정렬
			// System.out.println(Arrays.toString(list));
			
			int start = 0;
			int end = -1;
			boolean flag = false;
			outer : while(true) {
				int tmp = end;
				flag = false;
				char ch = list[start].charAt(0);
				for(int i = start; i < n; i++) { // 해당 숫자로 시작하는 list 범위 구하기
					if(list[i].charAt(0) != ch) {
						end = i;
						break; 
					}
				}
				
				if(end == tmp) end = n;
				
				for(int i = start; i < end; i++) {
					int len = list[i].length();
					if(len == 10) continue; // 비교 길이가 10이라면 제외 
					for(int j = start; j < end; j++) {
						if(i == j) continue; // 같은 번호는 비교 X
						if(len >= list[j].length()) continue; // 비교 길이가 더 길면 제외
						if(list[i].equals(list[j].subSequence(0, len))) {
							flag = true; 
							sb.append("NO").append("\n");;
							break outer;
						}
						
					}
				}
				
				start = end;
				if(start >= n-1) break; 
				
			}
			
			if(!flag) sb.append("YES").append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
