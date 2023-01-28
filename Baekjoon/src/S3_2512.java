import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2023.01.28
 * 예산
 * 얼라리요? 아니야?
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
    	if(start + 1 >= end) return end;
    	else {
    		int mid = (start + end) / 2;
    		
    		int sum = 0;
    		for(int i = 0; i < n; i++) {
    			if(mid < list[i]) sum += mid;
    			else sum += list[i];
    		}
    		
    		if(sum < m) return binarySearch(mid, end);
    		else return binarySearch(start, mid);
    	}
    }
}
