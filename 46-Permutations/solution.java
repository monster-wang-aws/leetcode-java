public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(result, list, nums);
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            result.add(new ArrayList(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;             
            }
            list.add(nums[i]);
            helper(result, list, nums);
            list.remove(list.size() - 1);
        }
    }
}