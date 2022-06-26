import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 2022.06.26
 * 카드2
 * 생각보다 다양한 풀이 방식이 있었는데 
 * 첫번째는 수학적으로 풀어내는거였는데 코드 보고 이해를 못했다..... ㅠ
 * 두번째는 값을 배열에 넣고 첫값과 끝값의 인덱스를 늘려가면서 카드를 버리고 옮기는 것과 같이 만들어주는거였다.
 * 내가 쓴 방법은 가장 간단한 방법인데 역시 시간이 오래 걸린다.
 */
public class S4_2164 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= n; i++) {
			q.offer(i);
		}
		
		int cnt = 0; 
		while(q.size() > 1) {
			
			if(cnt % 2 == 0) q.poll();
			else q.offer(q.poll());
			cnt++;
		}
		
		System.out.println(q.poll());
	}
}
