import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 22.10.08
 * 1학년
 * DP는 어렵다.. 풀었지만 내 아이디어로 풀지도 않았음
 * 0부터 20까지라는 조건을 준 이유가 있구나. 
 */
public class G5_5557 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        
        long[][] dp = new long[n-1][21];
        dp[0][list[0]] = 1; 
        for(int i = 1; i < n-1; i++) {
            for(int j = 0; j < 21; j++) {
                if(dp[i-1][j] == 0) continue;
                
                int minus = j - list[i];
                if(minus >= 0 && minus <= 20) dp[i][minus] += dp[i-1][j];
                
                int plus = j + list[i];
                if(plus >= 0 && plus <= 20) dp[i][plus] += dp[i-1][j];
            }
        }
        
        System.out.println(dp[n-2][list[n-1]]);
    }
    
}