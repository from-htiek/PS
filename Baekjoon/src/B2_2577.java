import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 2577
 * 숫자의 개수
 */
public class B2_2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = 1;
        
        for(int i = 0; i < 3; i++) {
            number *= Integer.parseInt(br.readLine());
        }
        
       
        int[] num = new int[10];
        String string = String.valueOf(number);
        for(int i = 0, size = string.length(); i < size; i++) {
            num[string.charAt(i) - '0'] += 1;
        }
        
        for(int i = 0; i < 10; i ++) {
            System.out.println(num[i]);
        }
        
    }
}
