package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.algorithm.AbstractSolution;
import org.insa.graphs.algorithm.ArcInspectorFactory;
import org.insa.graphs.model.io.BinaryGraphReader;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import org.insa.graphs.model.Graph;
import org.insa.graphs.model.Node;




public abstract class ShortestPathTest {
	

/*test avec oracle
 * Sans oracle il aurait fallu :
 * comparer les propriétés du graphe
 * comparer les distances des chemins les plus court en distance et en temps, dist du plus court en dist < dist du plus court en temps
 * comparer les temps des chemins les plus court en distance et en temps, temps du plus court en dist > temps du plus court en temps
*/
/* Dijkstra a de meilleures performances que A* lorsque il n'y a pas de routes possibles entre les deux nodes, A* met plus de temps à
 * le voir.
 */

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
	
	public abstract ShortestPathSolution run(ShortestPathData data) ;
	
	
	@BeforeClass
	public static void test() throws IOException {
		
		String cheminMap1 = "D:/Pierre-rog/Desktop/BE_Graphe/Be_Graphe/maps/carre.mapgr";
		String cheminMap2 = "D:/Pierre-rog/Desktop/BE_Graphe/Be_Graphe/maps/morbihan.mapgr";
				
		BinaryGraphReader reader = new BinaryGraphReader(new DataInputStream(new FileInputStream(cheminMap1)));	
		Graph graph1 = reader.read();
		
		//utiliser BufferedInputStream si le fichier est volumineux (à mettre avant new FileInputStream)
		BinaryGraphReader reader2 = new BinaryGraphReader(new DataInputStream(new FileInputStream(cheminMap2)));	
		Graph graph2 = reader2.read();
			
		
		
		//chemin carré
		Node origine1 = graph1.get(9);
		Node destination1 = graph1.get(16);
		
		//chemin longueur nulle carré
		Node origine2 = graph1.get(1);
		Node destination2 = graph1.get(1);
		
		
		//chemin morbihan
		Node origine4 = graph2.get(122666);
		Node destination4 = graph2.get(134738);
		
		//chemin null morbihan
		Node origine5 = graph2.get(1);
		Node destination5 = graph2.get(1);
		
		//chemin impossible morbihan
		Node origine6 = graph2.get(138551);
		Node destination6 = graph2.get(134738);
		
		
		
		//chemin impossible
        
        data1= new ShortestPathData(graph2, origine6, destination6, ArcInspectorFactory.getAllFilters().get(0)); //shortest
        data2= new ShortestPathData(graph2, origine6, destination6, ArcInspectorFactory.getAllFilters().get(2)); //fastest
        
        //Chemins de longueur nulle
        data3= new ShortestPathData(graph1, origine2, destination2, ArcInspectorFactory.getAllFilters().get(0)); //shortest
        data4= new ShortestPathData(graph1, origine2, destination2, ArcInspectorFactory.getAllFilters().get(2)); //fastest
        
        data5= new ShortestPathData(graph2, origine5, destination5, ArcInspectorFactory.getAllFilters().get(0)); //shortest
        data6= new ShortestPathData(graph2, origine5, destination5, ArcInspectorFactory.getAllFilters().get(2));//fastest
		
        
      //Chemin existant
        data7= new ShortestPathData(graph1, origine1, destination1, ArcInspectorFactory.getAllFilters().get(0)); //shortest
        data8= new ShortestPathData(graph1, origine1, destination1, ArcInspectorFactory.getAllFilters().get(2)); //fastest
        
        data9= new ShortestPathData(graph2, origine4, destination4, ArcInspectorFactory.getAllFilters().get(0)); //shortest
        data10= new ShortestPathData(graph2, origine4, destination4, ArcInspectorFactory.getAllFilters().get(2)); //fastest
        
	}
	
	

	

	
	//chemin inexistant, morbihan, shortest
	@Test
    public void testIsValid() {		
		assertTrue((run(data1)).getStatus().equals(AbstractSolution.Status.INFEASIBLE));
    }
	
	//chemin inexistant, morbihan, fastest
	@Test
    public void testIsValid2() {		
		assertTrue((run(data2)).getStatus().equals(AbstractSolution.Status.INFEASIBLE));
    }
	
	//chemin null, carré, shortest
	@Test
    public void testIsValid3() {		
		assertTrue((run(data3)).getStatus().equals(AbstractSolution.Status.INFEASIBLE));
    }
	
	//chemin null, carré, fastest
	@Test
    public void testIsValid4() {		
		assertTrue((run(data4)).getStatus().equals(AbstractSolution.Status.INFEASIBLE));
    }

	//chemin null, morbihan, shortest
	@Test
    public void testIsValid5() {		
		assertTrue((run(data5)).getStatus().equals(AbstractSolution.Status.INFEASIBLE));
    }
	
	//chemin null, morbihan, fastest
	@Test
    public void testIsValid6() {		
		assertTrue((run(data6)).getStatus().equals(AbstractSolution.Status.INFEASIBLE));
    }
	
	
	//chemin existant, carré, shorstest
	@Test
    public void testIsValid7() {
		double resultBellman = (new BellmanFordAlgorithm(data7).run().getPath().getLength());
		assertEquals((long)((run(data7)).getPath().getLength()),(long)(resultBellman));
    }
	
	//chemin existant, carré, fastest
	@Test
    public void testIsValid8() {
		double resultBellman = (new BellmanFordAlgorithm(data8).run().getPath().getMinimumTravelTime());
		assertEquals((long)((run(data8)).getPath().getMinimumTravelTime()),(long)(resultBellman));
    }
	
	
	
	//chemin existant, morbihan, shortest
	@Test
    public void testIsValid9() {
		double resultBellman = (new BellmanFordAlgorithm(data9).run().getPath().getLength());
		assertEquals((long)((run(data9)).getPath().getLength()),(long)(resultBellman));
    }
	
	//chemin existant, morbihan, fastest
	@Test
    public void testIsValid10() {
		double resultBellman = (new BellmanFordAlgorithm(data10).run().getPath().getMinimumTravelTime());
		assertEquals((long)((run(data10)).getPath().getMinimumTravelTime()),(long)(resultBellman));
    }
	
	
}
