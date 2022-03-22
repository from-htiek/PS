import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

/*
 * 2022.03.12
 * 시험 감독
 * 
 * 최악의 경우에 int값을 벗어날 수 있다는걸 다시 생각해야함 
 * 
 */
public class B2_13458 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = new int[n];
		
		for(int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		long cnt = 0; // 필요한 감독관 수의 최솟값, int면 범위를 넘어날수도 있음
		
		for(int i = 0; i < n; i++) {
			num[i] -= b;
			cnt++; // 총감독관 배정
			
			if(num[i] > 0) { // 학생이 더 있다면 부감독관 배정
				cnt += num[i]/c;
				num[i] %= c; 
				if(num[i] != 0) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		
	}
}
