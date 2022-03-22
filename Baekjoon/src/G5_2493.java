import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 2022.02.07
 * 탑
 * 
 * https://www.acmicpc.net/source/11500424 : kkonddd
 * 레이저가 닿을 수 있을 때까지 stack의 top을 내린 후 값 갱신하여 stack의 top값 가지고 바로 비교 가능
 */
public class G5_2493 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] tower = new int[n];
		int[] result = new int[n];
		Stack<Integer> save = new Stack<Integer>();

		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			tower[i] = Integer.parseInt(st.nextToken());
		}
		
		// 끝에서부터 for문
		for(int i = n-1; i > 0; i--) {
			// 앞의 탑 높이가 더 높으면 result에 i값 넣음 (idx가 i-1이지만, 0을 1번째로 보므로 1 더해줌)
			if(tower[i] < tower[i-1]) {
				result[i] = i;
				// 스택이 비어있지 않고, 스택의 최상위 값보다 앞의 탑이 높다면
				if(!save.isEmpty() && tower[save.peek()] < tower[i-1]) {
					// 스택의 크기만큼 for문
					for(int j = 0; j < save.size(); j++) {
						// 앞의 탑이 높으면 pop해서 값 넣어줌
						if(tower[save.peek()] <= tower[i-1]) result[save.pop()] = i;
						// 낮으면 더 이상 비교할 필요 X
						else break;
						// pop하면 스택 사이즈 줄어드니까 j도 낮춰줌
						j--;
					}
					
				}

			}
			// 앞의 탑 높이가 낮다면 저장 스택에 인덱스 추가
			else {
				save.push(i);
			}
		}
		
		for(int i = 0; i < n; i++) {
			bw.write(result[i] + " ");
		}
		bw.close();

	}
}
