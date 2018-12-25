public class avl {

}

class avlNode{
    avlNode left, right;
    int key;
    int height;

    avlNode() {
        left = null;
        right = null;
        key = 0;
        height = 0;
    }

    avlNode(int k) {
        left = null;
        right = null;
        key = k;
        height = 0;
    }
}