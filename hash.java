import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * Created by KAY on 23/02/2017.
 */
public class hash {
    public static int vidNo, endNo, reqNo, cacheNo, cacheSize;


    public static char[][] read(String filename) throws IOException {
        Charset charset = Charset.forName("US-ASCII");
        char[][] p = null;
        Path file = FileSystems.getDefault().getPath("src", filename);
        BufferedReader reader = Files.newBufferedReader(file, charset);
        String line = reader.readLine();

        vidNo = Integer.parseInt(line.split(" ")[0]);
        endNo = Integer.parseInt(line.split(" ")[1]);
        reqNo = Integer.parseInt(line.split(" ")[2]);
        cacheNo = Integer.parseInt(line.split(" ")[3]);
        cacheSize = Integer.parseInt(line.split(" ")[4]);

        line = reader.readLine();

        String[] sizes = line.split(" ");

        return null;
    }


    public static void main(String[] args) throws IOException {


    }

}
