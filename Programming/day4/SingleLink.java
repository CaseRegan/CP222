
public class SingleLink<T> implements ISLink<T> {
	private T element;
	private ISLink<T> next;
	
	public SingleLink(T e, ISLink<T> n) {
		element = e;
		next = n;
	}
	
	public SingleLink(T t) {
		this(t, null);
	}
	
	public SingleLink() {
		this(null, null);
	}
	
	public T getValue() {
		return element;
	}

	public void setValue(T v) {
		element = v;
	}

	public ISLink getNext() {
		return next;
	}

	public void setNext(ISLink<T> c) {
		next = c;
	}

}
