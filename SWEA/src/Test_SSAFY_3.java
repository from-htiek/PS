import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.08.28
 * Shuffle-O-Matic
 * 50개 중 48개만 맞음.. 엣지 케이스를 못찾겠다 
 */
public class Test_SSAFY_3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++){
			int n = Integer.parseInt(br.readLine()); // 카드의 갯수
			int[] card = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				card[i] = Integer.parseInt(st.nextToken()) - 1;
			}
		
			int half = n/2;
			int result = 0; 
			Queue<int[]> q = new LinkedList<>();
			q.offer(card);
			
			outerloop : while(!q.isEmpty()) {
				
				int size = q.size();
				while(size-- > 0) {
					int[] cur = q.poll();
					
					boolean flag = true; 
					for(int i = 0; i < n; i++) { // 오름차순 확인 
						if(cur[i] != i) {
							flag = false;
							break; 
						}
					}
					
					if(!flag) {
						flag = true;
						for(int i = 0; i < n; i++) {  // 내림차순 확인 
							if(cur[i] != n-1-i) {
								flag = false;
								break; 
							}
						}
					}
					
					
					if(flag) {
//						sb.append("#").append(tc).append(" ").append(result).append("\n");
						System.out.println("#" + tc + " " + result);
						break outerloop; 
					}
					
					// 다이아몬드 모양으로 셔플
					for(int i = half-1; i >= 0; i--) {
						for(int j = 0, len = half-1-i; j <= len; j++) {
							int tmp = 0;
							tmp = cur[i+(j*2)];
							cur[i+(j*2)] = cur[i+(j*2)+1];
							cur[i+(j*2)+1] = tmp;
						}
						
						int[] _card = cur.clone();
						q.offer(_card);
//						System.out.println(Arrays.toString(tmp));
					}
					
					for(int i = 1; i < half; i++) {
						for(int j = 0, len = half-i; j < len; j++) {
							int tmp = 0;
							tmp = cur[i+(j*2)];
							cur[i+(j*2)] = cur[i+(j*2)+1];
							cur[i+(j*2)+1] = tmp;
						}
						
						int[] _card = cur.clone();
						q.offer(_card);
//						System.out.println(Arrays.toString(tmp));
					}
				
						
				}
				
				result++;
				if(result > 5) {
					System.out.println("#" + tc + " " + -1);
//					sb.append("#").append(tc).append(" ").append(-1).append("\n");
					break outerloop;
				}
			}
		}
		
//		System.out.println(sb.toString());
	}
}
