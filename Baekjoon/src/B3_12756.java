import java.util.Scanner;

/*
 * 2022.07.18
 * 고급 여관
 */
public class B3_12756 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a1 = sc.nextInt(); // A 플레이어 카드 공격력, 생명력 입력
		int a2 = sc.nextInt(); 
		int b1 = sc.nextInt(); // B 플에이어 카드 공격력, 생명력 입력
		int b2 = sc.nextInt();
		
		while(a2 > 0 && b2 > 0) {
			a2 -= b1;
			b2 -= a1;
		}
		
		if(a2 > 0 && b2 <= 0) {
			System.out.println("PLAYER A");
		}else if(a2 <= 0 && b2 > 0) {
			System.out.println("PLAYER B");
		}else {
			System.out.println("DRAW");
		}
		
		
	}
}
