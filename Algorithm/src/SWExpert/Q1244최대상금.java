package SWExpert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q1244최대상금 {
	static Scanner sc = new Scanner(System.in);
	static int ans = 0, num, changeCnt;
	static int[] arr;
	static ArrayList<Set<Integer>> al = new ArrayList<>();
	static Set<Integer> set = new HashSet<>();
	

	public static void main(String[] args) {

		int testCase = sc.nextInt();

		for (int T = 1; T <= testCase; T++) {
			input();
			solve();

			System.out.println("#" + T + " " + ans);
		}

	}

	private static void solve() {
		String strNum = String.valueOf(num);

		ans = 0;
		arr = new int[strNum.length()];
		for (int i = 0; i < strNum.length(); i++) {
			arr[i] = strNum.charAt(i) - 48;
		}
		// System.out.println(strNum);
		// System.out.println(arrayToInt(arr));

		rec(arr, 0);

	}

	private static void rec(int[] arr, int depth) {
		if (changeCnt == depth) {
			int tmp = arrayToInt(arr);
			if (tmp > ans) {
				ans = tmp;
			}
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				if(i==j) continue;
				int [] tmpArr = new int[arr.length];
				tmpArr = arr.clone();
							
				swap(tmpArr, i, j);
				int swapNum = arrayToInt(tmpArr);
				
				if(al.size() < depth+1) {
					Set<Integer> newSet = new HashSet<>();
					newSet.add(swapNum);
					al.add(depth, newSet);
				}else {
					if(!al.get(depth).contains(swapNum)) {
						al.get(depth).add(swapNum);
						rec(tmpArr, depth+1);
					}
				}
			}
		}
	}

	static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	private static int arrayToInt(int[] arr) {
		int ret = 0;
		int i = 1;
		for (int idx = arr.length - 1; idx >= 0; --idx) {
			ret += arr[idx] * i;
			i *= 10;
		}

		return ret;
	}

	private static void input() {
		// 최대 자릿수 6자리
		num = sc.nextInt();
		changeCnt = sc.nextInt();
	}
}
