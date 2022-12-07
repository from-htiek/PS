import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/*
 * 2022.12.07
 * 괄호 제거
 * 생각하지 못했던 점 
 * 1. 다른 괄호를 없애도 똑같은 결과가 나올 수 있다 ex) ((0)) => hashset을 썼다
 * 2. 괄호 번호가 순차적일거라고 생각했는데 아니였음 => check 배열을 하나 더 추가했다
 */
public class G5_2800 {
	public static int total;
	public static String input;
	public static StringBuilder sb;
	public static HashSet<String> hashset;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		
		total = 0; // 괄호 쌍 개수
		for(int i = 0, size = input.length(); i < size; i++) {
			if(input.charAt(i) == '(') total++; 
		}
		
		sb = new StringBuilder();
		hashset = new HashSet<>();
		subset(0, new boolean[total], 0); // 부분집합 생성
		
		ArrayList<String> list = new ArrayList<>(hashset);
		Collections.sort(list); // 정렬
		
		for(String str : list) {
			System.out.println(str);
		}
	}
	
	public static void subset(int idx, boolean visitied[], int cnt) {
		
		if(idx == total) {
			if(cnt != total) { // input과 같은 경우는 제외 
//				System.out.println(Arrays.toString(visitied));
				boolean[] check = new boolean[total]; // 해당 괄호를 체크했는지
				int frontCnt = -1;
				int backCnt = frontCnt;
				
				for(int i = 0, size = input.length(); i < size; i++) {
					char ch = input.charAt(i);
					if(ch == '(') { 
						frontCnt++;
						if(visitied[frontCnt]) sb.append(ch);
					}else if(input.charAt(i) == ')') {
						backCnt = frontCnt;
						while(true) { 
							if(!check[backCnt]) break;
							backCnt--;
						}
						
						check[backCnt] = true;
						if(visitied[backCnt]) sb.append(ch);
					}else {
						sb.append(ch);
					}
				}
//				System.out.println(sb.toString());
				hashset.add(sb.toString()); // 중복 방지를 위해 hashset에 넣기
				sb.setLength(0);
			}

			return;
		}
		
		visitied[idx] = true;
		subset(idx+1, visitied, cnt+1);
		
		visitied[idx] = false;
		subset(idx+1, visitied, cnt);		
		
	}
}
