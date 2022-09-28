import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 2022.09.26
 * 시리얼 번호
 * Comparable, Comparator 안쓰니까 헷갈린다
 */
public class S3_1431 {
	public static class serial implements Comparable<serial>{
		int len;
		int sum;
		String str;
		public serial(int len, int sum, String str) {
			super();
			this.len = len;
			this.sum = sum;
			this.str = str;
		}
		
		@Override
		public String toString() {
			return "serial [len=" + len + ", sum=" + sum + ", str=" + str + "]";
		}
		
		@Override
		public int compareTo(serial o) {
			
			if(this.len == o.len) {
				if(this.sum == o.sum) {
					return this.str.compareTo(o.str);
				}else {
					return this.sum - o.sum;
				}
			}
			
			return this.len - o.len;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine()); // 기타의 개수
		
		serial[] guitar = new serial[n];
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			
			int sum = 0;
			for(int j = 0, size = str.length(); j < size; j++) {
				int num = str.charAt(j) - '0';
				
				if(num > 0 && num < 10) sum += num;
			}
			guitar[i] = new serial(str.length(), sum, str);
		}
		
		Arrays.sort(guitar);
		for(serial s : guitar) {
			sb.append(s.str).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
