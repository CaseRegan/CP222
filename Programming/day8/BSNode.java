
public class BSNode<K extends Comparable<K>, V> {
	private K key;
	private V value;
	private BSNode<K, V> left;
	private BSNode<K, V> right;

	public BSNode(K k, V v, BSNode<K, V> l, BSNode<K, V> r) {
		key = k;
		value = v;
		left = l;
		right = r;
	}
	
	public K getKey() {
		return key;
	}
	
	public void setKey(K k) {
		key = k; 
	}
	
	public V getValue() {
		return value;
	}
	
	public void setValue(V v) {
		value = v;
	}
	
	public BSNode<K, V> getLeft() {
		return left;
	}
	
	public BSNode<K, V> getRight() {
		return right;
	}
	
	public void setLeft(BSNode<K, V> l) {
		left = l;
	}
	
	public void setRight(BSNode<K, V> r) {
		right = r;
	}
	
	public V add(K k, V v) {
		if(k.compareTo(key) < 0) {
			if(getLeft() == null) { setLeft(new BSNode<K, V>(k, v, null, null)); return null; }
			else { return(getLeft().add(k, v)); }
		} else if(k.compareTo(key) > 0) {
			if(getRight() == null) { setRight(new BSNode<K, V>(k, v, null, null)); return null; }
			else { return(getRight().add(k, v)); }
		} else {
			setValue(v);
			return v;
		}
	}
	
	public V fetch(K k) {
		if(k.compareTo(key) < 0) { return getLeft().fetch(k); }
		else if(k.compareTo(key) > 0) { return getRight().fetch(k); }
		else return value;
	}
}
