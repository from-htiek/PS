import java.util.*;
import java.io.*;
/*
 * 2022.11.03
 * 성적평균
 */
public class 성적평균
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] score = new int[n+1];

        for(int i = 1; i <= n; i++){
            score[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            float sum = 0;
            for(int j = a; j <= b; j++){
                sum += score[j];
            }
            sum = sum/(b-a+1);
            System.out.println(String.format("%.2f", sum));
        }
    }
}