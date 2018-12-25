public class dsInterface {
    //TODO: temp function
    public static void main(String args[]) {
        avl a = new avl();
        a.insert(1);
        a.insert(2);
        a.insert(3);
        a.insert(4);
        a.insert(5);
        a.insert(6);
        a.insert(7);
        a.insert(8);
        a.display();
        a.findKey(3);
        a.findKey(4);
        a.destroy();
    }
}
