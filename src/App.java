import javax.sound.midi.SysexMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    static long start,stop;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static utils u;
    static dsInterface ds;

    public static void main(String args[])throws Exception {
        u = new utils();
        ds = new dsInterface();

        while(true) {
            System.out.println("\nSelect a data structure");
            System.out.println("0. Exit");
            System.out.println("1. AVL Tree");
            System.out.println("2. Min Heap");
            System.out.println("3. Create CSV");
            System.out.print("Input: ");
            switch (Integer.parseInt(br.readLine())) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    avlMenu();
                    break;
                case 2:
                    minHeapMenu();
                    break;
                case 3:
                    System.out.print("Input file name with path:");
                    String filePath = br.readLine();
                    System.out.print("Input the number of keys: ");
                    long x = Long.parseLong(br.readLine());
                    start = System.nanoTime();
                    u.createFile(filePath,x);
                    stop = System.nanoTime();
                    displayTime(start,stop);
                    break;
                default:
                    System.out.println("Invalid options");
                    break;
            }
        }
    }

    static void avlMenu()throws Exception {
        String tmp, file;
        int x;
        System.out.println("\nSelect an AVL Tree operation");
        System.out.println("0. Go Back");
        System.out.println("1. Create");
        System.out.println("2. Destroy");
        System.out.println("3. Insert key");
        System.out.println("4. Insert keys from file");
        System.out.println("5. Delete key");
        System.out.println("6. Delete keys from file");
        System.out.println("7. Find key");
        System.out.println("8. Show tree");
        System.out.print("Input: ");
        switch (Integer.parseInt(br.readLine())) {
            case 0:
                break;
            case 1:
                System.out.print("Input a name: ");
                tmp = br.readLine();
                start = System.nanoTime();
                ds.avlCreate(tmp);
                stop = System.nanoTime();
                displayTime(start,stop);
                break;
            case 2:
                System.out.print("Input a name: ");
                tmp = br.readLine();
                start = System.nanoTime();
                ds.avlDestroy(tmp);
                stop = System.nanoTime();
                displayTime(start,stop);
                break;
            case 3:
                System.out.print("Input a name: ");
                tmp = br.readLine();
                System.out.print("Input a key: ");
                x = Integer.parseInt(br.readLine());
                start = System.nanoTime();
                ds.avlInsertKey(tmp,x);
                stop = System.nanoTime();
                displayTime(start,stop);
                break;
            case 4:
                System.out.print("Input a name: ");
                tmp = br.readLine();
                System.out.print("Input name of csv with filePath: ");
                file = br.readLine();
                start = System.nanoTime();
                ds.avlInsertKey(tmp,file);
                stop = System.nanoTime();
                displayTime(start,stop);
                break;
            case 5:
                System.out.print("Input a name: ");
                tmp = br.readLine();
                System.out.print("Input a key: ");
                x = Integer.parseInt(br.readLine());
                start = System.nanoTime();
                ds.avlDeleteKey(tmp,x);
                stop = System.nanoTime();
                displayTime(start,stop);
                break;
            case 6:
                System.out.print("Input a name: ");
                tmp = br.readLine();
                System.out.print("Input name of csv with filePath: ");
                file = br.readLine();
                start = System.nanoTime();
                ds.avlDeleteKey(tmp,file);
                stop = System.nanoTime();
                displayTime(start,stop);
                break;
            case 7:
                System.out.print("Input a name: ");
                tmp = br.readLine();
                System.out.print("Input a key: ");
                x = Integer.parseInt(br.readLine());
                start = System.nanoTime();
                ds.avlFindKey(tmp,x);
                stop = System.nanoTime();
                displayTime(start,stop);
                break;
            case 8:
                System.out.print("Input a name: ");
                tmp = br.readLine();
                start = System.nanoTime();
                ds.avlShow(tmp);
                stop = System.nanoTime();
                displayTime(start,stop);
                break;
            default:
                System.out.println("Invalid options");
                break;
        }
    }

    static void minHeapMenu()throws Exception {
        String tmp, file;
        int x;
        System.out.println("\nSelect a Min Heap operation");
        System.out.println("0. Go Back");
        System.out.println("1. Create");
        System.out.println("2. Destroy");
        System.out.println("3. Insert key");
        System.out.println("4. Insert keys from file");
        //System.out.println("5. Delete key");
        //System.out.println("6. Delete keys from file");
        //System.out.println("7. Delete min");
        //System.out.println("8. Find key");
        //System.out.println("9. Find min");
        System.out.println("10. Show tree");
        System.out.print("Input: ");
        switch (Integer.parseInt(br.readLine())) {
            case 0:
                break;
            case 1:
                System.out.print("Input a name: ");
                tmp = br.readLine();
                start = System.nanoTime();
                ds.heapCreate(tmp);
                stop = System.nanoTime();
                displayTime(start,stop);
                break;
            case 2:
                System.out.print("Input a name: ");
                tmp = br.readLine();
                start = System.nanoTime();
                ds.heapDestroy(tmp);
                stop = System.nanoTime();
                displayTime(start,stop);
                break;
            case 3:
                System.out.print("Input a name: ");
                tmp = br.readLine();
                System.out.print("Input a key: ");
                x = Integer.parseInt(br.readLine());
                start = System.nanoTime();
                ds.heapInsertKey(tmp,x);
                stop = System.nanoTime();
                displayTime(start,stop);
                break;
            case 4:
                System.out.print("Input a name: ");
                tmp = br.readLine();
                System.out.print("Input name of csv with filePath: ");
                file = br.readLine();
                start = System.nanoTime();
                ds.heapInsertKey(tmp,file);
                stop = System.nanoTime();
                displayTime(start,stop);
                break;
            case 10:
                System.out.print("Input a name: ");
                tmp = br.readLine();
                start = System.nanoTime();
                ds.heapShow(tmp);
                stop = System.nanoTime();
                displayTime(start,stop);
                break;
            default:
                System.out.println("Invalid options");
                break;
        }
    }

    static void displayTime(long str, long stp) {
        System.out.println("Time takem:"+(double)((stp-str)/1000000)+"ms");
    }
}
