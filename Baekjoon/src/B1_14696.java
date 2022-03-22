import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.02.26
 * 딱지놀이
 */
public class B1_14696 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < n; tc++) {
			// 1 : 세모, 2 : 네모, 3 : 동그라미, 4 : 별
			int[] a = new int[5]; // 0 인덱스 사용 X 
			int[] b = new int[5]; 
			
			// a 카드 입력
			st = new StringTokenizer(br.readLine());
			for(int i = 0, cnt = Integer.parseInt(st.nextToken()); i < cnt; i++) {
				a[Integer.parseInt(st.nextToken())]++;
			}
			
			// b 카드 입력 
			st = new StringTokenizer(br.readLine());
			for(int i = 0, cnt = Integer.parseInt(st.nextToken()); i < cnt; i++) {
				b[Integer.parseInt(st.nextToken())]++;
			}
			
			// 승부
			for(int i = 4; i > 0; i--) {
				if(a[i] == b[i]) {
					if(i == 1) System.out.println("D");
					continue;
				}else if(a[i] > b[i]) {
					System.out.println("A");
					break; 
				}else {
					System.out.println("B");
					break;
				}
			}
			
		}
	}
}
