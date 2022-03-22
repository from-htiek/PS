import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2022.02.27
 * 크로아티아 알파벳
 * 
 * lj, nj 같은건 하나의 if문에서 || 사용, s, z도!
 */
public class S5_2941 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int cnt = 0;
		for(int i = 0, size = str.length(); i < size; i++) {
			if(str.charAt(i) == 'c') {
				if(i < size-1 && str.charAt(i+1) == '=') {
					cnt++;
					i++;
				}else if(i < size-1&& str.charAt(i+1) == '-') {
					cnt++;
					i++;
				}else {
					cnt++;
				}
			}else if(str.charAt(i) == 'd') {
				if(i < size-1 && str.charAt(i+1) == '-') {
					cnt++;
					i++;
				}else if(i < size-2 && str.charAt(i+1) == 'z' && str.charAt(i+2) == '=') {
					cnt++;
					i += 2;
				}else {
					cnt++;
				}
			}else if(str.charAt(i) == 'l') { 
				if(i < size-1 && str.charAt(i+1) == 'j') {
					cnt++;
					i++;
				}else {
					cnt++;
				}
			}else if(str.charAt(i) == 'n') {
				if(i < size-1 && str.charAt(i+1) == 'j') {
					cnt++;
					i++;
				}else {
					cnt++;
				}
			}else if(str.charAt(i) == 's') {
				if(i < size-1 && str.charAt(i+1) == '=') {
					cnt++;
					i++;
				}else {
					cnt++;
				}
			}else if(str.charAt(i) == 'z') {
				if(i < size-1 && str.charAt(i+1) == '=') {
					cnt++;
					i++;
				}else {
					cnt++;
				}
			}else {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}
}
