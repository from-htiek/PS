import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.02.08
 * 한빈이와 Spot Mart
 * 
 * 박대현_0434556
 * weight 오름 차순 정렬 
 * => weight[i]+wieght[j]가 result보다 크다면 i를 올려(더 큰값) 더해 비교
 * => weight[i]+wieght[j]가 result보다  작다면 j를 내려(더 작은값) 더해 비교
 * 
 * 윤준수_0447510
 * weight 오름 차순 정렬 
 * => binary search, 반을 나눠 mid가 max weight보다 mid보다 값이 큰 이후 인덱스는 계산할 필요 X
 * 난수처럼 숫자가 둘쭉날쭉일때는 Arrays.sort보다 Arrays.parallelSort가 더 빠름
 */
public class D3_9229 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			int[] weight = new int[n];
			
			for(int _ = 0; _ < n; _++) {
				weight[_] = Integer.parseInt(st.nextToken());
			}
			
			int result = -1;
			// i는 n-1까지만 돌아도 됨
			for(int i = 0; i < n; i++) {
				for(int j = i+1; j < n; j++) {
					if(weight[i] + weight[j] <= m){
						result = Math.max(weight[i] + weight[j], result);
					}
				}
			}
			
			System.out.printf("#%d %d", tc, result);
		}

	}


}
