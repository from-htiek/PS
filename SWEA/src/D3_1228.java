import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 2022.02.08
 * 암호문1
 */
public class D3_1228 {
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
			// while(st.hasMoreTokens())도 가능
			for(int i = 0; i < cnt; i++) {
				String insert = st.nextToken(); // I 
				int idx = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());

				for(int _ = 0; _ < num; _++) {
					list.add(idx+_, Integer.parseInt(st.nextToken()));
				}
			}
			// Stringbuilder 사용 가능
			System.out.printf("#%d ", tc);
			for(int _ = 0; _ < 10; _++) {
				System.out.printf("%d ", list.get(_));
			}
			System.out.println();

		}
	}
}
