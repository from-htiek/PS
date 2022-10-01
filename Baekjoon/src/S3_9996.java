import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 22.10.01
 * 한국이 그리울 땐 서버에 접속하지
 */
public class S3_9996 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine()); // 파일 개수
		String pattern = br.readLine();
		int idx = pattern.indexOf('*'); // * 위치 찾기
		
		for(int i = 0; i < n; i++) {
			String file = br.readLine(); // 파일
			boolean flag = true; 
			
			if(pattern.length()-1 > file.length()) { // pattern이 더 길때는 조건 만족 불가능
				sb.append("NE").append("\n");
				continue;
			}
			
			for(int j = 0; j < idx; j++) { // 앞부터 * 전까지 비교 
				if(pattern.charAt(j) == file.charAt(j)) continue;
				flag = false;
				sb.append("NE").append("\n");
				break; 
			}
			
			if(!flag) continue;
			
			for(int j = file.length()-1, k = pattern.length()-1; k > idx; j--, k--) { // 뒤부터 *직전까지 비교 
				if(pattern.charAt(k) == file.charAt(j)) continue;
				flag = false;
				sb.append("NE").append("\n");
				break; 
			}
			
			if(flag) sb.append("DA").append("\n");
			
		}
		
		System.out.println(sb.toString());
		
		
	}
}
