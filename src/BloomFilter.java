import java.util.BitSet;

public class BloomFilter {
   // https://www.javamex.com/tutorials/collections/bloom_filter_java.shtml

    private static final int MAX_HASHES = 8;
    private static final long[] byteTable;
    private static final long HSTART = 0xBB40E64DA205B064L;
    private static final long HMULT = 7664345821815920749L;


    private  BitSet data;
    private  int noHashes;
    private  int hashMask;



    static
    {
        byteTable = new long[256 * MAX_HASHES];
    }
    public BloomFilter(int log2noBits, int noHashes)
        {

            long h = 0x544B2FBACAAF1684L;
            this.data = new BitSet(1 << log2noBits);
            this.noHashes = noHashes;
            this.hashMask = (1 << log2noBits) - 1;
            for (int i = 0; i < byteTable.length; i++) {
                for (int j = 0; j < 31; j++) {
                    h = (h >> 7) ^ h;
                    h = (h >> 11) ^ h;
                    h = (h >> 10) ^ h;

                }
                byteTable[i] = h;
            }
        }

    private long hashCode(String value, int hcNo)
        {
        long h = HSTART;
        final long hmult = HMULT;
        int startIndex = 256* hcNo;
        for (int i = 0; i < value.length(); i ++ )
        {
            char ch = value.charAt(i);
            h = h * hmult ^ byteTable[startIndex + (ch & 0xff) ];
            h = h * hmult ^ byteTable[startIndex + ((ch>>>8) & 0xff) ];
        }
        return h;
    }

    public void add(String s) {
        for (int n = 0; n < noHashes; n++) {
            long hc = hashCode(s, n);
            int bitNo = (int) (hc) & this.hashMask;
            data.set(bitNo);

        }
    }

    public boolean contains (String s)
    {
        for (int i = 0; i < noHashes; i ++) {
            long hc = hashCode(s, i);
            int bitNo = (int) hc & this.hashMask;
            if (!data.get(bitNo)) return false;
        }
        return true;
    }

}
