package Kakao.blind2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 등산코스정하기 {
	public static void main(String[] args) {
		class Solution {
			class Cost{
				private int linkedNodeNum=0, val=0;

				public Cost(int linkedNodeNum, int val) {
					super();
					this.linkedNodeNum = linkedNodeNum;
					this.val = val;
				}

				public int getLinkedNodeNum() {
					return linkedNodeNum;
				}

				public void setLinkedNodeNum(int linkedNodeNum) {
					this.linkedNodeNum = linkedNodeNum;
				}

				public int getVal() {
					return val;
				}

				public void setVal(int val) {
					this.val = val;
				}
			}
			class Node{
				int num;
				boolean isGate;
				boolean isSummits;
				List <Cost>linkedNodes = new ArrayList<>();
				
				public Node(int num, boolean isGate, boolean isSummits) {
					super();
					this.num = num;
					this.isGate = isGate;
					this.isSummits = isSummits;
				}
				
				public void addLinkedNode(int linkedNodeNum, int val) {
					linkedNodes.add(new Cost(linkedNodeNum, val));   
				}
			}
			
			int[] answer = {Integer.MAX_VALUE, -1};
			Node[] nodeList = new Node[50001];
		    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
		        //init Node 
		        for(int i=1; i<=n; ++i) {
		        	nodeList[i] = new Node(i, false, false);
		        }
		        //set gates
		        for(int i=0; i<gates.length; ++i) {
		        	nodeList[gates[i]].isGate = true;
		        }
		        //set summits
		        for(int i=0; i<summits.length; ++i) {
		        	nodeList[summits[i]].isSummits = true;
		        }
		        //set Paths
		        for(int i=0; i<paths.length; ++i) {
		        	int fromNodeNum = paths[i][0];
		        	int toNodeNum = paths[i][1];
		        	int val = paths[i][2];
		        	nodeList[fromNodeNum].addLinkedNode(toNodeNum, val);
		        	nodeList[toNodeNum].addLinkedNode(fromNodeNum, val);
		        }
		        
		        //gates 기준으로 search
		        for(int i=0; i<gates.length; ++i) {
		        	int gateNode = gates[i];
		        	int [] tmpAns = new int[] {Integer.MAX_VALUE, -1};
		        	boolean[] visitedNode = new boolean[50001];
		        	visitedNode[gateNode] = true;
		        	dfs(gateNode, tmpAns, visitedNode, gateNode);
		        }
		        
		        return answer;
		    }
			private void dfs(int gateNode, int[] tmpAns, boolean[] visitedNode, int befroeNodeNume) {
				Node beforeNode = nodeList[befroeNodeNume];
				List<Cost> costList = beforeNode.linkedNodes;
				
				for(Cost cost : costList) {
					Node tNode = nodeList[cost.getLinkedNodeNum()];
					//chk promise
					if((answer[1] != -1 && answer[1] < cost.val) || visitedNode[tNode.num]) {
						continue;
					}
					
					//chk same gate
					if(tNode.isGate && gateNode != tNode.num) {
						continue;
					}
					
					int backupCost = tmpAns[1];
					
					
					//update 
					if(tmpAns[1] < cost.val) {
						backupCost = tmpAns[1];
						tmpAns[1] = cost.val;
					}
					
					//chk summit
					if(tNode.isSummits) {
						if(answer[1] == -1 || answer[1] > tmpAns[1]) {
							answer[0] = tNode.num;
							answer[1] = tmpAns[1];
						}
						if(answer[1] == tmpAns[1] && answer[0] > tNode.num ) {
							answer[0] = tNode.num;
							answer[1] = tmpAns[1];
						}
						if(befroeNodeNume != gateNode) {
							return;
						}
					}
					visitedNode[tNode.num] = true;
					dfs(gateNode, tmpAns, visitedNode, tNode.num);
					visitedNode[tNode.num] = false;
					tmpAns[0] = Integer.MAX_VALUE;
					tmpAns[1] = backupCost;
				}
				
			}
		}
		
//		int[][] paths = {{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}};
//		int[] gates = {1, 3};
//		int[] summits = {5};
		
//		int[][] paths = {{1, 2, 5}, {1, 4, 1}, {2, 3, 1}, {2, 6, 7}, {4, 5, 1}, {5, 6, 1}, {6, 7, 1}};
//		int[] gates = {3, 7};
//		int[] summits = {1, 5};
		
		int[][] paths = {{1, 4, 4}, {1, 6, 1}, {1, 7, 3}, {2, 5, 2}, {3, 7, 4}, {5, 6, 6}};
		int[] gates = {1};
		int[] summits = {2, 3, 4};
		
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(7, paths, gates, summits)));
	}

}
