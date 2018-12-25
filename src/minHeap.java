package com.company;
import com.company.App;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class minHeap {

    private int[] Heap;
    private int size;
    private int maxsize;
    private static final int FRONT = 1;

    //maxsize of heap
    public minHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MIN_VALUE;
    }


    private int parent(int pos) {
        return pos / 2;
    }


    private int leftChild(int pos) {
        return (2 * pos);
    }


    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }


    private boolean isLeaf(int pos) {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }


    private void swap(int fpos, int spos) {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    //heapify after every insert delete or deletemin
    private void minHeapify(int pos) {
        if (!isLeaf(pos)) {
            if (Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)]) {
                if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }


    //insert into heap
    public void insert(int element) {
        Heap[++size] = element;
        int current = size;
        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    //print the tree
    public void print() {
        System.out.println("Level    Parent    LeftChild    RightChild");
        for (int i = 1; i <= size / 2; i++) {

            System.out.print(i +"          " + Heap[i] + "           " + Heap[2 * i]
                    + "             " + Heap[2 * i + 1]);
            System.out.println();
        }
    }

    public void minHeap() {
        for (int pos = (size / 2); pos >= 1; pos--) {
            minHeapify(pos);
        }
    }

    //delete min
    public int removemin() {
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);
        return popped;
    }

    //find min element
    public int findmin() {
        int popped = Heap[FRONT];
        return popped;
    }


    private void decreaseKey(int i, int new_val)
    {
        Heap[i] = new_val;
        while (i != 0 && Heap[parent(i)] > Heap[i])
        {
            int temp = Heap[i];
            Heap[i] = Heap[parent(i)];
            Heap[parent(i)] = temp;
            i = parent(i);
        }
    }


    private int extractMin()
    {
        if (size <= 0)
            return MAX_VALUE ;
        if (size == 1)
        {
            size--;
            return Heap[0];
        }
        int root = Heap[0];
        Heap[0] = Heap[size-1];
        size--;
        minHeapify(0);

        return root;
    }


    private int findpos(int x)
    {
        int value=0;
        for (int i = 0; i < maxsize; i++)  // Worst case n+1
            if (Heap[i] == x)  // Worst case n
                value=i;
        return value;
    }

    //delete a key at position x
    void deleteKey(int i)
    {
        int pos = findpos(i);
        decreaseKey(pos, MIN_VALUE);
        extractMin();
    }
}



