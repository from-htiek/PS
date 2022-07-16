import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.07.16
 * 기상캐스터
 */
public class S5_10709 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken()); // JOI시 세로
		int w = Integer.parseInt(st.nextToken()); // JOI시 가로
		
		char[][] sky = new char[h][w]; // 하늘 
		int[][] result = new int[h][w]; // 구름이 뜨는 데 걸리는 시간 
		for(int i = 0; i < h; i++) {
			sky[i] = br.readLine().toCharArray();
			Arrays.fill(result[i], 999); // 999로 초기화
 		}
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				if(sky[i][j] == 'c') { // 구름이 떠 있을 때 
					
					for(int t = 0; t < w; t++) {
						if(j + t >= w) continue; // 범위 넘으면 제외
						result[i][j+t] = Math.min(result[i][j+t], t); // 가장 빨리 구름 뜰 때로 갱신
					}
				}
			}
		}
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				if(result[i][j] == 999) sb.append(-1).append(" "); // 999는 -1로 치환 
				else sb.append(result[i][j]).append(" ");
			}
			
			sb.append("\n");
		}
		
		
		System.out.println(sb.toString());
		
	}
}
