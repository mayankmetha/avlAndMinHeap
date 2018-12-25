import java.util.Scanner;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.System.exit;

public class App {

        public static void main(String...arg) {
        Scanner input = new Scanner(System.in);
        System.out.println("Implementation of 1. AVL Tree 2. Min Heap");
        System.out.println("Enter your choice : ");
        int number = input.nextInt();
        if (number == 1)
        {
            System.out.println("------------------------------------------");
            System.out.println("AVL TREE IMPLEMENTATION");
            System.out.println("------------------------------------------");
        }

        else if (number == 2) {

        System.out.println("------------------------------------------");
        System.out.println("MIN HEAP IMPLEMENTATION");
        System.out.println("------------------------------------------");
        System.out.println("Maxsize of heap:");
        int maxsize = input.nextInt();
        minHeap heapObj = new minHeap(maxsize);
        while(true) {
            System.out.println(" ");
            System.out.println("basic funtionalities:");
            System.out.println("1.insert 2.print 3.find min 4.delete min 5.delete a key 6.exit");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the element to be inserted:");
                    int element = input.nextInt();
                    heapObj.insert(element);
                    break;

                case 2:
                    heapObj.print();
                    break;

                case 3:
                    int minelement = heapObj.findmin();
                    System.out.println("The min element is:" + minelement);
                    break;

                case 4:
                    int deleted = heapObj.removemin();
                    System.out.println("The deleted element is:" + deleted);
                    break;

                case 5:
                    System.out.println("Enter element to be deleted:");
                    int key = input.nextInt();
                    heapObj.deleteKey(key);
                    System.out.println("Key deleted!");
                    break;

                case 6:
                    exit(0);
                    break;

                }
            }
        }
        else
        {
            System.out.println("------------------------------------------");
            System.out.println("Select the right option!!");
            System.out.println("------------------------------------------");
        }
    }
}
