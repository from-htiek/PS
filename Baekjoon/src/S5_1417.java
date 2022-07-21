import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 2022.07.21
 * 국회의원 선거
 * while문 안의 else문에서 for문을써서 다솜이의 득표수보다 작은 후보를 만나기전까지 사람을 매수하면 왜 틀릴까? 
 */
public class S5_1417 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 후보의 수
		int dasom = Integer.parseInt(br.readLine()); // 기호 1번 다솜이의 표 수
		
		if(n == 1) { // 후보가 다솜이 밖에 없을때는 매수 필요없음 
			System.out.println(0);
			return;
		}		
		
		int[] vote = new int[n-1]; // 득표수
		for(int i = 0; i < n-1; i++) {
			vote[i] = Integer.parseInt(br.readLine());
		}
	
		int cnt = 0; // 매수해야하는 사람의 최솟값
		
		while(true) {
			Arrays.sort(vote); // 정렬
			if(vote[n-2] < dasom) break; // 득표수가 가장 많은 사람보다 다솜이의 표가 더 많으면 멈춤
			else { // 그렇지 않으면 매수
				vote[n-2]--;
				dasom++; 
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}
}
