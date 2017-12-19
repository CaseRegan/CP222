public class Queue<T> implements IQueue<T> {
    	T[] queue;
	int size = 0;

	public Queue(int s) {
		queue = (T[]) new Object[s];
	}
	
    	public T dequeue() {
		if(queue.length == 0) {
			throw new UnderFlowException();
		}

		return queue[size--];
	}
    
    	public void enqueue(T v) {
		if(queue.length >= size - 1) {
			throw new OverFlowException();
		}

		T[] temp = (T[]) new Object[queue.length];
		temp[0] = v;

		for(int i = 0; i < queue.length; i++) {
			temp[i + 1] = queue[i];
		}

		queue = temp;
		size++;
	}

	public int size() {
		return size;
	}
}
