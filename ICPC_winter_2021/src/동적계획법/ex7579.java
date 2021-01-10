package ������ȹ��;

import java.util.*;

public class ex7579 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N =  sc.nextInt(), M = sc.nextInt();
		int[][] input = new int[N][2]; //ù��° �� ����Ʈ��, �ι�° �� ��Ȱ��ȭ ���
		int min=Integer.MAX_VALUE; // �ּҰ��� ������ �ִ밪���� �����س��´�.
		int[][] dp = new int[N][100001]; // dp[����Ʈ][���]
		
		for(int i=0;i<N;i++) input[i][0]=sc.nextInt(); // ����Ʈ ��
		for(int i=0;i<N;i++) input[i][1]=sc.nextInt(); // ���
		
		dp[0][input[0][1]] = input[0][0];
		for(int i=1;i<N;i++) {
			int m = input[i][0], val=input[i][1];
			for(int j = 0 ; j <= 10000 ; j++ ) {
                if (j >= val) dp[i][j] = Math.max(dp[i - 1][j - val] + m, dp[i][j]);
                else dp[i][j] =Math.max(dp[i][j], dp[i - 1][j]);
                if(dp[i][j] >= M) min = Math.min(min, j);
			}
		}
		System.out.println(min);
	}
}
