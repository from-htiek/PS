import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
 
/*
 * 2022.10.13
 * 점심 식사시간
 * 너무 어려웠던 문제, 이렇게 풀어도 되나 싶다.
 * 이걸 DP로 풀 수 있을까?
 */
public class Test_2383 {
    public static class pos { // 위치 나타내는 클래스 
        int y;
        int x;
        int len;
         
        public pos(int y, int x) {
            super();
            this.y = y;
            this.x = x;
        }
 
        public pos(int y, int x, int len) {
            super();
            this.y = y;
            this.x = x;
            this.len = len;
        }
    }
    public static ArrayList<pos> stair, people;
    public static int result, peopleCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null; 
        int t = Integer.parseInt(br.readLine());
         
        for(int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[n][n];
             
            stair = new ArrayList<>(); // 계단
            people = new ArrayList<>(); // 사람 
            result = Integer.MAX_VALUE; 
             
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                     
                    if(map[i][j] == 1) people.add(new pos(i, j));
                    else if(map[i][j] > 1) stair.add(new pos(i, j, map[i][j]));
                }
            }
             
            peopleCnt = people.size();
            powerset(new boolean[peopleCnt], 0, peopleCnt);
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
         
        System.out.println(sb.toString());
    }
     
    // 부분집합 만들기 
    static void powerset(boolean[] visitied, int idx, int n) {
        if(idx == n) {
            int[] first = new int[11]; // 첫번째 계단 이용하는 사람 시간 계산
            int[] second = new int[11]; // 두번째 계단 이용하는 사람 시간 계산
            int firstIdx = 0;
            int secondIdx = 0;
             
            for(int i = 0; i < peopleCnt; i++) { // 부분집합으로 계단 배정
                if(visitied[i]) {
                    first[firstIdx] = Math.abs(stair.get(0).y - people.get(i).y) + Math.abs(stair.get(0).x - people.get(i).x);
                    firstIdx++;
                }else {
                    second[secondIdx] = Math.abs(stair.get(1).y - people.get(i).y) + Math.abs(stair.get(1).x - people.get(i).x);
                    secondIdx++;
                }
            }
             
            Arrays.sort(first); // 정렬
            Arrays.sort(second);
             
            firstIdx = 11 - firstIdx; // 0이 포함되어 있으므로 시작점 교체
            secondIdx = 11 - secondIdx;
             
//          System.out.println(Arrays.toString(first));
//          System.out.println(Arrays.toString(second));
 
             
            for(int i = firstIdx; i < 11; i = i+3) {
                for(int j = 0; j < 3; j++) {
                    if(i+j >= 11) break;
                    if(i == firstIdx) { // 처음 도착한 세 사람은 무조건 내려감 
                        first[i+j] += stair.get(0).len + 1;
                    }else { // 사람이 있을 때는 기다렸다가 내려감 
                        first[i+j] = first[i+j]+1 < first[i+j-3] ? first[i+j-3] + stair.get(0).len : first[i+j] + stair.get(0).len + 1; 
                    }
                }
            }
             
            for(int i = secondIdx; i < 11; i = i+3) {
                for(int j = 0; j < 3; j++) {
                    if(i+j >= 11) break;
                    if(i == secondIdx) {
                        second[i+j] += stair.get(1).len + 1;
                    }else {
                        second[i+j] = second[i+j]+1 < second[i+j-3] ? second[i+j-3] + stair.get(1).len : second[i+j] + stair.get(1).len + 1; 
                    }
                }
            }
             
 
            result = Math.min(result, Math.max(first[10], second[10]));
             
//          System.out.println(result);
//          System.out.println(Arrays.toString(first));
//          System.out.println(Arrays.toString(second));
//          System.out.println("-----------------------");
             
            return;
        }
         
        visitied[idx] = false;
        powerset(visitied, idx+1, n);
         
        visitied[idx] = true;
        powerset(visitied, idx+1, n);
    }
}