package PQueue;

/** @MSaber 
 * 
 * Priority Queue Class
 *  
 * */

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;


public class PQDemo { 

	public static void main(String[] args) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(16);

//      System.out.println("Please Enter Number of size array : ");
        Scanner insize =new Scanner(System.in);
        
    	int size = insize.nextInt();
//        System.out.println("Please Enter " + size + " elements of array");

        Scanner in =new Scanner(System.in);
        int[] arr=new int[size];
        
        for(int i=0;i<arr.length;i++) {
             arr[i]=in.nextInt(); 
             }
        	 
        for (int i=0;i<arr.length;i++) {
        	int e = arr[i];
        	pq.add(e);
        }	 
        
		Iterator <Integer> itr = pq.iterator();
//		System.out.println("Iterating over PriorityQueue");
		while(itr.hasNext()){
			System.out.println(itr.next());
		}

	}
}  

