import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.09.16
 * 거짓말
 * 예외
10 10 
1 1 
2 10 1
2 9 2
2 8  3
2 7 4
2 6 5
2 5 7 
2 4 8
2 3 9 
2 2 10 
1 1
 */
public class G4_1043 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 사람의 수
		int m = Integer.parseInt(st.nextToken()); // 파티의 수
		
		int[] truth = new int[n+1]; // 진실을 아는 사람 
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		for(int tc = 0; tc < t; tc++) { 
			truth[Integer.parseInt(st.nextToken())] = -1; 
		}
		
		
		for(int tc = 0; tc < m; tc++) { // 파티 수 만큼 반복 
			boolean flag = false; // 진실을 아는 사람이 있는지 체크 
			String str = br.readLine();
			st = new StringTokenizer(str);
			int num = Integer.parseInt(st.nextToken());
			for(int i = 0; i < num; i++) {
				if(truth[Integer.parseInt(st.nextToken())] == -1) { // 진실을 아는 사람이 있다 
					flag = true; 
					break; 
				}
			}
			
			st = new StringTokenizer(str);
			st.nextToken();
			if(flag) { // 있을 때는 같이 파티에 온 사람들도 모두 진실을 알고 있음 
				for(int i = 0; i < num; i++) {
					truth[Integer.parseInt(st.nextToken())] = -1;
				}
			}else { // 거짓말 가능, 일행 한명만 체크 
				truth[Integer.parseInt(st.nextToken())]++; 
			}
		}
		
		int result = 0; 
		for(int i = 1; i <= n; i++) {
			if(truth[i] != -1) result += truth[i];
		}
		
		System.out.println(Arrays.toString(truth));
		System.out.println(result);
	}
}
