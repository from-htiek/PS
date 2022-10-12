import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.10.12
 * 미생물 격리
 * 메모리를 엄청 많이 쓰는 코드였다. 최적화된 코드를 보니 map을 해당 위치에 몇 개의 군집이 모여있는지를 체크 하는 배열로 사용하고
 * 이 값이 2이상일 때 (2개 이상의 군집이 모였을 때) 를 체크하는 식의 코드가 많았다.
 * 사실 이 코드도 군집이 순차적으로 합쳐지는것이 아닌, 순서와 상관없이 크기가 가장 큰 군집의 방향을 따라가야한다는 걸 
 * 뒤늦게 깨달아서 스터디원의 조언을 받고 고친 코드인데.. 아직도 나는 많이 헤매는 것 같다
 */
public class Test_2382 {
    public static class pos {
    
        int id;
        int y;
        int x;
        int num;
        int dir;
        int max; 
        
        public pos(int id, int y, int x, int num, int dir, int max) {
            super();
            this.id = id;
            this.y = y;
            this.x = x;
            this.num = num;
            this.dir = dir;
            this.max = max;
        }

        @Override
        public String toString() {
            return "pos [id=" + id + ", y=" + y + ", x=" + x + ", num=" + num + ", dir=" + dir + ", max=" + max + "]";
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int t = Integer.parseInt(br.readLine());
        
        int[] dy = {0, -1, 1, 0, 0}; // 상, 하, 좌, 우
        int[] dx = {0, 0, 0, -1, 1};
        
        for(int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 구역 크기
            int m = Integer.parseInt(st.nextToken()); // 격리 시간
            int k = Integer.parseInt(st.nextToken()); // 미생물 군집 개수
            
            int[][]map = new int[n][n];
            pos[] micro = new pos[k+1];
            for(int i = 1; i <= k; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken()); // 세로
                int x = Integer.parseInt(st.nextToken()); // 가로
                int num = Integer.parseInt(st.nextToken()); // 미생물 수
                int dir = Integer.parseInt(st.nextToken()); // 이동방향
                
                micro[i] = new pos(i, y, x, num, dir, num); // 군집 추가
                map[y][x] = i; // 위치 기록
//                System.out.println(micro[i]);
            }
        
            
            while(m-- > 0) { // m시간동안 반복 
                int[][] _map = new int[n][n]; // 미생물 위치 표시할 새 구역
                
                for(int i = 1; i <= k; i++) {
                    pos mic = micro[i];
                    if(mic.num == 0) continue; // 이미 합쳐진 군집은 계산 X
                    
                    int newy = mic.y + dy[mic.dir]; // 이동 후 위치 
                    int newx = mic.x + dx[mic.dir];
                    
                    if(newy == 0 || newy == n-1 || newx == 0 || newx == n-1) { // 약품이 칠해져 있을 때
                        mic.num /= 2;
                        mic.dir = mic.dir % 2 == 1 ? mic.dir+1 : mic.dir-1;
                    }
                    
                    if(_map[newy][newx] == 0) { // 해당 자리에 다른 미생물 군집이 없다면
                        _map[newy][newx] = mic.id;
                        micro[i].y = newy;
                        micro[i].x = newx;
                        micro[i].num = mic.num;
                        micro[i].dir = mic.dir;
                    }else { // 있다면
                        int other = _map[newy][newx];
                        
                        if(micro[other].max > mic.max) { // 해당 위치에 모이는 군집의 최대값 비교
                            micro[other].num += mic.num;
                            micro[i].num = 0; 
                        }else {
                            mic.num += micro[other].num;
                            micro[other].num = 0;
                            
                            _map[newy][newx] = mic.id;
                            micro[i].y = newy;
                            micro[i].x = newx;
                            micro[i].num = mic.num;
                            micro[i].dir = mic.dir;
                        }
                    }
                    
                }
                
                
                map = _map;
                for(int i = 1; i <= k; i++) { // 최대값을 미생물 군집의 수로 바꿔줌
                    micro[i].max = micro[i].num;
                }

            }
            
            int result = 0;
            for(int i = 1; i <= k; i++) {
                if(micro[i].num == 0) continue;
                result += micro[i].num;
            }
            
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        
        System.out.println(sb.toString());
    }
}