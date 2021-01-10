package 동적계획법;

import java.util.*;

public class ex7579 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N =  sc.nextInt(), M = sc.nextInt();
		int[][] input = new int[N][2]; //첫번째 열 바이트수, 두번째 열 비활성화 비용
		int[][] dp = new int[N][100001]; // dp[바이트][비용]
		int min=Integer.MAX_VALUE; // 최소값을 정수의 최대값으로 설정해놓는다.
		
		for(int i=0;i<N;i++) input[i][0]=sc.nextInt(); // 바이트 수
		for(int i=0;i<N;i++) input[i][1]=sc.nextInt(); // 비용
		
		for(int i=1;i<=N;i++) {
			int m = input[i][0], val=input[i][1];
			for(int j=1;j<=10000;j++) {
				if(i == 1) {
                    if (j >= val) dp[i][j] = m;
                }
                else {
                    if (j >= val) dp[i][j] = Math.max(dp[i - 1][j - val] + m, dp[i - 1][j]);
                    else dp[i][j] = dp[i - 1][j];
                }
                if(dp[i][j] >= m) min = Math.min(min, j);
			}
		}
		System.out.println(min);
	}
}
