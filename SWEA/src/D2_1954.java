import java.util.Scanner;
/*
 * 2022.02.03
 */
public class D2_1954 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for(int tc = 1; tc <= t; tc++) {
			int num = sc.nextInt();
			
			// 1일 때는 1찍고 끝내기
			if(num == 1) {
				System.out.println("# " + tc);
				System.out.println(1);
			}else {
				int[][] snail = new int[num][num];
				int idx = 1;
				int start = 0;
				// 행렬 안의 숫자의 최댓값 :  입력값의 제곱
				while(idx < Math.pow(num, 2)) {
					
					// 4가지 방향 순서대로 (입력값-1)부터 줄어들며 채워짐
					// ex) 입력값이 4 => 첫 while문 3칸씩, 2번째 while문 2칸씩, 3번째 while문 1칸(끝)
					// → 방향 
					for(int i = start; i < num-start-1; i++) {
						if(snail[start][i] != 0) break;
						snail[start][i] = idx++;
					}
					
					// ↓ 방향
					for(int i = start; i < num-start-1; i++) {
						if(snail[i][num-start-1] != 0) break;
						snail[i][num-start-1] = idx++;
					}

					// ← 방향
					for(int i = num-start-1; i > start; i--) {
						if(snail[num-start-1][i] != 0) break;
						snail[num-start-1][i] = idx++;
					}

					// ↑ 방향 
					for(int i = num-start-1; i > start; i--) {
						if(snail[i][start] != 0) break;
						snail[i][start] = idx++;
					}
					
					// while문 1번 끝날 때 마다 채워지는 칸 1칸씩 줄이기
					start++;
				}
				
				// 입력값이 홀 수 일 때는 가장 중간 지점에 최댓값
				if(num%2 == 1) {
					snail[num/2][num/2] = idx;
				}
				
				System.out.println("# " + tc);
				for(int[] i : snail) {
					for(int j : i) {
						System.out.print(j + " ");
					}
					System.out.println();
				}
			}
		}
	}
}