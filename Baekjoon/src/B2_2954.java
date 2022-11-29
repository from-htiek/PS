import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2022.11.29
 * 창영이의 일기장
 */
public class B2_2954 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String str = br.readLine();
        for(int i = 0, size = str.length(); i < size; i++) {
            char ch = str.charAt(i);
            sb.append(ch);
            
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                i+= 2; 
            }
        }
        
        System.out.println(sb.toString());
    }
}