import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.09.12
 * 연산자 끼워넣기 
 */
public class S1_14888 {
	public static int n, num[], operator[], min, max, perm[]; 
	public static boolean visitied[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); // 수의 개수
		
		num = new int[n]; // 숫자 입력 
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		visitied = new boolean[n-1]; // 순열 방문 체크 
		operator = new int[n-1]; // 연산자 배열 
		int idx = 0; 
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) { // 해당 연산자만큼 채운 배열 만들기 ex. +가 3개면 0, 0, 0
			int op = Integer.parseInt(st.nextToken());
			for(int j = 0; j < op; j++) {
				operator[idx] = i;
				idx++;
			}
		}
		
		min = Integer.MAX_VALUE; // 최솟값
		max = Integer.MIN_VALUE; // 최댓값 
		perm = new int[n-1]; // 순열의 결과로 만들어진 연산자 배열
		
		permutation(0);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	// 순열 만들기 
	public static void permutation(int idx) {
		if(idx == n-1) {
			int result = num[0];
			for(int i = 0; i < n-1; i++) { // 연산자 우선순위와 상관없이 계산 
				switch (perm[i]) {
				case 0:
					result += num[i+1];
					break;
				case 1:
					result -= num[i+1];
					break; 
				case 2:
					result *= num[i+1];
					break;
				case 3:
					result /= num[i+1];
					break; 
				}
			}

			min = Math.min(result, min);
			max = Math.max(result, max);
			return;
		}
		
		for(int i = 0; i < n-1; i++) {
			if(visitied[i]) continue;
			visitied[i] = true; 
			perm[idx] = operator[i];
			permutation(idx+1);
			visitied[i] = false;
		}
	}
}
