package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.model.Arc;
import org.insa.graphs.model.Label;
import org.insa.graphs.model.Node;
import org.insa.graphs.model.LabelStar;
import org.insa.graphs.model.Point;
import org.insa.graphs.algorithm.AbstractInputData;

public class AStarAlgorithm extends DijkstraAlgorithm {

    public AStarAlgorithm(ShortestPathData data) {
        super(data);
    }
    
    @Override
    protected Label initialisationLabel(Node node,boolean bool,double cout,Arc arc) {
    	double coutEstime ;
    	if (getInputData().getMode() == AbstractInputData.Mode.LENGTH) {
    		coutEstime = Point.distance(node.getPoint(),getInputData().getDestination().getPoint());
    	}else {
    		coutEstime = Point.distance(node.getPoint(),getInputData().getDestination().getPoint())/(double)getInputData().getMaximumSpeed();
    	}
    	return new LabelStar(node,bool,cout,arc,coutEstime);    	
    }
    
    

}
