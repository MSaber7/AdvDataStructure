package AVL;

public class AVLRoot {
	
	int data;
	AVLRoot left;
	AVLRoot right;
	int height;

	public AVLRoot(int data) {
		this.data = data;
		height = 1;
	}
}
