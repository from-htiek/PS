import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/*
 * 2022.11.09
 * 줄어드는 수
 */
public class G5_1174 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		ArrayList<Double> list = new ArrayList<>();
		// 초기값 : 길이가 1인 줄어드는 수
		for(double i = 0; i < 10; i++) { 
			list.add(i);
		}
		
		int start = 0;
		int end = list.size();		
		for(int i = 0; i < 10; i++) { // 9876543210이 마지막 수이므로 pow(10, 9)까지만 반복
			ArrayList<Double> addList = new ArrayList<>();
			double multiple = Math.pow(10, i);
			
			for(int j = start; j < end; j++) { // list의 start부터 end까지의 수에 해당 수의 첫째자리 수 보다 큰 수 곱해서 다시 리스트에 넣기
				double num = list.get(j); // 해당 숫자 얻어옴
				int front = (int) (num / multiple); // 해당 숫자의 첫째자리 수
				
				for(int k = front+1; k < 10; k++) { // 그 숫자보다 큰 수를 앞자리에 넣기
					addList.add(num + k * multiple * 10);
				}
				
				
			}
			
			Collections.sort(addList); // 정렬
//			System.out.println(addList);
			list.addAll(addList); // 기존 리스트에 추가
			start = end; // start, end값 갱신
			end = list.size();
			
			if(n < list.size()) break; 
		}

		if(n > 1023) {
			System.out.println(-1);
		}else {
			System.out.printf("%.0f", list.get(n-1));
		}
	
	}
}
