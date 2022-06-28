import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.06.28
 * 달팽이는 올라가고 싶다
 * while문 돌리면 시간초과 난다.
 */
public class S5_2869 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		
		// 정상에 도달하면 더 이상 미끄러지지않으므로
		// 정상높이(v) - 마지막 날에 올라갈 수 있는 높이(a)를 뺀다.  
		// 이 값을 하루 동안 올라갈 수 있는 높이(a - b)로 나눈 후 
		// 마지막 날에 올라가므로 +1을 한다. 
		System.out.println((int)Math.ceil((double)(v - a) / ((double)a - b)) + 1);
	}
}
