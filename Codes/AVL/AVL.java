package AVL;

public class AVL {
//------------------------------------------------------------------------------	
	public int getBalance(AVLRoot n) {
		if (n != null) {
			return (getHeight(n.left) - getHeight(n.right));
		}
		return 0;
	}
//-------------------------------------------------------------------------------
	public int getHeight(AVLRoot n) {
		if (n != null) {
			return n.height;
		}
		return 0;
	}
//-------------------------------------------------------------------------------
	public AVLRoot rightRotate(AVLRoot A) {
		AVLRoot B = A.left;
		AVLRoot T2 = B.right;

		// Rotation
		B.right = A;
		A.left = T2;

		// update their heights
		B.height = Math.max(getHeight(B.left), getHeight(B.right)) + 1;
		A.height = Math.max(getHeight(A.left), getHeight(A.right)) + 1;

		return B;
	}
//--------------------------------------------------------------------------------
	public AVLRoot leftRotate(AVLRoot A) {
		AVLRoot B = A.right;
		AVLRoot T2 = B.left;

		// Rotation
		B.left = A;
		A.right = T2;

		// update their heights
		A.height = Math.max(getHeight(A.left), getHeight(A.right)) + 1;
		B.height = Math.max(getHeight(B.left), getHeight(B.right)) + 1;

		return B;
	}
//---------------------------------------------------------------------------------
	public AVLRoot insert(AVLRoot node, int data) {
		if (node == null) {
			return (new AVLRoot(data));
		}
		if (node.data > data) {
			node.left = insert(node.left, data);
		} else {
			node.right = insert(node.right, data);
		}
		// update the node height
		node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

		int balDiff = getBalance(node);

		// -------- Left Left Rotate ---------------
		if (balDiff > 1 && data < node.left.data) {
			return rightRotate(node);
		}
		
		// -------- Left Right Rotate --------------
				if (balDiff > 1 && data > node.left.data) {
					node.left = leftRotate(node.left);
					return rightRotate(node);
				}

		// -------- Right Right Rotate --------------
		if (balDiff < -1 && data > node.right.data) {
			return leftRotate(node);
		}

		// --------- Right Left Rotate ---------------
		if (balDiff < -1 && data < node.right.data) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		return node;
	}
	
//--------------------------------------------------------------------
	public void display(AVLRoot root) {
		if (root != null) {
			display(root.left);
			System.out.print(" " + root.data);
			display(root.right);
		}
	}
// ---------------------------------------------------------------------
	public static void main(String args[]) {
		AVLRoot root = null;
		AVL i = new AVL();
		root = i.insert(root, 4);
		root = i.insert(root, 2);
		root = i.insert(root, 1);
		root = i.insert(root, 5);
		root = i.insert(root, 6);
		root = i.insert(root, 9);
		root = i.insert(root, 14);
		root = i.insert(root, 11);
		root = i.insert(root, 10);
		root = i.insert(root, 20);
		System.out.print("Inorder / Display Traversal of Constructed AVL Tree :");
		i.display(root);
		System.out.print("\n New Root of AVL Tree is : " + root.data);
	}
}
