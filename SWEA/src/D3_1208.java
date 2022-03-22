import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * 2022.02.04
 * Flatten
 */
public class D3_1208 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc <= 10; tc++) {
			int[] box = new int[100];
			int cnt = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int maxIdx = 0;
			int minIdx = 0;
			int max = 0;
			int min = 0;
			
			// 배열 입력
			for(int i = 0; i < 100; i++) {
				box[i] = Integer.parseInt(st.nextToken());
			}
					
			
			for(int c = cnt; c >= 0; c--) {
				max = 0;
				min = 101;
				for(int i = 0; i < 100; i++) {
					if(max < box[i]) {
						max = box[i];
						maxIdx = i;
					}
					if(min > box[i]) {
						min = box[i];
						minIdx = i;
					}
				}
				if(c == 0) continue;
				box[maxIdx] -= 1;
				box[minIdx] += 1;
			}

			System.out.printf("#%d %d\n", tc, max - min);

		}

	}

}
