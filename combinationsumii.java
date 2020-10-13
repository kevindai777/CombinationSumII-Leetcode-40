//Java Solution

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int sum = 0;
        int index = 0;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        LinkedList<Integer> temp = new LinkedList<Integer>();
        
        backtrack(result, temp, sum, index, target, candidates);
        return result;
    }
    
    public void backtrack(List<List<Integer>> result, LinkedList<Integer> temp, int sum, int index, int target, int[] candidates) {
        if (sum > target) {
            return;
        }
        
        if (sum == target) {
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        
        for (int i = index; i < candidates.length; i++) {
            if (i != index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            temp.add(candidates[i]);
            backtrack(result, temp, sum + candidates[i], i + 1, target, candidates);
            temp.removeLast();
        }
    }
}