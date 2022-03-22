import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.02.16
 * 냉장고
 */
public class JO_1828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] fridge = new int[n][2];
		int cnt = 1; // 냉장고 개수 : 최소 1개는 언제나 필요
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			fridge[i][0] = Integer.parseInt(st.nextToken());
			fridge[i][1] = Integer.parseInt(st.nextToken());
		}
	
		// 정렬 : 최고 온도 오름차순
		Arrays.sort(fridge, (o1, o2)->{
			if(o1[1]==o2[1]) return Integer.compare(o1[0], o2[0]);
			else return Integer.compare(o1[1], o2[1]);
		});
//		
//		for(int[] f : fridge) {
//			System.out.println(Arrays.toString(f));
//		}
		
		// 현재 냉장고의 최고온도가 화학물질의 최저온도 보다 높으면 같은 냉장고 사용 가능 
		int tmp = fridge[0][1];  
		for(int[] f : fridge) {
			if(tmp < f[0]) {
				tmp = f[1];
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
