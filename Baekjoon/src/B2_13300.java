import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.02.26
 * 방 배정
 */
public class B2_13300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 참가하는 학생 수
		int k = Integer.parseInt(st.nextToken()); // 한 방에 배정할 수 있는 최대 인원 수
		// 1 : 1학년 남자, 2 : 1학년 여자, 3 : 2학년 남자, 4 : 2학년 여자 ... 
		int[] students = new int[13]; // 0인덱스 사용 X
		int cnt = 0; // 방 개수
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			int idx = grade*2-sex; // ex) 1학년 여자 = 1*2-0 = 인덱스 2
			
			students[idx]++;
			if(students[idx]%k == 1) cnt++; // 1명만 써도 방배정 필요 
		
		
		}
		System.out.println(cnt);
	}
}
