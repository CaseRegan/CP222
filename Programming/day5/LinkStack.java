public class LinkStack<T> implements IStack<Double> {
	private Link<Double> bottom;
	private int maxSize;
	private int currentSize;
	
	public LinkStack(int s) {
		maxSize = s;
		currentSize = 0;
	}
	
	public void push(Double v) throws OverFlowException {
		if(currentSize >= maxSize) {
			throw new OverFlowException();
		} else if(currentSize == 0) {
			bottom = new Link(v, null);
			currentSize++;
			return;
		}
		
		Link<Double> current = bottom;
		
		for(int i = 0; i < currentSize - 1; i++) {
			current = current.getNext();
		}
		
		current.setNext(new Link(v, null));
		currentSize++;
	}

	public Double pop() throws UnderFlowException {
		if(currentSize <= 0) {
			throw new UnderFlowException();
		}
		
		Link<Double> current = bottom;
		
		for(int i = 0; i < currentSize - 1; i++) {
			current = current.getNext();
		}
		
		currentSize--;
		return current.getValue();
	}

}
