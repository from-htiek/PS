import java.util.Scanner;

/*
 * 2022.06.26
 * 영화감독 숌
 * 
 * 문제를 너무 쉽게 풀면 안될 것 같은 느낌이 들 때가 많다. 
 * 이 문제도 그랬는데... 부르트 포스일거라고 전혀 예상을 못했다
 * 물론 666의 패턴을 찾아서 구할 수도 있지만 .. 
 * 한참 고민하다가 결국 못 풀어서 다른 사람 코드를 참고했는데 그냥 1부터 n까지 "666"이 있는지 찾는다로도 끝나는 코드였다니..! 
 * 하지만 부르트 포스는 역시 느리긴한다. 빠른 코드는 대부분 패턴을 찾아서 구하신 것 같다. 
 */
public class S5_1436 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int pattern = 666;
		int cnt = 1;
		
		while(cnt != n) {
			pattern++;
			
			if(String.valueOf(pattern).contains("666")) {
				cnt++;
			}
		}
		
		System.out.println(pattern);
	}
}
