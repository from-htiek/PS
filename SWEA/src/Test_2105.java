import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
/*
 * 2022.10.10
 * 디저트 카페
 * 사각형의 순서를 정해서 넣어줬다, 언제나 4방향 탐색을 하면 터지더라..
 */
public class Test_2105 {
	public static int n, map[][], starty, startx, result;
    public static boolean visitied[][], dessert[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null; 
        int t = Integer.parseInt(br.readLine());
         
        for(int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine()); // 지역 한 변의 길이
             
            map = new int[n][n];
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            result = 0; 
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    visitied = new boolean[n][n]; // 반복문 안에 넣기
                    dessert = new boolean[101];
                    starty = i;
                    startx = j;
                    dfs(i, j, 0, 0);
                     
                }
            }
             
            result = result == 0 ? -1 : result;
//          System.out.println("#" + tc + " " + result);
            sb.append("#").append(tc).append(" ").append(result).append("\n");
 
        }
         
        System.out.println(sb.toString());
         
    }
     
    public static int[] dy = {1, 1, -1, -1};
    public static int[] dx = {1, -1, -1, 1};
    public static void dfs(int y, int x, int dir, int cnt) {
         
        if(y == starty && x == startx && dir == 3) {
            result = Math.max(result, cnt);
            return; 
        }       
         
        for(int d = 0; d < 2; d++) {
            if(dir == 3 && d == 1) continue;
             
            int newy = y + dy[dir+d];
            int newx = x + dx[dir+d];
             
             
            if(newy < 0 || newy >= n || newx < 0 || newx >= n) continue; // 범위 벗어나면 제외
            if(visitied[newy][newx]) continue; // 이미 방문했다면 제외
            if(dessert[map[newy][newx]]) continue; // 이미 먹은 디저트라면 제외
             
            visitied[newy][newx] = true;
            dessert[map[newy][newx]] = true; 
             
            dfs(newy, newx, dir+d, cnt+1);
             
            dessert[map[newy][newx]] = false;
            visitied[newy][newx] = false;
             
        }
    }
}
