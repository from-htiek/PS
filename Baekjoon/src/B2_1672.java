import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
/*
 * 2022.07.18
 * DNA 해독
 * 해시맵으로는 메모리 초과가 나서 노가다로 풀었다
 * 배열로 풀면 훨씬 간단한듯하다.
 */
public class B2_1672 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 염기 서열의 길이
		char[] seq = br.readLine().toCharArray();

		if(n == 1) { // 길이 1일때는 출력 후 종료
			System.out.println(seq[0]);
			return; 
		}


		int cnt = n-2; 
		char end = ' ';

		while(cnt >= 0) {
			switch(seq[cnt]) {
			case 'A':
				switch(seq[cnt+1]) {
				case 'A' :
					end = 'A';
					break;
				case 'G' :
					end = 'C';
					break;
				case 'C' :
					end = 'A';
					break;
				case 'T':
					end = 'G';
					break;
				}
				break;
			case 'G':
				switch(seq[cnt+1]) {
				case 'A' :
					end = 'C';
					break;
				case 'G' :
					end = 'G';
					break;
				case 'C' :
					end = 'T';
					break;
				case 'T':
					end = 'A';
					break;
				}
				break;
			case 'C':
				switch(seq[cnt+1]) {
				case 'A' :
					end = 'A';
					break;
				case 'G' :
					end = 'T';
					break;
				case 'C' :
					end = 'C';
					break;
				case 'T':
					end = 'G';
					break;
				}
				break;
			case 'T':
				switch(seq[cnt+1]) {
				case 'A' :
					end = 'G';
					break;
				case 'G' :
					end = 'A';
					break;
				case 'C' :
					end = 'G';
					break;
				case 'T':
					end = 'T';
					break;
				}
				break; 
			}
			
			seq[cnt] = end;
			cnt--;
			
			System.out.println(Arrays.toString(seq));
		}
		
		System.out.println(seq[0]);
	}
}
