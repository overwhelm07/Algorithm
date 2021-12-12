package Acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q15686치킨배달 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] map;
	static int N, M, ans;
	static List<IJ> house, food;
	
	
	static private class IJ{
		int i, j, val;
		
		public IJ(int i, int j ) {
			this.i = i;
			this.j = j;
			val = 0;
		}
	}
	public static void main(String[] args) throws IOException {
		input();
		solve();
		System.out.println(ans);
	}

	private static void solve() {
		/**
		 * ġŲ�� �ִ� M�� ������ �� �ִ� ����� ���� dfs�� �����ϰ� 
		 * M���� ���õǾ��� �� sum(val)�� ���� �� ����� �����Ѵ�.
		 */
		
		rec(0, 0);
	}

	private static void rec(int dep, int startIdx) {
		if(dep==M) {
			if(getFoodValCnt() == M) {
				int tmpAns = retSumVal();
				if(ans > tmpAns) {
					ans = tmpAns;
				}
			}
			
			return;
		}
		
		for(int i=startIdx; i<food.size(); i++) {
			//val 1�̸� ġŲ���� � ����
			food.get(i).val=1;
			rec(dep+1, i+1);
			//val 0�̸� ġŲ���� ���� ����
			food.get(i).val=0;
		}
		
	}

	private static int getFoodValCnt() {
		int cnt = 0;
		
		for(IJ obj : food) {
			if(obj.val == 1) cnt++;
		}
		
		return cnt;
	}

	private static int retSumVal() {
		int ret = 0;
		
		
		for(IJ h : house) {
			int tmpVal = Integer.MAX_VALUE;
			for(IJ f : food) {
				//�����̸� �Ÿ������ ���� �ʴ´�.
				if(f.val == 0) continue;
				
				int tmp = (int)Math.abs(h.i-f.i) + (int)Math.abs(h.j-f.j);
				if(tmpVal > tmp) {
					tmpVal = tmp;
				}
			}
			ret+=tmpVal;
		}
		
		return ret;
	}

	private static void input() throws IOException {
		
		String [] in = br.readLine().split(" ");
		
		N = Integer.parseInt(in[0]);
		M = Integer.parseInt(in[1]);
		
		map = new int[N+1][N+1];
		house = new ArrayList<>();
		food = new ArrayList<>();
		ans = Integer.MAX_VALUE;
		
		
		for(int i = 1; i<=N; i++) {
			in = br.readLine().split(" ");
			
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(in[j-1]);
				
				//��
				if(map[i][j]==1) {
					house.add(new IJ(i, j));
				}
				//ġŲ
				else if(map[i][j]==2) {
					food.add(new IJ(i, j));
				}
			}
		}
		
//		System.out.println(house.size());
//		System.out.println(food.size());
		
		
	}

}
