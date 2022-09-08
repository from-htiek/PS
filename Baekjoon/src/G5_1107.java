import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.09.08
 * 리모컨
 */
public class G5_1107 {
	public static class channel{
		char[] num;
		int index;
		
		public channel(char[] num, int index) {
			super();
			this.num = num;
			this.index = index;
		}
		
		@Override
		public String toString() {
			return "channel [num=" + Arrays.toString(num) + ", index=" + index + "]";
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] n = br.readLine().toCharArray(); // 이동하려는 채널
		int m = Integer.parseInt(br.readLine()); // 고장난 버튼의 개수
		if(m == 0) { 
			System.out.println(n.length);
			return;
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean[] buttons = new boolean[10]; // 고장난 버튼 표시
		for(int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			buttons[num] = true; 
		}
		
		int value = 0; // 값 변환 
		for(int i = 0, size = n.length; i < size; i++) {
			value += (n[i] - '0') * Math.pow(10, size - i -1);
		}
		
		if(value == 100) { // 기존 채널이면 바꿀 필요 없음
			System.out.println(0);
			return; 
		}
		
		int result = Integer.MAX_VALUE; 
		int[] dx = {-1, 1}; 
		Queue<channel> q = new LinkedList<>();
		q.offer(new channel(n, 0));
		
		while(!q.isEmpty()) {
			channel cur = q.poll();
			if(cur.index == n.length) { // 모든 인덱스를 다 체크했다면 값 계산해서 갱신
//				System.out.println(Arrays.toString(cur.num));
				int cnt = cur.num.length;
				int _value = 0; 
				for(int i = 0, size = n.length; i < size; i++) {
					_value += (cur.num[i] - '0') * Math.pow(10, size - i -1);
				}
				
				cnt += Math.abs(value - _value);
				result = Math.min(cnt, result);
				continue;
			}
			
			char[] num = cur.num;
			int index = cur.index;
			int check = num[index] - '0';
//			if(!buttons[num]) continue; // 고장나지 않았다면 그냥 들고가도 될까? 
			boolean flag = false; 
			
			// 고장난 버튼을 제외하고 만들 수 있는 작은 수 중에 가장 큰수 || 큰수 중에 가장 작은 수
			// => 어떻게 만들 수 있지? 
			for(int i = 0; i <= 5; i++) {
				for(int d = 0; d < 2; d++) {
					if(i == 0 && d == 1) continue; 
//					if(i == 5 && d == 2) continue;
					int next = (check + 10 + i * dx[d]) % 10; // 해당 자리수의 값을 변환 
					
					if(buttons[next]) continue;
					char[] _num = num.clone();
					_num[index] = (char) (next + '0');
					q.offer(new channel(_num, index+1));
//					if(i != 0) flag = true;  // 일단 빼봐? 
				}
				
//				if(flag) break; 
			}
			
			
		}
		
		System.out.println(result);
		
	}
}
