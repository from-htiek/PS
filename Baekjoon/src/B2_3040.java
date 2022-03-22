import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 2022.02.14
 * 백설 공주와 일곱 난쟁이
 * 
 * nowkangmin
 * 전체의 합을 구해서 100 빼고, 그 합이 되는 2명이 출력되지 않게 
 * 
 */
public class B2_3040 {
	static int list[], result[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		list = new int[9];
		result = new int[7];
		for(int i = 0; i < 9; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		
		func(0, 0, 0);
	}
	
	static void func(int idx, int start, int sum) {
		// sum < 100 retrun  => 7명 다 뽑기전에 이미 sum을 넣으면 가망이 없음 => 가지치기
		if(idx == 7) { // 7명 다 뽑은 상태
			if(sum == 100) { // 합이 100일 때
				for(int i = 0; i < 7; i++) {
					System.out.println(result[i]);
				}
			}
			return;
		}
		
		// 조합 생성
		for(int i = start; i < 9; i++) {
			result[idx] = list[i];
			func(idx+1, i+1, sum+list[i]);			
		}
		
	}
}
