import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.11.13
 * 음식 평론가
 * 최소공약수를 이용해 푸는 문제라고 하는데, 사실 같은 방법으로 푼 것 같은데
 * 사람들 설명을 이해를 못하겠다.. 쥬륵
 */
public class G5_1188 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 소시지 수
		int m = Integer.parseInt(st.nextToken()); // 평론가 수
		
		// 예를들어, 3개의 소시지를 4명의 평론가가 평가해야한다면 
		// 1개의 소시지를 4조각씩 나눠 총 12개의 소시지 조각이 있다고 가정한다.
		// 12개를 4명이 가져가려면 3조각씩 가져가야하므로
		// 3조각씩 가져가되, 가져간 소시지의 조각이 4의 배수라면 그 부분은 자르지 않아도 된다
		// (이미 하나의 소시지는 4조각으로 잘려있기 때문에) 
		// 반대로 4의 배수가 아니라면 자르는 것과 같다
		int total = n*m; // total만큼의 소시지 조각으로 나눈다고 가정
		int piece = 0; 
		int cnt = 0; 
		while(piece < total) {
			piece += n; // 한번에 n개의 조각을 가져간다
			if(piece % m != 0) cnt++; // 0으로 나누어 떨어지지 않는다면 자르는 것과 같음
		}
		
		System.out.println(cnt);
	}
}
