package PQueue;

// ------------------------------- Priority Queue ----------------------------------------------------

public class PriorityQueue2 {
	
    private Root[] heap; 
    private int heapSize, capacity;
 
    /** Constructor **/
    public PriorityQueue2(int capacity)
    {    
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
    	System.out.println("\nSize : " + heapSize);
        return heapSize;
    }

    // ---------------------------------- Insert ---------------------------------------    
    public void insert(String job, int priority) {
        Root newJob = new Root(job, priority);
 
        heap[++heapSize] = newJob;
        int pos = heapSize;
        while (pos != 1 && newJob.priority > heap[pos/2].priority)
        {
            heap[pos] = heap[pos/2];
            pos /=2;
        }
        heap[pos] = newJob;    
        
        //System.out.println(Arrays.toString(heap));
        System.out.println(heap[pos]);     
    }
     
// ---------------------------------- Remove ---------------------------------------
    
    public Root remove()
    {
        int parent, child;
        Root item, temp;
        if (isEmpty() )
        {
            System.out.println("Heap is empty");
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
        System.out.println(item);
        return item;
    }
    
    
 // -------------------------------- main ---------------------------------------------   
    
    public static void main(String[] args) {
        System.out.println("Priority Queue Test\n");   
         
        int size = 3 ;
        PriorityQueue2 pq = new PriorityQueue2(size);
 
        System.out.println("First Insert : ");
        pq.insert("One", 10);
        
        System.out.println("\nSecond Insert : ");
        pq.insert("Two", 15);
        
        System.out.println("\nThird Insert : ");
        pq.insert("Three", 5);
        
        System.out.println("\nRemove ");
        pq.remove();
        pq.isEmpty();
        pq.isFull();
        pq.size();
        
    }  
    
}
 