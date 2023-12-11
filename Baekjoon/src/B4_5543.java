import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2023.12.11
 * 상근날드
 */
public class B4_5543 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sangduk = Integer.parseInt(br.readLine());
		int jungduk = Integer.parseInt(br.readLine());
		int haduk = Integer.parseInt(br.readLine());
		int coke = Integer.parseInt(br.readLine());
		int soda = Integer.parseInt(br.readLine());
		
		int total = -50; 
		
		total += Math.min(sangduk, Math.min(jungduk, haduk));
		total += Math.min(coke, soda);
		
		System.out.println(total);
	}
}
