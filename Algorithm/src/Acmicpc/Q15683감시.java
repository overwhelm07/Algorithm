package Acmicpc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q15683감시 {
	static Scanner sc = new Scanner(System.in);
	static final int[][] step = {{-1,0}, {0,1},{1, 0},{0, -1}};
	static int[][] map;
	static List<Obj> objList;
	static int N, M, zeroCnt, ans;
	
	private static class Obj{
		int i, j, num, dir;
		
		public Obj(int i, int j, int num, int dir) {
			this.i = i;
			this.j = j;
			this.num = num;
			this.dir = dir;
		}
	}
	
	public static void main(String[] args) {
		input();
		solve();
		System.out.println(ans);
	}

	private static void solve() {
//		System.out.println(objList.size());		
		
		rec(0);
	}
	private static void rec(int dep) {
		if(dep == objList.size()) {
			int zeroSize = getZeroSize();
			if(ans > zeroSize) {
				ans = zeroSize;
			}
//			printObjListInfo();
			return;
		}
		
		Obj obj = objList.get(dep);
		
		if(obj.num == 5) {
			obj.dir = 1;
			rec(dep+1);
		}else if(obj.num == 2) {
			for(int i=1; i<=2; i++) {
				obj.dir = i;
				rec(dep+1);
			}
		}else {
			for(int i=1; i<=4; i++) {
				obj.dir = i;
				rec(dep+1);
			}
		}
	}

	private static void printObjListInfo() {
		
		for(Obj obj : objList) {
			System.out.println(obj.i + " " + obj.j + " " + obj.num + " " + obj.dir);
		}
		System.out.println();
	}

	private static int getZeroSize() {
		//copyMap
		int [][]tmpMap = new int[N][M];
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length;j++) {
				tmpMap[i][j] = map[i][j];
			}
		}
		
		int ret = zeroCnt;
				
		for(Obj obj : objList) {
			List<Integer> dirList = getDirInfo(obj.num, obj.dir);
			
			for(int x : dirList) {
				int i = obj.i+step[x][0], j = obj.j+step[x][1];
				
				while(canGo(i, j, tmpMap)) {
					if(tmpMap[i][j] == 0) {
						tmpMap[i][j] = -1;
						ret--;
					}
					i+=step[x][0];
					j+=step[x][1];
				}
			}
			
		}
		
		return ret;
	}

	private static boolean canGo(int i, int j, int[][] map) {
		return i>=0 && i<N && j>=0 && j<M && map[i][j]!=6;
	}

	// ���� ������ �о���� �޼ҵ�
	private static List<Integer> getDirInfo(int num, int dir){
		List<Integer> ret = new ArrayList<Integer>();
		
		switch (num) {
		case 1:
			if(dir==1) {
				ret.add(0);
			}else if(dir==2) {
				ret.add(1);
			}else if(dir==3) {
				ret.add(2);
			}else if(dir==4) {
				ret.add(3);
			}
			break;
		case 2:
			if(dir==1) {
				ret.add(0);
				ret.add(2);
			}else if(dir==2) {
				ret.add(1);
				ret.add(3);
			}
			break;
		case 3:
			if(dir==1) {
				ret.add(0);
				ret.add(1);
			}else if(dir==2) {
				ret.add(1);
				ret.add(2);
			}else if(dir==3) {
				ret.add(2);
				ret.add(3);
			}else if(dir==4) {
				ret.add(3);
				ret.add(0);
			}
			break;
		case 4:
			if(dir==1) {
				ret.add(3);
				ret.add(0);
				ret.add(1);
			}else if(dir==2) {				
				ret.add(0);
				ret.add(1);
				ret.add(2);
			}else if(dir==3) {
				ret.add(1);
				ret.add(2);
				ret.add(3);
			}else if(dir==4) {
				ret.add(2);
				ret.add(3);
				ret.add(0);
			}
			break;
		case 5:
			if(dir==1) {
				ret.add(0);
				ret.add(1);
				ret.add(2);
				ret.add(3);
			}
			break;

		default:
			break;
		}
		
		
		return ret;
	}

	private static void input() {
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		ans = Integer.MAX_VALUE;
		objList = new ArrayList<>();
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 0) {
					zeroCnt++;
				}else if(map[i][j] != 0 && map[i][j] != 6) {
					objList.add(new Obj(i, j, map[i][j], 0));
				}
			}
		}
		
//		printMap(map);
	}

	private static void printMap(int[][] map) {
		
		System.out.println();
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
