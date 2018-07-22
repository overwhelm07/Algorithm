package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Q1859백만장자프로젝트 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] arr, maxArr, my;
	static List<Integer> list;
	static int cnt;
	static long ans;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			input();
			solve();

			System.out.println("#" + t + " " + ans);
		}

	}

	private static void solve() {
		
		for(int i=0; i<arr.length; i++) {

			if(arr[i] < maxArr[i]) {
				ans -= arr[i];
				ans += maxArr[i]; 
			}
		}
	}

	private static void input() throws IOException {
		list = new LinkedList<>();
		
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		//idx 이후에 있는 가장 큰 값을 갖고 있는 배열
		maxArr = new int[n];
		//내가 갖고 있는 상품
		my = new int[10001];
		ans = 0;
		
		
		String[] strArr = br.readLine().split(" ");
		
		for(int i=0; i<strArr.length; i++) {
			arr[i] = Integer.parseInt(strArr[i]);
		}
		
		int tmp = 0;
		
		for(int i=arr.length-1; i>=0; i--) {
			maxArr[i] = tmp;
			
			if(arr[i] > tmp) {
				tmp = arr[i];  
			}
		}
//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(maxArr));
		
	}

}
