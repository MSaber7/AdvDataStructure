package com.GraphAlgorithm;
import java.util.*;

// ------------------------- Java program to print DFS traversal from a given given graph ------------
public class DFSGraph {
	 
	// This class represents a directed graph using adjacency list representation
	
	private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; 	// Array  of lists for Adjacency List Representation
	 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	// Constructor
	DFSGraph(int v) {
	    V = v;
	    adj = new LinkedList[v];
	    for (int i=0; i<v; ++i)
	         adj[i] = new LinkedList();
	}
	
// ------------------- Function to add an edge into the graph --------------------------------------------
	    void addEdge(int v, int w)
	    {
	        adj[v].add(w);  // Add w to v's list.
	    }
	    
// ------------------------- A function used by DFS ------------------------------------------------------
	    void DFSUtil(int v,boolean visited[])
	    {
	        // Mark the current node as visited and print it
	        visited[v] = true;
	        System.out.print(v+" ");
	 
	        // Recur for all the vertices adjacent to this vertex
	        Iterator<Integer> i = adj[v].listIterator();
	        while (i.hasNext())
	        {
	            int n = i.next();
	            if (!visited[n])
	                DFSUtil(n, visited);
	        }
	    }
	 
// ---------------- The function to do DFS traversal. It uses recursive DFSUtil() -----------------------
	    public void DFS(int v) {

	    	boolean visited[] = new boolean[V]; // Mark all the vertices as not visited(set as false by default in java)
	        DFSUtil(v, visited);    	      	// Call the recursive helper function to print DFS traversal
	    }

// -------------------------------------------------------------------------------------------------------------	    
	    public static void main(String args[]) {
	    	
	    	DFSGraph g = new DFSGraph(4);
	 
	        g.addEdge(0, 1);
	        g.addEdge(0, 2);
	        g.addEdge(1, 2);
	        g.addEdge(2, 0);
	        g.addEdge(2, 3);
	        g.addEdge(3, 3);
	 
	        System.out.println("Following is Depth First Traversal "+ "(starting from vertex 2)");
	 
	        g.DFS(2);
	    }
	}
	
