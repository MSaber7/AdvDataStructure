package com.GraphAlgorithm;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

//import java.util.*;

// A Java program to print topological sorting of a DAG
// This class represents a directed graph using adjacency list representation

public class TopologicalSortGraph {
	
	private int V;   							// No. of vertices
	private LinkedList<Integer> adj[]; 			// Adjacency List
	private static Scanner sc;
	private static Scanner in;
	 
	 //Constructor
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	 TopologicalSortGraph(int v) {
	     V = v;
	     adj = new LinkedList[v];
	     for (int i=0; i<v; ++i) {
	         adj[i] = new LinkedList();}
 }

 // ------------------------------------ Function to add an edge into the graph ---------------------------------------

	 void addEdge(int v,int w) { 	 
	     adj[v].add(w); 
	}

 // ------------------------------------- A recursive function used by topologicalSort ---------------------------------
 
	 void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack) {
	     
	     visited[v] = true;									// Mark the current node as visited.
	     Integer i;
	
	     Iterator<Integer> it = adj[v].iterator(); 			// Recur for all the vertices adjacent to this vertex
	     while (it.hasNext()) {
	         i = it.next();
	         if (!visited[i]) {
	             topologicalSortUtil(i, visited, stack);
	         }
	     }
	
	     if (v != 0) {
	    	 stack.push((v));  	     							// Push current vertex to stack which stores result
	     }
	 }

 // ---------------- The function to do Topological Sort. It uses recursive topologicalSortUtil() -------------
 
 void topologicalSort() {
	 
     Stack<Integer> stack = new Stack<Integer>();
     
     boolean visited[] = new boolean[V];				// Mark all the vertices as not visited
     for (int i = 0; i < V; i++)
         visited[i] = false;

     for (int i = 0; i < V; i++)						// Call the recursive helper function to store
         if (visited[i] == false)						// Topological Sort starting from all vertices
             topologicalSortUtil(i, visited, stack);	// one by one
     		 //System.out.println("Stack 2 : " + stack);

     
     while (stack.empty()==false)                 		// Print contents of stack
         System.out.print(stack.pop() + " ");	
     
 }

// ----------------------------------------------------------------------------------------------------------
 
 public static void main(String args[]) {   

     
/*	 TopologicalSortGraph g = new TopologicalSortGraph(7); // Create a graph given in the above diagram  */
	 
 /*    g.addEdge(6, 6);    4 6 3 1 2 5 
     g.addEdge(1, 2);
     g.addEdge(3, 2);
     g.addEdge(4, 2);
     g.addEdge(2, 5);
     g.addEdge(6, 5);
     g.addEdge(4, 6);  */
	 
/*	 g.topologicalSort();*/

     
  /* g.addEdge(3, 3);
	 g.addEdge(1, 2);
	 g.addEdge(2, 3);
	 g.addEdge(3, 1);*/


//--------------------------------------- Scanner Input Value -----------------------------------------------------------    
    
	    sc = new Scanner(System.in);
	    int[] integers = new int[2];
	    for(int i = 0; i < 2; i++) { integers[i] = sc.nextInt(); }
	    int sizeU = integers[0]; int sizeV = integers[1];
 
	     in = new Scanner(System.in);
	     int[] arr=new int[sizeU + sizeV];
	     for(int i=0;i<arr.length;i++)
	          arr[i]=in.nextInt(); 
		 
	 //   System.out.println("Array : " + Arrays.toString(arr));
	      
	    int odd[] = new int[arr.length/2];
	    int even[] = new int[arr.length/2];
	    int j = 0, k = 0;
	    for(int i = 0; i < arr.length; i++) {
	            if(i % 2 != 0) {
	                odd[j] = arr[i];
	                j++;
	            }
	            else {
	                even[k] = arr[i];
	                k++;
	            }
	        }
	    

	    int maxEven = Arrays.stream(even).max().getAsInt();
	    int maxOdd = Arrays.stream(odd).max().getAsInt();
	    int max =0;
	    if (maxEven > maxOdd) {
	    	max = maxEven;
	    } else {
	    	max = maxOdd;
	    }
	    
	    TopologicalSortGraph g = new TopologicalSortGraph(max+1); // Create a graph given in the above diagram 


	   int sortEven[] = even.clone(); // Copy array to order to sorting
	   int sortOdd[] = odd.clone();
	   Arrays.sort(sortEven);         // sorting array to order to prepare to compare
	   Arrays.sort(sortOdd);
	   
	    if (Arrays.equals(sortOdd , sortEven)) { 								// If the graph cannot be topologically sorted, print -1 
	    	System.out.println(-1);    
	    } else {
		    for (int i = 0; i < even.length; i++) {
		    	int v = even[i];
		    	int w = odd[i];
		    	g.addEdge( v , w);
			}
		    g.topologicalSort();
	
	    }    



     
 }
}