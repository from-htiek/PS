import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 2022.09.24
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
//			int num = ch - 'a';
			if(ch >= 'a') sb.append(ch);
			else {
				if(ch == '_') {
					java = true;
					if(i+1 >= size || i == 0 || str.charAt(i+1) == '_' || str.charAt(i+1) < 'a' || c) {
						System.out.println("Error!");
						return;
					}
					
					sb.append((char)(str.charAt(i+1) - 32));
					i++;
				}else if(ch >= 'A' && ch <= 'Z') {
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
		
//		if(!java && !c) System.out.println("Error!");
		System.out.println(sb.toString());
		
	}
}
