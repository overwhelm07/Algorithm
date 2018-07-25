package SWExpert;

import java.util.Scanner;

public class Q2806NQueen {
	
	static Scanner sc = new Scanner(System.in);
	static int ans, n;
	static int[][] map;
	
	public static void main(String[] args) {
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			n = sc.nextInt();
			
			solve(n);
			
			System.out.println("#"+t+" " + ans);
		}
		

	}

	private static void solve(int n) {
		map = new int[n][n];
		ans = 0;
		
		rec(0, 0, 0);
	}

	

	private static void printMap() {
		System.out.println();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
	}
	
	private static void rec(int bi, int bj, int dep) {
		if(dep == n) {
			ans++;
			return;
		}
		
		for(int i=bi; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i==bi&&j==0)j=bj;
				
				if(isPromising(i, j)) {
					map[i][j] = 1;
					rec(i, j, dep+1);
					map[i][j] = 0;
				}
			}
		}
	}
	private static boolean isPromising(int i, int j) {
				
		if(map[i][j] == 1) return false;
		
		//ÁÂ »ó ÁÂ»ó ¿ì»ó ¸¸ °ËÁõÇÏ¸é µÊ
		int ti = i, tj = j;
		//left
		while(tj>=0) {
			if(map[ti][tj] == 1) return false;
			tj--;
		}
		ti = i; tj = j;
		//up
		while(ti>=0) {
			if(map[ti][tj] == 1) return false;
			ti--;
		}
		ti = i; tj = j;
		//ÁÂ»ó
		while(ti>=0&&tj>=0) {
			if(map[ti][tj] == 1) return false;
			ti--;tj--;
		}
		ti = i; tj = j;
		//¿ì»ó
		while(ti>=0&&tj>=0&&tj<n) {
			if(map[ti][tj] == 1) return false;
			ti--;tj++;
		}
		
		return true;
	}

}
