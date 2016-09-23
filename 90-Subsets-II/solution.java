public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null) {
            return result;
        }
        else if (nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(result, list, nums, 0);
        return result;
    }
    
    private void helper(List<List<Integer>> result,
    ArrayList<Integer>list, int[] nums, int pos) {
        result.add(new ArrayList(list));
        
        for (int i = pos; i < nums.length; i++) {
            if (i != pos && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            helper(result, list, nums, i+1);
            list.remove(list.size() - 1);
        }
    }
}