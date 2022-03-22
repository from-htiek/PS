import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2022.02.21
 * 슈퍼 마리오
 */
public class B1_2851 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		int result = 0;
		for(int i = 0; i < 10; i++) {
			int num = Integer.parseInt(br.readLine());
			sum += num;
			
			// 100에서 버섯을 먹었을 때를 빼서 현재의 result 보다 절댓값이 작으면 결과로 넣어줌
			if(Math.abs(100-sum) <= Math.abs(100-result)) {
				result = sum;
			}else break;
		}
		
		System.out.println(result);
	}
}
