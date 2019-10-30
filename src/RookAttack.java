public class RookAttack {

    void rookAttackValidPositions (int chess [][])
    {
        // zero represents that position can be attacked
        int rowSize = chess.length;
        int colSize = chess[0].length;
        boolean  hasFirstRowZeroes = false;
        boolean hasFirstColumnZeroes = false;

        for (int i = 0; i < chess[0].length; i ++)
        {
            if (chess[0][i] == 0)
            {
                hasFirstRowZeroes = true;
                break;
            }
        }

        for (int i = 0; i < chess.length; i ++)
        {
            if (chess[0][i] == 0)
            {
                hasFirstColumnZeroes = true;
                break;
            }
        }

        for (int i = 1; i < chess.length; i ++)
        {
            for (int j = 1; j < chess[0].length; j ++)

            {
                if (chess[i][j] == 0)
                {
                    chess[0][j] = 0;
                    chess[i][0] = 0;

                }
            }
        }

        for (int i = 1; i < chess.length; i++)
        {
            if (chess[0][i] ==0 )
            {
                for (int j = 0; j < chess[0].length; j++)
                {
                    chess[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < chess[0].length; i++)
        {
            if (chess[i][0] ==0 )
            {
                for (int j = 0; j < chess.length; j++)
                {
                    chess[i][j] = 0;
                }
            }
        }
        if (hasFirstRowZeroes) {
            for (int i = 0; i < chess[0].length; i++) {
                chess[0][i] =0;

            }
        }

        if (hasFirstColumnZeroes) {
            for (int i = 0; i < chess.length; i++) {
                chess[i][0] =0;

            }
        }
    }
}
