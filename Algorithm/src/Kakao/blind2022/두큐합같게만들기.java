package Kakao.blind2022;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class 두큐합같게만들기 {
	public static void main(String[] args) {
		class Solution {
			public int solution(int[] inputQ1, int[] inputQ2) {
				int answer = -2;

				Queue<Double> q1 = new LinkedList<>(
						Arrays.stream(inputQ1).mapToDouble(x -> (double) x).boxed().collect(Collectors.toList()));
				Queue<Double> q2 = new LinkedList<>(
						Arrays.stream(inputQ2).mapToDouble(x -> (double) x).boxed().collect(Collectors.toList()));

				double sum1 = q1.stream().mapToDouble(x -> x).sum();
				double sum2 = q2.stream().mapToDouble(x -> x).sum();

				int limit = 2 * (q1.size() + q2.size());
				int count = 0;

				while (sum1 != sum2) {
//					System.out.println("count : " + count);
//					System.out.println(q1.toString() + " " + sum1);
//					System.out.println(q2.toString() + " " + sum2);

					if (count >= limit) {
						answer = -1;
						break;
					}

					if (sum1 > sum2) {
						sum1 -= q1.peek();
						sum2 += q1.peek();

						q2.add(q1.poll());
					} else {
						sum1 += q2.peek();
						sum2 -= q2.peek();

						q1.add(q2.poll());
					}

					count++;
				}
				if (sum1 == sum2) {
					answer = count;
				}

				return answer;
			}
		}

		Solution sol = new Solution();
		int[] q1 = new int[] { 3, 2, 7, 2 };
		int[] q2 = new int[] { 4, 6, 5, 1 };

//		int[] q1 = new int[] { 300000, 2, 1, };
//		int[] q2 = new int[] { 300000, 300000, 300000, 1, 2, 3, 1 };

		System.out.println(sol.solution(q1, q2));

	}
}
