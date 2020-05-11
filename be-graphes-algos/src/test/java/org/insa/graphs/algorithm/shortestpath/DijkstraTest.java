package org.insa.graphs.algorithm.shortestpath;


public class DijkstraTest extends ShortestPathTest{
	
	@Override
	public ShortestPathSolution run(ShortestPathData data) {
		return new DijkstraAlgorithm(data).doRun();
	}
	

}
