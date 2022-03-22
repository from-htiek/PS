import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2022.02.27
 * 의석이의 세로로 말해요
 * 
 * 캐릭터의 기본형 \u0000
 * 
 * 김문성
 * ch[i]의 길이가 i보다 작으면 continue; 
 */
public class D3_5356 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			sb.append("#").append(tc).append(" "); 
			
			char[][] ch = new char[5][15];
			
			int size = 0; 
			for(int i = 0; i < 5; i++) {
				String str = br.readLine();
				for(int j = 0, l = str.length(); j < l; j++) {
					ch[i][j] = str.charAt(j);
				}
				size = Math.max(size, ch[i].length);
			}
			
			System.out.println();
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < 5; j++) {
					if(ch[j][i] != '\u0000') sb.append(ch[j][i]);
					
				}
			}
			
			System.out.println(sb.toString());
		}
	}
}
