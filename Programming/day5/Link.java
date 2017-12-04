
public class Link<T> {
	private T value;
	private Link<T> next;
	
	public Link(T v, Link<T> n) {
		value = v;
		next = n;
	}
	
	public void setValue(T v) {
		value = v;
	}
	
	public T getValue() {
		return value;
	}
	
	public void setNext(Link<T> n) {
		next = n;
	}
	
	public Link<T> getNext() {
		return next;
	}
}
