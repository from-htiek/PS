import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/*
 * 2022.01.05
 * 이모티콘
 * 꼭 방문 배열을 1002로 줘야할까 내가 짜놓고도 근거가 부족한것같은데
 */
public class G4_14226 {
	public static class emoji {
		int screen;
		int clipboard;
		int cnt;
		
		public emoji(int screen, int clipboard, int cnt) {
			super();
			this.screen = screen;
			this.clipboard = clipboard;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "emoji [screen=" + screen + ", clipboard=" + clipboard + ", cnt=" + cnt + "]";
		}		
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int s = scanner.nextInt();
		
		Queue<emoji> pq = new LinkedList<>();
		boolean[][] visitied = new boolean[1002][1002];
		pq.offer(new emoji(1, 0, 0));

		while(!pq.isEmpty()) {
			emoji cur = pq.poll();
			
			if(cur.screen == s) {
				System.out.println(cur.cnt);
				return;
			}
			
			for(int d = 0; d < 3; d++) {
				int newscreen = cur.screen;
				int newclip = cur.clipboard;
				
				if(d == 0) { // 1. 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장
					newclip = cur.screen;
				}else if(d == 1) { // 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기
					newscreen = cur.screen + cur.clipboard;
				}else { // 3. 화면에 있는 이모티콘 중 하나를 삭제
					newscreen = cur.screen - 1;
					
					if(newscreen <= 0) continue;
				}
				
				if(newscreen < 0 || newscreen > 1001 || newclip < 0 || newclip > 1001) continue;
				if(visitied[newscreen][newclip]) continue;
				
				pq.offer(new emoji(newscreen, newclip, cur.cnt+1));
				visitied[newscreen][newclip] = true;
			}
		
		}
	}
}
