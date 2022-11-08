import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.11.08
 * 링크와 스타트
 * 시간이 굉장히 오래 걸린다. n의 최대값이 20인데 subset을 만들면 2^20이니 그럴만도하다
 * 다른분들의 코드를 보니 사실은 subset을 만들지 않아도 되는 듯 하다
 * 결국 1 1 0 0 이나 0 0 1 1 이나 점수의 차는 같을테니, 
 * 순열로 한팀만 구하면 됐을 것 같다. 
 * 저번주에 코테 치고나서도 느꼈지만.. 문제를 정말 1차원 적으로 푸는 것 같다 흑흑
 */
public class G5_15661 {
    public static int n, ability[][], sub[], result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine()); 
        ability = new int[n][n]; // 능력치 배열
    
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        sub = new int[n]; // subset 만들기 위한 배열
        result = Integer.MAX_VALUE; // 능력치 차의 최소 값
        subset(0);
        
        System.out.println(result);
    }
    
    // 부분 집합 
    public static void subset(int idx) {
        if(idx == n) {
             System.out.println(Arrays.toString(sub));
            
            ArrayList<Integer> teamStart = new ArrayList<>();
            ArrayList<Integer> teamLink = new ArrayList<>();
            int startScore = 0;
            int linkScore = 0; 
            
            for(int i = 0; i < n; i++) { // 0은 start팀, 1은 link팀
                if(sub[i] == 0) teamStart.add(i);
                else teamLink.add(i);
            }
            
            for(int s1 : teamStart) { // 능력치 계산
                for(int s2 : teamStart) {
                    startScore += ability[s1][s2];
                }
            }
            
            for(int s1 : teamLink) {
                for(int s2 : teamLink) {
                    linkScore += ability[s1][s2];
                }
            }
            
            result = Integer.min(result, Math.abs(startScore - linkScore));
             System.out.println(result);
            
            return; 
        }
        
        sub[idx] = 0;
        subset(idx+1);
        sub[idx] = 1;
        subset(idx+1);
    }
}