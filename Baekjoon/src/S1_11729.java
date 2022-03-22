import java.util.Scanner;

/*
 * 2022.02.06
 * 하노이 탑 이동 순서
 */
public class S1_11729 {
	static int total = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		
		
		hanoi(n, 1, 2, 3, sb);
		System.out.println(total);
		System.out.println(sb.toString());
	}
	
	public static void hanoi(int n, int from, int tmp, int to, StringBuilder sb) {
		if(n == 0) return;
		
		total++;
		hanoi(n-1, from, to, tmp, sb);
		//System.out.printf("%d %d\n", from, to);
		sb.append(from).append(" ").append(to).append("\n");

		hanoi(n-1, tmp, from, to, sb);
	}
}
