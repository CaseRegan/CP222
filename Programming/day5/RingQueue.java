
public class RingQueue<T> implements IQueue<RPNToken> {
	private int size;
	private RPNToken[] queue;
	private int lastIndex;
	
	public RingQueue(int s) {
		size = s;
		queue = new RPNToken[size];
		lastIndex = 0;
	}
	
	public RPNToken dequeue() throws UnderFlowException {
		RPNToken toDequeue = queue[0];
		for(int i = 0; i < lastIndex; i++) {
			queue[i] = queue[i + 1];
		}
		lastIndex--;
		return toDequeue;
	}

	public void enqueue(RPNToken v) throws OverFlowException {
		if(lastIndex >= size) {
			throw new OverFlowException();
		}
		
		queue[lastIndex] = v;
		lastIndex++;
	}

}
