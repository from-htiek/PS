import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2023.01.10
 * 스네이크버드
 * 과일배열에 인덱스를 i를 넣는게 아니라 높이를 넣으면 정렬을 안해도 된다! 다른분 코드 보고 깨달음
 */
public class S5_16435 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 과일 수
		int l = Integer.parseInt(st.nextToken()); // 초기 길이 
		
		int[] fruits = new int[n]; // 과일 높이 리스트
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			fruits[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(fruits);
		
		for(int i = 0; i < n; i++) {
			if(fruits[i] > l) break;

			l++;
		}
		
		System.out.println(l);
		
		
	}
}
