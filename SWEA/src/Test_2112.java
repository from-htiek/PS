import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.04.07
 * 보호 필름
 */
public class Test_2112 {
	
	static int d, w, k, film[][], drugA[], drugB[], result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken()); // 행
			w = Integer.parseInt(st.nextToken()); // 열
			k = Integer.parseInt(st.nextToken()); // 합격기준
			result = Integer.MAX_VALUE; // 최소 약품 투입 횟수
			film = new int[d][w]; // A : 0, B : 1 			
			for(int i = 0; i < d; i++) {  
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			drugA = new int[w];
			drugB = new int[w];
			Arrays.fill(drugA, 0);
			Arrays.fill(drugB, 1);
			
			
			subset(0, 0);
			sb.append("#").append(tc).append(" ").append(result).append("\n");
					
		}
		
		System.out.println(sb.toString());
	}
	
	static boolean subset(int idx, int cnt) { // idx : 현재 행, cnt : 약품 투입 횟수 
		
		if(idx == d) { // 마지막 행까지 선택을 마쳤으면 체크 
			
			if(cnt >= result) return false; // 현재 result보다 사용한 투여횟수가 많으면 계산 X
	
			for(int j = 0; j < w; j++) { // 모든 열 체크
				int check = 1;
				int cur = film[0][j];
				for(int i = 1; i < d; i++) {
					if(cur == film[i][j]) {
						check++;
						if(check == k) break; 
						
					}
					else {
						check = 1;
						cur = film[i][j];
					}
				}
				
				if(check < k) return false; 
			}
			
			
			result = Math.min(result, cnt);
			return true; 
		}
		
		int[] tmp = film[idx]; // 현재 행 저장 
		
		// 선택 X 
		if(subset(idx+1, cnt)) return true;
		
		// 선택 A, 현재 행을 A가 채워진 행으로 바꾸기
		film[idx] = drugA;
		subset(idx+1, cnt+1); 
		
		// 선택 B, 현재 행을 B가 채워진 행으로 바꾸기
		film[idx] = drugB;
		subset(idx+1, cnt+1);
		
		film[idx] = tmp; // 되돌리기
		
		return false;
		
	}
}
