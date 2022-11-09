import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 2022.11.01
 * Fly me to the Alpha Centauri
 * 수학문제였다니...... 
 * 그리고 문제를 잘못이해한부분이 있었는데, 마지막 거리가 1이라서 y-1에 도착하기만 하면 되는게 아니라
 * 마지막 거리가 1이기때문에 마지막 전전은 0, 1, 2 셋 중에 하나여야한다로 해석해야하는 문제였다.
 * 여기서 얻을 수 있는건 처음 시작도 1, 2, 3.. 으로 하지만 끝도 3, 2, 1.. 로 끝나기 때문에
 * 1부터 n의 합인 n*(n+1)/2가 처음과 끝에 2개 있으므로 결국 n*(n+1)이 된다는 것이다.
 * 현재 위치와 목표 위치의 차이만큼(=distance) 이 값을 계산해주면 된다.
 * n*(n+1)이 distance와 같으면 그 n이 앞 뒤로 2번 있으면 되기때문에 n*2가 정답이 되고,
 * n*(n+1)이 distance보다 크다면, 상황에 따라 +2, 또는 +1을 해준다.
 * +2가 될 때는 distance - n*(n+1)이 n+1보다 클 때 인데 예를 들어 남은 거리가 7인데 n이 4라면 ~5까지 사용해 만들수 있는 조합을 사용해 (3+4)처럼 두 번을 더해줘야하기때문이고
 * 남은 거리가 3이면 최대 n+1이 5 이하의 숫자중에 3을 더해줄 수 있기때문에 (한번만 더하면 된다) +1을 해준다. 
 */
public class G5_1011 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int t = Integer.parseInt(br.readLine()); 
		
		for(int tc = 0; tc < t; tc++) { // 테스트 케이스만큼 반복
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); // 현재 위치
			int y = Integer.parseInt(st.nextToken()); // 목표 위치 

			long step = 1; 
			long distance = y - x;
			
			while(true) { // n(n+1)/2 * 2 = n(n+1)이므로, 이 식이 두 위치의 길이보다 커질 때 까지 반복 
				if(step * (step+1) >= distance) {
					if(step * (step+1) > distance) step--;
					break;
				}
				step++;

			}
			
//			System.out.println(step);
			
			if(distance - step * (step+1) == 0) { // 거리와 같다면 *2
				sb.append(step*2).append("\n");
			}else if(distance - step * (step+1) > step+1) { // 남은 칸이 마지막으로 이동한거리+1보다도 크다면 +2
				sb.append(step*2+2).append("\n");
			}else { // 그렇지 않다면 +1
				sb.append(step*2+1).append("\n");
			}

		}
		
		System.out.println(sb.toString());
	}
}
