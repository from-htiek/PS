import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/*
 * 2023.01.30
 * 긴자리 계산
 * BigInteger라니.. 생각도 못했다 
 * 브론즈5인데 생각보다 수학적으로 돌려풀 수 있는 방법이 많았음
 * 이거 브론즈5 맞아?
 */
public class B5_2338 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger a = new BigInteger(br.readLine());
        BigInteger b = new BigInteger(br.readLine());

        System.out.println(a.add(b));
        System.out.println(a.subtract(b));
        System.out.println(a.multiply(b));
        
    }
}
