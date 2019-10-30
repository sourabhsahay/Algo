public class Maximum2DSubArray {

    class MaxHW
    {
        int height;

        public MaxHW(int height, int width) {
            this.height = height;
            this.width = width;
        }

        int width;

        public int getHeight() {
            return height;
        }

        public int getWidth() {
            return width;
        }
    }
    int maximumRectangleSubMatrix (int matrix [][]) {
        MaxHW table[][] = new MaxHW[matrix.length][matrix[0].length];
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix.length - 1; j >= 0; j--) {
                table[i][j] = matrix[i][j] == 1 ?
                        new MaxHW(i + 1 < matrix.length ? table[i + 1][j].height + 1 : 1,
                                j + 1 < matrix.length ? table[i][j + 1].width + 1 : 1) : new MaxHW(0, 0);

            }
        }
        int maxRectArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > 0 && table[i][j].height * table[i][j].width > maxRectArea) {
                    int minimumWidth = Integer.MAX_VALUE;
                    for (int a = 0; a < table[i][j].height; a++) {
                        //Iterate through the entry in vertical Order, and select the minimum width.
                        /*111000
                          111100
                          110000
                          111110
                          Here minimum width will be first two columns with 2 11s, counting all rows.
                          If only first and second row is selected, width count will be 3
                         */
                        minimumWidth = Math.min(minimumWidth, table[i + a][j].width);
                        maxRectArea = Math.max(maxRectArea, minimumWidth * (a + 1));
                    }
                }
            }
        }
        return maxRectArea;
    }

}
