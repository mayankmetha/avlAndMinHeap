import java.util.ArrayList;
import java.util.List;

public class minHeap {
    List<Integer> heap;
    int size=-1;

    minHeap() {
        heap = new ArrayList<>();
    }

    void destroy() {
        heap.clear();
    }

    void insert(int key) {
        heap.add(++size,key);
        if(key>heap.get(parent(key)))
            heapifyDown(0);
    }

    void heapifyDown(int node) {
        int l = left(node);
        int r = right(node);
        int smallest = node;
        if(l<size && heap.get(l)<heap.get(node))
            smallest = l;
        if(r<size && heap.get(r)<heap.get(node))
            smallest = r;
        if(smallest != node) {
            swap(node, smallest);
            heapifyDown(smallest);
        }

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
