public class OptimizedGCD {
    long gcd (int x, int y)
    {
        if (x == y)
        {
            return x;
        }
        if ((x % 2)== 0 &&  (y % 2)== 0 )
        {
             return gcd (x >>1, y >> 1) << 1;
        }
        else if ((x % 2)== 0 &&  (y % 2)!= 0 )
        {
            return  gcd (x>>1, y);
        }
        else if ((x % 2) !=0 &&  (y % 2)== 0 )
        {
            return  gcd (x, y >>1);
        }
        else if (x > y)
        {
            return gcd (x-y, y);
        }
        return gcd (x, y-x);
    }
}
