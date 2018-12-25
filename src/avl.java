public class avl {
    avlNode root;
    private static Boolean flag=false;

    avl() {
        root = null;
    }

    void destroy() {
        root = null;
    }

    void insert(int key) {
       root = insert(key,root);
    }

    private avlNode insert(int key, avlNode t) {
        if(t == null) {
            t = new avlNode(key);
        } else if(key < t.key) {
            t.left = insert(key,t.left);
            if(height(t.left)-height(t.right) == 2) {
                if(key<t.left.key) {
                    t = LL(t);
                } else {
                    t = LR(t);
                }
            }
        } else if(key>t.key) {
            t.right = insert(key,t.right);
            if(height(t.right)-height(t.left) == 2) {
                if(key>t.right.key) {
                    t = RR(t);
                } else {
                    t = RL(t);
                }
            }
        } else {
            // Duplicate node not allowed
        }
        t.height = Math.max(height(t.left),height(t.right))+1;
        return t;
    }

    avlNode delete(int key, avlNode t) {
        //TODO: complete this
        return null;
    }

    void findKey(int key) {
        flag = false;
        if(find(key,root)) {
           System.out.println(key+" found");
       } else {
           System.out.println(key+ " not found");
       }
    }

    private Boolean find(int key, avlNode t) {
        if(t!=null) {
            if(t.key == key)
                flag = true;
            find(key,t.left);
            find(key,t.right);
        }
        return flag;
    }

    void display() {
        System.out.println("Preorder: ");
        preorder(root);
        System.out.println("\nInorder: ");
        inorder(root);
        System.out.println("\nPostorder: ");
        postorder(root);
        System.out.print("\n");
    }

    private void preorder(avlNode t) {
        if(t!=null) {
            System.out.print(t.key+" ");
            preorder(t.left);
            preorder(t.right);
        }
    }

    private void inorder(avlNode t) {
        if(t!=null) {
            inorder(t.left);
            System.out.print(t.key+" ");
            inorder(t.right);
        }
    }

    private void postorder(avlNode t) {
        if(t!=null) {
            postorder(t.left);
            postorder(t.right);
            System.out.print(t.key+" ");
        }
    }

    private avlNode RR(avlNode key1) {
        avlNode key2 = key1.right;
        key1.right = key2.left;
        key2.left = key1;
        key1.height = Math.max(height(key1.left),height(key1.right))+1;
        key2.height = Math.max(key1.height,height(key2.right))+1;
        return key2;
    }

    private avlNode LL(avlNode key2) {
        avlNode key1 = key2.left;
        key2.left = key1.right;
        key1.right = key2;
        key2.height = Math.max(height(key2.left),height(key2.right))+1;
        key1.height = Math.max(height(key1.left),key2.height)+1;
        return key1;
    }

    private avlNode LR(avlNode key3) {
        key3.left = RR(key3.left);
        return LL(key3);
    }

    private avlNode RL(avlNode key1) {
        key1.right = LL(key1.right);
        return RR(key1);
    }

    private int height(avlNode node) {
        return node == null ? -1 : node.height;
    }
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