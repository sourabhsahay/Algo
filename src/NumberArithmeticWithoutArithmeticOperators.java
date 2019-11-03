public class NumberArithmeticWithoutArithmeticOperators {

    int multiple (int x, int y)
    {
       int sum = 0;

       while (x != 0)
       {
           if ((x & 1) != 0)
           {
              sum =  Add(y, sum);
           }
           x >>= 1;
            y <<= 1;
       }
       return sum;
    }
   int Add (int a, int b)
    {
       int sum = 0, carryin = 0, k = 1, temp_a = a, temp_b = b;
       while (temp_a != 0|| temp_b != 0)
       {
           int ak = a & k;
           int bk = b & k;
           //TODO Complete the carryout part.
           int carryout = ((ak & bk) );// || (ak & carryin) || (bk & carryin);
           sum |= (ak ^bk ^ carryout);
           carryin = carryout <<1;
           k = k <<1;
           ak = ak >>1;
           bk = bk >>1;
       }
       return sum | carryin;
    }

    int Divide (int x, int y)
    {
        //TODO complete this method.
        return 0;
    }

    int Power (int x, int y)
    {
        /* if least significant bit of y is 0 , the result is (x ^ y.2)2, other wise it is x * (x ^y/2)2
         */
        int  result = 1;
        int power = y;
        if (y < 0)
        {
            power = -power; x = 1/x;
        }
        while (power!= 0)
        {
            if ((power & 1) != 0)
            {
                result *= x;
            }
            x *=x; power >>= 1;
        }
        return result;

    }
}
