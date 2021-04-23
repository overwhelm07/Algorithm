package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2805농작물수확하기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int ans, n;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			input();
			solve();
			System.out.println("#"+t+" " +ans);
		}
	}
	private static void solve() {
		int half = n/2;
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=half-cnt; j<=half+cnt; j++) {
				ans+=map[i][j];
			}
			if(i<half) {
				cnt++;
			}else {
				cnt--;
			}
		}
	}
	private static void input() throws NumberFormatException, IOException {
		ans = 0;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for(int i=0; i<map.length; i++) {
			String str = br.readLine();
			for(int j=0; j<str.length(); j++) {
				map[i][j] = str.charAt(j)-48;
			}
		}
	}
}
