package com.github.traverse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.github.traverse.mapper.BFSMapper;
import com.github.traverse.mapper.DFSMapper;
import com.github.traverse.model.Node;

public class GraphTraverseApplication{

	public static void main(String[] args) {
		long startTime=System.nanoTime();
		try{
			int vertices=Integer.parseInt(args[0]);
			int start=Integer.parseInt(args[1]);
			Node[][] bfsMatrix=new Node[vertices][vertices];
			Node[][] dfsMatrix=new Node[vertices][vertices];
			for (int i = 2; i < args.length-1; ) {
				int data=Integer.parseInt(args[i]);
				int neighbour=Integer.parseInt(args[i+1]);

				bfsMatrix[data-1][neighbour-1]=new Node();
				dfsMatrix[data-1][neighbour-1]=new Node();
				bfsMatrix[neighbour-1][data-1]=new Node();
				dfsMatrix[neighbour-1][data-1]=new Node();
				i+=2;

			}


			Queue<Integer> bfsQueue=new LinkedList<>();
			bfsQueue.add(start);
			long bfsStartTime=System.nanoTime();
			System.out.println(BFSMapper.traverseBFS(bfsMatrix,bfsQueue,new ArrayList<Integer>()));
			long bfsEndTime=System.nanoTime();
			System.out.println("Time taken for BFS: "+(bfsEndTime-bfsStartTime)/Math.pow(10, 6)+" ms");
			long dfsStartTime=System.nanoTime();
			Queue<Integer> dfsQueue=new LinkedList<>();
			
			dfsQueue.add(start);
			System.out.println(DFSMapper.traverseDFS(dfsMatrix,dfsQueue,new ArrayList<Integer>()));
			long dfsEndTime=System.nanoTime();
			System.out.println("Time taken for DFS: "+(dfsEndTime-dfsStartTime)/Math.pow(10, 6)+" ms");
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Check the node value! Seems it has weight more than the array size!!!");
			System.out.println("Kindly check the node value (1<=N<=int val)");
		}
		long endTime=System.nanoTime();
		System.out.println("Execution Time : "+(endTime-startTime)/Math.pow(10, 6)+" ms");
	}
}