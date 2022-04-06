import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.04.06
 * 게리멘더링
 * 
 * 나눌 수 없을때는 -1.. 문제를 제대로 읽자
 * 오늘 문제를 풀면서 느낀점 : 부분집합을 만들어서 넘기는걸 어려워하는 듯함 
 * 이 문제는 아니지만 배열을 다시 되돌리는 것도 어려워하는 듯 
 */
public class G4_17471 {
	static int n, population[], result;
	static List<Integer>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		population = new int[n+1]; // 0인덱스 사용X 
		result = Integer.MAX_VALUE; // 최소값 
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		list = new ArrayList[n+1];
		for(int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>(); // 리스트 초기화
		}
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int _n = Integer.parseInt(st.nextToken());
			for(int j = 0; j < _n; j++) {
				int end = Integer.parseInt(st.nextToken());
				list[i].add(end);
			}
		}
		
		// 입력 확인 
//		for(List<Integer> m: list) {
//			System.out.println(m);
//		}
		
		
		// nC1 ~ nC(n/2)까지 조합 만들기
		for(int i = 1; i <= n/2; i++) {
			combination(0, 1, i, new int[i]);
		}
		
		
		if(result == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(result);
		
	}
	
	// 조합
	static void combination(int idx, int start, int end, int[] aRegion) {
		
		if(idx == end) { // 조합 만들기 끝 
			int[] bRegion = new int[n-end]; // 선택되지 않는 지역들로 그룹 B 만들기
			
			int k = 0; 
			for(int i = 1, j = 0; i <= n; i++) {
				if(j < end && aRegion[j] == i) j++;
				else bRegion[k++] = i;
			}
			
			if(isPossible(aRegion, end) && isPossible(bRegion, n-end)) { // A, B 각 그룹끼리 연결될 수 있다면 값 계산
				
				int aSum = 0;
				int bSum = 0;
				
				for(int i = 0; i < end; i++) {
					aSum += population[aRegion[i]];
				}
				
				for(int i = 0; i < n-end; i++) {
					bSum += population[bRegion[i]];
				}

				result = Math.min(result, Math.abs(aSum-bSum));
			}

			return; 
		}
		
		for(int i = start; i <= n; i++) {
			aRegion[idx] = i;
			combination(idx+1, i+1, end, aRegion);
		}
	}

	public static boolean isPossible(int[] region, int end) { // 만든 그룹이 연결되어 있는지 체크
		Queue<Integer> q = new LinkedList<>();
		boolean[] visitied = new boolean[n+1];
		
		q.offer(region[0]);
		visitied[region[0]] = true;
		int cnt = 1; 
		
		if(cnt == end) return true; // 길이가 1이면 바로 true 리턴 
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i = 1; i < end; i++) { // region 배열 돌면서, 연결되어 있는 지역 만나면 cnt++, q에 넣기
				for(int num : list[cur]) {
					if(num == region[i] && !visitied[num]) {
						q.offer(num);
						visitied[num] = true; 
						cnt++;
						
						if(cnt == end) return true;
					}
				}
			}
		}
		
		return false;
	}
}
