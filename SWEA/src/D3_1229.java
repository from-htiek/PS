import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 2022.02.08
 * 암호문2
 */
public class D3_1229 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int tc = 1; tc <= 10; tc++) {
			LinkedList<Integer> list = new LinkedList<>();
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int _ = 0; _ < n; _++) {
				list.add(Integer.parseInt(st.nextToken()));
			}

			int cnt = Integer.parseInt(br.readLine()); 

			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < cnt; i++) {
				String insert = st.nextToken(); // I, D
				int idx = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				switch(insert) {
				case "I" :
					for(int _ = 0; _ < num; _++) {
						list.add(idx+_, Integer.parseInt(st.nextToken()));
					}
					break;
				case "D" :
					for(int _ = 0; _ < num; _++) {
						list.remove(idx);
					}
					
				}

			}
			System.out.printf("#%d ", tc);
			for(int _ = 0; _ < 10; _++) {
				System.out.printf("%d ", list.get(_));
			}
			System.out.println();

		}

	}

}
