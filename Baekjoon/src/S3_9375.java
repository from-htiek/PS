import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.03.08
 * 패션왕 신해빈
 * 
 * map 사용할 수 있음
 * june4145
 * Map<String, Integer> clothes = new HashMap<>();
 * if(!clothes.containKey(kind)){
 * 	count.put(kind, 0);
 * }
 * clothes.put(kind, clothes.get(kind)+1); 
 * 
 * Map의 for-each문은
 * for(String kind : clothes.ketSet()){
 * 	result *= clothes.get(kind)+1; 
 * }
 */
public class S3_9375 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for(int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());
			String[] clothes = new String[n];
			int[] num = new int[n];
			int idx = 0; 
			outerloop : for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken(); // 의상 이름
				String kind = st.nextToken(); // 의상 종류 

				int j = 0; 
				while(clothes[j] != null) {
					if(kind.equals(clothes[j])) {
						num[j]++;
						continue outerloop;
					}
					j++; 

				}
				clothes[j] = kind;
				num[j] = 1; 
				idx = j;

			}	


			int result = 1;

			if(idx == 0) {
				result = n;
			}else {
				for(int i : num) {
					result *= (i+1); // nC1 + nC0
				}
				result -= 1; // 모든 옷을 하나도 고르지않았을 때 제외
			}
			
			System.out.println(result);
//			System.out.println(Arrays.toString(clothes));
//			System.out.println(Arrays.toString(num));
//			sb.append(result).append("\n");
			
		}
		
		//System.out.println(sb.toString());
	}
}
