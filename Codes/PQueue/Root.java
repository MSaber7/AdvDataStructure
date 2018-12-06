package PQueue;

/** @author MSaber 
 * 
 *  Priority Queue Class
 *  
 *  **/

public class Root
{
    String job;
    int priority;
 
    /** Constructor **/
    public Root(String job, int priority)
    {
        this.job = job;
        this.priority = priority; 
    }
    /** toString() **/
    public String toString() 
    {
        return "Job Name : "+ job +"\nPriority : "+ priority;
    }
}