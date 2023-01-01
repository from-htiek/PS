import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2023.01.01
 * 다이얼
 * 풀이가 다 거기서 거기일 줄 알았던 문제도 정말 다양한 풀이법이 있구나.. 
 */
public class B2_5622 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		int result = 0;
		
		for(int i = 0, size = input.length(); i < size; i++) {
			char ch = input.charAt(i);
			
			if(ch >= 'A' && ch <= 'C') result += 3;
			else if(ch >= 'D' && ch <= 'F') result += 4;
			else if(ch >= 'G' && ch <= 'I') result += 5;
			else if(ch >= 'J' && ch <= 'L') result += 6;
			else if(ch >= 'M' && ch <= 'O') result += 7;
			else if(ch >= 'P' && ch <= 'S') result += 8;
			else if(ch >= 'T' && ch <= 'V') result += 9;
			else result += 10;
		}
		
		System.out.println(result);
	}
}
