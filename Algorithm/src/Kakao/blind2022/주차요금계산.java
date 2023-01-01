package Kakao.blind2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 주차요금계산 {
	public static void main(String[] args) {
		class Solution {
			class ParkingInfo {
				int inTime = -1;
				int outTime = -1;
				int totalTime = 0;

				public ParkingInfo(String inTime) {
					super();
					this.inTime = convertTime(inTime);
				}

				public int calculate() {

					if (outTime == -1) {
						setOutTime("23:59");
					}

					if (totalTime <= Park.baseTime) {
						return Park.baseFee;
					}

					int perTime = (int) Math.ceil((totalTime - Park.baseTime) / (double) Park.perTime);
					return Park.baseFee + (perTime * Park.perFee);
				}

				private int convertTime(String time) {
					String[] split = time.split(":");
					int hour = Integer.valueOf(split[0]);
					int min = Integer.valueOf(split[1]);
					return hour * 60 + min;
				}

				public void setOutTime(String time) {
					outTime = convertTime(time);
					totalTime += (outTime - inTime);
//					System.out.println("update totalTime: " + totalTime);
				}

				public void setInTime(String time) {
					inTime = convertTime(time);
				}

			}

			static class Park {
				public static int baseTime;
				public static int baseFee;
				public static int perTime;
				public static int perFee;
			}

			public int[] solution(int[] fees, String[] records) {

				Park.baseTime = fees[0];
				Park.baseFee = fees[1];
				Park.perTime = fees[2];
				Park.perFee = fees[3];

				Map<String, ParkingInfo> parkingInfos = new HashMap<>();
				List<String> carNumbers = new ArrayList<>();
				for (String record : records) {
					String[] splitedRecord = record.split(" ");

					String carNumber = splitedRecord[1];
					String time = splitedRecord[0];
					if ("IN".equals(splitedRecord[2])) {
//						System.out.println("IN" + carNumber);
						if (parkingInfos.get(carNumber) == null) {
							parkingInfos.put(carNumber, new ParkingInfo(time));
							carNumbers.add(splitedRecord[1]);
						} else {
							ParkingInfo parkingInfo = parkingInfos.get(carNumber);
							parkingInfo.setInTime(time);
							parkingInfo.outTime = -1;
						}
					} else {
//						System.out.println("OUT" + carNumber);
						parkingInfos.get(carNumber).setOutTime(time);
					}

				}

				Collections.sort(carNumbers);
				List<Integer> ans = new ArrayList<>();
				for (String carNumber : carNumbers) {
					ans.add(parkingInfos.get(carNumber).calculate());
				}

				return ans.stream().mapToInt(i -> i).toArray();
			}
		}

		Solution sol = new Solution();

		int[] fees = new int[] { 180, 5000, 10, 600 };
		String[] records = new String[] { "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT",
				"07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" };
		System.out.println(Arrays.toString(sol.solution(fees, records)));
	}

}
