import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 2022.06.29
 * 통계학
 */
public class S3_2108 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] list = new int[n];
		int[] cnt = new int[8001];
		int sum = 0; 
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			list[i] = num;
			cnt[num + 4000]++; 
			sum += num;
		}
		
//		System.out.println("---------");
		System.out.println((int)Math.round((double)sum/n)); // 산술평균 
		
		Arrays.sort(list);
		System.out.println(list[n/2]); // 중앙값 
		
		int max_num = 0; 
		int cnt_check = 0; 
		int check = 1; 
		for(int i = 0; i < n; i++) {
			if(cnt_check < cnt[list[i] + 4000]) {
				max_num = list[i];
				cnt_check = cnt[list[i] + 4000];
				check = 1; 
//				System.out.println("1 " + max_num + " " + cnt_check);
			}else if(cnt_check == cnt[list[i] + 4000]) {
				if(max_num != list[i]) {
					check++; 
					if(check == 2) max_num = list[i]; // 두 번째로 작은 값
//					System.out.println("2 " + max_num + " " + cnt_check);
//					System.out.println(check);
				}
			}
		}
		
		System.out.println(max_num); // 최빈값
		
		System.out.println(Math.abs(list[0] - list[n-1])); // 범위
		
		
		
		
		
	}
}
