import java.util.Scanner;

/*
 * 2022.02.06
 * 간단한 369게임
 * 
 * String tmp = i +""; -> string으로 만들어서 
 * tmp.charAt(j) == '3' || tmp.charAt(j) == '6' || tmp.charAt(j) == '9' => cnt ++
 * https://swexpertacademy.com/main/code/problem/problemSubmitDetail.do
 */
public class D2_1926 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int num = sc.nextInt();
		
		for(int i = 1; i <= num; i++) {
			int flag = 0;
			int n = i;
			while(n != 0) {
				int q = n/10;
				int r = n%10;
				if(r % 3 == 0 && r != 0) {
					sb.append("-");
					flag = 1;
				}
				n = q;
			}
			if(flag == 0) {
				sb.append(i);
			}
			sb.append(" ");
			
		}
		
		System.out.println(sb.toString());
	}

}
