
public class DoubleLink<T> implements IDLink<T> {
	private T element;
	private IDLink<T> next;
	private IDLink<T> prev;
	
	public DoubleLink(T e, IDLink<T> n, IDLink<T> p) {
		element = e;
		next = n;
		prev = p;
	}
	
	public DoubleLink(T e, IDLink<T> n) {
		this(e, n, null);
	}
	
	public DoubleLink(T e) {
		this(e, null, null);
	}
	
	public DoubleLink() {
		this(null, null, null);
	}
	
	public T getValue() {
		return element;
	}

	public void setValue(T v) {
		element = v;
	}

	public IDLink<T> getNext() {
		return next;
	}

	public IDLink<T> getPrev() {
		return prev;
	}

	public void setNext(IDLink<T> c) {
		next = c;
	}

	public void setPrev(IDLink<T> c) {
		prev = c;
	}
}
