import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 2022.10.28
 * 문자열 폭발 
 * 나는 스택에 약한 것 같다.. 
 * 아무리 해도 터지는데, 이  방법이 아닌듯하다.
 */
public class G4_9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine()
        String pattern =  br.readLine();
        
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        int length = input.length();
        int plength = pattern.length();
        int cnt = 0;
        boolean flag = false; 
        int idx = 0; 
        char[] result; 
        
        for(int i = 0; i < length; i++) {
            char ch = input.charAt(i);
            stack1.add(ch);
            
            if(ch == pattern.charAt(idx)) {
                idx++; 
                
                if(idx == plength) {
                    for(int j = 0; j < plength; j++) stack1.pop();
                    flag = true;
                    idx = 0;
                }
            }else if(ch == pattern.charAt(0)) {
                idx = 1;
            }else {
            	idx = 0;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        if(!flag) {
            if(stack1.size() != 0) {
            	result = new char[stack1.size()];
            	int k = stack1.size()-1;
                while(!stack1.isEmpty()) {
//                    sb.append(stack1.pop());
                	result[k--] = stack1.pop();
                	
                }
//                System.out.println(sb.reverse().toString());
                System.out.println(String.copyValueOf(result));
            }else {
                System.out.println("FRULA");
            }
            return; 
        }
        
//        System.out.println(stack1);
        

        
        while(true) {
            flag = false;
            if(cnt % 2 == 0) {
                length = stack1.size();
                idx = plength-1; 
                
                for(int i = 0; i < length; i++) {
                    char ch = stack1.pop();
                    stack2.add(ch);
                    
                    if(ch == pattern.charAt(idx)) {
                        idx--;
                        
                        if(idx == -1) {
                            for(int j = 0; j < plength; j++) stack2.pop();
                            flag = true;
                            idx = plength-1; 
                        }
                    }else if(ch == pattern.charAt(plength-1)) {
                        idx = plength-2;
                    }else {
                    	idx = plength-1; 
                    }
                    
                }
//                System.out.println(stack2);
                
            }else {
                length = stack2.size();
                idx = 0; 
                
                for(int i = 0; i < length; i++) {
                    char ch = stack2.pop();
                    stack1.add(ch);
                    
                    if(ch == pattern.charAt(idx)) {
                        idx++;
                        
                        if(idx == plength) {
                            for(int j = 0; j < plength; j++) stack1.pop();
                            flag = true;
                            idx = 0; 
                        }
                    }else if(ch == pattern.charAt(0)) {
                        idx = 1;
                    }else {
                    	idx = 0;
                    }
                    
                }
                
//                System.out.println(stack1);
            }
            
            cnt++;
            if(!flag) break; 
        }
        
        if(stack1.size() == 0 && stack2.size() == 0) {
        	System.out.println("FRULA");
            
        }else if(stack1.size() == 0) {
        	result = new char[stack1.size()];
        	int k = 0;
            while(!stack2.isEmpty()) {
            	result[k++] = stack2.pop();
//                sb.append(stack2.pop());
            }
            System.out.println(String.copyValueOf(result));
        }else if(stack2.size() == 0) {
        	result = new char[stack1.size()];
        	int k = stack1.size()-1;
            while(!stack1.isEmpty()) {
//                sb.append(stack1.pop());
            	result[k--] = stack1.pop();
            }
            System.out.println(String.copyValueOf(result));
        } 
    }
}