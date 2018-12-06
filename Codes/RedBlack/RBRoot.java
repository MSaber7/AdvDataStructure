package RedBlack;

public class RBRoot {    
	RBRoot left, right;
    int element;
    int color;

    //----------------- Constructor ---------------------------------------------
    public RBRoot(int theElement) {
        this( theElement, null, null );
    } 
    
    // -------------- Constructor -----------------------------------------------
    public RBRoot(int theElement, RBRoot lt, RBRoot rt){
        left = lt;
        right = rt;
        element = theElement;
        color = 1;
    }    
}
