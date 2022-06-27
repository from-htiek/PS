import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2022.06.27
 * 팰린드롬수
 */
public class B1_1259 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			char[] list = br.readLine().toCharArray();
			
			if(list.length == 1 && list[0] == '0') break; 
			
			boolean flag = true ; 
			for(int i = 0, size = list.length-1; i <= size/2; i++) {
				if(list[i] != list[size-i]) {
					flag = false;
					break;
				}
			}
			
			if(flag) {
				sb.append("yes").append("\n");
			}else {
				sb.append("no").append("\n");
			}
//			System.out.println(Arrays.toString(list));
			
		}
		
		System.out.println(sb.toString());
	}
}
