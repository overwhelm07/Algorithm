package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class View3 {

	static final int EXE_COUNT = 10, MAX_HEIGHT = 254, MAX_WIDTH = 1000;	
	static int ans, n;
	static int map[] = new int[1001];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		
		for (int T = 1; T <= EXE_COUNT; T++) {
			input();
			solve();
//			System.out.println(ans);
			System.out.println("#" + (T) + " " + ans);
		}

	}

	private static void solve() {

		for (int i = 1; i <= n; i++) {
			// System.out.println(map[i]);
			int val = map[i];

			for (int x = 1; x <= val; x++) {
				/**
				 * 예외케이스 
				 * 1.맨 왼쪽일 경우 오른쪽만 탐색 
				 * 2.맨 오른쪽일 경우 왼쪽만 탐색
				 */
				// 1
				if (i == 1) {
					if (map[i + 1] < x && map[i + 2] < x) {
						ans++;
					}
				} // 2
				else if (i == n) {
					if (map[i - 1] < x && map[i - 2] < x) {
						ans++;
					}
				} else if (i != 1 && i != n) {
					if ((map[i + 1] < x && map[i + 2] < x && map[i - 1] < x && map[i - 2] < x)) {
						ans++;
					}
				}
			}
		}
	}
	
	private static void solve2() {

		for (int i = 1; i <= n; i++) {
			// System.out.println(map[i]);
			int val = map[i];

			for (int x = 1; x <= val; x++) {
				/**
				 * 예외케이스 
				 * 1.맨 왼쪽일 경우 오른쪽만 탐색 
				 * 2.맨 오른쪽일 경우 왼쪽만 탐색
				 */
				// 1
				if (i == 1) {
					if (map[i + 1] < x && map[i + 2] < x) {
						ans++;
					}
				} // 2
				else if (i == n) {
					if (map[i - 1] < x && map[i - 2] < x) {
						ans++;
					}
				} else if (i != 1 && i != n) {
					if ((map[i + 1] < x && map[i + 2] < x && map[i - 1] < x && map[i - 2] < x)) {
						ans++;
					}
				}
			}
		}
	}

	private static void input() throws IOException {
		ans = 0;

		n = Integer.parseInt(br.readLine());

//		map = new int[n + 1];
		
		// 1-n까지 입력 (0, n+1은 비어있음)
		String strArr[] = br.readLine().split(" ");
		
		for(int i=1; i<=n; i++) {
			map[i] = Integer.parseInt(strArr[i-1]);
//			System.out.println(map[i]);
		}

		// System.out.println(Arrays.toString(map));

	}

}
