import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 2022.10.08
 * 등산로 조성
 * k만큼 깎는부분을 좀 더 효율적으로 짤 수 있었을 것 같은데 아직 많이 부족한듯.
 */
public class Test_1949 {
    public static int n, k, map[][], result; 
    public static boolean visitied[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
         
        for(int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 등산로 부지 가로, 세로
            k = Integer.parseInt(st.nextToken()); // 최대 공사 가능 깊이
            int maxHeight = 0; // 가장 높은 봉우리
            result = 0; 
             
            map = new int[n][n];
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    maxHeight = Math.max(maxHeight, map[i][j]);
                }
            }
             
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(map[i][j] == maxHeight) { // 가장 높은 봉우리에서만 시작
                        visitied = new boolean[n][n];
                        visitied[i][j] = true; 
                        dfs(i, j, 1, false); 
                    }
                }
            }
             
            sb.append("#").append(tc).append(" ").append(result).append("\n");
             
        }
         
        System.out.println(sb.toString());
         
    }
     
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    public static void dfs(int y, int x, int length, boolean flag) {
         
        for(int d = 0; d < 4; d++) { // 4방위 탐색 
            int newy = y + dy[d];
            int newx = x + dx[d];
             
            if(newy < 0 || newy >= n || newx < 0 || newx >= n) continue; // 범위 벗어나면 제외
            if(visitied[newy][newx]) continue; // 방문했다면 제외
             
            if(map[y][x] > map[newy][newx] - k && !flag) { // 아직 공사 하지 않았고, 공사했을 때 등산로를 만들 수 있으면 
                visitied[newy][newx] = true;
                int depth = Math.max(1, Math.abs(map[y][x] - map[newy][newx])+1);  // 공사 높이 (최대한 조금 깎아야 최대 길이를 만들 수 있음) 
                map[newy][newx] -= depth;
                dfs(newy, newx, length+1, true);
                map[newy][newx] += depth; // 되돌리기
                visitied[newy][newx] = false; 
            }
             
            if(map[y][x] <= map[newy][newx]) continue; // 높이가 같거나 낮다면 제외
             
            visitied[newy][newx] = true;
            dfs(newy, newx, length+1, flag);
            visitied[newy][newx] = false; 
        }
 
         
        result = Math.max(result, length);
    }
     
}