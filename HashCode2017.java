import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by xintongyu on 23/02/2017.
 */
public class HashCode2017 {

    //containing the length of each video
    public static int[] videos;
    public static int[][] requests;
    public static int[][] endpointsLatency;



    public static void main(String[] args) throws IOException {

        Charset charset = Charset.forName("US-ASCII");
        Path file = FileSystems.getDefault().getPath("src", "me_at_the_zoo.in");
        BufferedReader reader = Files.newBufferedReader(file, charset);
        String line = reader.readLine();

        int vidNo = Integer.parseInt(line.split(" ")[0]);
        int endNo = Integer.parseInt(line.split(" ")[1]);
        int reqNo = Integer.parseInt(line.split(" ")[2]);
        int cacheNo = Integer.parseInt(line.split(" ")[3]);
        int cacheSize = Integer.parseInt(line.split(" ")[4]);

        requests = new int[endNo][vidNo];
        endpointsLatency = new int[endNo][cacheNo];
        videos = new int[vidNo];

        //store videos
        line = reader.readLine();
        for (int i = 0; i < vidNo; i++) {
            videos[i] = Integer.parseInt(line.split(" ")[i]);
        }

        //store endPointsLatency
        for (int i = 0; i < endNo; i++) {
            line = reader.readLine();
            int centerLatency = Integer.parseInt(line.split(" ")[0]);
            endpointsLatency[i][0] = centerLatency;
            int connectCacheNo = Integer.parseInt(line.split(" ")[1]);
            for (int j = 0; j < connectCacheNo; j++){
                line = reader.readLine();
                int cNo = Integer.parseInt(line.split(" ")[0]);
                int cLat = Integer.parseInt(line.split(" ")[1]);
                endpointsLatency[i][cNo] = cLat;
            }
        }

        //store requests
        for (int i = 0; i < reqNo; i++) {
            line = reader.readLine();
            int vid = Integer.parseInt(line.split(" ")[0]);
            int end = Integer.parseInt(line.split(" ")[1]);
            int req = Integer.parseInt(line.split(" ")[2]);
            requests[end][vid] = req;
        }

        for (int i = 0; i < cacheNo; i++) {
            int[] connectEnds = new int[endpointsLatency.length];

        }
    }
}
