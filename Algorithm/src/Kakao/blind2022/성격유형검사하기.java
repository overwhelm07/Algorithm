package Kakao.blind2022;

import java.util.Arrays;

public class 성격유형검사하기 {
	public static void main(String[] args) {
		class Solution {
			enum TYPE {
				RT(1), CF(2), JM(3), AN(4);

				private final int typeNum;

				TYPE(int typeNum) {
					this.typeNum = typeNum;
				}

				public int getTypeNum() {
					return typeNum;
				}
			}
			
			class Mbti {
				int[] scoreMap = new int[] { -1, -3, -2, -1, 0, 1, 2, 3 };
				private int[] mbtiScore = new int[5];

				public void calculateScore(String typeStr, int score) {
					int typeNum = 0;
					int mappedScore = 0;
					try {
						typeNum = TYPE.valueOf(typeStr).getTypeNum();
						mappedScore = scoreMap[score];
					} catch (Exception e) {
						typeStr = new StringBuilder(typeStr).reverse().toString();
						typeNum = TYPE.valueOf(typeStr).getTypeNum();
						mappedScore = -scoreMap[score];
					}
					System.out.println("==============");
					System.out.println(typeStr + " " + score);
					System.out.println(typeNum + " " + mappedScore);
					System.out.println("==============");

					mbtiScore[typeNum] += mappedScore;
				}

				public String getMbti() {
					StringBuilder sb = new StringBuilder();
					System.out.println(Arrays.toString(mbtiScore));
					if (mbtiScore[1] > 0) {
						sb.append("T");
					} else {
						sb.append("R");
					}

					if (mbtiScore[2] > 0) {
						sb.append("F");
					} else {
						sb.append("C");
					}

					if (mbtiScore[3] > 0) {
						sb.append("M");
					} else {
						sb.append("J");
					}

					if (mbtiScore[4] > 0) {
						sb.append("N");
					} else {
						sb.append("A");
					}

					return sb.toString();
				}
			}

			public String solution(String[] survey, int[] choices) {

				String answer = "";

				Mbti mbti = new Mbti();

				for (int i = 0; i < survey.length; ++i) {
					mbti.calculateScore(survey[i], choices[i]);
				}

				return mbti.getMbti();
			}
		}

		Solution sol = new Solution();

		// 비동의, 동의
		// 1(매우 비동의 +3)~7(매우 동의+3) 4(모르겠음)
		String[] survey = new String[] { "AN", "CF", "MJ", "RT", "NA" };
		int[] choices = new int[] { 5, 3, 2, 7, 5 };
		System.out.println(sol.solution(survey, choices));

	}
}