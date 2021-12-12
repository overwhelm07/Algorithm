package SWExpert;

import java.util.Arrays;
import java.util.Scanner;

public class Q2817부분수열의합 {
	static Scanner sc = new Scanner(System.in);
	static int n, k, ans;
	static int[] arr;
	
	public static void main(String[] args) {
		int T = sc.nextInt();
		
		for(int t=1; t<=T; ++t) {
			input();
			solve();
			System.out.println("#"+t + " " + ans);
		}
	}

	private static void solve() {
		for(int i=0; i<n; i++) {
			rec(i, 0);
		}
	}

	private static void rec(int idx, int sum) {
		int newSum = arr[idx] + sum; 
		//�κм��� ���� k�� �� ��
		if(newSum == k) {
			ans++;
			return;
		}
		
		for(int i=idx+1; i<n; i++) {
			//�κм��� ���� k�� �ʰ��� ��
			if(newSum+arr[i] > k) {
				break;
			}
			rec(i, newSum);
		}
	}

	private static void input() {
		ans = 0;
		n = sc.nextInt();
		k = sc.nextInt();
		
		arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
	}
}
