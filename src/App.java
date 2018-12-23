public class App {

    public static void main(String args[]) {
        utils u = new utils();
        int x = u.keyboardInput();
        if(x == Integer.MIN_VALUE)
            System.out.println("Wrong Input");
        else System.out.println(x);
    }
}
