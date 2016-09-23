public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
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
        int[] visited = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            visited[i] = 0;
        }

        permutationHelper(result, list, visited, nums);
        return result;
    }
    
    private void permutationHelper(ArrayList<List<Integer>> result,
    ArrayList<Integer> list, int[] visited, int[] nums) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1 || (i != 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0)) {
                continue;
            }
            visited[i] = 1;
            list.add(nums[i]);
            permutationHelper(result, list, visited, nums);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
    }
}