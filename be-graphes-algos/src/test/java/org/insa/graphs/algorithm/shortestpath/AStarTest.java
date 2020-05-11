package org.insa.graphs.algorithm.shortestpath;



public class AStarTest extends ShortestPathTest{
	
	@Override
	public ShortestPathSolution run(ShortestPathData data) {
		return new AStarAlgorithm(data).doRun();
	}
	

}
