import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.02.04
 * 스위치 켜고 끄기
 */
public class S4_1244 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		// 1부터 관리하기 위해 앞에 0칸 생성
		int[] switches = new int[num+1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i < num+1; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int sNum = Integer.parseInt(br.readLine());
		for(int i = 0; i < sNum; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sex = Integer.parseInt(st.nextToken());
			int point = Integer.parseInt(st.nextToken());
			
			
			// 남학생
			if(sex == 1) {
				for(int j = 1; j < num+1; j++) {
					if(j % point == 0) {
						if(switches[j] == 0) switches[j] = 1;
						else switches[j] = 0;
					}
				}
				
			// 여학생
			}else {
				if(switches[point] == 0) switches[point] = 1;
				else switches[point] = 0;
			
				int front = point - 1;
				int back = point + 1;
				while(back < num+1 && front > 0 && switches[front] == switches[back]) {
					if(switches[front] == 1) {
						switches[front] = 0;
						switches[back] = 0;
					}else {
						switches[front] = 1;
						switches[back] = 1;
					}
					front--;
					back++;
				}
				
			}
		}
		
		for(int i = 1; i < num+1; i++) {
			System.out.printf("%d ", switches[i]);
			if(i % 20 == 0) {
				System.out.println();
			}
		}
		
	}

}
