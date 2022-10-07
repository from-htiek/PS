import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.10.07
 * 1학년
 */
public class G5_5557 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 숫자의 개수
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] list = new int[n];
 		for(int i = 0; i < n; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
 		
 		// 어떻게 풀어야할지 감도 안온다. 어떻게 풀어야할까? 
		
	}
}
