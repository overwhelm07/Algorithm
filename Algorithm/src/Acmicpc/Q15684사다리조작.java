package Acmicpc;

import java.util.Scanner;

public class Q15684사다리조작{
	
	static Scanner sc = new Scanner(System.in);
	static boolean map[][];
	static boolean chk = false;
	static int J, M, I, ans, count=0;
	
	public static void main(String[] args) {
		long a = System.currentTimeMillis();
		input();
		solve();
		System.out.println(ans);
		System.out.println(count);
		long b = System.currentTimeMillis();
		System.out.println(b-a + "ms");	
	}

	private static void solve() {

		if(isMatching()) {
			ans = 0;
			return;
		}
		
		//��ٸ� �����
		rec(0, 1, 0);
		
		if(ans == 4) ans = -1;
	}

	private static void rec(int depth, int bi, int bj) {
				
		//��ٸ��� ��ġ
		if(isMatching()) {
			if(depth < ans) {
				ans = depth;
			}
			chk = true;
			return;
		}
		//��ٸ� 3�������� �ֱ� ���� 
		if(depth == 3) {
			return;
		}
		
		for(int i=bi; i<=I; i++) {
			for(int j=1; j<J; j++) {
				if(i==bi && j==1) j = bj+1;
				if(map[i][j] || map[i][j-1] || map[i][j+1]) {
					continue;
				}
				map[i][j] = true;
								
				rec(depth+1, i, j);
				map[i][j] = false;
				if(chk)break;
			}
			if(chk) {
				chk = false;
				break;
			}
		}
	}

	private static boolean isMatching() {
		count++;
		for(int j=1; j<=J; j++) {
			int i = 1;
			int tmpJ = j;
			while(i!=I+1) {
				//���ʿ� ���� ���� ��� 
				if(map[i][tmpJ-1]) {
					tmpJ--;
				}//�����ʿ� ���� ���� ���
				else if(map[i][tmpJ]) {
					tmpJ++;
				}
				i++;
			}
			if(j != tmpJ) {
				return false;
			}
		}
		return true;
	}

	private static void input() {
		ans = 4;
		
		//���μ� ���� 2<=N<=10
		J = sc.nextInt();
		//���μ� ���� 0<=M<=N*H
		M = sc.nextInt();
		//���μ� ��ġ ���� 1<=H<=30
		I = sc.nextInt();
		
		map = new boolean[I+2][J+2];
		
		for(int i=0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = true;
		}
		
//		printMap();
		
	}
	static void printMap(boolean[][] map) {
		System.out.println();
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				if(map[i][j]) {
					System.out.print("1 ");
				}else {
					System.out.print("0 ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

}
