package approximate;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 * Created by vishwasourabh.sahay on 04/01/17.
 */
public class SlidingHyperLogLog {


    int bucketSize = 0;
    TimeBuckets[] timeBuckets;
    TimeUnit timeUnit; // which time unit to use for window. Hours or Minutes

    public SlidingHyperLogLog(int bucketSize, TimeUnit timeUnit) {
        this.bucketSize = bucketSize;
        timeBuckets = new TimeBuckets[(int) Math.pow(2, bucketSize)];
        this.timeUnit = timeUnit;
    }

    //token is a String identifier which can be an IP address string or device Id for incoming request.
    //hash into suitable integer
    public void insert(String token)
    {


        Integer hashValue = hash(token);
        int hashLength = String.valueOf(hashValue).length();
        int bucketPart = hashValue >>(hashLength - bucketSize);
        int remaining = hashValue & ((1 <<(hashLength - bucketSize)) -1);
        //first set bit after series of leading zeroes, and also removing firstSetBit part.
        int firstSetBit =  64 - bucketSize - (int)logOfBase(2, remaining);

        insertInNecessaryBucket(firstSetBit, bucketPart);



    }

    public double getApproximateCount()
    {
        int bucketsResults[] = new int[timeBuckets.length];
        for(int i = 0; i < timeBuckets.length; i ++)
        {
            int maxBucketValue = findMax(timeBuckets[i]);
            bucketsResults[i] = maxBucketValue;
        }
        int harmonicSetBits = harmonicMean(bucketsResults);
        return Math.pow (2, harmonicSetBits);

    }

    private int findMax(TimeBuckets timeBuckets) {
       int max = Integer.MIN_VALUE;
        long slidingWindowStartTime= getSlidingWindowStartTime();
        for(TimeBuckets.TimeBucket  timeBucket : timeBuckets.getTimeBucketList())
        {
            //Again check if the current entry is in sliding window or not
            if(timeBucket.getTimestamp() > slidingWindowStartTime )
                continue;
            else if ( timeBucket.getFirstSetBit()> max)
            {
                max = timeBucket.getFirstSetBit();
            }
        }
        return max;
    }

    int harmonicMean(int array[])
    {
        int result = 0;
        int i;
        for(i=0; i <array.length; i++)
        {
            result+=(1.0)/array[i];
        }
        result = (int) ((int)(array.length)*Math.pow(result,-1.0));
        return result;
    }

    private void insertInNecessaryBucket(int firstSetBit, int bucketPart) {

        TimeBuckets buckets = timeBuckets[bucketPart];
        long slidingWindowStartTime= getSlidingWindowStartTime();
        for(TimeBuckets.TimeBucket timeBucket : buckets.getTimeBucketList())
        {

             // Remove values which are outside the sliding time window, or less than current maximum.
             if(timeBucket.getTimestamp() > slidingWindowStartTime  || timeBucket.getFirstSetBit() < firstSetBit)
             {
                 buckets.getTimeBucketList().remove(timeBucket);
             }

        }
        TimeBuckets.TimeBucket timeBucket =  buckets. new TimeBucket(Calendar.getInstance().getTimeInMillis(),firstSetBit);
        buckets.getTimeBucketList().add(timeBucket);

    }

    private long getSlidingWindowStartTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.getTime();
        if(TimeUnit.HOURS== timeUnit)
        {
            calendar.add(Calendar.HOUR_OF_DAY, -1);
            return calendar.getTimeInMillis();
        }
        if(TimeUnit.MINUTES== timeUnit)
        {
            calendar.add(Calendar.MINUTE, -1);
            return calendar.getTimeInMillis();
        }
        //TODO add implementation for other window sizes , 4 hours, 5 minutes etc.
        return 0;
    }


    private Integer hash (String token)
    {
        // Can be replaced by a better hash function.
        return token.hashCode();
    }

    public double logOfBase(int base, int num) {
        return Math.log(num) / Math.log(base);
    }
}
