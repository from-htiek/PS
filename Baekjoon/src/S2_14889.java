import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 2022.03.22
 * 스타트와 링크
 * 
 * 전체값을 구해놓고 startteam을 골랐을 때 점수를 계산해서 빼준다면 
 * link팀을 선택하는 부분과 점수 계산하는 부분 모두 줄일 수 있다 .. ! 
 */
public class S2_14889 {
	static int n, list[][], result, teamStart[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		list = new int[n][n];
		teamStart = new int[n/2];
		result = Integer.MAX_VALUE;
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0;  j < n; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		System.out.println(Arrays.deepToString(list));
		
		combination(0, 0);
		System.out.println(result);
	}
	
	// 조합 생성
	public static void combination(int idx, int start) {
		if(idx == n/2) { // 인원수의 반으로 팀 만들기 
			
			List<Integer> teamLink = new ArrayList<>(n/2);
			outerloop : for(int i = 0; i < n; i++) {
				for(int j = 0; j < n/2; j++) {
					if(i == teamStart[j]) continue outerloop;
				}
				
				teamLink.add(i);
			}
			
			int startScore = 0;
			int linkScore = 0;
			for(int i = 0; i < n/2; i++) {
				for(int j = 0; j < n/2; j++) {
					startScore += list[teamStart[i]][teamStart[j]];
					linkScore += list[teamLink.get(i)][teamLink.get(j)];
				}
			}
			
			result = Math.min(result, Math.abs(startScore-linkScore));
			return;
		}
		
		for(int i = start; i < n; i++) {
			teamStart[idx] = i;
			combination(idx+1, i+1);
		}
	}
}
