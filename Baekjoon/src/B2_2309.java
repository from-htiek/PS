import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 2022.02.19
 * 일곱 난쟁이
 */
public class B2_2309 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dwarf = new int[9];
		int sum = 0;
		for(int i = 0; i < 9; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
			sum += dwarf[i];
		}
		
		sum -= 100;
		
		Arrays.sort(dwarf);
		System.out.println(Arrays.toString(dwarf));
		outerloop : for(int i = 0; i < 9; i++) {
			for(int j = i+1; j < 9; j++) {
				if(dwarf[i] + dwarf[j] == sum) {
					for(int k = 0; k < 9; k++) {
						if(k != i && k != j) System.out.println(dwarf[k]);
					}
					break outerloop;
				}
			}
		}
		
	}
}
