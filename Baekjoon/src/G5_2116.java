import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.12.01
 * �ֻ��� �ױ�
 */
public class G5_2116 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null; 
		int n = Integer.parseInt(br.readLine());
		int[][] dices = new int[n][7];
		
		for(int i = 0; i < n; i++) { // �ֻ��� �Է�
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < 7; j++) {
				dices[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] order = {0, 6, 4, 5, 2, 3, 1}; // ���� ���ֺ��� �ε���
		int result = 0; // ������ �� �ִ밪 
		
		for(int i = 1; i <= 6; i++) { // ù��° �ֻ����� �ٴڿ� �� �� �ִ� ���ڴ� 1~6 
			int num = i; // ���� ������ �Ǵ� ����
			int opposite = order[num]; 
			int sum = 0; // ���� ���ڸ� �������� �׾��� �� �ִ밪
			
			for(int j = 0; j < n; j++) { // n���� �ֻ��� �ױ�
				int max = 0; // ���� �ֻ��������� �ִ밪 
				int tmp = 0; // ���� �ֻ����� �Ʒ���
				
				for(int k = 1; k <= 6; k ++) { // �ֻ��� 6���� �� ���� 
					if(j != n-1 && dices[j+1][k] == dices[j][opposite]) tmp = k; 
					if(k == dices[j][num] || k == dices[j][opposite]) continue;
					max = Math.max(max, k);
				}

				sum += max;
				num = tmp; // ���� �ֻ��� �Ʒ���
				opposite = order[num]; // ���� �ֻ��� ����
			}

			result = Math.max(sum, result); // �ִ밪 ���� 
		}
		
		System.out.println(result);
		
		
		
		
	}
}
