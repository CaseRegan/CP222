public class DepthFirstSearcher<N, W> implements ISearcher<N, W> {
    	public boolean pathExists(IGraph<N, W> g, INode<N> s, INode<N> e) {
		return scoreNode(g, s, e, 0) > 0;
	}
    
    	public IList<INode<N>> getPath(IGraph<N,W> g, INode<N> s, INode<N> e) {
		if(!pathExists(g, s, e)) { return null; }

		ArrayList<INode<N>> path = new ArrayList<INode<N>>();
		path.append(s);

		INode<N> current = s;
		
		while(!current.getValue().equals(e.getValue())) {
			double bestScore = 0.0;
			INode<N> bestNode = null;
			for(IEdge<N, W> edge : g.getEdgesFrom(current)) {
				INode<N> testing = edge.getDestination();
				double testScore = scoreNode(g, testing, e, 0);
				if(testScore > bestScore) {
					bestScore = testScore;
					bestNode = testing;
				}
			}
			current = bestNode;
			path.append(current);
		}

		return path;
	}

	public double scoreNode(IGraph<N, W> g, INode<N> s, INode<N> e, int depth) {
		if(depth > g.getNodeSet().length) { return 0; }
		if(s.getValue().equals(e.getValue())) { return 1 + 1.0 / depth; }
		
		double best = 0;
		for(IEdge<N, W> edge : g.getEdgesFrom(s)) {
			best = Math.max(best, scoreNode(g, edge.getDestination(), e, depth + 1));
		}

		return best;
	}
}
