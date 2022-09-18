import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
/*
 * 2022.09.18
 * 햄버거 분배
 */
public class S3_19941 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 식탁의 길이
		int k = Integer.parseInt(st.nextToken()); // 햄버거를 선택할 수 있는 거리
		
		char[] pos = new char[n];
		String str = br.readLine();
		for(int i = 0; i < n; i++) {
			pos[i] = str.charAt(i); // P : 사람, H : 햄버거 
		}
		
		int result = 0;
		for(int i = 0; i < n; i++) {
			if(pos[i] == 'P') {
				for(int j = -k; j <= k; j++) {
					int idx = i + j;
					if(idx < 0 || idx >= n) continue; // 범위 벗어나면 제외
					if(pos[idx] == 'X' || pos[idx] == 'P') continue; // 이미 먹었거나, 사람이면 제외
					result++;
					pos[idx] = 'X';
					break;
				}
			}
		}
		
		System.out.println(result);
		
		
	}
}
