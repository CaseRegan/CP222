import java.io.*;

/**
 * Class that is capable of reading in a graph file from disk.
 * Graph files are line based. Node names have type String and edge weights have 
 * type Double. Fields on the line are separated by ':' and there is no extra white space.
 */
public class DiGraphReader implements IGraphReader {
    // Fields needed for the Graph Reader should be added here
    
    /**
     * Creates a new graph reader instance
     */
    	public DiGraphReader() {
         // Configure the graph reader here
    	}
    
    /**
     * Reads in a file and instantiates the graph
     * @param filename the file to read
     * @return the instantiated graph
     */
   	public IGraph<String,Double> read(String filename) throws FileNotFoundException, IOException {
        	File file = new File(filename);
		BufferedReader reader = new BufferedReader(new FileReader(file));

		IGraph<String, Double> graph = new Graph<String, Double>();

		String line = null;
		while((line = reader.readLine()) !=  null) {
			String source = line.substring(0, line.indexOf(":"));
			String destination = line.substring(source.length() + 1, line.indexOf(":", source.length() + 1));
			Double weight = Double.parseDouble(line.substring(source.length() + destination.length() + 2));
			
			INode<String> sourceNode = new Node(source);
			INode<String> destinationNode = new Node(destination);

			INode<String>[] nodes = graph.getNodeSet();
			for(INode<String> node : nodes) {
				if(node.getValue().equals(source)) { sourceNode = node; }
				else { graph.addNode(sourceNode.getValue()); }
				if(node.getValue().equals(destination)) { destinationNode = node; }
				else { graph.addEdge(sourceNode, destinationNode, weight); }
			}

			graph.addEdge(sourceNode, destinationNode, weight);
		}	
		
		reader.close();
        	return graph;
    	}
    
    /**
     * Simple main method to open and process a file
     */
    	public static void main(String[] argv) throws Exception {
        	// This code should work without modification once your reader code is working
        	IGraphReader r = new DiGraphReader();
       		IGraph<String,Double> g = r.read("graphfile.cs2");
        	IEdge<String,Double>[] edges = g.getEdgeSet();
        	for(int i=0; i<edges.length; i++) {
            		System.out.println(edges[i].getSource().getValue()+" -> "+edges[i].getDestination().getValue()+"  w: "+edges[i].getWeight());
        	}
    	}
}
