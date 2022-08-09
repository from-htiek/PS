import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

/*
 * 2022.08.09
 * AC
 * 구현보다는 입출력에서 걸리는게 많았던 문제
 * deque로 구현했으나 가장 빠른건 비트연산인것같고 직접 빼는 작업을 하지 않고 인덱스로 관리하는것도 충분히 빠른듯하다.
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
			String string = br.readLine().replace("[", "").replace("]", ""); // 들어오는 배열 
			StringTokenizer st = new StringTokenizer(string, ","); 
			
			Deque<Integer> deque = new ArrayDeque<>(); // 숫자만 배열에 삽입
			
			for(int i = 0; i < n; i++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}
			
			boolean flag = false; // 에러 체크
			direction = 0; // 처음 디폴트 방향 0 
			for(int i = 0, size = p.length(); i < size; i++) {
				char ch = p.charAt(i);
				if(ch == 'R') { // R일 때 
					if(direction == 0) direction = 1; // 방향 뒤집기
					else direction = 0; 
				}else { // D일 때 
					if(deque.size() == 0) {
						flag = true;
						break; // 배열이 없으면 에러 
					}
					
					if(direction == 0) deque.removeFirst();
					else deque.removeLast();
				}
				
			}
			
			if(flag) {
				sb.append("error\n");
			}else {
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
					sb.append("[]\n");
				}
			}
			
			
		}
		
		System.out.println(sb.toString());
		
	}
}
