package cache.hashmap;

public class Entry {
	
	private String key;
	private String value;
	private Entry next;
	
	public Entry() {
		super();
	}
	public Entry(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Entry getNext() {
		return next;
	}
	public void setNext(Entry next) {
		this.next = next;
	}
	@Override
	public String toString() {
		return "Entry [key=" + key + ", value=" + value + ", next=" + next + "]";
	}
	

}
