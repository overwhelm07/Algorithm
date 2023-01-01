package Kakao.blind2022;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class 신고결과받기 {
	public static void main(String[] args) {
		class Solution {
			public int[] solution(String[] id_list, String[] report, int k) {
				class Info {
					int idx;
					Set<Integer> reporterIdx = new HashSet<>();

					public Info(int idx) {
						super();
						this.idx = idx;
					}

					public void addReportIdx(int idx) {
						reporterIdx.add(idx);
					}

					public void setAnswer(int[] answer, int k) {
						if (reporterIdx.size() < k) {
							return;
						}
						Iterator<Integer> it = reporterIdx.iterator();
						while (it.hasNext()) {
							int idx = it.next();
							answer[idx] = answer[idx] + 1;
						}

					}
				}

				HashMap<String, Info> map = new HashMap<>();

				// init
				for (int i = 0; i < id_list.length; ++i) {
					String id = id_list[i];
					map.put(id, new Info(i));
				}

				for (int i = 0; i < report.length; ++i) {
					String r = report[i];
					String[] split = r.split(" ");
					String from = split[0];
					String to = split[1];

					map.get(to).addReportIdx(map.get(from).idx);

				}

				int[] answer = new int[id_list.length];

				for (int i = 0; i < id_list.length; ++i) {
					String id = id_list[i];
					map.get(id).setAnswer(answer, k);;
				}

				return answer;
			}
		}

		Solution sol = new Solution();
		String[] id_list = new String[] { "muzi", "frodo", "apeach", "neo" };
		String[] report = new String[] { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
		int k = 2;

		System.out.println(Arrays.toString(sol.solution(id_list, report, k)));

	}
}
