package 동적계획법;

	import java.io.*;
	import java.util.*;

	public class ex1949 {
		static int N;
		static int[][] dp;
		static int[] citizen;
		static boolean[] visit;
		static ArrayList<Integer>[] edgeList;
		
		public static void main(String[] args) throws IOException {
			Scanner sc = new Scanner(System.in);
			N = sc.nextInt();
			citizen = new int[N+1];
			edgeList = new ArrayList[N+1];
			visit = new boolean[N+1];
			
			for (int i = 1; i <= N; ++i) {
				citizen[i] = sc.nextInt();
				edgeList[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < N-1; ++i) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				
				edgeList[from].add(to);
				edgeList[to].add(from);
			}
			
			dp = new int[N+1][2];
			/* 
			    dp[i][0] = i번째 마을이 우수 마을일때 우수 마을의 주민 수 Max
			             => 조건에 따라 i+1번째 마을은 우수 마을이 될수가 없음
			              
			    dp[i][1] = i번째 마을이 우수마을이 아닐때 우수 마을의 주민 수 Max
			             => 조건에 따라 i+1번째 마을은 우수 마을이거나 아니거나 둘다 가능 
			*/
			
			visit[1] = true;
			getMaxCitizen(1);
			System.out.println(Math.max(dp[1][0], dp[1][1]));
		}
		
		public static void getMaxCitizen(int v) {
			for (int i = 0; i < edgeList[v].size(); ++i) {
				int nv = edgeList[v].get(i);
				
				if (visit[nv]) continue;
				visit[nv] = true;

				getMaxCitizen(nv);
				
				dp[v][0] += dp[nv][1];
				dp[v][1] += Math.max(dp[nv][0], dp[nv][1]);
			}
			
	        //v번째 마을을 우수 마을로 선정할 경우 시민의 수를 더함
			dp[v][0] += citizen[v];
		}
	}