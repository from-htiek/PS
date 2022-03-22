import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


/*
 * 2022.02.22
 * 패턴 마디의 길이
 * 
 * 맨어만점
 * -> substring 이용해 비교 
 */
public class D2_2007 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= t; tc++) {
			char[] list = br.readLine().toCharArray();
			ArrayList<Character> pattern = new ArrayList<>();
			int result = 0; // 패턴의 길이
			pattern.add(list[0]); // 패턴 최소 1개
			int idx = 0; // 일단 패턴으로 보여 넘어갔지만, 나중에 패턴이 아님을 발견해  패턴으로 추가할 때 추가해야되는 첫 부분 첫 인덱스
			// 예를 들어 AAAAAAAAABAAAAAAAAAB에서 A가 패턴인 줄 알고 넘어갔으나 마지막부분에서 B를 보고 패턴이 아님을 판단
			// 처음에 idx에 처음 A 추가한 인덱스 기억(idx : 0) 
			// 리스트의 1번부터 B 직전의 8까지 모두 패턴에 추가해줘야함
			
			for(int i = 1; i < 10; i++) { // 패턴 길이 최대 10
				for(int j = 0; j < 10; j++) { // 리스트 0~9번째와 비교
					int size = pattern.size();
					if(pattern.get(j%size) == list[j]) { // 같으면 넘어감 
						if(j == 9) result = size; // 리스트 9까지 비교했다면 그 크기가 패턴(10을 넘지 않음)
						continue;
					}
					else {
						if(j-idx > 1) { // 후에 패턴이 아님을 발견했을 때, idx+1부터 아님을 발견한 j 전까지 추가
							for(int k = idx+1; k < j; k++) {
								pattern.add(list[k]);
							}
						}
						pattern.add(list[j]); // 같지않다면 추가
						idx = j; // 추가했을 때 인덱스 메모
						break;
					}
				}
			}
			
			System.out.printf("#%d %d", tc, result);
		}
	}
}