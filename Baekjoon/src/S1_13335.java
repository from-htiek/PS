import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.08.06
 * 트럭
 * 문제를 보고 큐를 전혀 떠올리지 못한걸보면 나는 아직 자료구조가 많이 부족한가보다.
 * 다른 분들 코드를 보니, int[] 배열로 큐에 넣고 
 * [0]에는 트럭의 인덱스를, [1]에는 시간을 넣으시더라.
 * 생각해보면 버스가 처음 도로에 들어가서 도로를 벗어나는시간은 '도로에 들어간 시간 + 도로길이' 였다
 * ..난 전혀 깨닫지못했다. 생각을 좀 더 하면서 문제를 풀ㅈㅏ..
 */
public class S1_13335 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 다리를 건너는 트럭 수
		int w = Integer.parseInt(st.nextToken()); // 다리 길이
		int l = Integer.parseInt(st.nextToken()); // 다리의 최대 하중
		
		int[] trucks = new int[n]; // 트럭 무게 
		int[] pos = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			trucks[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int cnt = 1; // 최단 시간
		int idx = 0; // 도로의 첫 트럭 위치 
		int sum = trucks[0]; // 현재 다리 위의 무게 
		pos[idx] = 1; 
		
		while(true) {
			cnt++; 
			
			if(++pos[idx] > w) { // 위치가 다리길이보다 크다면 다리를 다 지나갔으므로 무게에서 빼주고 idx를 첫 트럭 위치 바꿔줌 
				sum -= trucks[idx];
				idx++; 
				
				if(idx == n) {
					System.out.println(cnt);
					return; 
				}
				
				if(pos[idx] == 0) sum += trucks[idx];
				pos[idx]++; 
			}
			
			
			for(int i = 1; i < w; i++) {
				if(idx + i >= n) break; // 범위를 벗어난다면 제외 
				if(sum + trucks[idx+i] > l && pos[idx+i] == 0) break; // 다리 최대 하중보다 무겁다면 다리에는 다음 트럭이 올 수 없음 
				if(pos[idx+i] != 0) pos[idx+i]++; // 이미 도로위에 있는 트럭이라면 한칸 씩 앞으로 
				else if(pos[idx+i] == 0) { // 처음 도로위로 진입한 트럭이라면 무게를 더해주고 위치 체크
					sum += trucks[idx+i];
					pos[idx+i]++;
				}

			}

		}
		
	} 
}
