
public class SingleLinkList<T> implements IList<T> {
	private ISLink<T> head;
	private ISLink<T> tail;
	private ISLink<T> current;
	
	private int length;
	
	public SingleLinkList() {
		length = 0;
	}
	
	public void initialize(T v) {
		ISLink<T> toInsert = new SingleLink(v);
		
		head = toInsert;
		tail = toInsert;
		current = toInsert;
	}
	
	public void insert(int idx, T v) {
		if(head == null) {
			initialize(v);
			length++;
			return;
		}
		
		if(idx == length) {
			append(v);
			length++;
			return;
		}
		
		ISLink<T> previous = getLink(idx - 1);
		ISLink<T> next = getLink(idx);
		
		ISLink<T> toInsert = new SingleLink(v, next);
		if(idx != 0) {
			previous.setNext(toInsert);
		} else {
			head = toInsert;
		}
		
		current = toInsert;
		
		length++;
	}

	public void append(T v) {
		if(head == null) {
			initialize(v);
			length++;
			return;
		}
		
		ISLink<T> appended = new SingleLink(v);
		tail.setNext(appended);
		tail = tail.getNext();
		
		length++;
	}

	public void remove() {
		if(current == head) {
			head = head.getNext();
			current = head;
			length--;
			return;
		} else if(current == tail) {
			prev();
			current.setNext(null);
			tail = current;
			length--;
			return;
		}
		
		ISLink<T> tempNext = current.getNext();
		prev();
		current.setNext(tempNext);
		
		length--;
	}

	public void remove(int idx) {
		if(idx == 0) {
			head = head.getNext();
			length--;
			return;
		} else if(idx == length - 1) {
			tail = getLink(idx - 1);
			tail.setNext(null);
			length--;
			return;
		}
		
		ISLink<T> toRemove = getLink(idx);
		
		ISLink<T> tempPrev = getLink(idx - 1);
		tempPrev.setNext(toRemove.getNext());
		current = tempPrev;
		
		length--;
	}

	public void move(int sidx, int didx) {
		ISLink<T> toMove = getLink(sidx);
		remove(sidx);
		insert(didx, toMove.getValue());
	}

	public T fetch() {
		return current.getValue();
	}

	public T fetch(int idx) {
		return getLink(idx).getValue();
	}

	public void next() {
		current = current.getNext();
	}

	public void prev() {
		ISLink<T> currentIter = head;
		
		for(int i = 0; i < length - 1; i++) {
			if(currentIter.getNext() == current) {
				current = currentIter;
				return;
			} else {
				currentIter = currentIter.getNext();
			}
		}
	}

	public void jumpToTail() {
		current = tail;
	}

	public void jumpToHead() {
		current = head;
	}
	
	public ISLink<T> getLink(int idx) {
		ISLink<T> currentIter = head;
		
		for(int i = 0; i < idx; i++) {
			currentIter = currentIter.getNext();
		}
		
		return currentIter;
	}

	public int size() {
		return length;
	}
}
