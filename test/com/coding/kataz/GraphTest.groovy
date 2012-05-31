package com.coding.kataz

import org.junit.Test

class GraphTest extends GroovyTestCase {
	
	Graph graph 
	
	@Override
	protected void setUp() throws Exception {
		graph = new Graph(new Vertex(10))
	}
	
	@Override
	protected void tearDown() throws Exception {
		graph = null
	}
	
	@Test
	void testDepthFirstSearch() throws Exception {
		Vertex vertex = new Vertex(20)
		Vertex vertex2 = new Vertex(30)
		graph.addVertex(vertex)
		graph.addVertex(vertex2)
		graph.addEdge(graph.root, vertex)
		graph.addEdge(vertex, vertex2)
		graph.depthFirstSearch(graph, graph.root)
	}
	
	@Test
	void testBreadthFirstSearch() throws Exception {
		graph.addVertex(new Vertex(20))
		graph.addEdge(graph.root, new Vertex(10))
		graph.addEdge(new Vertex(20), new Vertex(30))
		graph.breadthFirstSearch(graph, graph.root)
	}
}
