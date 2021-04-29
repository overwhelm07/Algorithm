package Kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 파일명정렬 {

	public static void main(String[] args) {
		class Solution {
			class File {
				String fileName, head;
				String number;
				
				public File(String fileName) {
					this.fileName = fileName;
					head = "";number="";
					splitFileName();
					if(isEmptyStr(number)) {
						number ="0";
					}
					System.out.println(fileName + " " + head + " " + number);
				}
				
				private void splitFileName() {
					
					int idx = 0;
					//find head
					for(idx=0; idx<fileName.length(); ++idx) {
						char c = fileName.charAt(idx);
						if(c>='0'&&c<='9') {
							head = head.toLowerCase();
							break;
						}
						head+=c;
					}
					//find number
					for(;idx<fileName.length(); ++idx) {
						char c = fileName.charAt(idx);
						if(!(c>='0'&&c<='9')) {
							break;
						}
						number+=c;
					}
				}

				@Override
				public int hashCode() {
					final int prime = 31;
					int hashCode = 1;

					hashCode = prime * hashCode + ((fileName == null) ? 0 : fileName.hashCode());
					hashCode = prime * hashCode + Integer.parseInt(number);

					return hashCode;
				}

				public boolean equals(Object obj) {
					if (obj == null) {
				        return false;
				    }

				    if (this.getClass() != obj.getClass()) {
				        return false;
				    }

				    if (this == obj) {
				        return true;
				    }
				    
				    File that = (File) obj;
				    if (this.fileName == null && that.fileName != null) {
				        return false;
				    }

				    if (this.fileName.equals(that.fileName)) {
				        return true;
				    }

				    return false;
				}
				
				
			}

		    public String[] solution(String[] files) {
		    	
		        List<String> ans = new ArrayList<>();
		        
		        List <File> fileList = new ArrayList<File>();
		        for(String file : files) {
		        	fileList.add(new File(file));
		        }
		        fileList.sort(new Comparator<File>() {
					@Override
					public int compare(File o1, File o2) {
						int compareValHead = o1.head.compareTo(o2.head);
						
						if(compareValHead==0) {
							return Integer.parseInt(o1.number)-Integer.parseInt(o2.number);
						}
						
						return compareValHead;
					}
					
				});	
		        
		        for(File file : fileList) {
		        	ans.add(file.fileName);
		        }
		        
		        return ans.toArray(new String[0]);
		    }
		    
		    private boolean isEmptyStr(String str) {
		    	return str==null||str.length()==0;
		    }
		}
		Solution sol = new Solution();
//		String[] files = {"img2.JPG"};
		String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
//		String[] files = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
		System.out.println(Arrays.toString(sol.solution(files)));

	}

}
