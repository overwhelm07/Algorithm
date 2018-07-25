package SWExpert;

import java.util.Scanner;

public class Q2806NQueen2 {
	
	static Scanner sc = new Scanner(System.in);
	static int ans, n;
	static int[] map;
	
	public static void main(String[] args) {
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			n = sc.nextInt();
			
			solve(n);
			
			System.out.println("#"+t+" " + ans);
		}
		

	}

	private static void solve(int n) {
		map = new int[n];
		ans = 0;
		
		rec(0);
	}
	
	
	private static void rec(int dep) {
		if(dep==n) {
			ans++;
			return;
			
		}
		for(int i=0; i<n; i++) {
			map[dep] = i;
			if(isPromising(dep)) {
				rec(dep+1);
			}
		}
		
		
	}

	private static boolean isPromising(int dep) {
		for(int i=0; i<dep; i++) {
			//같은 열에 있을 경우 
			if(map[i] == map[dep]) return false;
			
			//대각선에 있는 경우 
			if(Math.abs(map[i]-map[dep]) == Math.abs(i-dep)) return false;
		}
		
		return true;
	}

	

}
