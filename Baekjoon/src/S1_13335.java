import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.08.03
 * 트럭
 */
public class S1_13335 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 다리를 건너는 트럭 수
		int w = Integer.parseInt(st.nextToken()); // 다리 길이
		int l = Integer.parseInt(st.nextToken()); // 다리의 최대 하중
		
		int[] trucks = new int[n]; // 트럭 무게 
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			trucks[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] pos = new int[n]; // 트럭 위치 체크 
		int cnt = 0; // 최단 시간 
		int idx = 0; // 위치 체크를 위한 index
		int sum = trucks[idx]; 
		while(true) {
			cnt++; 
			pos[idx]++; 
			
			if(pos[idx] > w) {
				sum -= trucks[idx];
				idx++;
			}
		
			if(idx == n) break;
			
			if(pos[idx] == 0) {
				pos[idx]++;
				sum += trucks[idx];
			}
			
			for(int i = 1; i < pos[idx]; i++) {
				if(idx+i >= n) break;
				if(sum + trucks[idx+i] <= l) {
					pos[idx+i]++; 
					sum += trucks[idx+i];
				}
			}
			
			
		}
		
		System.out.println(Arrays.toString(pos));
		System.out.println(cnt);
		
	}
}
