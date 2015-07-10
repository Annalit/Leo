我真的好想吐槽，第k大不是第k小。。。
class Solution {
    //param k : description of k
    //param numbers : array of numbers
    //return: description of return
    public int kthLargestElement(int k, ArrayList<Integer> numbers) {
        return quickSelect(numbers, 0, numbers.size() - 1, numbers.size() - k );
    }
    int quickSelect(ArrayList<Integer> nums, int low, int high, int k){
        if (nums == null || nums.size() == 0){
            return 0;
        }
        int i = low;
        int j = high;
        int pivot = nums.get(i);
        while (i < j){
            while (i < j && nums.get(j) >= pivot)
                j--;
            nums.set(i, nums.get(j));
            while (i < j && nums.get(i) <= pivot)
                i++;
            nums.set(j,nums.get(i));
        }
        nums.set(i, pivot);

    if(i == k){
        return nums.get(i);
    }
    if (i < k){
        return quickSelect(nums, i + 1, high, k);
    } else
        return quickSelect(nums, low, i - 1, k);
    }
}
