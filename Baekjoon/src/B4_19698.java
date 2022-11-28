import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.11.28
 * 헛간 청약
 */
public class B4_19698 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        
        int num = (w/l)*(h/l);
        if(num > n) System.out.println(n);
        else System.out.println(num);
        
    }
}