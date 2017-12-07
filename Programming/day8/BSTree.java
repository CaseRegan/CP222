
public class BSTree<K extends Comparable<K>, V> implements IDict<K, V>{
	private BSNode<K, V> root;
	private int numNodes;
	private K[] keys;
	
	public BSTree() {
		root = new BSNode<K, V>(null, null, null, null);
		numNodes = 0;
		keys = null;
	}
	
	public V add(K k, V v) {
		if(root.getKey() == null) {
			root.setKey(k);
			root.setValue(v);
			keys = (K[]) new Comparable[1];
			keys[0] = k;
			return null;
		}
	
		if(!contains(k)) {
			K[] updatedKeys = (K[]) new Comparable[keys.length + 1];
			for(int i = 0; i < keys.length; i++) {
				updatedKeys[i] = keys[i];
			}
			updatedKeys[keys.length] = k;
			keys = updatedKeys;
		}
		
		V toReturn = root.add(k, v);
		if(toReturn != null) { numNodes++; }
		return toReturn;
	}

	// Damnit, I don't like how I decorated the Christmas tree. Better get a new one!
	public V remove(K k) {
		if(!contains(k)) { return null; }
		
		BSNode<K, V>[] nodes = (BSNode<K, V>[]) new Object[keys.length - 1];
		
		int i = 0;
		boolean passed = false;
		
		V toRemove = null;
		
		while(i < keys.length) {
			if(keys[i].equals(k)) {
				toRemove = fetch(keys[i]);
				passed = true; 
				i++; 
				continue; 
			}
			
			nodes[i - (passed ? 1 : 0)] = new BSNode<K, V>(keys[i], fetch(keys[i]), null, null);
		}
		
		root = new BSNode<K, V>(null, null, null, null);
		
		for(BSNode<K, V> node : nodes) {
			add(node.getKey(), node.getValue());
		}
		
		return toRemove;
	}

	
	public int size() {
		return numNodes;
	}

	
	public V fetch(K k) {
		return root.fetch(k);
	}

	public boolean contains(K k) {
		for(int i = 0; i < keys.length; i++) {
			if(keys[i].equals(k)) { return true; }
		}
		
		return false;
	}
	
	public K[] keys() {
		return keys;
	}
}
