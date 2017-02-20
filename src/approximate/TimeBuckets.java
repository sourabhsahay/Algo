package approximate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vishwasourabh.sahay on 04/01/17.
 */
public class TimeBuckets {

    public TimeBuckets() {
        timeBucketList = new ArrayList<>();
    }

    public class TimeBucket
   {
       public TimeBucket(long timestamp, int firstSetBit) {
           this.timestamp = timestamp;
           this.firstSetBit = firstSetBit;
       }

       private long timestamp;
       int firstSetBit;

       public int getFirstSetBit() {
           return firstSetBit;
       }

       public long getTimestamp() {
           return timestamp;
       }

       public void setTimestamp(long timestamp) {
           this.timestamp = timestamp;
       }
   }

    public List<TimeBucket> getTimeBucketList() {
        return timeBucketList;
    }

    private  List<TimeBucket>  timeBucketList;


}
