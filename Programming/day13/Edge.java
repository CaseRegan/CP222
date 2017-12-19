// 2edgy4me
public class Edge<N, W> implements IEdge<N, W> {
	private INode<N> source;
	private INode<N> destination;
	private W weight;
	
	public Edge(INode<N> s, INode<N> d, W w) {
		source = s;
		destination = d;
		weight = w;
	}	
    	
	public INode<N> getSource() {
		return source;
	}
    
	public INode<N> getDestination() {
		return destination;
	}
    
    	public W getWeight() {
		return weight;
	}
    	
	public boolean equals(IEdge<N, W> other) {
		return source == other.getSource() && destination == other.getDestination();
	}
}
