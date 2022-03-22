import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.02.14
 * 도영이가 만든 맛있는 음식
 * 
 * wjsdjqqpxj
 * 매개변수를 하나만 주고, idx == n일때만 visitied가 1인것 계산
 * 
 * kwon2852
 * flag 대신 쓴맛이 0보다 클 때를 이용 => 쓴맛은 무조건 양의 정수, 하나라도 선택되었다면 1 이상임 ! 
 * 비트 마스킹 이용
 * subset을 구할 때 visitied 대신  flag & 1<<idx => 선택 한 것, flag | 1<<idx => 선택하지 않은 것
 */
public class S1_2961 {
	static int n, dish[][], result;
	static boolean visitied[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		dish = new int[n][2];
		visitied = new boolean[n];
		result = Integer.MAX_VALUE;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			dish[i][0] = Integer.parseInt(st.nextToken());
			dish[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 입력이 1개면 바로 출력
		if(n == 1) result = Math.abs(dish[0][0] - dish[0][1]);
		// 신맛은 곱이므로 1이 기본값
		else subset(0, 1, 0);
		
		System.out.println(result);
	}
	
	static void subset(int idx, int sour, int bitter) {
		if(idx == n) {
			// 하나도 선택하지 않은 값 제외 => 1이 하나라도 있으면 flag는 1 
			int flag = 0;
			for(int i = 0; i < n; i++) {
				if(visitied[i]) {
					flag += 1;
					break;
				}
			}
			
			// 재료가 하나라도 선택되었을 때, 결과 갱신
			if(flag != 0) {
				//System.out.println("sour : " + sour + " bitter : " + bitter);
				result = Math.min(result, Math.abs(sour-bitter));
			}
			
			return;
		}
		
		visitied[idx] = true;
		subset(idx+1, sour*dish[idx][0], bitter+dish[idx][1]);
		visitied[idx] = false;
		subset(idx+1, sour, bitter);
	}
}
