package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 최빈수구하기{

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] cnt;
	static int ans, maxCnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			Integer.parseInt(br.readLine());
			input();

			System.out.println("#" + t + " " + ans);
		}

	}

	private static void input() throws IOException {
		cnt = new int[101];

		String[] strArr = br.readLine().split(" ");

		ans = 0;
		maxCnt = 0;

		for (String str : strArr) {
			int num = Integer.parseInt(str);

			cnt[num]++;
		}

		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] >= maxCnt) {
				maxCnt = cnt[i];
				ans = i;
			}
		}
	}

}
