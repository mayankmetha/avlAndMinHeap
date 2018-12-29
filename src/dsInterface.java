import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class dsInterface {

    HashMap<String,Object> avlInstances = new HashMap<>();
    HashMap<String,Object> heapInstances = new HashMap<>();

    void avlCreate(String name) {
        if(avlInstances.containsKey(name)) {
            System.out.println("Failed to create duplicate avl tree");
        } else {
            avlInstances.put(name, new avl());
            System.out.println("Successfully created avl tree: "+name);
        }
    }

    void avlDestroy(String name) {
        if(!avlInstances.containsKey(name)) {
            System.out.println("Failed to destroy a non existence avl tree");
        } else {
            ((avl)avlInstances.get(name)).destroy();
            avlInstances.remove(name);
            System.out.println(name+ " destroyed");
        }
    }

    void avlInsertKey(String name, int key) {
        if(!avlInstances.containsKey(name)) {
            System.out.println("Failed to get the avl tree");
        } else {
            ((avl)avlInstances.get(name)).insert(key,Boolean.TRUE);
        }
    }

    void avlInsertKey(String name, String filePath) {
        if(!avlInstances.containsKey(name)) {
            System.out.println("Failed to get the avl tree");
        } else {
            try {
                Scanner s = new Scanner(new FileReader(filePath)).useDelimiter(",");
                while(s.hasNextInt()) {
                    ((avl)avlInstances.get(name)).insert(s.nextInt(),Boolean.FALSE);
                }
                System.out.println("Inserted keys from "+filePath);
            } catch (IOException e) {
                System.out.println("Failed to read "+filePath);
            }
        }
    }

    void avlDeleteKey(String name, int key) {
        if(!avlInstances.containsKey(name)) {
            System.out.println("Failed to get the avl tree");
        } else {
            ((avl)avlInstances.get(name)).delete(key,Boolean.TRUE);
        }
    }

    void avlDeleteKey(String name, String filePath) {
        if(!avlInstances.containsKey(name)) {
            System.out.println("Failed to get the avl tree");
        } else {
            try {
                Scanner s = new Scanner(new FileReader(filePath)).useDelimiter(",");
                while(s.hasNextInt()) {
                    ((avl)avlInstances.get(name)).delete(s.nextInt(),Boolean.FALSE);
                }
                System.out.println("Deleted keys using "+filePath);
            } catch (IOException e) {
                System.out.println("Failed to read "+filePath);
            }
        }
    }

    void avlFindKey(String name, int key) {
        if(!avlInstances.containsKey(name)) {
            System.out.println("Failed to get the avl tree");
        } else {
            ((avl)avlInstances.get(name)).find(key);
        }
    }

    void avlShowTree(String name) {
        if(!avlInstances.containsKey(name)) {
            System.out.println("Failed to get the avl tree");
        } else {
            ((avl)avlInstances.get(name)).display();
        }
    }

    void heapCreate(String name) {
        if(heapInstances.containsKey(name)) {
            System.out.println("Failed to create duplicate minimum heap");
        } else {
            heapInstances.put(name, new minHeap());
            System.out.println("Successfully created minimum heap: "+name);
        }
    }

    void heapDestroy(String name) {
        if(!heapInstances.containsKey(name)) {
            System.out.println("Failed to destroy a non existence minimum heap");
        } else {
            ((minHeap)heapInstances.get(name)).destroy();
            heapInstances.remove(name);
            System.out.println(name+ " destroyed");
        }
    }

    void heapInsertKey(String name, int key) {

    }
}
