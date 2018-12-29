import java.util.ArrayList;
import java.util.List;

public class minHeap {
    List<Integer> heap;

    minHeap() {
        heap = new ArrayList<>();
    }

    void destroy() {
        heap.clear();
    }

    void insert(int key) {
        heap.add(key);
        heapifyUp(heap.size()-1);
    }

    void delete(int key,Boolean status) {
        if(heap.contains(key)) {
            swap(heap.indexOf(key),heap.size()-1);
            heap.remove(heap.size()-1);
            heapifyDown(0);
            if(status) System.out.println(key+" deleted");
        } else {
            if(status) System.out.println(key+" not found");
        }
    }

    void deleteMin() {
        swap(0,heap.size()-1);
        heap.remove(heap.size()-1);
        heapifyDown(0);
    }

    void display() {
        System.out.println("Preorder: ");
        preorder(0);
        System.out.println("\nInorder: ");
        inorder(0);
        System.out.println("\nPostorder: ");
        postorder(0);
        System.out.print("\n");
    }

    private void preorder(int t) {
        if(t<heap.size() && t>=0) {
            System.out.print(heap.get(t)+" ");
            preorder(left(t));
            preorder(right(t));
        }
    }

    private void inorder(int t) {
        if(t<heap.size() && t>=0) {
            inorder(left(t));
            System.out.print(heap.get(t)+" ");
            inorder(right(t));
        }
    }

    private void postorder(int t) {
        if(t<heap.size() && t>=0) {
            postorder(left(t));
            postorder(right(t));
            System.out.print(heap.get(t)+" ");
        }
    }

    void heapifyUp(int node) {
        if(node>0 && heap.get(parent(node))>heap.get(node)) {
            swap(node,parent(node));
            heapifyUp(parent(node));
        }
    }

    void heapifyDown(int node) {
        int l = left(node);
        int r = right(node);
        int smallest = node;
        if(l<heap.size() && heap.get(l)<heap.get(node))
            smallest = l;
        if(r<heap.size() && heap.get(r)<heap.get(smallest))
            smallest = r;
        if(smallest != node) {
            swap(node, smallest);
            heapifyDown(smallest);
        }
    }

    void find(int key) {
        if(heap.contains(key))
            System.out.println(key+" found");
        else
            System.out.println(key+ " not found");
    }

    void findMin() {
        System.out.println(heap.get(0));
    }

    void swap(int a,int b) {
        int tmp = heap.get(a);
        heap.set(a,heap.get(b));
        heap.set(b,tmp);
    }

    int left(int node) {
        return 2*node+1;
    }

    int right(int node) {
        return 2*node+2;
    }

    int parent(int node) {
        return (node-1)/2;
    }
    
}
