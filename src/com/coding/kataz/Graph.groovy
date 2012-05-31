package com.coding.kataz

class Graph {
	
	List<Vertex> vertices = new ArrayList<Vertex>()
	List<Edge> edges = new ArrayList<Edge>()
	Vertex root 
	
	private Graph(Vertex root) {
		this.root = root
	}
	
	void addVertex(Vertex v) {
		vertices.add(v)
	}
	
	void removeVertex(Vertex v) {
		vertices.remove(v)
	}
	
	void addEdge(Vertex from, Vertex to) {
		Edge edge = new Edge(from,to)
		from.addEdge(edge)
		to.addEdge(edge)
		edges.add(edge)
	}
	
	void removeEdge(Vertex from, Vertex to) {
		Edge edge = new Edge(from,to)
		from.removeEdge(edge)
		to.removeEdge(edge)
		edges.remove(edge)
	}
	
	void depthFirstSearch(Graph g, Vertex start) {
		Vertex root = start
		println root.data
		root.visited = true
		for (Vertex v : root.getAdjacentVertexes()) {
			if(!v.visited) {
				depthFirstSearch(g, v)
			}
		}
	}
	
	void breadthFirstSearch(Graph g, Vertex start) {
		LinkedList queue = new LinkedList()
		Vertex root = start
		println root.data
		root.visited = true
		queue.add(root)
		Vertex n 
		while(!queue.isEmpty()) {
			n = queue.removeFirst()
			if( n != null) {
				for (Vertex v : root.getAdjacentVertexes()) {
					if(!v.visited) {
						queue.add(v)
					}
				}
			}
		}
	}
}

class Edge {
	
	Vertex to
	Vertex from
	
	Edge(Vertex to, Vertex from) {
		this.to = to
		this.from = from
	}
	
	Vertex getTo() {
		return to
	}
	
	Vertex getFrom() {
		return from
	}
}


class Vertex {
	List incomingEdges = new ArrayList()
	List outgoingEdges = new ArrayList()
	int data
	boolean visited
	
	Vertex(int data) {
		this.data = data
	}
	
	List<Vertex> getAdjacentVertexes() {
		List<Vertex> adjacentVertexes = new ArrayList<Vertex>() 
		for (Edge e : incomingEdges) {
			if(e.getFrom().data == this.data) {
				adjacentVertexes.add(e.getFrom())
			}
		}
		
		for (Edge e : outgoingEdges) {
			if(e.getTo().data == this.data) {
				adjacentVertexes.add(e.getTo())
			}
		}
		adjacentVertexes
	}
	
	void addEdge(Edge e) {
		if(e.getFrom().data == this.data) {
			outgoingEdges.add(e)
		 } 
		 if(e.getTo().data == this.data) {
	 		incomingEdges.add(e)
		 }
	}
	
	void removeEdge(Edge e) {
		if(e.getFrom().data == this.data) {
			outgoingEdges.remove(e)
		 } else if(e.getTo().data == this.data) {
			 incomingEdges.remove(e)
		 }
	}
}