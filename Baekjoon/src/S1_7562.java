import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.11.15
 * 나이트의 이동
 */
public class S1_7562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        
        for(int tc = 0; tc < t; tc++) {
            int l = Integer.parseInt(br.readLine()); // 체스판 한 변의 길이
            st = new StringTokenizer(br.readLine());
            int knighty = Integer.parseInt(st.nextToken()); // 나이트 시작점
            int knightx = Integer.parseInt(st.nextToken()); 
            
            st = new StringTokenizer(br.readLine());
            int desty = Integer.parseInt(st.nextToken()); // 도착점
            int destx = Integer.parseInt(st.nextToken());
            
            
            int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2}; // 나이트 이동 
            int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
            boolean[][] visitied = new boolean[l][l];
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[] {knighty, knightx, 0});
            
            // bfs
            while(!q.isEmpty()) {
                int[] cur = q.poll();
                
                if(cur[0] == desty && cur[1] == destx) {
                    sb.append(cur[2]).append("\n");
                    break;
                }
                
                for(int d = 0; d < 8; d++) {
                    int newy = cur[0] + dy[d];
                    int newx = cur[1] + dx[d];
                    
                    if(newy < 0 || newy >= l || newx < 0 || newx >= l) continue;
                    if(visitied[newy][newx]) continue;
                    
                    q.offer(new int[] {newy, newx, cur[2]+1});
                    visitied[newy][newx] = true;
                    
                }
            }
        }
        
        System.out.println(sb.toString());
        
    }
}