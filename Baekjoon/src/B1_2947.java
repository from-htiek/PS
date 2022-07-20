import java.util.Arrays;
import java.util.Scanner;

/*
 * 2022.07.20
 * 나무 조각
 * 버블 소트
 */
public class B1_2947 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int[] list = new int[5]; // 나무조각 입력
		for(int i = 0; i < 5; i++) {
			list[i] = sc.nextInt();
		}
		
		boolean flag = false;
		int i = 0;
		
		while(!flag) { // flag가 true가 될 때 까지 반복
			if(list[i] > list[i+1]) { // 조건에 해당될 때 swap
				flag = true;
				
				int tmp = list[i];
				list[i] = list[i+1];
				list[i+1] = tmp;
				
				for(int j = 0; j < 5; j++) {
					sb.append(list[j]).append(" ");
					if(list[j] == j+1 && flag) flag = true; // 1,2,3,4,5 순서가 맞는지 체크
					else flag = false; 
				}
				
				sb.append("\n");
			}
			
			i = (i+1) % 4; // index 관리
			
		}
		
		System.out.println(sb.toString());
	}
}
