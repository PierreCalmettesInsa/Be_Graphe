package org.insa.graphs.model;

public class Label {
	
	protected Node sommet_courant;
	protected boolean marque ;
	protected float cout ;
	protected Node pere ;
	
	public Label(Node sommet_courant, boolean marque, float cout, Node pere) {
		super();
		this.sommet_courant = sommet_courant;
		this.marque = marque;
		this.cout = cout;
		this.pere = pere;
	}


	public float getCost() {
		return cout;
	}


}
