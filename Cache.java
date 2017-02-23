import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by KAY on 23/02/2017.
 */
public class Cache {
    private int size, noVid;
    private ArrayList<Integer> endPoints = new ArrayList<Integer>();
    private int[][] requests;
    private int[] vidSize;
    private int[] demand;
    private ArrayList<Integer> videos = new ArrayList<Integer>();

    public Cache(int size, int noVid, int[] vidSize){
        this.size = size;
        this.noVid = noVid;
//        this.requests = new int[noVid];
        this.demand = new int[noVid];
        this.vidSize = vidSize;

    }

    public void connectEndPoint(int point){
        this.endPoints.add(point);
    }

    public void recalculate(){
        this.demand = new int[noVid];
        for(int p: endPoints){
            Arrays.setAll(this.demand, i -> this.demand[i] + requests[p][i]);
        }

        Pair[] pairs = new Pair[noVid];
        for(int i=0; i<noVid; i++){
            pairs[i] = new Pair(i, demand[i]);
        }

        Arrays.sort(pairs, Collections.reverseOrder());
        int storage = 0;
        for(int i=0; i<noVid; i++){
            if (storage + vidSize[pairs[i].index] <= this.size) {
                storage += vidSize[pairs[i].index];
                //***********
                //optimisation
                //***********
                this.videos.add(pairs[i].index);
            }
        }
    }

    public ArrayList<Integer> getVideos(){
        return this.videos;
    }

    public class Pair {
        private int index;
        private int value;
        public Pair(int index, int value){
            this.index = index;
            this.value = value;
        }

        @overide
        public int compareTo(Pair obj){
            if (this.value < obj.value) return -1;
            if (this.value > obj.value) return 1;
            return 0;
        }
    }

}
