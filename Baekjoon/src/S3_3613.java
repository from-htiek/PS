import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 2022.09.23
 * Java vs C++
 */
public class S3_3613 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		
		boolean java = false;
		boolean c = false;
		for(int i = 0, size = str.length(); i < size; i++) {
			char ch = str.charAt(i);
			int num = ch - 'a';
			if(num >= 0) sb.append(ch);
			else {
				if(num == -2) {
					java = true;
					if(i+1 >= size || i == 0 || str.charAt(i+1) == '_' || c) {
						System.out.println("Error!");
						return;
					}
					
					sb.append((char)(str.charAt(i+1) - 32));
					i++;
				}else if(num >= -32 && num <= -7) {
					c = true; 
					if(i == 0 || java) {
						System.out.println("Error!");
						return;
					}
					sb.append("_").append((char)(ch + 32));
				}else {
					System.out.println("Error!");
					return;
				}
			}
			
		}
		
		if(!java && !c) System.out.println("Error!");
		else System.out.println(sb.toString());
		
	}
}
