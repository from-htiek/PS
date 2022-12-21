import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2022.12.21
 * 과제 안 내신 분..?
 */
public class B5_5597 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] visitied = new boolean[31];
		for(int i = 0; i < 28; i++) {
			visitied[Integer.parseInt(br.readLine())] = true;
		}
		
		for(int i = 1; i <= 30; i++) {
			if(!visitied[i]) System.out.println(i);
		}
	}
}
