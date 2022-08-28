import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.08.28
 * 헌터
 */
public class Test_SSAFY_2 {
	public static class pos{
		int y;
		int x;
		int value; 
		
		public pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
		public pos(int y, int x, int value) {
			super();
			this.y = y;
			this.x = x;
			this.value = value;
		}

		@Override
		public String toString() {
			return "pos [y=" + y + ", x=" + x + "]";
		}
		
	}
	
	public static boolean visitied[];
	public static int length, order[], result; 
	public static ArrayList<pos> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= t; tc++) {
			list = new ArrayList<>(); // 고객, 몬스터 위치 담기 리스트          
			int n = Integer.parseInt(br.readLine());
			
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					int dot = Integer.parseInt(st.nextToken());
					if(dot != 0) list.add(new pos(i, j, dot)); // 0이 아닐 때 list에 추가
				}
			}
			
			length = list.size(); // 고객, 몬스터 수
			visitied = new boolean[length]; // 순열 만들기 위한 방문 체크
			order = new int[length]; // 방문 순서
			result = Integer.MAX_VALUE; // 작업 완료할 수 있는 가장 빠른 시간
			permutation(0);
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	// 순열
	public static void permutation(int idx) {
		if(idx == length) {
			
			// 해당 순서가 유효한 순서인지 체크 
			// 바로는 아니더라도 적어도 몬스터를 죽이고 해당 고객에게 방문해야 함
			for(int i = 0; i < length; i++) {
				int cur = list.get(order[i]).value; 
				
				for(int j = 0; j < length; j++) {
					if(i == j) continue;
					int check = list.get(order[j]).value;
					
					if(Math.abs(cur) == Math.abs(check)) { // 몬스터와 고객은 절대값이 같음
						if((cur < 0 && i < j) 
								|| (cur > 0 && i > j)) return; // 순서 유효하지 않으면 해당 순열은 버림
					}
				}
			}
			
//			System.out.println(Arrays.toString(order));
			result = Math.min(result, visit());
			return;
		}
		
		for(int i = 0; i < length; i++) {
			if(visitied[i]) continue;
			visitied[i] = true;
			order[idx] = i;
			
			permutation(idx+1);
			visitied[i] = false;
		}
	}
	
	// 순서대로 방문 후 작업 시간 계산
	public static int visit() {
		int sum = 0; // 작업 완료 시간 
		
		pos prev = new pos(0, 0); // 헌터는 항상 (0, 0) 에서 출발
		for(int i = 0; i < length; i++) {
			pos cur = list.get(order[i]);
			
			sum += Math.abs(prev.x - cur.x) + Math.abs(prev.y - cur.y);
			prev = cur; 
		}
		
//		System.out.println(sum);
		return sum; 
	}
}
