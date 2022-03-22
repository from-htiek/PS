import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.02.16
 * 집합
 */
public class S5_11723 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int m = Integer.parseInt(br.readLine());
		int flag = 0; // 공집합 S
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int num = 0;
			switch(st.nextToken()){
			case "add" : // x 추가
				num = Integer.parseInt(st.nextToken());
				flag = flag | 1<<(num-1);
				break;
			case "remove": // x 제거
				num = Integer.parseInt(st.nextToken());
				flag = flag - (flag & 1<<(num-1));
				break;
			case "check": // x 체크
				num = Integer.parseInt(st.nextToken());
				if((flag&1<<(num-1)) != 0) sb.append("1\n");
				else sb.append("0\n");
				break;
			case "toggle": // 있으면 제거, 없으면 추가
				num = Integer.parseInt(st.nextToken());
				flag = flag ^ (1<<(num-1));
				break;
			case "all": // 모두 다 1
				flag = -1; // -1은 11111111111111111111111111111111(32bit)
				break;
			case "empty": // 모두 다 0
				// flag = flag ^ flag; 
				flag = 0;
				break;
			}
		}
		
		System.out.println(sb.toString());
	}
}
