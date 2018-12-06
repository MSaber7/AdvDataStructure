
/** @MSaber
 * 
 * Priority Queue Class
 *  
 * */


package PQueue;

import java.util.Scanner;

// ------------------- Class to Create Root of PriorityQueue  --------------------------------------------- 
class NewPQRoot {
    String job;
    int priority;
 
    /** Constructor **/
    public NewPQRoot(String job, int priority){
        this.job = job;
        this.priority = priority; }
    
    /** toString() **/
    public String toString()  {
        return  job + priority; }
}

// ------------------- Class to Processing Priority Queue -------------------------------------------------
public class NewPriorityQueue {
	static int cap = 0;
	
    private Root[] heap; 
    private int heapSize, capacity;
 
    /** Constructor **/
    public NewPriorityQueue(int capacity){   
    	
        this.capacity = capacity + 1;
        heap = new Root[this.capacity];
        heapSize = 0;
    }
    
// ---------------------------------- clear ---------------------------------------
    public void clear()
    {
        heap = new Root[capacity];
        heapSize = 0;
    }
    
// ---------------------------------- isEmpty ---------------------------------------
    public boolean isEmpty()
    {
        return heapSize == 0;    
    }
// ---------------------------------- isFull ---------------------------------------    
    public boolean isFull()
    {
        return heapSize == capacity - 1;
    }
    
// ---------------------------------- size ---------------------------------------
    public int size()
    {
        return heapSize;
    }

    // ---------------------------------- Insert ---------------------------------------    
    public void insert(String job, int priority) {         // 2 < 1 2 3
    	
    	if(isFull()) {
      /*  	System.out.println("Error : Array Index Out Of Bounds Exception ");
        	System.out.println("beacuse size of priority queue is only " + heapSize + " elements and ") ;
        	System.out.println("You are trying to enter " + (heapSize+1) + " elements. " );*/
        	return;
    	}
 
        Root newJob = new Root(job, priority);

        heap[++heapSize] = newJob;
        int pos = heapSize;

        while (pos != 1 && newJob.priority > heap[pos/2].priority){
            heap[pos] = heap[pos/2];
            pos /=2;
        }
        heap[pos] = newJob;    

        
        
        //System.out.println(Arrays.toString(heap));
     //   System.out.println(heap[pos]);     
    }
     
// ---------------------------------- Remove ---------------------------------------
    
    public Root remove()
    {
        int parent, child;
        Root item, temp;
        if (isEmpty() )
        {
            System.out.println("*");
            return null;
        }
 
        item = heap[1];
        temp = heap[heapSize--];
 
        parent = 1;
        child = 2;
        while (child <= heapSize)
        {
            if (child < heapSize && heap[child].priority < heap[child + 1].priority)
                child++;
            if (temp.priority >= heap[child].priority)
                break;
 
            heap[parent] = heap[child];
            parent = child;
            child *= 2;
        }
        heap[parent] = temp;
        //System.out.println(heap[parent]);
        //System.out.println(item);
        return item;
    }
    
 // -------------------------------- main ---------------------------------------------   
   
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
  //      System.out.println("Priority Queue Test\n");   
 
  //      System.out.println("Enter size of priority queue ");
  //      cap = scan.nextInt();
        NewPriorityQueue pq = new NewPriorityQueue(3 );
 
        
    //    System.out.println("push ");
        pq.insert(scan.next(), scan.nextInt() ); 
        
   //     System.out.println("\npush ");
        pq.insert(scan.next(), scan.nextInt() );
        
   //     System.out.println("\npush ");
        pq.insert(scan.next(), scan.nextInt() );
        
        System.out.println("\n"+ pq.remove()); 
        
        System.out.println("\n"+ pq.remove()); 
        
        System.out.println("\n"+ pq.remove()); 
        
        System.out.println("\n "+ pq.remove()); 
        
        System.out.println("\n"+ pq.remove()); 
        
        
    /*
             
        char ch;
        /*  Perform Priority Queue operations */
   /*      do   
        {
            System.out.println("\nPriority Queue Operations\n");
            System.out.println("1. insert");
            System.out.println("2. remove");
            System.out.println("3. check empty");
            System.out.println("4. check full");
            System.out.println("5. clear");
            System.out.println("6. size");
 
            int choice = scan.nextInt();            
            switch (choice) 
            {
            case 1 : 
                System.out.println("Enter job name and priority");
                pq.insert(scan.next(), scan.nextInt() );     
                
                break;                          
            case 2 : 
                System.out.println("\nJob removed \n\n"+ pq.remove()); 
                break;        
            case 3 : 
                System.out.println("\nEmpty Status : "+ pq.isEmpty() );
                break; 
            case 4 : 
                System.out.println("\nFull Status : "+ pq.isFull() );
                break; 
            case 5 : 
                System.out.println("\nPriority Queue Cleared");
                pq.clear();
                break;    
            case 6 : 
                System.out.println("\nSize = "+ pq.size() );
                break;         
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }    
 
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');  
        */
    } 
  
}







