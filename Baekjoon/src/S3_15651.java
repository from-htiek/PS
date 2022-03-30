import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.03.30
 * N과 M(3)
 * 
 * 다른 사람들 코드를 보다가 왜 자꾸 2*idx 패턴이 반복적으로 등장하길래 이게 뭐지..? 했더니
 * char의 리스트는 sb.append(charList)를 하면 바로 리스트안에 들어 있는 값이 들어간다
 * (int 리스트는 주소값이 들어감!) 그래서 idx == m일때 for문을 한번 더 돌지 않아도 되는거였다. 
 */
public class S3_15651 {
	static int n, m, num[], result[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		num = new int[n+1];
		result = new int[m];
		for(int i = 1; i <= n; i++) {
			num[i] = i;
		}
		

		
		func(0);
		System.out.println(sb.toString());
	}
	
	static void func(int idx) {
		if(idx == m) {
			for(int i = 0; i < m; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= n; i++) {
			result[idx] = num[i];
			
			func(idx+1);
		}
	}
}
