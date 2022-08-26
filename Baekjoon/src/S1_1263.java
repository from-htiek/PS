import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.08.26
 * 시간 관리
 * 음 생각보다 너무 어렵게 푼 것 같은 문제다.. 그만큼 아직 부족하다는거겠지
 * 정렬 후에 여유시간과 일어나야하는 최소시간을 계산해서 풀었는데 다른 사람의 코드를 보면서 느낀건 굳이? 였다
 * 끝나는 시간이 큰 순서대로 정렬하고 난 후에 
 * 각각 일이 끝나는 시간과, 일을 처리했을 때의 시간을 비교해 작은 값으로 갱신해주는 코드가 간결하고 제일 좋아보였다.
 * (작은걸 선택하는 이유는 일의 데드라인이 a라면 a시간까지는 무조건 처리해야하기때문임) 
 * 가장 좋았던 코드 : https://www.acmicpc.net/source/33665117
 */
public class S1_1263 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine()); // 하루에 해야 할 일
		
		int schedule[][] = new int[n][2]; // 스케줄 입력
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 2; j++) {
				schedule[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		// 마감 시간이 빠른 순, 작업이 오래 걸리는 순으로 정렬
		Arrays.sort(schedule, (o1, o2) -> {
			if(o1[1] == o2[1]) return Integer.compare(o2[0], o1[0]);
			else return Integer.compare(o1[1], o2[1]);
		});
		
//		for(int[] s : schedule) {
//			System.out.println(Arrays.toString(s));
//		}
		
		int result = schedule[0][1] - schedule[0][0]; // 일어나야 하는 시간 
		int prev = schedule[0][1]; // 바로 전 일이 끝난 시간
		int spare = 0; // 여유있는 시간
		
		for(int i = 1; i < n; i++) {
			int time = schedule[i][0];
			int end = schedule[i][1];
			int gap = end - time; // 최소 시작 시간
			
			if(prev <= gap) {
				spare += (gap - prev); 
			}else { 
				spare -= (prev - gap); 
	
				if(spare < 0) {
					result += spare; 
					spare = 0; 
				}
			}

			prev = end; 
			
			if(result < 0) {
				System.out.println(-1);
				return; 
			}
		}
		
		System.out.println(result);

		
	}
}
