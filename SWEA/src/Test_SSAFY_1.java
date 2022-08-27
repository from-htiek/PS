import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.08.27
 * 낚시터 자리잡기
 * 배열 복사 이해가 완벽하지 않은듯함
 */
public class Test_SSAFY_1 {
	// 낚시터 입구
	public static class enter{ 
		int pos; // 위치
		int num; // 인원
		
		public enter(int pos, int num) {
			super();
			this.pos = pos;
			this.num = num;
		}

		@Override
		public String toString() {
			return "enter [pos=" + pos + ", num=" + num + "]";
		}
	}
	
	public static int order[], n, result;
	public static boolean visitied[];
	public static enter enters[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine()); // 낚시터의 개수
			result = Integer.MAX_VALUE; 
			
			enters = new enter[3]; // 낚시터 입구 입력
			for(int i = 0; i < 3; i++) {
				st = new StringTokenizer(br.readLine());
				enters[i] = new enter(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
			}
			
//			System.out.println(Arrays.toString(enters));
			
			order = new int[3];
			visitied = new boolean[3];
			permutation(0); // 입장 순서 
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	// 순열 
	public static void permutation(int idx) {
		if(idx == 3) {
			arrange(new boolean[n], 0, 0);
			return;
		}
		
		for(int i = 0; i < 3; i++) {
			if(visitied[i]) continue;
			visitied[i] = true;
			order[idx] = i;
			
			permutation(idx+1);
			visitied[i] = false;
		}
	}
	
	// 인원 배치
	public static int[] dx = {-1, 1};
	public static void arrange(boolean[] visitied, int idx, int sum) {
		if(idx == 3) {
//			System.out.println("sum : " + sum);
			result = Math.min(result, sum);
			return; 
		}
		
		int cnt = 0; // 현재까지 배치한 인원 수
		int check = 0; // 위치 offset
		int num = enters[order[idx]].num;
		
		while(num > cnt) { // 인원 다 배치할 때 까지 반복
			for(int d = 0; d < 2; d++) {
				int newx = enters[order[idx]].pos + check * dx[d]; // 배치할 위치 (현재 위치에서 같은 거리에 떨어진 두 지점)
				
				if(newx < 0 || newx >= n) continue; // 범위 벗어나면 제외
				if(!visitied[newx]) { // 배치하지 않았다면 배치
					visitied[newx] = true; 
					cnt++; 
					sum += check + 1; 
				}
				
				if(num == cnt) { // 인원이 다 배치되었을 때는 다음 낚시터 입구로
					boolean[] _visitied = visitied.clone();
					arrange(_visitied, idx+1, sum);
				} 
				
				if(num == cnt && d == 0) { // 인원이 다 배치되었지만, 경우의 수가 더 있을 수 있다면 
					int _newx = newx + check * 2; // 같은 거리로 떨어진 다른 지점도 비어있는지 체크
					if(_newx < 0 || _newx >= n) continue;
					if(!visitied[_newx]) {
						boolean[] _visitied = visitied.clone();
						visitied[newx] = false;
						visitied[_newx] = true; 
						arrange(_visitied, idx+1, sum);
					}
				}
			}
			
			check++; 
		}
		
	}
}
