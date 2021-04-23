package Kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 비밀지도{
	static char map[][];
	static int n;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {		
		input();
		sol();
	}

	private static void sol() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

	}

	private static void input() throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		map = new char [n][n];

		for (int i = 0; i < 2; i++) {
			String str = br.readLine();
			String[] strArr = str.split(" ");
			for (int j = 0; j < strArr.length; j++) {
				int num = Integer.parseInt(strArr[j]);
				String binary = Integer.toBinaryString(num);
								
				for(int k = binary.length()-1, tmp = n-1; k>=0; k--, tmp--) {
					if(binary.charAt(k)-48 == 1) {
						map[j][tmp] = '#';
					}
				}
				
			}
		}
	}

}
