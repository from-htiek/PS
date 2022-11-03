import java.util.*;
import java.io.*;
/*
 * 2022.11.03
 * 바이러스
 */
public class 바이러스
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long result = k;
        for(int i = 0; i < n; i++){
            result = (result * p) % 1000000007;
        }

        System.out.println(result);

    }
}