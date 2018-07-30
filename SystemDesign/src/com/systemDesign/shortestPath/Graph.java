package com.systemDesign.shortestPath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


class Node{
	int data;
	int parent;
	
	public Node(int data){
		this.data =data;
	}
	
	public Node(int data ,int parent){
		this.data =data;
		this.parent =parent;
	}
}
public class Graph {

	int size;
	LinkedList<Node>[] vertices;
	
	Graph(int size){
		this.size = size;
		vertices = new LinkedList[size];
		for(int i=0;i<size;i++){
			vertices[i] = new LinkedList<Node>();
		}
	}
	
	public void addEdge(int start, int end){
		vertices[start].add(new Node(end,start));
		vertices[end].add(new Node(start, end));
	}
	
	public List<Integer> getvertices(int start){
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(Node n:vertices[start]){
			list.add(n.data);
		}
		return list;
	}
	
	// We just know start and end nodes no other information we knew
	public ArrayList<Integer> shortestPath(int start, int end){
		
		Queue<Integer> queue = new LinkedList<Integer>();
		Set<Integer> set = new HashSet<Integer>();
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		queue.add(start);
		set.add(start);
		map.put(start, null);
		
		ArrayList<Integer> path = new ArrayList<Integer>();
		
		while(!queue.isEmpty()){
			Integer source = queue.poll();
			
			if(source == end){
				while(source!=null){
					path.add(source);
					source = map.get(source);
				}
				return path;
			}
			List<Integer> list = getvertices(source);
			for(int target:list){
				if(!set.contains(target)){
					map.put(target,source);
					set.add(target);
					queue.add(target);
				}
			}
		}
		
		return null;
	}
	
}
