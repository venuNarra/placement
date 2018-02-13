package cache.hashmap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HashMapTest {
	HashMap hashMap ;
	@Before
	public void setup(){
		hashMap=new HashMap(4);
	}

	@Test
	public void testPutGet() {
		hashMap.put("VENU", "NARRA");
		assertEquals(hashMap.get("VENU"), "NARRA");
	}

	@Test
	public void testHashCollisions() {
		System.out.println("Testing    ");
		for (int i = 0; i < 5; i++)
			hashMap.put(Integer.toString(i), Integer.toString(i));
		System.out.println(hashMap);
		for (int i = 0; i < 5; i++)
			assertEquals(Integer.toString(i), hashMap.get(Integer.toString(i)));
	}
	
	@After
	public void tearDown() {
		hashMap=null;
	}
}

