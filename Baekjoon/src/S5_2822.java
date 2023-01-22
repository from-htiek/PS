import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/*
 * 2023.01.22
 * 점수 계산
 */
public class S5_2822 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] score = new int[8][2];
		
		for(int i = 0; i < 8; i++) {
			score[i][0] = Integer.parseInt(br.readLine());
			score[i][1] = i+1;
		}
		
		Arrays.sort(score, Comparator.comparingInt(o1 -> o1[0]));
		
		int result = 0;
		int[] index = new int[5];
		for(int i = 0; i < 5; i++) {
			result += score[i+3][0];
			index[i] = score[i+3][1];
		}
		
		Arrays.sort(index);

		System.out.println(result);
		for(int i = 0; i < 5; i++) {
			System.out.printf("%d ", index[i]);
		}
	}
}
