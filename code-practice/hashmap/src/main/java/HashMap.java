import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class HashMap<K,V> implements Map<K, V>{

	Entry table [];
	
	private int count;
	private final int initialCapacity=10;
	
	
	
	public HashMap() {
		super();
		table = new Entry[initialCapacity];
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}

	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	public Set<Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	public V get(Object key) {

		int hash = key.hashCode();
		int pos = hash % initialCapacity;
		Entry<K,V> entry = table[pos];
		if(entry==null) {
			return null;
		}
		else {
			while(entry != null) {
				if(entry.hash == hash && key.equals(entry.key)) {
					return entry.value;
				}
				entry = entry.next;
			}
		}
		return null;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	public V put(K key, V value) {

		int hash = key.hashCode();
		int pos = hash % initialCapacity;
		Entry<K,V> entry = table[pos];
		if(entry == null) {
			entry = getEntry(key, value, hash);
			table[pos] = entry;
			count ++;
		}
		else {
			while(entry.next != null) {
				if(entry.hash == hash && key.equals(entry.key)) {
					V oldValue = entry.value;
					entry.value = value;
					return oldValue;
				}
				entry = entry.next;
			}
			entry.next = getEntry(key, value, hash);
			count ++;
		}
		return null;
	}

	private Entry<K, V> getEntry(K key, V value, int hash) {
		Entry<K, V> entry;
		entry = new Entry<K, V>();
		entry.hash = hash;
		entry.key=key;
		entry.value = value;
		return entry;
	}

	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub
		
	}

	public V remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	public int size() {
		return count;
	}

	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private class Entry<K,V> {
		int hash;
		K key;
		V value;
		Entry <K,V> next;
		
	}

}
