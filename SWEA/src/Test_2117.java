import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
/*
 * 2022.10.10
 * 홈 방범 서비스
 * 더 좋은 방법을 찾아보자.. 이거 말고
 */
public class Test_2117 {
	public static int n, m, result, map[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int t = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 도시 크기
            m = Integer.parseInt(st.nextToken()); // 하나의 집이 지불할 수 있는 비용
             
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
                    for(int k = 1; k <= n+1; k++) {
                        bfs(i, j, k);
                    }
                }
            }
             
            System.out.println("#" + tc + " " + result);
        }
    }
     
     
    public static void bfs(int y, int x, int k) {
         
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};
         
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visitied = new boolean[n][n];
        q.offer(new int[] {y, x});
        visitied[y][x] = true;
 
        int cnt = 0; 
        if(map[y][x] == 1) cnt++;
         
        while(!q.isEmpty()){
            int[] cur = q.poll();
             
            for(int d = 0; d < 4; d++) {
                int newy = cur[0] + dy[d];
                int newx = cur[1] + dx[d];
                 
                if(newy < 0 || newy >= n || newx < 0 || newx >= n) continue; // 범위 벗어나면 제외
                if(visitied[newy][newx]) continue; // 이미 방문 했다면 제외
                if(Math.abs(y - newy) + Math.abs(x - newx) >= k) continue; // 거리를 벗어났다면 제외
                 
                q.offer(new int[] {newy, newx});
                visitied[newy][newx] = true;
                if(map[newy][newx] == 1) cnt++; 
            }
        }
         
        int cost = k * k + (k-1) * (k-1);
        if(cnt*m - cost >= 0 && cnt > result) {
            result = cnt;
        }
         
         
    }
}
