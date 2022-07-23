import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.07.23
 * 주사위 게임
 */
public class B3_10103 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int aScore = 100; // 둘 다 100점부터 시작
		int bScore = 100;
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int aDice = Integer.parseInt(st.nextToken());
			int bDice = Integer.parseInt(st.nextToken());
			
			// 작은 사람점수에서 큰 사람 주사위 수만큼 빼기
			if(aDice > bDice) bScore -= aDice; 
			else if(aDice < bDice) aScore -= bDice;
		}
		
		System.out.println(aScore);
		System.out.println(bScore);
		
		
	}
}
