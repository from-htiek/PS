import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


/*
 * 2022.02.23
 * 치킨 배달
 * 
 * Next permutation을 이용한다면 ? 
 * 
 * mjkim103301
 * 입력 받을 때 1이면 집 리스트에, 2면 치킨집 리스트에 넣어 n*n만큼 탐색하지 않고 이 둘만 비교!
 */
public class G5_15686 {
	static int n, m, list[], map[][], length, result;
	static ArrayList<int[]> chicken;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken()); // 폐업 시키지 않을 치킨집 
		map = new int[n][n];
		list = new int[m]; // m개 선택했을 때의 combination 리스트
		chicken = new ArrayList<>(); // 치킨 집 좌표
		result = Integer.MAX_VALUE; // 치킨 거리 최솟값
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 2) chicken.add(new int[]{i, j}); 
			}
		}
		
		length = chicken.size();
		

		// m개를 선택했을 때의 combination만들고 계산
		combination(0, 0);

		System.out.println(result);
	}
	
	public static void combination(int idx, int start) {
		if(idx == m) { // m개 선택 되었을 때
			int tmp; 
			int distance = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(map[i][j] == 1) { // 집일 때 
						int min = Integer.MAX_VALUE;
						for(int k = 0; k < m; k++) { // 가장 가까운 치킨 거리 구하기 
							tmp = Math.abs(i-chicken.get(list[k])[0]) +  Math.abs(j-chicken.get(list[k])[1]);
							min = Math.min(tmp, min);
						}
						
						distance += min; // 해당 치킨집이 선택 됐을 때, 마을 전체의 치킨 거리 계산
					}
									
				}
			}
			
			result = Math.min(result, distance); // 최솟값 구하기
			return;
		}
		for(int i = start; i < length; i++) {
			list[idx] = i;
			combination(idx+1, i+1);
		}
	}
}
