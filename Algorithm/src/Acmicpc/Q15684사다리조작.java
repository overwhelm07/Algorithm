package Acmicpc;

import java.util.Scanner;

public class Q15684사다리조작 {
	
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
		
		//사다리 세우기
		rec(0, 1, 0);
		
		if(ans == 4) ans = -1;
	}

	private static void rec(int depth, int bi, int bj) {
				
		//사다리가 일치
		if(isMatching()) {
			if(depth < ans) {
				ans = depth;
			}
			chk = true;
			return;
		}
		//사다리 3개까지만 넣기 가능 
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
				//왼쪽에 선이 있을 경우 
				if(map[i][tmpJ-1]) {
					tmpJ--;
				}//오른쪽에 선이 있을 경우
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
		
		//세로선 개수 2<=N<=10
		J = sc.nextInt();
		//가로선 개수 0<=M<=N*H
		M = sc.nextInt();
		//가로선 위치 개수 1<=H<=30
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
