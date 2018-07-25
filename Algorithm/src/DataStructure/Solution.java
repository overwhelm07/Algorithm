package DataStructure;

import java.util.Scanner;

class HashTable {
	class Hash{
		String key;
		String data;
	}
	
	int capacity;
	Hash tb[];
	
	public HashTable(int capacity) {
		this.capacity = capacity;
		tb = new Hash[capacity];
		
		for(int i=0; i<capacity; i++) {
			tb[i] = new Hash();
		}
	}
	
	private int hash(String str) {
		int hash = 5381;
		
		for(int i=0; i<str.length(); i++) {
			int c = (int) str.charAt(i);
			hash = ((hash << 5) + hash) + c;
		}
		if(hash < 0) hash*=-1;
		
		return hash % capacity;
	}
	
	boolean add(String key, String data) {
		int h = hash(key);

		while(tb[h].key != null) {
			if(tb[h].key.equals(key)) {
				return false;
			}
			h = (h+1) % capacity;
		}
		tb[h].key = key;
		tb[h].data = data;
		
		return true;
	}
	public String find(String key) {
		int h = hash(key);
		int cnt = capacity;
		
		while(tb[h].key != null && (--cnt) != 0) {
			if(tb[h].key.equals(key)) {
				return tb[h].data;
			}
			h = (h + 1) & capacity;
		}
		
		return null;
		
	}
	
}

public class Solution{
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		HashTable ht = new HashTable(100);
		
		ht.add("a", "b");
		ht.add("a", "c");
		
		System.out.println(ht.find("a"));
		System.out.println(ht.find("b"));
		
		
		
	}
}
