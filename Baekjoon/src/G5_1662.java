import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


/*
 * 2022.10.19
 * 압축
 * 스택을 쓰지 않고도 풀 수 있을 줄 알았는데 생각보다 어려웠다. 지금 코드도 같은 레벨에서 여러번의 괄호가 나오면 정상적으로 돌아가지 않는 코드다.
 * 다른 분들의 코드를 찾아보니 스택을 사용하거나 재귀를 사용해서 푼 코드가 많았다
 * 코드를 많이 봤는데도 아직 명확하지 않은 것 같다. 내일 다시 또 찾아봐야지 
 * 그리고 자료구조를 사용해서 코드 짜는게 아직 많이 어색한 것 같기도하다. 관련 문제를 더 풀어보는것도 좋아보임
 * 주말에 다시 꼭 풀어보자.
 */
public class G5_1662 {
	public static String input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        
    }
    
    public static int func(int idx) {
    	int cnt = 0;
    	
    	if(input.charAt(idx) == '(') {
    		func(idx+1);
    	}else if(input.charAt(idx) == ')') {
    		return cnt;
    	}else {
    		cnt++; 
    	}
    	
    	
    	return cnt;
    }
}