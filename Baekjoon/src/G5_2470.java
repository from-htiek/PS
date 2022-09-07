import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.09.07
 * 두 용액
 * 팀원이 준 힌트가 사실은 힌트라 아니라 거의 정답지 수준이였다... 
 * 투포인터 오랜만에 쓰려고 했더니 엄청 헤매서 결국 개념부터 다시봤음 
 * 그리고 처음에는 기준값을 찾아서 푸는 방법을 생각해서 이분탐색을 떠올렸는데 구현 방법이 생각이 안났다
 * 시간이 지나면 잊혀지는것들이 정말 많구나.. 공부해야할 것들은 언제나 있는듯하다.
 * 
 * 기본적인 접근은, 두 수의 절대값을 비교해서 절대값이 더 크면. 지금 계산한 값이 0에 가장 가깝기때문에
 * 더 이상 계산하지않고 포인터를 옮기는 것이다.
 * 지금 계산한 값이 0에 가장 가깝다고 확신할 수 있는 이유는 이미 정렬을 했기때문임.. 
 */
public class G5_2470 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] list = new int[n]; // 용액 입력
		for(int i = 0; i < n; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(list); // 정렬 
//		System.out.println(Arrays.toString(list));
		
		if(list[n-1] <= 0) { // 모두 다 알칼리성 용액
			System.out.println(list[n-2] + " " + list[n-1]);
			return;
		}else if(list[0] >= 0) { // 모두 다 산성 용액
			System.out.println(list[0] + " " + list[1]);
			return; 
		}
		
		
		// 알칼리성 + 산성 섞여있다면
		int start = 0;
		int end = n-1;
		int sum = Integer.MAX_VALUE;
		int a = 0;
		int b = 0; 
		while(start < end) {
			int _sum = Math.abs(list[start] + list[end]);
			if(_sum < sum) {
				sum = _sum;
				a = list[start];
				b = list[end];
			}
			
			if(Math.abs(list[start]) < Math.abs(list[end])) end--;
			else start++; 
		}
		
		System.out.println(a + " " + b);
	}
}
