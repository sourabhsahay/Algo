public class MinJumps {
    public int jump(int[] nums) {
        int [] jump = new int[nums.length];
        if (nums[0]==0 || nums.length==0)
        {
            return Integer.MAX_VALUE;
        }


        jump[0] = 0;

        for (int i = 1 ; i <= nums.length-1; i ++)
        {
            jump[i] = Integer.MAX_VALUE;

            for (int j = 0; j < i; j ++)
            {
                if (i <= j + nums[j]  &&  jump[j] != Integer.MAX_VALUE)
                {
                    jump[i] = Math.min (jump[i], jump[j] + 1);
                }
            }
        }
        return jump[nums.length -1];
    }
}

