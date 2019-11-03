import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MeasureWithDefectiveContainer {
    class Jug
    {
        int low;
        int high;
    }

    class VolumeRange
    {
       int low;
       int high;

        public VolumeRange(int low, int high) {
            this.low = low;
            this.high = high;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            VolumeRange that = (VolumeRange) o;

            if (low != that.low) return false;
            return high == that.high;
        }

        @Override
        public int hashCode() {
            int result = low;
            result = 31 * result + high;
            return result;
        }
    }

    boolean checkIfFeasible (List<Jug> jugs, int L, int H)
    {
        Set<VolumeRange> cache = new HashSet() ;
        return checkIfFeasible(jugs, L, H, cache);
    }

    private boolean checkIfFeasible(List<Jug> jugs, int L, int H, Set<VolumeRange> cache) {
        if (L > H || cache.contains(new VolumeRange(L, H)) || (L < 0 && H <0 ))
        {
            return false;
        }
        for (Jug jug : jugs)
        {
            if (L < jug.low && jug.high <= H || checkIfFeasible(jugs, L-jug.low, H - jug.high, cache))
            {
                return true;
            }

        }
        cache.add(new VolumeRange(L,H));
        return false;

    }

}
