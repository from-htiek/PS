import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2023.01.29
 * 예산
 * 조건을 모르겠어서 검색했다. 아직 나는 매개변수 탐색에 서툴다.
 * 언제 +1을 해주고, 언제는 그냥 mid를 넘기는 건지 잘 모르겠다
 * 매개변수도 뭘로 정해야할지 바로 와닿지 않고 return 조건도 헷갈린다 흑흑
 * 벌써 이분탐색부터 3문제정도는 풀어본것같은데 감을 못잡네... 
 */
public class S3_2512 {
	public static int n, m, list[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 지방의 수
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        list = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++) {
        	list[i] = Integer.parseInt(st.nextToken());
        	max = Math.max(max, list[i]);
        }
        
        m = Integer.parseInt(br.readLine()); // 총 예산
        
        System.out.println(binarySearch(0, max));
        
	}
    
    public static int binarySearch(int start, int end) {
    	if(start > end) return end;
    	else {
    		int mid = (start + end) / 2;
    		
    		int sum = 0;
    		for(int i = 0; i < n; i++) {
    			if(mid < list[i]) sum += mid;
    			else sum += list[i];
    		}
    		
//    		System.out.println(sum);
//    		System.out.println(start + " " + end + " " + mid);
    		if(sum <= m) return binarySearch(mid+1, end);
    		else return binarySearch(start, mid-1);
    	}
    }
}
