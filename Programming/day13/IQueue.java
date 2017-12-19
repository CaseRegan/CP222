/**
 * Interface for a generic fixed length queue
 */
public interface IQueue<T> {
    /**
     * Dequeues the Front element from the queue
     * @return dequeued element
     */
    public T dequeue()
    
    /**
     * Enqueues an element at the back of the queue
     * @param v enqueued element
     */
    public void enqueue(T v)

    /**
     * Returns the number of elements in the queue
     */
    public int size();
}
