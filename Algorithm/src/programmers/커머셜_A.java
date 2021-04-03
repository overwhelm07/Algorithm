package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 커머셜_A {
	public static void main(String[] args) {
		class Solution {

			Map<Integer, List<Integer>> cardIdx = new HashMap<>();

			// 1<=gift_cards<=100,000
			public int solution(int[] gift_cards, int[] wants) {

				int answer = 0;

				// 여분(원하지 않는) 카드 정보 생성
				for (int i = 0; i < gift_cards.length; ++i) {
					if (gift_cards[i] != wants[i]) {

						List<Integer> cardList = cardIdx.get(gift_cards[i]);

						if (cardList == null) {
							cardList = new ArrayList<Integer>();
						}
						cardList.add(i);
						cardIdx.put(gift_cards[i], cardList);

					}
				}

				for (int i = 0; i < gift_cards.length; ++i) {
					
					int wantedCard = wants[i];
					
					if (gift_cards[i] != wantedCard) {
						
						List<Integer> cardList = cardIdx.get(wantedCard);
						
						//shuffle
						if (cardList != null) {
							gift_cards[cardList.get(0)] =  gift_cards[i];
							gift_cards[i] = wantedCard;
							cardList.remove(0);
							
							if(cardList.isEmpty()) {
								cardIdx.remove(wantedCard);
							}else {
								cardIdx.put(wantedCard, cardList);
							}
									
						} else {
							answer++;
						}

					}
				}

				return answer;
			}
		}

		Solution sol = new Solution();

//		System.out.println(sol.solution(new int[] { 4, 5, 3, 2, 1 }, new int[] { 2, 4, 4, 5, 1 }));
		System.out.println(sol.solution(new int[] { 5, 4, 5, 4, 5 }, new int[] { 1, 2, 3, 5, 4 }));

	}
}
