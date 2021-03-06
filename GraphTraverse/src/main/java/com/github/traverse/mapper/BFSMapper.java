package com.github.traverse.mapper;

import java.util.List;
import java.util.Queue;

import com.github.traverse.model.Node;

public class BFSMapper {

	public static List<Integer> traverseBFS(Node[][] graph,Queue<Integer> queue,List<Integer> traversed) {
		int start=queue.peek();
		
		for(int i=0;i<graph[start-1].length;i++) {
			if(queue.contains(i+1) || traversed.contains(i+1)) {
				continue;
			}
			Node row=graph[start-1][i];
			if(row!=null && row.getData()==1 && !row.isVisited()) {
				 {
					queue.add(i+1);
					
					row.setVisited(true);
					graph[i][start-1].setVisited(true);
				}
			}
		}
		int ele=queue.remove();
		traversed.add(ele);
		if(!queue.isEmpty())
		traverseBFS(graph, queue,traversed);
		
		return traversed;
	}


}
