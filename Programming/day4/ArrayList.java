public class ArrayList<T> implements IList<T> {
	// isn't this a bad class name since it mirrors the builtin java.util.Arraylist?
	private int current;
	private T[] list;
	
	public ArrayList() {
		current = 0;
		list = (T[]) new Object[0];
	}

	public void insert(int idx, T v) {
		if(idx == list.length) {
			append(v);
			return;
		}
		
		T[] tempList = (T[]) new Object[list.length + 1];
		
		for(int i = 0; i < tempList.length; i++) {
			if(i < idx) {
				tempList[i] = list[i];
			} else if(i == idx) {
				tempList[i] = v;
			} else { // if i > idx
				tempList[i] = list[i - 1];
			}
		}
		
		if(idx <= current) { next(); }
		
		list = tempList;
	}

	public void append(T v) {
		T[] tempList = (T[]) new Object[list.length + 1];
		
		for(int i = 0; i < list.length; i++) {
			tempList[i] = list[i];
		}
		
		tempList[tempList.length - 1] = v;
		
		list = tempList;
	}

	public T fetch() {
		return fetch(current);
	}
 
	public T fetch(int idx) {
		return list[idx];
	}

	public void remove() {
		remove(current);
	}

	public void remove(int idx) {
		T[] tempList = (T[]) new Object[list.length - 1];
		
		for(int i = 0; i < tempList.length; i++) {
			if(i < idx) {
				tempList[i] = list[i];
			} else if(i >= idx) {
				tempList[i] = list[i + 1];
			}
		}
		
		list = tempList;
		
		if(idx <= current) { prev(); }
	}

	public void move(int sidx, int didx) {
		T toMove = list[sidx];
		
		remove(sidx);
		insert(didx, toMove);

		if(current == sidx) { current = didx; }
		else if(current == didx) { current = sidx; }
	}

	public void next() {
		current++;
		current = Math.min(list.length - 1, current);
		// this prevents current from becoming an illegal value
	}

	public void prev() {
		current--;
		current = Math.max(0, current);
		// this prevents current from becoming an illegal value and comes into play when current is zero and remove() is called
	}

	public void jumpToTail() {
		current = list.length - 1;
	}

	public void jumpToHead() {
		current = 0;
	}

	public int size() {
		return list.length;
	}
}
