import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.02.08
 * 암호생성기
 * 
 * 미래의래리앨리슨
 * 배열에서 idx %= 8 을 사용해 해당 배열에 값 계속 덮어쓰는 방법
 * 다른 배열을 잡지 않아서 처음부터 모두 계산해도 훨씬 빠른듯 함
 * 
 * st.hasMoreTokens() : while문과 함께 사용할 수 있음
 */
public class D3_1225 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 총 10개의 케이스
		for(int i = 0; i < 10; i++) {

			int t = Integer.parseInt(br.readLine());

			Queue<Integer> q = new LinkedList<>();
			int[] tmp = new int[8];
			int quotient = Integer.MAX_VALUE;

			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 8 cycle이 돌아가면 동일하게 모든 숫자가 -15가 됨
			// 모든 수를 15로 나눠 몫을 quotient 저장
			for(int _ = 0; _ < 8; _++) {
				int num = Integer.parseInt(st.nextToken());
				tmp[_] = num;
				quotient = Math.min(quotient, num/15);
			}
			
			// 모든 숫자가 적어도 하나 이상의 사이클이 돌아간다면 그만큼 빼고 q에 저장
			// quotient-1을 한 이유 : 15의 배수가 있을 수 있음
			if(quotient != 0) {
				for(int _ = 0; _ < 8; _++) {
					q.offer(tmp[_]-15*(quotient-1));
				}
			}else {
				for(int _ = 0; _ < 8; _++) {
					q.offer(tmp[_]);
				}
			}
			
			// 0이 나올 때까지 반복
			// num은 6이 되면 다시 1로 초기화
			int num = 1;
			while(true) {
				if(num == 6) num = 1;

				int n = q.poll()-num;
				if(n <= 0) {
					q.offer(0);
					break;
				}else q.offer(n);
				num++;

			}

			System.out.printf("#%d ", t);
			for(Integer a : q) {
				System.out.print(a+" ");
			}
			System.out.println();
		}
	}

}
