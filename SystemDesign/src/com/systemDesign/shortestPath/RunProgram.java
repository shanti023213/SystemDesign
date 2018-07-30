package com.systemDesign.shortestPath;

import java.util.ArrayList;

public class RunProgram {

	public static void main(String[] args) {
		
		Graph graph = new Graph(27);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(1, 5);
		graph.addEdge(1, 6);
		graph.addEdge(1, 7);
		
		graph.addEdge(2, 3);
		
		graph.addEdge(2, 8);
		graph.addEdge(3, 8);
		
		graph.addEdge(3, 9);
		
		graph.addEdge(4, 10);
		graph.addEdge(4, 11);
		
		graph.addEdge(8, 12);
		graph.addEdge(8, 13);
		graph.addEdge(8, 14);
		
		graph.addEdge(12, 15);
		graph.addEdge(12, 16);
		graph.addEdge(12, 17);
		graph.addEdge(12, 18);
		graph.addEdge(12, 19);
		
		graph.addEdge(15, 20);
		graph.addEdge(15, 21);
		graph.addEdge(15, 22);

		
		graph.addEdge(16, 23);
		
		graph.addEdge(21, 24);
		graph.addEdge(21, 25);
		graph.addEdge(21, 26);
		
		ArrayList<Integer> list = graph.shortestPath(1,26);
		System.out.println(list);
	}

}
