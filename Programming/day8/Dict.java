
public class Dict<K extends Comparable<K>, V> implements IDict<K,V> {
	private K[] keys;
	private V[] values;
	
	public Dict() {
		keys = null;
		values = null;
	}

	public V add(K k, V v) {
		if(keys == null) {
			keys = (K[]) new Comparable[1];
			values = (V[]) new Object[1];
			keys[0] = k;
			values[0] = v;
			return null;
		}
		
		int keyIndex = getKeyIndex(k);
		
		if(keyIndex != -1) {
			V toReplace = values[keyIndex];
			values[keyIndex] = v;
			return toReplace;
		}
		
		K[] updatedKeys = (K[]) new Comparable[keys.length + 1];
		V[] updatedValues = (V[]) new Object[values.length + 1];
		
		for(int i = 0; i < keys.length; i++) {
			updatedKeys[i] = keys[i];
			updatedValues[i] = values[i];
		}
		
		updatedKeys[keys.length] = k;
		updatedValues[values.length] = v;
		
		keys = updatedKeys;
		values = updatedValues;
		
		return null;
	}

	public V remove(K k) {
		int keyIndex = getKeyIndex(k);
		
		if(keyIndex == -1) { return null; }
		
		V toRemove = values[keyIndex];
		K[] updatedKeys = (K[]) new Comparable[keys.length - 1];
		V[] updatedValues = (V[]) new Object[values.length - 1];
		
		for(int i = 0; i < keys.length; i++) {
			if(i < keyIndex) { 
				updatedKeys[i] = keys[i]; 
				updatedValues[i] = values[i];
			} else if(i > keyIndex) {
				updatedKeys[i] = keys[i + 1];
				updatedValues[i] = values[i + 1];
			}
		}

		return toRemove;
	}
	
	public int size() {
		int numValues = 0;
		
		for(int i = 0; i < keys.length; i++) {
			if(values[i] != null) {
				numValues++;
			}
		}
		
		return numValues;
	}

	public V fetch(K k) {		
		int i = getKeyIndex(k);
		
		if(i == -1) { return null; }
		
		return values[i];
	}
	
	public K[] keys() {	
		return keys;
	}

	public int getKeyIndex(K k) {
		int i = 0;
		
		while(i < keys.length) {
			if(keys[i].equals(k)) { return i; }
			i++;
		}
		
		return -1;
	}
}
