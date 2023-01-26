import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2023.01.26
 * 나무 자르기
 */
public class S2_2805 {
	public static int n, m, tree[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 나무의 수
		m = Integer.parseInt(st.nextToken()); // 집으로 가져가려고 하는 나무의 길이
		
		tree = new int[n];
		st = new StringTokenizer(br.readLine());
		int max = 0;
		for(int i = 0; i < n; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, tree[i]); // 나무의 최대값
		}
		
		
		System.out.println(binarySearch(0, max)); // 나무높이 0 ~ max로 이분탐색
		
	}
	
	public static long binarySearch(long start, long end) {
		if(start + 1 >= end) return start;
		else {
			long mid = (start + end) / 2;
			
			long sum = 0; // mid 높이로 잘랐을 때 나오는 나무의 길이
			for(int i = 0; i < n; i++) {
				if(mid < tree[i]) sum += (tree[i] - mid);
			}
			
			if(sum < m) return binarySearch(start, mid); // 나무의 길이가 필요한 길이보다 작을 때
			else return binarySearch(mid, end); // 클 때
		}
	}
}
