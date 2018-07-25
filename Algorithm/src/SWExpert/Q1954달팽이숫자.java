package SWExpert;

import java.util.Scanner;

public class Q1954달팽이숫자 {

	static Scanner sc = new Scanner(System.in);
	static int n;
	static int[][] map;
	static int[][] step = {{0, 1},{1, 0},{0, -1},{-1, 0}};
	public static void main(String[] args) {
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; ++t) {
			n = sc.nextInt();
			solve();
			output(t);
		}

	}
	private static void output(int test_case) {
		System.out.println("#"+test_case);
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	private static void solve() {
		map = new int[n][n];
		
		// 우 하 좌 상
		rec(0, 0, 0, 1);
	}
	private static void rec(int i, int j, int x, int cnt) {
		//범위에 벗어났을 때 또는 이미 숫자가 있을 때 
		if(!(inRange(i, j)) || map[i][j]!=0) {
			i-=step[x][0];
			j-=step[x][1];
			x++;
			if(x==4) x=0;
			i+=step[x][0];
			j+=step[x][1];
		}
		
		if(inRange(i, j) && map[i][j]==0) {
			map[i][j] = cnt;
			rec(i+step[x][0], j+step[x][1], x, cnt+1);
		}
	}
	private static boolean inRange(int i, int j) {
		return i>=0 && i<n && j>=0 && j<n;
	}
}
