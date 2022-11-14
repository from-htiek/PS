import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.11.14
 * 고층 건물
 * 어디서 잘못된거야 
 * 는 엉망이네? 피타고라스 정리로 기울기를 어케 구함! 
 */
public class G4_1027 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] buildings = new int[n];
		for(int i = 0; i < n; i++) {
			buildings[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = 0;
		for(int i = 0; i < n; i++) {
			if(i == 11) {
				System.out.println("");
			}
			int cnt = 0; 
			for(int j = 0; j < n; j++) {
				if(i == j) continue;
				int start = Math.min(i, j);
				int end = Math.max(i, j);
				double lean = buildings[end]-buildings[start] != 0 ? Math.sqrt(Math.pow(end-start, 2) + Math.pow(buildings[end]-buildings[start], 2))/(end-start) : 0;
				
				boolean flag = true;
				double height = buildings[start];
				if(buildings[start] > buildings[end]) {
					for(int k = start+1; k < end; k++) {
						if(height - lean <= buildings[k]) {
							flag = false;
							break; 
						}
						height -= lean;
					}
				}else {
					for(int k = start+1; k < end; k++) {
						if(height + lean <= buildings[k]) {
							flag = false;
							break; 
						}
						height += lean;
					}
				}
				
				if(flag) cnt++;
			}
			
			System.out.println(cnt);
			result = Math.max(result, cnt);
		}
		
		System.out.println(result);
		
	}
}
