import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

/*
 * 2022.08.07
 * AC
 * 마의 33퍼.. 
 */
public class G5_5430 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		
		int direction; // 방향
		for(int tc = 0; tc < t; tc++) {
			String p = br.readLine(); // 수행할 함수 
			int n = Integer.parseInt(br.readLine()); // 배열의 개수
			StringTokenizer st = new StringTokenizer(br.readLine(), ","); // 들어오는 배열 

			
			Deque<Integer> deque = new ArrayDeque<>(); // 숫자만 배열에 삽입
			
			if(n > 2) { // 입력, 하지만 이렇게 받으면 안될것같음 
				int num = 0; 
				String _num = st.nextToken();
				if(_num.length() == 2) num += _num.charAt(1) - '0';
				else if(_num.length() == 3) {
					num += (_num.charAt(1) - '0') * 10;
					num += _num.charAt(2) - '0';
				}
				deque.add(num);
				
				for(int i = 1; i < n-1; i++) {
					deque.add(Integer.parseInt(st.nextToken()));
				}
				
				
				num = 0;
				_num = st.nextToken();
				if(_num.length() == 2) num += _num.charAt(0) - '0';
				else if(_num.length() == 3) {
					num += (_num.charAt(0) - '0') * 10;
					num += _num.charAt(1) - '0';
				}
				deque.add(num);
				
			}else if(n == 1) {
				int num = 0; 
				String _num = st.nextToken();
				if(_num.length() == 3) num += _num.charAt(1) - '0';
				else if(_num.length() == 4) {
					num += (_num.charAt(1) - '0') * 10;
					num += _num.charAt(2) - '0';
				}
				deque.add(num);
			}

			direction = 0; // 처음 디폴트 방향 0 
			for(int i = 0, size = p.length(); i < size; i++) {
				char ch = p.charAt(i);
				if(ch == 'R') { // R일 때 
					if(direction == 0) direction = 1; // 방향 뒤집기
					else direction = 0; 
				}else { // D일 때 
					if(deque.size() == 0) break; // 배열이 없으면 에러 
					
					if(direction == 0) deque.removeFirst();
					else deque.removeLast();
				}
				
			}
			
			
			if(!deque.isEmpty()) {
				sb.append("[");
				if(direction == 0) {
					Iterator itr = deque.iterator();
					while(itr.hasNext()) sb.append(itr.next()).append(",");
				}else {
					Iterator itr = deque.descendingIterator();
					while(itr.hasNext()) sb.append(itr.next()).append(",");
				}
				
				sb.deleteCharAt(sb.lastIndexOf(","));
				sb.append("]\n");
			}else {
				sb.append("error\n");
			}
			
			
		}
		
		System.out.println(sb.toString());
		
	}
}
