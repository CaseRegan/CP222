public class Graph<N, W> implements IGraph<N, W> {
    	private INode<N>[] nodes;
	private IEdge<N, W>[] edges;
	
	public Graph() {
		nodes = (INode<N>[]) new INode[0];
		edges = (IEdge<N, W>[]) new IEdge[0];
	}

    	public INode<N>[] getNodeSet() {
		return nodes;
	}
    
    	public INode<N>[] getNeighbors(INode<N> n) {
		IList<INode<N>> neighbors = new ArrayList<INode<N>>();

		for(IEdge<N, W> edge : edges) {
			if(edge.getSource() == n) {
				neighbors.append(edge.getDestination());	
			} else if(edge.getDestination() == n) {
				neighbors.append(edge.getSource());
			}
		}

		INode<N>[] neighborsList = (INode<N>[]) new INode[neighbors.size()];
		for(int i = 0; i < neighborsList.length; i++) {
			neighborsList[i] = neighbors.fetch(i);
		}
		return neighborsList;
	}
    
    	public INode<N> addNode(N v) {
		INode<N> toAdd = new Node(v);
		INode<N>[] updated = (INode<N>[]) new INode[nodes.length + 1];
		for(int i = 0; i < nodes.length; i++) {
			updated[i] = nodes[i];
		}
		updated[nodes.length] = toAdd;
		nodes = updated;

		return toAdd;
	}
    
    	public IEdge<N, W>[] getEdgeSet() {
		return edges;
	}
    
    	public IEdge<N, W>[] getEdgesFrom(INode<N> n) {
		ArrayList<IEdge<N, W>> edgesFrom = new ArrayList<IEdge<N, W>>();

		for(IEdge<N, W> edge : edges) {
			if(edge.getSource() == n) {
				edgesFrom.append(edge);
			}
		}

		IEdge<N, W>[] edgesFromList = (IEdge<N, W>[]) new IEdge[edgesFrom.size()];
	       	for(int i = 0; i < edgesFromList.length; i++) {
			edgesFromList[i] = edgesFrom.fetch(i);
		}
		return edgesFromList;	
	}

    	public IEdge<N,W>[] getEdgesTo(INode<N> n) {
		ArrayList<IEdge<N, W>> edgesTo = new ArrayList<IEdge<N, W>>();

		for(IEdge<N, W> edge : edges) {
			if(edge.getDestination() == n) {
				edgesTo.append(edge);
			}
		}

		IEdge<N, W>[] edgesToList = (IEdge<N, W>[]) new IEdge[edgesTo.size()];
	       	for(int i = 0; i < edgesToList.length; i++) {
			edgesToList[i] = edgesTo.fetch(i);
		}
		return edgesToList;	
	}

    	public void addEdge(INode<N> s, INode<N> d, W w) {
		IEdge<N, W> toAdd = new Edge(s, d, w);
		IEdge<N, W>[] updated = (IEdge<N, W>[]) new IEdge[edges.length + 1];
		for(int i = 0; i < edges.length; i++) {
			updated[i] = edges[i];
		}
		updated[edges.length] = toAdd;
		edges = updated;
	}	
}
