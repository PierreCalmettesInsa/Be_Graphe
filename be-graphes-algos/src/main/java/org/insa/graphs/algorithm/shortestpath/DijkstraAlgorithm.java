package org.insa.graphs.algorithm.shortestpath;


import java.util.ArrayList;
import java.util.Collections;
import org.insa.graphs.algorithm.AbstractSolution.Status;
import org.insa.graphs.algorithm.utils.BinaryHeap;
import org.insa.graphs.algorithm.utils.ElementNotFoundException;
import org.insa.graphs.model.Arc;
import org.insa.graphs.model.Graph;
import org.insa.graphs.model.Node;
import org.insa.graphs.model.Label;
import org.insa.graphs.model.Path;

public class DijkstraAlgorithm extends ShortestPathAlgorithm {

    public DijkstraAlgorithm(ShortestPathData data) {
        super(data);
    }
    
    
    
    protected Label initialisationLabel(Node node,boolean bool,double cout,Arc arc) {
    	return new Label(node,bool,cout,arc);    	
    }

    @Override
    protected ShortestPathSolution doRun() {
    	
        final ShortestPathData data = getInputData();
        ShortestPathSolution solution = null;
        
        Graph graph = data.getGraph();

        final int nbNodes = graph.size();
        
        BinaryHeap<Label> tas = new BinaryHeap<Label>() ;
        Label[] labels = new Label[nbNodes];



        for (Node node: graph.getNodes()) {
        	if (node.equals(data.getOrigin())){
            	Label label = initialisationLabel(node,false,0.0,null);
            	labels[node.getId()]=label;
                tas.insert(labels[node.getId()]);
        	} else {
        		Label label = initialisationLabel(node,false,Double.MAX_VALUE,null);
        		labels[node.getId()]=label;
        	}
        }
        
        
        
        while (!tas.isEmpty() && !labels[data.getDestination().getId()].marque) {
        	Label labelActuel = tas.deleteMin() ;
        	Node nodeActuel = labelActuel.sommet_courant;
        	labelActuel.marque = true ;
        	
        	
            for (Arc arcSuc: graph.get(nodeActuel.getId()).getSuccessors()) {
            	
            	notifyNodeReached(arcSuc.getDestination());
        		
                // Small test to check allowed roads...
                if (!data.isAllowed(arcSuc)) {
                    continue;
                }
                
        		Label labSuc = labels[arcSuc.getDestination().getId()];

            	if (!labSuc.marque) {
            		if (labSuc.getCost() > (labelActuel.getCost() + data.getCost(arcSuc))) {
            			try {
            				tas.remove(labSuc);
            			} catch (ElementNotFoundException e) {
            			}
            			labSuc.setCout(labelActuel.getCost() + data.getCost(arcSuc));
                		labSuc.pere = arcSuc ;
            			tas.insert(labSuc);
            		}
            	}
        	}
        }
        
        Node node = data.getDestination() ;
        if (labels[node.getId()].pere == null) {
            solution = new ShortestPathSolution(data, Status.INFEASIBLE);
        } else {
            // The destination has been found, notify the observers.
            notifyDestinationReached(data.getDestination());
            

            // Create the path from the array of predecessors...
            ArrayList<Arc> arcs = new ArrayList<>();
			while (!node.equals(data.getOrigin())) {
				arcs.add(labels[node.getId()].pere);
				node = labels[node.getId()].pere.getOrigin();
			}
            
            Collections.reverse(arcs);
            
            // Create the final solution.
            solution = new ShortestPathSolution(data, Status.OPTIMAL, new Path(graph, arcs));    
            
        }
        
        return solution;
    }

}




