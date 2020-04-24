package org.insa.graphs.model;

public class LabelStar extends Label {
	

	protected double coutEstime ;
	
	
	public LabelStar(Node sommet_courant, boolean marque, double cout, Arc pere, double coutEstime) {
		super(sommet_courant,marque,cout,pere);
		this.coutEstime = coutEstime ;
	}
	
	public void setCoutEstime(double cout) {
		this.coutEstime = cout;
	}


	public double getCostEstime() {
		return coutEstime;
	}

	
	
	@Override
	public double getTotalCost(){
		return cout+coutEstime ;
	}
	
	

}
