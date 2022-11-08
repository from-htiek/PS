import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 2022.11.08
 * 문자열 폭발 
 * Stringbuilder에는 다양한 기능이있네
 * 문자열 길이가 100만이다보니 무지성으로 옮기다보면 터진다.
 * stack으로 갔다가 배열로 갔다가 .. 돌아돌아 Stringbuilder로
 */
public class G4_9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] input = br.readLine().toCharArray();
        char[] pattern =  br.readLine().toCharArray();
        
        int inputLen = input.length;
        int patternLen = pattern.length;
        int idx = -1; 
        for(int i = 0; i < inputLen; i++) { // input 길이만큰 반복 
        	sb.append(input[i]);
        	idx++;
        	boolean flag = true;
        	if(input[i] == pattern[patternLen-1]) { // 마지막 글자와 같을 때
        		if(idx - patternLen+1 < 0) continue; // sb의 길이가 패턴의 길이보다 짧으면 패스
        		for(int j = 0; j < patternLen; j++) { // 패턴과 동일한지 검사 			 
        			if(sb.charAt(idx-j) != pattern[patternLen-1-j]) {
        				flag = false;
        				break; 
        			}
        		}
        		
        		if(flag) { // 패턴과 동일하다면 삭제
        			sb.delete(idx-patternLen+1, idx+1);
        			idx -= patternLen;
        		}

        	}

        }
        
        if(sb.length() == 0) System.out.println("FRULA");
        else System.out.println(sb.toString());
        
    }
}