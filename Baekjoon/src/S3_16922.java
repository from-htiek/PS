import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * 2022.08.24
 * 로마 숫자 만들기
 * 순조부도 오랜만에 푸니까 까먹는구나 세상에
 */
public class S3_16922 {
	public static int n, list[];
	public static Set<Integer> set; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		set = new HashSet<>(); // 중복값 제거를 위해 set 사용
		
		list = new int[] {1, 5, 10, 50}; // 로마 숫자 
		combination(0, 0, 0);
		
		System.out.println(set.size());
		
	}
	
	// 중복 허용하는 조합
	public static void combination(int idx, int start, int sum) {
		if(idx == n) {
			set.add(sum);
			return; 
		}
		
		for(int i = start; i < 4; i++) {
			combination(idx+1, i, sum + list[i]);
		}
		
	}
}
