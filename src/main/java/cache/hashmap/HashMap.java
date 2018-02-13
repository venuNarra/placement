package cache.hashmap;

import java.util.Arrays;

public class HashMap {

	int SIZE;

	Entry map[] = new Entry[SIZE];

	public HashMap(int size) {
		super();
		SIZE = size;
		map=new Entry[size];
	}

	public void put(String key, String value) {
		int hash = key.hashCode() % SIZE;
	
		Entry entry = new Entry(key, value);
		if (map[hash] == null) {
			map[hash] = entry;
		} else {
			Entry node = map[hash];
			while (node.getNext() != null) {
				if (node.getKey().equals(key)) {
					node.setValue(value);
					return;
				}
				node = node.getNext();
			}
			node.setNext(entry);
		}

	}

	public String get(String key) {
		int hash = key.hashCode() % SIZE;
		if (map[hash] != null) {
			Entry node = map[hash];
			while (node != null) {
				if (node.getKey().equals(key)) {
					return node.getValue();
				}
				node = node.getNext();
			}
		}
		return null;

	}

	@Override
	public String toString() {
		return "HashMap [map=" + Arrays.toString(map) + "]";
	}
	
}
