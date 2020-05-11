package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.algorithm.AbstractSolution;
import org.insa.graphs.algorithm.ArcInspectorFactory;
import org.insa.graphs.model.io.BinaryGraphReader;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import org.insa.graphs.model.Graph;
import org.insa.graphs.model.Node;




public abstract class ShortestPathTest {
	


	private static ShortestPathData data1;
	private static ShortestPathData data2;
	private static ShortestPathData data3;
	private static ShortestPathData data4;
	private static ShortestPathData data5;
	private static ShortestPathData data6;
	private static ShortestPathData data7;
	private static ShortestPathData data8;
	private static ShortestPathData data9;
	private static ShortestPathData data10;
	private static ShortestPathData data11;
	private static ShortestPathData data12;
	
	public abstract ShortestPathSolution run(ShortestPathData data) ;
	
	
	@BeforeClass
	public static void test() throws IOException {
		
		String cheminMap1 = "D:/Pierre-rog/Desktop/BE_Graphe/Be_Graphe/maps/carre.mapgr";
		String cheminMap2 = "D:/Pierre-rog/Desktop/BE_Graphe/Be_Graphe/maps/haute-garonne.mapgr";
				
		BinaryGraphReader reader = new BinaryGraphReader(new DataInputStream(new FileInputStream(cheminMap1)));	
		Graph graph1 = reader.read();
		
		
		BinaryGraphReader reader2 = new BinaryGraphReader(new DataInputStream(new FileInputStream(cheminMap2)));	
		Graph graph2 = reader2.read();
			
		
		
		//chemin carré
		Node origine1 = graph1.get(9);
		Node destination1 = graph1.get(16);
		
		//chemine longueur nulle carré
		Node origine2 = graph1.get(1);
		Node destination2 = graph1.get(1);
		
		//chemin impossible carré
		Node origine3 = graph1.get(24);
		Node destination3 = graph1.get(24);
		
		//chemin haute-garonne
		Node origine4 = graph2.get(88339);
		Node destination4 = graph2.get(128194);
		
		//chemin null haute-garonne
		Node origine5 = graph2.get(1);
		Node destination5 = graph2.get(1);
		
		//chemin impossible haute-garonne
		Node origine6 = graph2.get(1);
		Node destination6 = graph2.get(1);
		
		
		
		 //Chemins impossibles
        data1= new ShortestPathData(graph1, origine3, destination3, ArcInspectorFactory.getAllFilters().get(0)); //shortest
        data2= new ShortestPathData(graph1, origine3, destination3, ArcInspectorFactory.getAllFilters().get(2)); //fastest
        
        data3= new ShortestPathData(graph2, origine6, destination6, ArcInspectorFactory.getAllFilters().get(0)); //shortest
        data4= new ShortestPathData(graph2, origine6, destination6, ArcInspectorFactory.getAllFilters().get(2)); //fastest
        
        //Chemins de longueur nulle
        data5= new ShortestPathData(graph1, origine2, destination2, ArcInspectorFactory.getAllFilters().get(0)); //shortest
        data6= new ShortestPathData(graph1, origine2, destination2, ArcInspectorFactory.getAllFilters().get(2)); //fastest
        
        data7= new ShortestPathData(graph2, origine5, destination5, ArcInspectorFactory.getAllFilters().get(0)); //shortest
        data8= new ShortestPathData(graph2, origine5, destination5, ArcInspectorFactory.getAllFilters().get(2));//fastest
		
        
      //Chemin existant
        data9= new ShortestPathData(graph1, origine1, destination1, ArcInspectorFactory.getAllFilters().get(0)); //shortest
        data10= new ShortestPathData(graph1, origine1, destination1, ArcInspectorFactory.getAllFilters().get(2)); //fastest
        
        data11= new ShortestPathData(graph2, origine4, destination4, ArcInspectorFactory.getAllFilters().get(0)); //shortest
        data12= new ShortestPathData(graph2, origine4, destination4, ArcInspectorFactory.getAllFilters().get(2)); //fastest
        
	}
	
	
	//chemin inexistant, carré, shortest
	@Test
    public void testIsValid() {		
		assertTrue((run(data1)).getStatus().equals(AbstractSolution.Status.INFEASIBLE));
    }
	
	//chemin inexistant, non routière, fastest
	@Test
    public void testIsValid2() {		
		assertTrue((run(data2)).getStatus().equals(AbstractSolution.Status.INFEASIBLE));
    }
	
	//chemin inexistant, haute-garonne, shortest
	@Test
    public void testIsValid3() {		
		assertTrue((run(data3)).getStatus().equals(AbstractSolution.Status.INFEASIBLE));
    }
	
	//chemin inexistant, haute-garonne, fastest
	@Test
    public void testIsValid4() {		
		assertTrue((run(data4)).getStatus().equals(AbstractSolution.Status.INFEASIBLE));
    }
	
	//chemin null, carré, shortest
	@Test
    public void testIsValid5() {		
		assertTrue((run(data5)).getStatus().equals(AbstractSolution.Status.INFEASIBLE));
    }
	
	//chemin null, carré, fastest
	@Test
    public void testIsValid6() {		
		assertTrue((run(data6)).getStatus().equals(AbstractSolution.Status.INFEASIBLE));
    }

	//chemin null, haute-garonne, shortest
	@Test
    public void testIsValid7() {		
		assertTrue((run(data7)).getStatus().equals(AbstractSolution.Status.INFEASIBLE));
    }
	
	//chemin null, haute-garonne, fastest
	@Test
    public void testIsValid8() {		
		assertTrue((run(data8)).getStatus().equals(AbstractSolution.Status.INFEASIBLE));
    }
	
	
	//chemin existant, carré, shorstest
	@Test
    public void testIsValid9() {
		double resultBellman = (new BellmanFordAlgorithm(data9).run().getPath().getLength());
		assertEquals((long)((run(data9)).getPath().getLength()),(long)(resultBellman));
    }
	
	//chemin existant, carré, fastest
	@Test
    public void testIsValid10() {
		double resultBellman = (new BellmanFordAlgorithm(data10).run().getPath().getMinimumTravelTime());
		assertEquals((long)((run(data10)).getPath().getMinimumTravelTime()),(long)(resultBellman));
    }
	
	
	
	//chemin existant, haute-garonne, shortest
	@Test
    public void testIsValid11() {
		double resultBellman = (new BellmanFordAlgorithm(data11).run().getPath().getLength());
		assertEquals((long)((run(data11)).getPath().getLength()),(long)(resultBellman));
    }
	
	//chemin existant, haute-garonne, fastest
	@Test
    public void testIsValid12() {
		double resultBellman = (new BellmanFordAlgorithm(data12).run().getPath().getMinimumTravelTime());
		assertEquals((long)((run(data12)).getPath().getMinimumTravelTime()),(long)(resultBellman));
    }
	
}
