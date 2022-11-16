import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2022.11.16
 * 단어 공부
 */
public class B1_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] alphabet = new int[26];
        
        for(int i = 0, size = str.length(); i < size; i++) {
            char ch = str.charAt(i);
            if(ch >= 'a') alphabet[ch - 'a']++;
            else alphabet[ch - 'A']++;
        }

        int max = 0;
        boolean flag = false; 
        char ch = '\u0000'; 
        for(int i = 0; i < 26; i++) {
            if(alphabet[i] > max) {
                max = alphabet[i];
                ch = (char) (i + 'A'); 
                flag = false;
            }else if(alphabet[i] == max && alphabet[i] != 0) {
                flag = true;  
            }
        }
        
        if(flag) {
            ch = '?';
        }
        
        
        System.out.println(ch);
    }
}