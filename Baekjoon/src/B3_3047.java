import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
 * 2022.12.26
 * ABC
 */
public class B3_3047 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		HashMap<Character, Integer> hashmap = new HashMap<>();
		
		int x = 0, y = 0, z = 0;
		
		if(a < b && a < c) {
			x = a;
			
			if(b < c) {
				y = b;
				z = c;
			} else {
				y = c;
				z = b;
			}
		}else if(b < a && b < c) {
			x = b;
			
			if(a < c) {
				y = a;
				z = c;
			}else {
				y = c;
				z = a;
			}
		}else {
			x = c;
			
			if(a < b) {
				y = a;
				z = b;
			}else {
				y = b;
				z = a;
			}
		}
		
		hashmap.put('A', x);
		hashmap.put('B', y);
		hashmap.put('C', z);
		
		
		String input = br.readLine();
		for(int i = 0; i < 3; i++) {
			System.out.printf("%d ", hashmap.get(input.charAt(i)));
		}
	}
}
