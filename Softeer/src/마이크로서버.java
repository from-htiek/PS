import java.util.*;
import java.io.*;


public class 마이크로서버
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int t = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < t; tc++){
            int result = 0; 
            int n = Integer.parseInt(br.readLine());
            int[] list = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                list[i] = Integer.parseInt(st.nextToken());
            }

            // System.out.println(Arrays.toString(list));
            Arrays.sort(list); // 정렬
            // System.out.println(Arrays.toString(list));

            int sum = 0;
            boolean flag = false;
            for(int i = n-1; i >= 0; i--){ // 제일 용량이 큰 서비스부터 시작
                flag = false;
                sum = list[i]; 
                if(sum == 0) continue; // 이미 클러스터에 포함된 서비스라면 제외
                if(sum > 600) { // 서비스의 최소 크기는 300이므로, 600 이상의 서비스는 하나의 서버를 써야함
                    flag = true; 
                    result++;
                    continue;
                }
                for(int j = i-1; j >= 0; j--){ // 같은 서버를 쓸 수 있는 서비스 찾기 
                    if(list[j] == 0) continue; // 이미 클러스터에 포함된 서비스라면 제외

                    if(sum + list[j] > 900) continue; // 합이 900을 넘으면 같은 서버 쓸 수 없으므로 제외
                    else if(sum + list[j] > 600){ // 하나의 서버 사용해야 함
                        sum += list[j];
                        list[j] = 0; 
                        result++;
                        flag = true; 
                        break;
                    }else{ // 더 합칠 수 있는 서비스 찾기
                        sum += list[j];
                        list[j] = 0;
                    }
                }
                
                if(!flag && sum != 0) result++; // 아직 포함되지 못한 서비스가 있다면 포함
            }

            System.out.println(result);

        }
    }
}