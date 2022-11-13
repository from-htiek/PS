import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


/*
 * 2022.11.13
 * Moo 게임
 * s(k)는 s(k-1) + m + o * (k-2)개 + s(k-1)개의 구조를 가진다
 * 결국 모든 수열은 ABA의 구조를 가지는데 해당 숫자가 A / B 중 어디에 있는지를 알면 된다.. 라고 스터디원이 가르쳐줌
 * 사실 나는 이 문제를 어떻게 풀어야할지 감을 잘 못잡았다. 입력이 10억이라 String으로 전체 문자열을 만들면 무조건 터지고..
 * m이 들어가는 위치로만 문자열을 만들어도 생각보다 굉자히 길어서 터졌다.
 * A/B/A의 구조로 나눠서 B가 아니라면 그건 A에 있다는거고 A는 그 전 수열과 같기때문에.. 위치를 찾을 수 있다.
 * 처음에 대놓고 재귀문제라고 생각했는데 결국 재귀는 안씀.. 어렵다 어려워
 */
public class G5_5904 {
	public static int n;
	public static String result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		String moo = "moo";
		ArrayList<Integer> list = new ArrayList<>();
		list.add(3);
		int num = 3;
		int middle = 4; 
		while(n >= num) {
			num = num * 2 + middle;
			middle++;
			list.add(num);
		}
		
//		System.out.println(list);
		middle--;
//		System.out.println(middle);
		
		for(int i = list.size()-1; i > 0; i--) {
			int len = list.get(i-1);
			if(n > len && n <= len + middle) { // ABA에서 B에 있을 때
				if(n == len+1) {
					System.out.println("m");
					return;
				}else {
					System.out.println("o");
					return;
				}
			}else { // A에 있을 때
				if(n > len) {
					n -= len + middle;
				}
			}
			
			middle--;
			
//			System.out.println(n);
		}
		
		if(n == 1) {
			System.out.println("m");
		}else {
			System.out.println("o");
		}

//		System.out.println(middle);
		
	}
}
