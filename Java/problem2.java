class Solution {
    public int minPatches(int[] nums, int n) {
        int patches = 0;
        int i = 0;
        //int acum = 1;
        //List<Integer> nums=new ArrayList<Integer>();
        //System.out.print(patches+"_"+i);
        //while (acum <= n) {
        for(long acum = 1;acum<=n;){
            if (i < nums.length && nums[i] <= acum) {
                acum += nums[i];
                i ++;
            }else{
                patches ++;
                acum += acum;
            }
        }
        return patches;
    }
}