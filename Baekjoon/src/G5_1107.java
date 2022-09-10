import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.09.10
 * 리모컨
 * 애증의 리모컨. 임의의 한 자리수를 더 만들어서 넣을 수 있는 값들을 넣어서 구했음 
 * 예를 들어 999라면 4자리를 만들어 고장난 버튼은 뺴고 각 자리수에 들어갈 수 있도록
 * 다만 index 0, 1은 조건에 따라 0이 고장이 나도 들어갈 수 있으니까 예외처리를 했다
 * 근데 굉장히ㅣㅣㅣㅣㅣㅣㅣㅣㅣ 오래 걸림. 
 * 0부터 999999까지 완탐을 하는게 더 효율적이다.. 왜냐면 난 최대값일때도 굳이 볼 필요없는 자리수를 하나 더 만드니까 ㅠ
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
		
		int value = 0; // 값 변환 
		for(int i = 0, size = n.length; i < size; i++) {
			value += (n[i] - '0') * Math.pow(10, size - i -1);
		}
		
		int result = Math.abs(value - 100); // 현재 채널(100)에서 직접 이동하는게 더 빠를 수도 있음 
		
		if(m == 0) { // 고장난 버튼이 하나도 없을 때
			System.out.println(Math.min(n.length, result));
			return;
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean[] buttons = new boolean[10]; // 고장난 버튼 표시
		for(int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			buttons[num] = true; 
		}
	

		if(value == 100) { // 기존 채널이면 바꿀 필요 없음
			System.out.println(0);
			return; 
		}
		
		char[] _n = new char[n.length+1];
		_n[0] = '0';
		for(int i = 1; i < n.length+1; i++) {
			_n[i] = n[i-1];
		}
//		System.out.println(Arrays.toString(n));
//		System.out.println(Arrays.toString(_n));
		
		
		int[] dx = {-1, 1}; 
		Queue<channel> q = new LinkedList<>();
		q.offer(new channel(_n, 0));
		
		while(!q.isEmpty()) { // 채널 후보를 다 체크할 때까지 반복
			channel cur = q.poll();
			

			
			if(cur.index == n.length + 1) { // 모든 인덱스를 다 체크했다면 값 계산해서 갱신
				int cnt = cur.num.length; // 채널 길이만큼 버튼 눌러야함
				int _value = 0; 
				
				for(int i = 0, size = n.length+1; i < size; i++) { // 채널 값 변환
					int ch = cur.num[i] - '0';
					if(i == 0 && ch == 0 && cur.num[i+1] == '0' && cnt != 2) cnt -= 2; 
					else if(i == 0 && ch == 0) cnt--;

					_value += ch * Math.pow(10, size - i -1);
				}
				
				cnt += Math.abs(value - _value);
				result = Math.min(cnt, result); // 더 작은 값으로 갱신
//				System.out.println(Arrays.toString(cur.num) + " " + _value + " " + cnt);
				continue;
			}
			
			char[] num = cur.num; // 배열 
			int index = cur.index; // 인덱스
			int check = num[index] - '0'; // 배열 인덱스의 값

			for(int i = 0; i <= 5; i++) {
				for(int d = 0; d < 2; d++) {
					if(i == 0 && d == 1) continue;
					if(i == 5 && d == 1) continue;
					
					int next = (check + 10 + i * dx[d]) % 10; // 해당 자리수의 값을 변환
					boolean flag = false; 
					
					
					if(index == 0 && next == 0) flag = true;
					if(index == 1 && next == 0 && num[0] == '0' && num.length != 2) flag = true;
					
					if(buttons[next]) {
						if(!flag) continue;
					}
					char[] _num = num.clone();
					_num[index] = (char) (next + '0');
					q.offer(new channel(_num, index+1));
				}
			}
			
			
		}
		
		System.out.println(result);
		
	}
}
