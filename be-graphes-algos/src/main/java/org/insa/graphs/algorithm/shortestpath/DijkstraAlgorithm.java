package org.insa.graphs.algorithm.shortestpath;

import java.util.Arrays;

import org.insa.graphs.model.Graph;
import org.insa.graphs.model.Node;
import org.insa.graphs.model.Label;

public class DijkstraAlgorithm extends ShortestPathAlgorithm {

    public DijkstraAlgorithm(ShortestPathData data) {
        super(data);
    }

    @Override
    protected ShortestPathSolution doRun() {
        final ShortestPathData data = getInputData();
        ShortestPathSolution solution = null;
        
        Graph graph = data.getGraph();

        final int nbNodes = graph.size();

        // Initialize array of distances.
        double[] distances = new double[nbNodes];
        Arrays.fill(distances, Double.POSITIVE_INFINITY);
        distances[data.getOrigin().getId()] = 0;
        
        ArrayList

        // Notify observers about the first event (origin processed).
        notifyOriginProcessed(data.getOrigin());
        int i = 0; 
        for (Node node: graph.getNodes()) {
        	Label label = new Label(node,false,Float.MAX_VALUE,null);
        	labels[i]=label;
        	
        	
        }
        
        
        
        
        // TODO:
        return solution;
    }

}
