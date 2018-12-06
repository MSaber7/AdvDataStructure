package RedBlack;

public class RBTree {
	
    private RBRoot current;
    private RBRoot parent;
    private RBRoot grand;
    private RBRoot great;
    private RBRoot header;    
    private static RBRoot nullNode;
    
    /* static initializer for nullNode */
    static {
        nullNode = new RBRoot(0);
        nullNode.left = nullNode;
        nullNode.right = nullNode;
    }
    
    /* Black - 1  RED - 0 */
    static final int BLACK = 1;    
    static final int RED   = 0;

    /* Constructor */
    public RBTree(int negInf)
    {
        header = new RBRoot(negInf);
        header.left = nullNode;
        header.right = nullNode;
    }
    
    
    //-------------------------- Empty ------------- ---------------------------
    public boolean isEmpty()
    {
        return header.right == nullNode;
    }
    // -------------------------- MakeEmpty-------------------------------------
    public void makeEmpty()
    {
        header.right = nullNode;
    }
    // ------------------------- Insert -----------------------------------------
    public void insert(int item )
    {
        current = parent = grand = header;
        nullNode.element = item;
        while (current.element != item)
        {            
            great = grand; 
            grand = parent; 
            parent = current;
            current = item < current.element ? current.left : current.right;
            // Check if two red children and fix if so            
            if (current.left.color == RED && current.right.color == RED)
                handleReorient( item );
        }
        // Insertion fails if already present
        if (current != nullNode)
            return;
        current = new RBRoot(item, nullNode, nullNode);
        // Attach to parent
        if (item < parent.element)
            parent.left = current;
        else
            parent.right = current;        
        handleReorient( item );
    }
    // ---------------------Handle Reorient --------------------------------------------------
    private void handleReorient(int item)
    {
        // Do the color flip
        current.color = RED;
        current.left.color = BLACK;
        current.right.color = BLACK;

        if (parent.color == RED)   
        {
            // Have to rotate
            grand.color = RED;
            if (item < grand.element != item < parent.element)
                parent = rotate( item, grand );  // Start dbl rotate
            current = rotate(item, great );
            current.color = BLACK;
        }
        // Make root black
        header.right.color = BLACK; 
    }   
    
    // -----------------Rotate------------------------------------------------------
    private RBRoot rotate(int item, RBRoot parent)
    {
        if(item < parent.element)
            return parent.left = item < parent.left.element ? rotateWithLeftChild(parent.left) : rotateWithRightChild(parent.left) ;  
        else
            return parent.right = item < parent.right.element ? rotateWithLeftChild(parent.right) : rotateWithRightChild(parent.right);  
    }
    
    // ---------------- Rotate Left -------------------------------------------------------
    /* Rotate binary tree node with left child */
    private RBRoot rotateWithLeftChild(RBRoot k2)
    {
    	RBRoot k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        return k1;
    }
    // --------------- Rotate Right --------------------------------------------------------
    /* Rotate binary tree node with right child */
    private RBRoot rotateWithRightChild(RBRoot k1)
    {
    	RBRoot k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        return k2;
    }
    // --------------- Count Node  ------------------------------------------------------------
    /* Functions to count number of nodes */
    public int countNodes()
    {
        return countNodes(header.right);
    }
    private int countNodes(RBRoot r)
    {
        if (r == nullNode)
            return 0;
        else
        {
            int l = 1;
            l += countNodes(r.left);
            l += countNodes(r.right);
            return l;
        }
    }
    // --------------- Search -----------------------------------------------------------------
    public boolean search(int val)
    {
        return search(header.right, val);
    }
    private boolean search(RBRoot r, int val)
    {
        boolean found = false;
        while ((r != nullNode) && !found)
        {
            int rval = r.element;
            if (val < rval)
                r = r.left;
            else if (val > rval)
                r = r.right;
            else
            {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }
    // -------------- Inorder traversal ------------------------------------------------------- 
    public void inorder()
    {
        inorder(header.right);
    }
    private void inorder(RBRoot r)
    {
        if (r != nullNode)
        {
            inorder(r.left);
            char c = 'B';
            if (r.color == 0)
                c = 'R';
            System.out.print(r.element +""+c+" ");
            inorder(r.right);
        }
    }
    // ------------- Preorder traversal ---------------------------------------------------------
    public void preorder()
    {
        preorder(header.right);
    }
    private void preorder(RBRoot r)
    {
        if (r != nullNode)
        {
            char c = 'B';
            if (r.color == 0)
                c = 'R';
            System.out.print(r.element +""+c+" ");
            preorder(r.left);             
            preorder(r.right);
        }
    }
    /* Function for postorder traversal */
    public void postorder()
    {
        postorder(header.right);
    }
    private void postorder(RBRoot r)
    {
        if (r != nullNode)
        {
            postorder(r.left);             
            postorder(r.right);
            char c = 'B';
            if (r.color == 0)
                c = 'R';
            System.out.print(r.element +""+c+" ");
        }
    }  
    
    
 // ------------------------------------ Main -----------------------------------------------   
    
    public static void main(String[] args) { 
    	
    	RBTree o = new RBTree(Integer.MIN_VALUE); 
    	
    	o.insert(1);
    	o.insert(2);
    	o.insert(3);
    	o.insert(4);
    	o.insert(5);
    	
    	o.search(2);
    	
    	System.out.print("\nPost order : ");
        o.postorder();
        System.out.print("\nPre order : ");
        o.preorder();
        System.out.print("\nIn order : ");
        o.inorder(); 
    	
    } 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
