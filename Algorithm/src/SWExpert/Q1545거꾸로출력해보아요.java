package SWExpert;

import java.util.Scanner;

public class Q1545�Ųٷ�����غ��ƿ� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n  = sc.nextInt();
		
		StringBuffer ans = new StringBuffer(String.valueOf(n));
		for(int i=n-1; i>=0; i--) {
			ans.append(" "+i);
		}
		System.out.println(ans);
	}

}
