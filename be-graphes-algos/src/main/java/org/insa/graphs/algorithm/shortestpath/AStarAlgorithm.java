package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.model.Arc;
import org.insa.graphs.model.Label;
import org.insa.graphs.model.Node;
import org.insa.graphs.model.LabelStar;
import org.insa.graphs.model.Point;

public class AStarAlgorithm extends DijkstraAlgorithm {

    public AStarAlgorithm(ShortestPathData data) {
        super(data);
    }
    
    @Override
    protected Label initialisationLabel(Node node,boolean bool,double cout,Arc arc) {
    	double coutEstime = Point.distance(node.getPoint(),getInputData().getDestination().getPoint());
    	return new LabelStar(node,bool,cout,arc,coutEstime);    	
    }
    
    

}
