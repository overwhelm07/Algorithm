package Acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q15685드래곤커브 {
	
	static int [][] step = {{-1,0},{0,1},{1,0},{0,-1}};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int [][] input;
	static boolean[][] map = new boolean[101][101];
	
	static private class Obj{
		int i, j, d, g;
		
		public Obj(int i, int j, int d, int g) {
			this.i = i;
			this.j = j;
			this.d = d;
			this.g = g;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		System.out.println(solve());
	}
	
	private static int solve() {
		
		for(int x=0; x<input.length; x++) {
			int i = input[x][0];
			int j = input[x][1];
			int d = input[x][2];
			int g = input[x][3];
			
			ArrayList <Obj> al = new ArrayList<>();
//			System.out.println("start");
			map[i][j] = true;
			al.add(new Obj(i, j, d, g));
			makeDragon(al);
//			System.out.println("end");
		}
		
//		printMap();
		return getAns();
	}
	
	private static void makeDragon(ArrayList<Obj> al) {
	
		// 0 우, 1 상, 2 좌, 3 하
		/**
		 * 0 상, 1 우, 2 하, 3 좌 
		 *  
		 *  0 -> 3	   
		 *  1 -> 0
		 *  2 -> 1
		 *  3 -> 2
		 *  
		 *  (x+3) % 4
		 *  
		 *  0세대 1번
		 *  1세대 2번
		 *  2세대 4번 
		 *  3세대 8번
		 */
		
		int g = al.get(0).g;
		
		int size = al.size()-1;
		int i = al.get(size).i, j = al.get(size).j, d = al.get(size).d;
		
		ArrayList <Integer> dir = new ArrayList<>();
				
		int point = 1;
		
		//0세대 
		i+=step[d][0];
		j+=step[d][1];
		map[i][j] = true;
		dir.add(d);
//		System.out.println(i + " " + j + " " + d);
		
		// 드래곤 세대
		for(int x=1; x<=g; x++) {
			int tryPoint = (int)Math.pow(2, x);
			int dIdx = dir.size()-1;
//			System.out.println(x+"세대!!!");
			for(;point<tryPoint; point++) {
				int dd;
				
				dd = dir.get(dIdx--);
				
				i += step[(dd+3)%4][0];
				j += step[(dd+3)%4][1];
				
				map[i][j] = true;
				
				dir.add((dd+3)%4);
//				System.out.println(i + " " + j + " " + (dd+3)%4);
			}
		}
		
	}


	private static int getAns() {
		int ret = 0;
		
		for(int i=1; i<=100; i+=2) {
			for(int j=0; j<100; j++) {
				//위 
				if(map[i][j] && map[i-1][j] && map[i-1][j+1] && map[i][j+1]) ret++;
				
				//아래
				if(map[i][j] && map[i+1][j] && map[i+1][j+1] && map[i][j+1]) ret++;
			}
		}
		
		return ret;
	}
	
	static void printMap() {
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
	}

	private static void input() throws NumberFormatException, IOException {
		
		int n = Integer.parseInt(br.readLine());
		
		input = new int[n][4];
		
		for(int i=0; i<n; i++) {
			String[] strArr = br.readLine().split(" ");
			input[i][0] = Integer.parseInt(strArr[1]);
			input[i][1] = Integer.parseInt(strArr[0]);
			// 0 우, 1 상, 2 좌, 3 하
			input[i][2] = Integer.parseInt(strArr[2]);
			switch(input[i][2]) {
			case 0:
				input[i][2] = 1;
				break;
			case 1:
				input[i][2] = 0;
				break;
			case 2:
				input[i][2] = 3;
				break;
			case 3:
				input[i][2] = 2;
				break;
			}
			input[i][3] = Integer.parseInt(strArr[3]);
			
//			System.out.println(input[i][0] + " " + input[i][1] + " " + input[i][2] + " " + input[i][3]);			
			
		}
		
	}
	
}
