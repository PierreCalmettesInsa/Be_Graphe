package org.insa.algo.weakconnectivity;

import java.util.ArrayList;

import org.insa.algo.AbstractSolution;
import org.insa.graph.Node;

public class WeaklyConnectedComponentsSolution extends AbstractSolution {

    // Components
    private ArrayList<ArrayList<Node>> components;

    protected WeaklyConnectedComponentsSolution(WeaklyConnectedComponentsData data) {
        super(data);
    }

    protected WeaklyConnectedComponentsSolution(WeaklyConnectedComponentsData data, Status status,
            ArrayList<ArrayList<Node>> components) {
        super(data, status);
        this.components = components;
    }

    @Override
    public WeaklyConnectedComponentsData getInputData() {
        return (WeaklyConnectedComponentsData) super.getInputData();
    }

    /**
     * @return Components of the solution, if any.
     */
    public ArrayList<ArrayList<Node>> getComponents() {
        return components;
    }

}
