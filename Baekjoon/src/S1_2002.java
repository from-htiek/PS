import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/*
 * 2022.12.02
 * 추월
 * hashmap으로 접근은 한 것 맞았으나 계속 틀려서 결국 찾아봤다. 그리고 땅을 침. 왜 이 생각을 못했을까
 * 처음에는 터널에서 나왔을 때의 index를 가지고 터널에 들어가기 전보다 위치가 더 앞이라면, 혹은 추월당했음에도 불구하고 위치가 그대로라면 result값을 올려주는 식으로 했었는데 예외가 있었다.
 * 추월을 했음에도 내 위치가 더 뒤로 밀릴 수도 있었던것.. 
 * 쉽지 않다 쉽지 않다
 */
public class S1_2002 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(br.readLine()); // 자동차 수
		HashMap<String, Integer> hashmap = new HashMap<>(); // 터널에 들어갈 때 차량번호와 순서 
		for(int i = 0; i < n; i++) {
			hashmap.put(br.readLine(), i);
		}
		
		int[] order = new int[n]; // 나올 때 순서 
		
		for(int i = 0; i < n; i++) {
			order[i] = hashmap.get(br.readLine());
		}
		
		int result = 0; 
		for(int i = 0; i < n-1; i++) {
			for(int j = i+1; j < n; j++) { // 먼저 들어간 차가 내 뒤에 있다면 추월한 것
				if(order[i] > order[j]) {
					result++;
					break; 
				}
			}
		}
		
		System.out.println(result);
			
		
	}
}