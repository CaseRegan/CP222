
public class DoubleLinkList<T> implements IList<T> {
	private IDLink<T> head;
	private IDLink<T> tail;
	private IDLink<T> current;
	
	private int length;
	
	public DoubleLinkList() {
		length = 0;
	}
	
	public void initialize(T v) {
		IDLink<T> toInsert = new DoubleLink(v);
		
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
		
		IDLink<T> toInsert = new DoubleLink(v);
		IDLink<T> prevIter = getLink(idx - 1);
		IDLink<T> nextIter = getLink(idx);
		
		toInsert.setNext(nextIter);
		if(idx < length) {
			nextIter.setPrev(toInsert);
		}
		toInsert.setPrev(prevIter);
		if(idx >= 0) {
			prevIter.setNext(toInsert);
		}
		
		length++;
	}

	public void append(T v) {
		if(head == null) {
			initialize(v);
		} else {
			tail = new DoubleLink(v);
			getLink(length - 1).setNext(tail);
			tail.setPrev(getLink(length - 1));
		}
		
		length++;
	}

	public void remove() {
		if(current == head) {
			head = current.getNext();
			current = head;
		} else if(current == tail) {
			tail = current.getPrev();
			current = tail;
		} else {
			current.getPrev().setNext(current.getNext());
			current.getNext().setPrev(current.getPrev());
		}

		length--;
	}

	public void remove(int idx) {		
		if(idx == 0) {
			head = head.getNext();
			head.getNext().setPrev(head);
		} else if(idx == length - 1) {
			tail = tail.getPrev();
			tail.getPrev().setNext(tail);
		} else {
			getLink(idx).getNext().setPrev(getLink(idx).getPrev());
			getLink(idx).getPrev().setNext(getLink(idx).getNext());
		}
		
		length--;
	}

	public void move(int sidx, int didx) {
		IDLink<T> toMove = getLink(sidx);
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
		current = current.getPrev();
	}

	public void jumpToTail() {
		current = tail;
	}

	public void jumpToHead() {
		current = head;
	}
	
	public IDLink<T> getLink(int idx) {
		if(idx < 0 || idx >= length) {
			return null;
		}
		
		IDLink<T> currentIter = head;
		
		for(int i = 0; i < idx; i++) {
			currentIter = currentIter.getNext();
		}
		
		return currentIter;
	}

	public int size() {
		return length;
	}
}
