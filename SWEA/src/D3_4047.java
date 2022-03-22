import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2022.02.23
 * 영준이의 카드 카운팅
 * 
 * 강철몬
 * num을 직접 계산하지 말고
 *  int t = Integer.parseInt(s.substring(i+1, i+3)); 이렇게도 됨
 *  
 *  cnt를 카드 배열을 하나만들어서 사용해도 깔끔함
 */
public class D3_4047 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= t; tc++) {
			sb.append("#").append(tc).append(" ");
			char[] card = br.readLine().toCharArray();
			boolean[][] deck = new boolean[4][14]; // 2차원 0번 인덱스 사용 X 
			int num = 0; // 입력 된 카드의 숫자
			int sCnt = 13; // 카드 4종의 필요한 카드 수
			int dCnt = 13;
			int hCnt = 13;
			int cCnt =13;
			boolean check = false; // 오류 체크
			
			for(int i = 0, size = card.length; i < size; i++) {
				num = (card[i+1] - '0') * 10 + (card[i+2] - '0'); // 숫자 계산, i+1은 10의 자리, i+2는 1의 자리
				switch(card[i]) {
				case 'S':
					if(!deck[0][num]) {
						deck[0][num] = true;
						sCnt--;
					} else check = true; // 이미 있는 카드라면 오류 체크 
					break;
				case 'D' :
					if(!deck[1][num]) {
						deck[1][num] = true;
						dCnt--;
					} else check = true;
					break;
				case 'H' :
					if(!deck[2][num]) {
						deck[2][num] = true;
						hCnt--;
					} else check = true;
					break;
				case 'C' :
					if(!deck[3][num]) {
						deck[3][num] = true;
						cCnt--;
					} else check = true;
					break;
 				}
				
				i += 2; // 한번에 3글자씩 읽음 
				
				// 있는 있는 카드므로 에러
				if(check) {
					sb.append("ERROR\n");
					break;
				}

			}
			
			if(!check) {
				sb.append(sCnt).append(" ").append(dCnt).append(" ")
				.append(hCnt).append(" ").append(cCnt).append("\n");
			}
			
			
		}
		
		System.out.println(sb.toString());
			
	}
}
