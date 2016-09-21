public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        if (nums == null) {
            return null;
        }
        else if (nums.length == 0) {
            return result;
        }
        
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        subsetsHelper(result, list, nums, 0);
        return result;
    }
    
    public void subsetsHelper(List<List<Integer>> result, List<Integer> list, int[] nums, int pos) {
        result.add(new ArrayList<Integer>(list));
        
        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            subsetsHelper(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}