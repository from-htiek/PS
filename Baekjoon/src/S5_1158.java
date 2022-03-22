import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 2022.02.11
 * 요세푸스 문제
 * 
 * lunar00 / jhw919
 * while문의 idx를 조절하는 코스를 한번에 합쳐도 될 것 같음
 * 언제나 % 취하기
 * idx = (idx+k) % lis.size()
 */
public class S5_1158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		LinkedList<Integer> list = new LinkedList<>();
		sb.append("<");
		
		for(int i = 1; i < n+1; i++) {
			list.add(i);
		}	
		
		
		int idx = -1; // 0 인덱스 고려
		while(!list.isEmpty()){
			idx += k;
			if(idx >= list.size()) idx %= list.size(); // 사이즈 넘어가면 나머지
			sb.append(list.remove(idx)).append(", ");
			idx--; // 리스트 길이가 1 줄어들기 때문에 idx도 같이 1 줄여줌
		}
		
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb.toString());
		
	}
}
