package org.insa.graphs.model;

public class Label implements Comparable<Label> {
	
	public Node sommet_courant;
	public boolean marque ;
	public double cout ;
	public Arc pere ;
	
	public Label(Node sommet_courant, boolean marque, double cout, Arc pere) {
		super();
		this.sommet_courant = sommet_courant;
		this.marque = marque;
		this.cout = cout;
		this.pere = pere;
	}


	public double getCost() {
		return cout;
	}
	
    @Override
    public int compareTo(Label other) {
        return Double.compare(this.getCost(), other.getCost());
    }
	
	


}
