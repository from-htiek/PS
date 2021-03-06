import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.03.17
 * 상어 초등학교
 */
public class S1_21608 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] seat = new int[n][n]; // 자리 배치 
		int[][] favorite = new int[n*n][5]; // 입력 리스트

		for(int i = 0; i < n*n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				favorite[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 입력 확인 
		//		for(int[] f : favorite) {
		//			System.out.println(Arrays.toString(f));
		//		}

		int[] dy = {1, -1, 0, 0}; // 4방위 탐색
		int[] dx = {0, 0, 1, -1};

		for(int s = 0; s < n*n; s++) { // 총 n*n명 배치
			int like, empty; // 인접한 위치에 좋아하는 학생이 앉은 수, 빈자리 수 
			int likeMax = 0;
			int emptyMax = 0;
			int[] cur = {-1, -1}; // 배치될 자리
			for(int i = 0; i < n; i++) { // n*n 자리 탐색 
				for(int j = 0; j < n; j++) {
					like = 0;
					empty = 0; 

					if(seat[i][j] != 0) continue; // 이미 배정 된 자리는 탐색 제외 
					for(int d = 0; d < 4; d++) { // 인접칸 탐색 
						int newy = i + dy[d];
						int newx = j + dx[d];

						if(newy < 0 || newy >= n || newx < 0 || newx >= n) continue; // 범위 벗어나면 제외

						for(int k = 1; k < 5; k++) {
							if(seat[newy][newx] == favorite[s][k]) { // 인접한 곳에 좋아하는 친구가 앉았을 때
								like++; 
							}

							if(seat[newy][newx] == 0) { // 인접한 칸이 비었을 때
								empty++; 
							}
						}
					}
					
					// 인접한 자리에 좋아하는 학생이 더 많이 앉아있거나
					// 좋아하는 학생 수는 같지만 빈자리가 더 많을 때 (행열 번호 최소를 위해 같을 때는 갱신X)
					// 아직 배정되지 않았는데 좋아하는 학생도 없고 빈자리도 없을 때는 일단 기본값으로 가져가기 
					// 마지막 조건이 빠지면  arraysindexofbounds 에러남 => cur 기본값이 -1, -1 이므로 
					if(likeMax < like || (likeMax == like && emptyMax < empty)
							|| (cur[0] == -1 && like == 0 && empty == 0)) {
						likeMax = like;
						emptyMax = empty;
						cur[0] = i;
						cur[1] = j; 
					}
					
				}
			}
			
			// 배치
			seat[cur[0]][cur[1]] = favorite[s][0];
			
			
		}
		
		// 만족도 구하기
		int result = 0; // 만족도
		int[] score = {0, 1, 10 ,100, 1000}; // 만족도 점수
		for(int i = 0 ; i < n; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n*n; k++) {
					int friend = 0; 
					if(seat[i][j] == favorite[k][0]) {
					
						for(int d = 0; d < 4; d++) { // 인접칸 탐색 
							int newy = i + dy[d];
							int newx = j + dx[d];
							
							if(newy < 0 || newy >= n || newx < 0 || newx >= n) continue; // 범위 벗어나면 제외
							
							for(int l = 1; l < 5; l++) {
								if(seat[newy][newx] == favorite[k][l]) { // 인접한 곳에 좋아하는 친구가 앉았을 때
									friend++; 
								}
							}
							
						}
					}
					
					result += score[friend];
				}
			}
		}
		
		System.out.println(result);

	}
}
