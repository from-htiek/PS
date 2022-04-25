import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 2022.04.25
 * 숫자놀이
 * 
 * 숫자를 영어로 바꾼 {"zero", "one", "two" .. } 와 같은 배열을 줬는데 이걸 어떻게 비교해야 될 지 몰랐었다
 * 다른 사람 코드를 보니 String이 가진 compare를 이용해서 쉽게 비교를 하더라! 
 * data라는 클래스를 하나 만들고 거기에 인자로 해당 숫자와, 그 숫자를 영어로 바꾼 문자열을 받고
 * 문자열로 정렬 하는 방법이였는데 좋은 코드인듯하다.  
 */
public class S4_1755 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		int m = Integer.parseInt(st.nextToken()); // M 
		int n = Integer.parseInt(st.nextToken()); // N


		int[] value = {9, 4, 8, 7, 2, 1, 6, 5, 0, 3}; // 숫자 우선순위 배열 (0은 9번째 우선순위를 가짐) 
		int[] order = {8, 5, 4, 9, 1, 7, 6, 3, 2}; // 우선 순위로 재배열한 숫자 순서 (8은 우선순위가 가장 높으므로 0번째), 0으로 시작하는 숫자는 없으므로 제외 
		int[][] num = new int[10][11]; // 우선순위에 맞춰 숫자 넣기 위한 배열, 0인덱스 사용X
		boolean[] check = new boolean[10]; // 한자리수 숫자 체크


		for(int i = m; i <= n; i++) { // m이상 n이하 숫자만큼 반복 
			if(i < 10) { // 한 자리수 일 때
				num[i][0] = i; // 해당 숫자로 시작하는 숫자중에 가장 우선순위 높음 (8은 80보다 우선순위가 높음) 
				check[i] = true; // 한자리 숫자가 있음을 체크
			}else { // 두 자리수 이상일 때 
				int x = i/10; // 10의 자리
				int y = i%10; // 1의 자리 

				if(check[x]) { 
					num[x][value[y]+1] = i; // 0배열에 숫자있으므로 한자리씩 자리 밀림 
				}else {
					num[x][value[y]] = i; // 없으면 우선순위 그대로 숫자 넣기
				}
			}

		}

		// 체크
//		for(int a[] : num) {
//			System.out.println(Arrays.toString(a));
//		}

		int cnt = 0; // Stringbuilder에 10개 추가 했을 때 한줄 띄어쓰기 넣기위해 카운트
		for(int i = 0; i < 9; i++) {
			int x = order[i]; // 우선순위 높은 숫자부터 추가
			for(int j = 0; j < 11; j++) {
				if(num[x][j] != 0) { // 숫자가 있을 때 추가
					sb.append(num[x][j]).append(" ");
					cnt++; 
				}

				if(cnt == 10){ // 띄어쓰기 추가 후 cnt 초기화
					sb.append("\n");
					cnt = 0;
				}
			}
		}

		System.out.println(sb.toString());

	}
}
