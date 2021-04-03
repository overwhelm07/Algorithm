package programmers;

public class 네트워크 {

	public static void main(String[] args) {
		class Solution {
			boolean[] chk;
			int answer = 0;

			public int solution(int n, int[][] computers) {

				chk = new boolean[n];

				for (int i = 0; i < n; ++i) {
					if (chk[i]) {
						continue;
					}
					chk[i] = true;
					answer++;
					dfs(n, computers, i);
				}

				return answer;
			}

			private void dfs(int n, int[][] computers, int startIdx) {

				for (int i = 0; i < n; ++i) {
					if (computers[startIdx][i] == 1) {
						if (chk[i]) {
							continue;
						}
						chk[i] = true;
						dfs(n, computers, i);
					}
				}

			}
		}

		Solution s = new Solution();

//		System.out.println(s.solution(3, new int[][] {{1,1,0}, {1,1,0}, {0,0,1}}));
		System.out.println(s.solution(3, new int[][] { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } }));

	}

}
