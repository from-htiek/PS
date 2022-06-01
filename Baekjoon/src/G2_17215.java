import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
* 2022. 05. 30
* 볼링 점수 계산
*/
public class G2_17215 {
	static char[] bowling; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bowling = br.readLine().toCharArray();
		int result = 0; // 총 점수
		int frame = 0; 
		int chance = 0; 

		for(int i = 0, size = bowling.length; i < size; i++) {
			int score = getScore(i, bowling[i]);
			result += score;
			//System.out.println(bowling[i] + " : " + i  + " : "+ score);
			chance++; 

			if(bowling[i] == 'S' | chance == 2) {
				chance = 0;
				frame++; 
			}

			if(frame < 10) {
				if(bowling[i] == 'S') {
					result += getScore(i+1, bowling[i+1]);
					result += getScore(i+2, bowling[i+2]);
				}else if(bowling[i] == 'P') {
					result += getScore(i+1, bowling[i+1]);
				}
			}

			//System.out.println(result);
		}

		System.out.println(result);
	}

	// 점수 변환 
	public static int getScore(int idx, char score){
		int add = 0; 
		switch(score) {
		case 'P':
			if(bowling[idx-1] == '-') add = 10; 
			else add = (10 - (bowling[idx-1]- '0')) ; 
			break;
		case 'S':
			add = 10;
			break; 
		case '-' :
			add = 0;
			break;
		default :
			add = score - '0';
		}
		return add;
	}
}
