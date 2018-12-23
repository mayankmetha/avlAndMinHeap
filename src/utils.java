import java.io.*;
import java.util.Random;

public class utils {

    private Random rand = new Random(System.currentTimeMillis());

    int nextRandom() {
        return rand.nextInt();
    }

    String createFile(String filePath, long keys) {
        try {
            BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(filePath))));
            while(keys > 1) {
                br.write(Integer.toString(nextRandom()));
                br.write(",");
                keys--;
            }
            br.write(Integer.toString(nextRandom()));
            br.close();
            return ("Creating file in "+filePath+" successful");
        } catch (IOException e) {
            return ("Creating file in "+filePath+" failed");
        }
    }
}
